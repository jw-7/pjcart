package com.pjcart.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // URL 권한설정
        // 로그인 페이지와 회원가입 페이지만 허용하고 나머지는 인증
        http
                .authorizeRequests()
                    .antMatchers("/member/test").authenticated()
                    .anyRequest().permitAll();


        // 로그인 설정
        http
                .formLogin()
                    .loginPage("/member/login") // 로그인 view 페이지 get 요청
                    .loginProcessingUrl("/member/loginProc") // 로그인 post 처리
                    .usernameParameter("m_id") // 로그인 id 값 = m_id
                    .passwordParameter("m_pwd") // 로그인 password 값 = m_pwd
                    .defaultSuccessUrl("/"); // 처리 후 메인 페이지로 이동

        // 로그아웃 설정
        http
                .logout()
                .logoutUrl("/member/logout")
                .logoutSuccessUrl("/"); // 처리 후 메인 페이지로 이동

        return http.build();
    }
}
