package com.pjcart.shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class MemberDTO {

    private Integer id; // 회원번호

    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String m_email; // 회원 이메일

    @NotBlank(message = "비밀번호를 입력하세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>/?])[A-Za-z\\d!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>/?]{8,20}$",message = "영문 대,소문자와 숫자, 특수기호가 최소 1개 이상 포함된 8 ~ 20자의 비밀번호를 입력하세요.")
    private String m_pwd; // 회원 비밀번호

    @NotBlank(message = "이름을 입력하세요.")
    private String m_name; // 회원이름

    @NotBlank(message = "연락처를 입력하세요.")
    @Pattern(regexp = "^01[0-9]-?\\d{3,4}-?\\d{4}$", message = "유효한 휴대폰 번호를 입력하세요.")
    private String m_phone; // 회원 전화번호

    @NotBlank(message = "주소를 입력하세요.")
    private String m_add; // 회원 주소

    private String m_detailadd; // 회원 상세주소
    private int m_status; // 회원상태
    private Timestamp m_regdate; // 회원 가입날짜
    private Timestamp m_update; // 회원 정보수정날짜
}
