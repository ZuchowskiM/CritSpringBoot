package zuchowskim.crit.crit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailService")
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        String[] staticResources  =  {
                "/gameImages/**",
                "/logos/**",
                "/newsImages/*",
                "/site.css",
        };

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/deleteReview*", "/deleteGame*", "/producers", "/editGame*", "/editProducer*", "/deleteProducer*", "/createGame*", "/createProducer*")
                .hasAuthority("admin")
                .antMatchers("/createReview", "/editReview*")
                .hasAuthority("critic")
                .antMatchers("/*").permitAll()
                .antMatchers(staticResources).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/home", true)
                //.failureUrl("/home")
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout();
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");
                //.logoutSuccessHandler(logoutSuccessHandler());

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance(); }


}
