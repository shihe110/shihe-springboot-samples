package org.shihe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-08-18 17:16
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("shihe")
                .password("123456")
                .roles("admin");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/js/**","/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                .successHandler((req, resp, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    String name = e.getClass().getName();
                    RespBean respBean = new RespBean(name,null);
                    if (e instanceof LockedException){
                        respBean.setMsg("账号被锁定");
                    }else if(e instanceof CredentialsExpiredException){
                        respBean.setMsg("密码过期");
                    }else if (e instanceof AccountExpiredException) {
                        respBean.setMsg("账户过期，请联系管理员!");
                    } else if (e instanceof DisabledException) {
                        respBean.setMsg("账户被禁用，请联系管理员!");
                    } else if (e instanceof BadCredentialsException) {
                        respBean.setMsg("用户名或者密码输入错误，请重新输入!");
                    }
                    out.write(new ObjectMapper().writeValueAsString(respBean));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}
