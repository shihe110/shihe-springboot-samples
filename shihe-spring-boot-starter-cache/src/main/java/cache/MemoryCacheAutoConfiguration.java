package cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MemoryCacheAutoConfiguration
 * @Description 内存缓存自动化配置
 * @Author admin
 * @Date 2020-07-14 17:05
 * @Version 1.0
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@ConditionalOnClass(MemoryCache.class)
public class MemoryCacheAutoConfiguration {

    @Autowired
    CacheProperties cacheProperties;

    @Bean
    MemoryCache memoryCache(){
        long timeout = cacheProperties.getTimeout();
        long checkTime = cacheProperties.getChecktime();
        return new MemoryCache(timeout, checkTime);
    }
}
