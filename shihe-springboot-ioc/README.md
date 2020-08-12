## IoC 容器

Spring是如何知道要怎么管理你的bean，通过元数据+POJO

元数据几种表现方式：
- 1、xml配置
- 2、注解和java配置

spring的ioc容器：ApplicationContext,他拥有一个父接口BeanFactory，用来提供管理配置任意对象的基础功能。
而ApplicationContext提供了更多的企业级功能且包含父接口的所有功能。我们只要新建一个ApplicationContext的实现就拥有了一个Spring的IoC容器。

```js
ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(xxxConfig.class);
```

Spring Boot为我们在不同的环境下自动创建正确的IoC容器：

- AnnotationConfigApplicationContext：默认创建的IoC容器；
- AnnotationConfigServletWebServerApplicationContext：Web应用下创建的IoC容器；
- AnnotationConfigReactiveWebServerApplicationContext：响应式Web应用创建的IoC容器。
