package org.shihe.cache;

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

    private static final long CHECK_TIME = 1000 * 60 * 30;

    private static final long DEFAULT_TIMEOUT = 1000 * 60 * 30;

    private Long timeout = DEFAULT_TIMEOUT;

    private Long checktime = CHECK_TIME;

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
