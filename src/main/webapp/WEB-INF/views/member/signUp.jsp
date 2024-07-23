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
                                    <div style="display: flex; align-items: center;">
                                        <div class="form-floating mb-3" style="width: 280px; flex-grow:1; margin-right: 10px;">
                                            <input class="form-control" name="m_email" id="m_email" type="email" placeholder="email@example.com" />
                                            <label for="m_email">이메일</label>
                                        </div>
                                        <button class="btn btn-dark" type="button" onclick="dupliCk()" style="height: 58px; margin-bottom: 15px;">중복체크</button>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_pwd" id="m_pwd" type="password" placeholder="Password" />
                                        <label for="m_pwd">비밀번호</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_ckpwd" id="m_ckpwd" type="password" placeholder="Password Check" />
                                        <label for="m_ckpwd">비밀번호 확인</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_name" id="m_name" type="text" placeholder="이름을 입력하세요." />
                                        <label for="m_name">이름</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_phone" id="m_phone" type="text" placeholder="-를 제외하고 입력하세요." maxlength="11"/>
                                        <label for="m_phone">전화번호 ( 숫자만 입력하세요. )</label>
                                    </div>
                                    <div style="display: flex; align-items: center;">
                                        <div class="form-floating mb-3" style="width: 280px; flex-grow:1; margin-right: 10px;">
                                            <input class="form-control" name="m_add" id="m_add" type="text" placeholder="주소를 입력하세요." readonly/>
                                            <label for="m_add">주소</label>
                                        </div>
                                        <button class="btn btn-dark" type="button" id="findAddSearch" onclick="findAdd()" style="height: 58px; margin-bottom: 15px;">주소 검색</button>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="m_detailadd" id="m_detailadd" type="text" placeholder="나머지 주소를 입력하세요." />
                                        <label for="m_detailadd">상세주소</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0" style="width: 150px; margin-left: 40%;">
                                            <button class="btn btn-dark" type="submit">가입하기</button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="/member/login">로그인</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/static/signUp/signIn-js/scripts.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function dupliCk() {
        var email = $("#m_email").val();
        var header = $("meta[name='_csrf_header']").attr('content');
        var token = $("meta[name='_csrf']").attr('content');
        $.ajax({
            type: 'POST',
            url: '/emailCheck',
            beforeSend: function(xhr){
                xhr.setRequestHeader(header,token);
            },
            data: {"m_email": email},
            dataType: "text",
            success: function (result){
                if(result == 0){
                    alert("사용가능한 이메일입니다.");
                   /* $("#m_email").attr("disabled", true);*/
                } else {
                    alert("사용할 수 없는 이메일입니다.");
                    document.getElementById("m_email").focus();
                }
            },
            error: function () {
                alert("오류입니다.");
            }
        })
    }

    function findAdd(){
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = '';
                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }
                $("#m_add").val(addr);

            }
        }).open();
    }
</script>
<%@ include file="../layout/footer.jsp" %>
