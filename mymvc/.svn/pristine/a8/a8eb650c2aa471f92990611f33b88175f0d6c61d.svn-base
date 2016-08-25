<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<html>	
<head>
<title>Login</title>
<link href="${ctx}/style/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<script src="${ctx}/scripts/jquery-1.8.2.min.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});

function check()
{
	var userName=$("#userName").val();//获取登录类型
	var flag=false;
	if(isEmail(userName))
		{
		//邮箱登录写法，进行ajax
		$.ajax({
			 type: 'POST',
			 async:false,
             data: {
            	 "userName":$("#userName").val(),
            	 "password":$("#password").val(),
            	 "loginType":2
            	 },
             dataType:'json',
             url: '${ctx}/userInfo/getSelectLogin.do',
             error:function (date)
             {
            	 alert(date.status);
             },
             success: function(data){
            	 
            	 if(data!=null)
        		 {
        		 //alert("登陆成功");
        		 flag= true;
        		 }
        	 else
        		 {
        		 alert("账号密码有误！");
        		 flag= false;
        		 }
                /* if(data=="1")
                	{
                	//alert("登录成功");
                	flag= true;
                	}
                else
                	{
                	alert("账号密码有误");
                	flag= false;
                	} */
              }
			});
		}
	else if(isnum(userName))
			{
			//手机登录写法，进行ajax
			$.ajax({
				 type: 'POST',
				 async:false,
	             data: {
	            	 "userName":$("#userName").val(),
	            	 "password":$("#password").val(),
	            	 "loginType":1
	            	 },
	             dataType:'json',
	             url: '${ctx}/userInfo/getSelectLogin.do',
	             error:function (date)
	             {
	            	 alert(date.status);
	             },
	             success: function(data){
	            	 if(data!=null)
	            		 {
	            		 //alert("登陆成功");
	            		 flag= true;
	            		 }
	            	 else
	            		 {
	            		 alert("账号密码有误！");
	            		 flag= false;
	            		 }
	                /* if(data=="1")
	                	{
	                	//alert("手机模式登录成功");
	                	flag= false;
	                	}
	                else
	                	{
	                	alert("账号密码有误");
	                	flag= false;
	                	} */
	              }
				});
			}
		else{
			alert("请输入正确方式登录");
			flag= false;
		}
	
	return flag;
	
	
	}
	
	//验证邮箱类型
function isEmail(strEmail) {
	if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
	return true;
	else
		return false;
	}
	
	//校验手机号码
	//手机号码验证
    function isnum(value){
    	var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
        var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
        if(isMob.test(value)||isPhone.test(value)){
            return true;
        }
        else{
            return false;
        }
    }
</script>
 <!--SIGN UP-->
 <h1>网上银行</h1>
<div class="login-form">
	<!-- <div class="close"> </div> -->
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="${ctx}/images/avtar.png" />
	</div><a href="${ctx}/views/user/regist.jsp">注册</a>
			<form action="${ctx}/userInfo/returnPersonal.do" method="post" onsubmit="return check()">
					<input type="text" class="text" id="userName" value="Phone Or Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Phone Or Email';}" >
						<div class="key">
					<input type="password" value="Password" id="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
						</div>
			<span><a href="${ctx}/views/user/forget_password.jsp">忘记密码？</a></span>
	<div class="signin">
		<input type="submit" value="Login"/>
	</div>
			</form>
</div>


</body>
</html>
