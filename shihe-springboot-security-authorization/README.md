## SpringSecurity之授权

### 认证数据源
认证数据源简单来说就是用户名密码等用户信息。SpringSecurity支持多种数据源，（内存、数据库、LDAP等），这些数据源被共同封装成一个接口：UserDetailService，任何实现了该接口的对象都可以作为认证数据源。

### 配置用户
继承WebSecurityConfigurerAdapter，重新userDetailsService方法。

### 新建控制器接口
```js
    @GetMapping("/hello")
    public String hello(){
        return "hello springsecurity!!";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "admin hello springsecurity!!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "user hello springsecurity!!";
    }
```

### 配置拦截规则
```js
http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
```
note:anyRequest不能再AntMatchers之前，否则启动会报错。

Ant风格路径匹配说明 

| 通配符 | 说明 |
| ---- | ---- |
| ** | 匹配多层路径 |
| * | 匹配一层路径 |
| ？| 匹配任意单个字符 |

### 角色继承
RoleHierarchy 
```js
    @Bean
    RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin>ROLE_user");
        return roleHierarchy;
    }
```