## springboot环境下注册bean到spring容器的4种方式

- 1.包扫描@ComponentScan+注解（@Controller @Service等）
- 2.配置类@Configuration+@Bean注解
- 3.@Import的三种方式
    - 3.1.直接引入 
    - 3.2.ImprotSelector  
    - 3.3.ImportBeanDefinitionRegistrar
- 4.FactoryBean
