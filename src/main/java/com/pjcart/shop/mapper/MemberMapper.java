package com.pjcart.shop.mapper;

import com.pjcart.shop.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void registerMember(MemberVO mvo); // 회원등록
    MemberVO getMemberById(String m_id);
}
