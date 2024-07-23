package com.pjcart.shop.service;

import com.pjcart.shop.dto.MemberDTO;
import com.pjcart.shop.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private MemberMapper memberMapper;

    public void registerMember(MemberDTO memberDTO) throws Exception {
        memberDTO.setM_pwd(passwordEncoder.encode(memberDTO.getM_pwd()));
        memberMapper.registerMember(memberDTO);
    }

    public MemberDTO getMemberById(String m_email) throws Exception {
        return memberMapper.getMemberById(m_email);
    }

    public int emailCheck(String m_email) throws  Exception {
        return memberMapper.emailCheck(m_email);
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
