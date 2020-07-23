## 一个基于内存缓存的spring-boot-starter

## step 1
新建一个maven工程，依赖包
```xml
// springboot自动化配置包
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
</dependency>
// 产生配置提示文件，也可不配置
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

## step 2 
遵循springboot-starter标准

配置文件代码：CacheProperties

自动化配置文件代码：MemoryCacheAutoConfiguration

缓存相关代码：ICache-缓存约束接口、MemoryCache-基于内存的接口实现

## step 3 
maven命令：install

结果：org\shihe\shihe-spring-boot-starter-cache\1.0-SNAPSHOT\shihe-spring-boot-starter-cache-1.0-SNAPSHOT.pom

## step 4
测试，新建springboot项目，添加此starter依赖
```xml
<dependency>
    <groupId>org.shihe</groupId>
    <artifactId>shihe-spring-boot-starter-cache</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

使用方法：
- 新建springboot项目配置application.properties
```java
shihe.checktime=5000 //表示检查缓存是否过期的时间间隔
shihe.timeout=5000 //表示缓存过期时间毫秒值-5000表示5秒
```
- 注入memoryCache使用
```java
    // 注入memoryCache
   @Autowired
    MemoryCache memoryCache;

    @GetMapping("/put")
    public String hello(){
        memoryCache.put("zhangsan","张三");
        return "hello cache";
    }

    @GetMapping("/get")
    public String get(String key){
        String byKey = (String) memoryCache.getByKey(key);
        return byKey;
    }
```
## step 5

[github地址](https://github.com/shihe110/shihe-springboot-samples/tree/master/shihe-spring-boot-starter-cache)

----