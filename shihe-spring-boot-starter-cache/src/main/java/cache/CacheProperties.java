package cache;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName CacheProperties
 * @Description 缓存的配置文件
 * @Author admin
 * @Date 2020-07-23 14:18
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "shihe")
public class CacheProperties {

    private Long timeout;

    private Long checktime;

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Long getChecktime() {
        return checktime;
    }

    public void setChecktime(Long checktime) {
        this.checktime = checktime;
    }

}
