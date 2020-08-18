## SpringSecurity入门

### 依赖

```js
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
springsecurity会自动保护所有接口

### 启动

启动过程：控制台打印
```js
Using generated security password: bb7e89a6-3a5c-48e4-aee2-2737f4533e4a
```
springsecurity在内存中生成一个默认用户名：user 密码：bb7e89a6-3a5c-48e4-aee2-2737f4533e4a

### 访问接口
会被SpringSecurity拦截到登陆页面，SpringSecurity默认登陆页面和登陆接口为login


