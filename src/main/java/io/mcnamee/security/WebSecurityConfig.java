package io.mcnamee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Luke on 3/12/2017.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * configuration for the springboot server
     *
     * @param http
     * @throws Exception
     * @Edited by Luke McNamee, orginal code provided by MkYong
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .and()
                .authorizeRequests()
                    .antMatchers("/contemplative/**", "/").permitAll()
                    .antMatchers("/css/**", "/img/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .csrf();
    }

    /*
    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
    */
}
