## SpringSecurity之formlogin

- 配置formlogin
```js
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/hello")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
```
- 配置放行静态资源拦截
```js
 @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/images/**");
    }
```

successForwardUrl()该方法只支持post请求。

