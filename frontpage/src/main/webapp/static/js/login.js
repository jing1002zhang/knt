function login() {
	$(function() {
		var loginName = $("#loginName").val();
		var password = $("#password").val();
		var verifyCode = $("#kaptcha").val();
		window.location.href = "/frontpage/login?loginName=" + loginName
				+ "&password=" + password + "&captcha="+verifyCode;
	});
}

function fulshKaptchaImage(){
	$("#kaptchaImage").attr("src", "/frontpage/kaptcha.jpg?" + Math.floor(Math.random()*100) ); 
}