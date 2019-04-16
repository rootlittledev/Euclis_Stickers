package com.ethero.euclisstickers.config;

import com.ethero.euclisstickers.domain.User;
import com.ethero.euclisstickers.repository.UserRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                    .mvcMatchers("/", "/login**", "/webjars/**", "/error**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .logout().logoutSuccessUrl("/").permitAll();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository){
        return map -> {
            return new User();
        };
    }
}
