//package com.example.musicdownloader.configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception
//    {
//        // http.anonymous().disable();
//        http.requestMatchers()
//                .antMatchers("/login", "/oauthorize")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.parentAuthenticationManager(authenticationManager)
//                .inMemoryAuthentication()
//                .withUser("Peter")
//                .password("peter")
//                .roles("ADMIN");
//
//    }
//}
