<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header-version2.jsp" %>
<!-- Section-->
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5" style="margin-top: 20px; margin-bottom: 60px;">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">회원가입</h3></div>
                            <div class="card-body" id="loginModal">
                                <form action="/member/signUpProc" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_id" id="m_id" type="text" placeholder="name@example.com" />
                                        <label for="m_id">아이디</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_pwd" id="m_pwd" type="password" placeholder="Password" />
                                        <label for="m_pwd">비밀번호</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_name" id="m_name" type="text" placeholder="name@example.com" />
                                        <label for="m_name">이름</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_phone" id="m_phone" type="text" placeholder="name@example.com" />
                                        <label for="m_phone">전화번호</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_email" id="m_email" type="email" placeholder="name@example.com" />
                                        <label for="m_email">이메일</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_add" id="m_add" type="text" placeholder="name@example.com" />
                                        <label for="m_add">주소</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_detailadd" id="m_detailadd" type="text" placeholder="name@example.com" />
                                        <label for="m_detailadd">상세주소</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <button class="btn btn-primary" type="submit">등록</button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="register.html">Need an account? Sign up!</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/signUp/signIn-js/scripts.js"></script>
<%@ include file="../layout/footer.jsp" %>