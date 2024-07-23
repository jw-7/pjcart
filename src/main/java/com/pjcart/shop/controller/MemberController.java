package com.pjcart.shop.controller;

import com.pjcart.shop.dto.MemberDTO;
import com.pjcart.shop.service.MemberService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    private MemberService memberService;

    @GetMapping(value = "/member/login")
    public String loginPage() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken) {
            return "/member/login";
        }
        log.info("Login Page In");
        return "redirect:/";
    }

    @GetMapping(value = "/member/signUp")
    public String signUpPage() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken) {
            return "/member/signUp";
        }
        log.info("SignUp Page In");
        return "redirect:/";
    }

    @PostMapping(value = "/member/signUpProc")
    public String signUpProc(@Valid MemberDTO memberDTO) throws Exception {
        log.info("Sign Up Success");
        memberService.registerMember(memberDTO);
        return "redirect:/member/login";
    }

    @PostMapping(value = "/emailCheck")
    @ResponseBody
    public int emailCheck(@RequestParam("m_email") String m_email) throws Exception {
        log.info("Email Check Ajax Success");
        int result = memberService.emailCheck(m_email);
        return result;
    }
}
