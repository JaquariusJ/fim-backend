package com.money.fimsystem.config;

import com.money.fimsystem.security.filter.AddUserIdHeaderFilter;
import com.money.fimsystem.security.filter.TokenCheckFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
//
//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable();
        //
        //  http.httpBasic().authenticationEntryPoint(samlEntryPoint());
        //
        httpSecurity.authorizeRequests()
                //saml
                //登录接口
                .antMatchers("/**/login").anonymous()
                .antMatchers("/**/loginout").anonymous()
                //健康检查接口
                .antMatchers("/**/actuator/**").permitAll()
                //注册相关接口
                .antMatchers("/**/registry/**").permitAll()
                //其他接口
              // .anyRequest().permitAll();
                .anyRequest().authenticated();

        //设置session管理器
        httpSecurity.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .maximumSessions(Integer.MAX_VALUE);
        //登出
        httpSecurity.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .invalidateHttpSession(true)
                .deleteCookies()
                .clearAuthentication(true);

        //添加token校验的过滤器
         httpSecurity.addFilterBefore(new TokenCheckFilter(), UsernamePasswordAuthenticationFilter.class);
         httpSecurity.addFilterBefore(new AddUserIdHeaderFilter(),UsernamePasswordAuthenticationFilter.class);
        //
        //配置认证和授权异常处理器

        httpSecurity.exceptionHandling()
                //.authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
        ;
    }
}

