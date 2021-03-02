package com.dit.hua.security;
import javax.sql.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username,password, enabled from user where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
                .loginProcessingUrl("/authUser").permitAll().and().logout().logoutUrl("/logoutUser").logoutSuccessUrl("/login").permitAll().and().exceptionHandling()
                .accessDeniedPage("/403");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedMethods("*");
    }
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/api/**");
        web.ignoring().antMatchers("/register");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}