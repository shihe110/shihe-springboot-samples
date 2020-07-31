## SpringBoot事件

### 定义事件
```java
public class HelloEvent extends ApplicationEvent {

    private String msg;

    public HelloEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

```
### 监听事件
```java
@Component
public class HelloEventListener implements ApplicationListener<HelloEvent> {

    @Autowired
    private HelloService helloService;
    
    // 监听事件发生后处理想要的业务
    @Override
    public void onApplicationEvent(HelloEvent helloEvent) {
        String msg = helloEvent.getMsg();
        if (msg!=null){
            helloService.sayHello(msg);
        }
    }
}
```

### 发布事件
```java
@Component
public class HelloEventPublisher {

    @Autowired
    private ApplicationContext context;

    public void publish(String msg){
        context.publishEvent(new HelloEvent(this,msg));
    }
}
```

### 配置 -也可不配置-springboot默认会扫描启动类所在包
```java
@Configuration
@ComponentScan(basePackages = "org.shihe")
public class HelloEventConfig {
}
```

### 运行测试
```java
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloEventPublisher helloEventPublisher;

    @GetMapping("/hello")
    public String sayHello(String name){
        helloEventPublisher.publish(name + " 调用helloService了！");
        return helloService.sayHello(name);
    }
}

@Service
public class HelloService {

    public String sayHello(String name){
        System.out.println("================="+name);// 为省事，在事件处理中调用该方法，便于后台查看。
        return name + " say Hello!!";
    }
}
```