package com.pjcart.shop.security;

import com.pjcart.shop.domain.MemberVO;
import com.pjcart.shop.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String m_id = (String) authentication.getPrincipal();
        String m_pwd = (String) authentication.getCredentials();

        PasswordEncoder passwordEncoder = memberService.passwordEncoder();
        UsernamePasswordAuthenticationToken token;
        MemberVO mvo = null;
        try {
            mvo = memberService.getMemberById(m_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(mvo != null && passwordEncoder.matches(m_pwd, mvo.getM_pwd())) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("MEMBER"));

            token = new UsernamePasswordAuthenticationToken(mvo.getM_id(),null,roles);
            return token;
        }
        throw new BadCredentialsException("No such user or wrong password.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
