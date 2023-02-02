package HAZAGroup.HAZACommunity.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final CorsConfig config;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .requestMatchers("/**").permitAll();

//                .and()
//                .oauth2Login()
//                .loginPage("/loginForm")		// 인증이 필요한 URL에 접근하면 /loginForm으로 이동
//                .defaultSuccessUrl("/")			// 로그인 성공하면 "/" 으로 이동
//                .failureUrl("/loginForm")		// 로그인 실패 시 /loginForm으로 이동
//                .userInfoEndpoint()			// 로그인 성공 후 사용자정보를 가져온다
//                .userService(principalOauth2UserService);	//사용자정보를 처리할 때 사용한다

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/**");
    }

}

