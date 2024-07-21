package com.pjcart.shop.mapper;

import com.pjcart.shop.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void registerMember(MemberDTO memberDTO); // 회원등록
    MemberDTO getMemberById(String m_email);
}
