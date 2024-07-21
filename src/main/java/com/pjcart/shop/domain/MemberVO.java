package com.pjcart.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class MemberVO {
    private Integer id; // 회원번호
    private String m_id; // 회원아이디
    private String m_pwd; // 회원 비밀번호
    private String m_name; // 회원이름
    private String m_phone; // 회원 전화번호
    private String m_email; // 회원 이메일
    private String m_add; // 회원 주소
    private String m_detailadd; // 회원 상세주소
    private int m_status; // 회원상태
    private Timestamp m_regdate; // 회원 가입날짜
    private Timestamp m_update; // 회원 정보수정날짜
}
