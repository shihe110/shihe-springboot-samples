package cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MemoryCache
 * @Description 内存缓存实现-每30分钟检查缓存是否过期
 * @Author shihe
 * @Date 2020-07-23 14:19
 * @Version 1.0
 */
public class MemoryCache implements ICache{
    /**
     * 每30分钟检查一次缓存是否过期
     */
    private long check_time = 1000 * 60 * 30;

    /**
     * 默认缓存时间30分钟（毫秒值）
     */
    private long default_timeout = 1000 * 60 * 30;
    /**
     * 缓存时间key
     */
    private static final String TK = "IN_TIME_MILLIS";
    /**
     * 缓存数据key
     */
    private static final String DK = "CACHE_DATA";
    /**
     * 自定义过期时间key
     */
    private static final String TOK = "TIME_OUT_MILLIS";

    private Map<Object, Object> cache = Collections.synchronizedMap(new HashMap<Object, Object>());

    public synchronized void put(Object key, Object value) {
        Map map = new HashMap();
        map.put(TK,System.currentTimeMillis());
        map.put(DK,value);
        map.put(TOK,default_timeout);
        cache.put(key,map);
    }

    public void put(Object key, Object value, long timeout) {
        Map map = new HashMap();
        map.put(TK,System.currentTimeMillis());
        map.put(DK,value);
        map.put(TOK,timeout);
        cache.put(key,map);
    }

    public synchronized Object getByKey(Object key) {
        if(cache.containsKey(key)){
            Map dataMap = (Map) cache.get(key);
            Long timeout = (Long) dataMap.get(TOK);
            if(dataMap != null){
                Long inTime = (Long) dataMap.get(TK);
                Long nowTime = System.currentTimeMillis();
                // 线程间隔中缓存到期，清理缓存并返回null
                if ((nowTime - inTime) >= timeout) {
                    cache.remove(key);
                    return null;
                } else {
                    return dataMap.get(DK);
                }
            }else{
                return null;
            }
        }else {
            return null;
        }
    }

    public synchronized void delByKey(Object key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public boolean containsKey(Object key) {
        return cache.containsKey(key);
    }


    private class ClearThread extends Thread{
        ClearThread() {
            setName("clear cache thread");
        }
        @Override
        public void run() {
            while (true) {
                try {
                    long now = System.currentTimeMillis();
                    Object[] keys = cache.keySet().toArray();
                    for (Object key : keys) {
                        Map dm = (Map) cache.get(key);
                        Long timeout = (Long) dm.get(TOK);
                        Long intime = (Long) dm.get(TK);
                        if (now - intime >= timeout) {
                            cache.remove(key);
                        }
                    }
                    Thread.sleep(check_time);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MemoryCache(long default_timeout, long check_time) {
        if (default_timeout!=0){
            this.default_timeout = default_timeout;
        }
        if (check_time!=0){
            this.check_time = check_time;
        }
        new ClearThread().start();
    }

}
