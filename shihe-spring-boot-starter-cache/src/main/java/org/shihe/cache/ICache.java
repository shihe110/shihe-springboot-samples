package org.shihe.cache;

/**
 * 缓存约束接口
 * @Author shihe
 */
public abstract interface ICache {

    public abstract void put(Object key, Object value);

    public abstract void put(Object key, Object value, long timeout);

    public abstract Object getByKey(Object key);

    public abstract void delByKey(Object key);

    public abstract void clear();

    public abstract boolean containsKey(Object key);

}
