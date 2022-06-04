package sg.azlabs.ms.testms.app.configuration;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import sg.azlabs.ms.testms.app.security.filter.ApiKeyAuthenticationFilter;
import sg.azlabs.ms.testms.app.security.provider.ApiKeyAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated().and().addFilterBefore(
                new ApiKeyAuthenticationFilter(authenticationManager()), AnonymousAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationManager authenticationManager(ApiKeyAuthenticationProvider apiKeyAuthenticationProvider) {
        return new ProviderManager(Collections.singletonList(apiKeyAuthenticationProvider));
    }
}
