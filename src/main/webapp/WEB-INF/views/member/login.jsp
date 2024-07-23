<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layout/header-version2.jsp" %>
<!-- Section-->
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5" style="margin-top: 20px; margin-bottom: 60px;">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">로그인</h3></div>
                            <div class="card-body" id="loginModal">
                                <form>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="id" type="text" placeholder="아이디를 입력하세요." />
                                        <label for="id">ID</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="pwd" type="password" placeholder="비밀번호를 입력하세요" />
                                        <label for="pwd">PASSWORD</label>
                                    </div>
                                    <div class="form-check mb-3">
                                        <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                                        <label class="form-check-label" for="inputRememberPassword">아이디 기억하기</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <a class="small" href="/findPwd">비밀번호 찾기</a>
                                        <a class="btn btn-dark" href="index.html">로그인</a>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="/member/signUp">회원가입</a></div>
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