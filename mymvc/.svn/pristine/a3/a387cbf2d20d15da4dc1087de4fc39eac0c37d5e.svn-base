<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<head>
	<title>忘记密码</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="${ctx}/style/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/style/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/style/templatemo_style.css" rel="stylesheet" type="text/css">	
	
	<script type="text/javascript">
	 window.onload=function(){
		 var val=document.getElementById("getCode");
		 val.setAttribute("disabled", true); 
		 
     }
		
	
		function check()
		{
			var phone=$("#phone").val();
			var email=$("#email").val();
			var userName=$("#userName").val();
			var password=$("#password").val();
			var password_confirm=$("#password_confirm").val();
			var statu=$("#statu").val();
			
			
			if(userName==""||userName.length==0)
				{
				alert("用户昵称不能为空！");
				return false;
				}
			else if(password==""||password.length==0)
				{
				alert("密码框不能为空！");
				return false;
				}
			else if(password!=password_confirm)
			{
			alert("密码不一致！");
			return false;
			}
			else if(statu=="1"){
				alert("请补充好其他条件！");
				return false;
			}
			else
				{
				$.ajax({
					type: 'POST',
					 async:false,
		             data: {
		            	 "userName":userName,
		            	 "phone":phone,
		            	 "email":email,
		            	 "password":password
		            	 },
		             dataType:'json',
		             url: '${ctx}/userInfo/addRegister.do',
		             error:function (date)
		             {
		            	 alert(date.status);
		             },
		             success: function(data){
		                if(data=="1")
		                	{
		                	//alert("手机模式登录成功");
		                	alert("注册成功！");
		                	return true;
		                	}
		                else
		                	{
		                	alert("注册失败！");
		                	return false;
		                	}
		              }
					
					
				});
				return true;
				
				}
			
		}
		
		
		
		
		
		
		//验证邮箱类型
		function isEmail(strEmail) {
			if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
			return true;
			else
				return false;
			}
			
			//校验手机号码
		
			
			//邮箱校验
			function searchEmail()
			{
				var val=document.getElementById("getCode");
				var email=$("#email").val();
				if (email== '') {
					document.getElementById("email").value="请输入Email";
					document.getElementById("email_show").innerHTML="<span style='color:red;'>该email不能空</span>";
					val.setAttribute("disabled", true); 
					return false;
					}
				else
					{
					//邮箱校验
					if(isEmail(email))
						{
						//邮箱校验成功
						$.ajax({
							 type: 'POST',
							 async:false,
				             data: {
				            	 "content":email,
				            	 "type":2
				            	 },
				             dataType:'json',
				             url: '${ctx}/userInfo/validPhone.do',
				             error:function (date)
				             {
				            	 alert(date.status);
				             },
				             success: function(data){
				                if(data=="1")
				                	{
				                	document.getElementById("email_show").innerHTML="<span style='color:#00EC00;'>该邮箱可以找回密码</span>";
				                	val.removeAttribute("disabled"); 
				                	return true;
				                	}
				                else
				                	{
				                	document.getElementById("email_show").innerHTML="<span style='color:red;'>该邮箱不存在</span>";
				                	val.setAttribute("disabled", true); 
				                	return false;
				                	}
				              }
							});
						
						
						}
					else
						{
						//邮箱校验失败
						document.getElementById("email_show").innerHTML="<span style='color:red;'>该邮箱格式有误</span>";
						val.setAttribute("disabled", true); 
	                	return false;
						}
					}
				
			}
			
			function sendcode()
			{
				var to=$("#email").val();
				$.ajax({
					type: 'POST',
					 async:false,
		             data: {
		            	 "email":to
		            	 },
		             dataType:'json',
		             url: '${ctx}/userInfo/validEmail.do',
		             error:function (date)
		             {
		            	 alert(date.status);
		             },
		             success: function(data){
		            	 if(data=="1")
		            		 {
		            		 alert("验证码发送成功");
		            		 }
		             }
				});
			}
			
				var countdown=30; 
			function getEmailCode(vals)
			{
				
				if(countdown==30)
					{
					sendcode();
					}
				
				if (countdown == 0) { 
				vals.removeAttribute("disabled");    
				vals.value="免费获取验证码"; 
				countdown = 30; 
				
				} 
				else { 
				vals.setAttribute("disabled", true); 
				vals.value="重新发送(" + countdown + ")"; 
				countdown--; 
				
				if(countdown<=0)
					{
					vals.removeAttribute("disabled");    
					vals.value="免费获取验证码"; 
					countdown=30;
				return;
					}
				} 
				setTimeout(function() { 
					getEmailCode(vals);
				},1000);
				
			}
			
			//邮箱密码验证
			function toValid()
			{
				var email=$("#email").val();
				var code=$("#code").val();
				if(code==""||code.length==0)
					{
					alert("验证码不能为空");
					}
				else if(code.length<6)
					{
					alert("长度不能小于6位");
					}
				else
					{
						//校验验证码合法性
						$.ajax({
							type: 'POST',
							 async:false,
				             data: {
				            	 "email":email,
				            	 "code":code
				            	 },
				             dataType:'json',
				             url: '${ctx}/userInfo/toValid.do',
				             error:function (date)
				             {
				            	 alert(date.status);
				             },
				             success: function(data){
				            	 if(data=="1")
				            		 {
				            		 alert("校验成功");
				            		 window.top.location.href="${ctx}/views/user/update_password.jsp";
				            		 }
				            	 else if(data=="0")
				            		 {
				            		 alert("验证码错误！");
				            		 }
				             }
						});
					}
				
			}
			
			
	</script>
	
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">忘记密码/找回密码</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="${ctx}/views/user/login.jsp" method="post" onsubmit="return check()">
				<div class="form-inner">
					<div class="form-group">
			        <div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">Email</label>
			            <input type="email" class="form-control" id="email" name="email" placeholder="" value="请输入Email" onfocus="this.value = '';" onblur="searchEmail();">		            		            		            
			          </div>              
			        </div>
			        <div class="form-group">
			            <div  id="email_show"></div>             
			        </div>
			         <input type="button" class="btn btn-info" id="getCode" value="免费获取验证码" onclick="getEmailCode(this)"/>
			        			
			        <div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="username" class="control-label">验证码</label>
			            <input type="text" class="form-control" id="code" name="code" placeholder=""/>		            		            		            
			          </div>
			        </div>
			        
			           
			           
			        <div class="form-group">
			          <div class="col-md-12">
			            <input type="button" value="验证" class="btn btn-info" onclick="toValid()">
			            <a href="login.jsp" class="pull-right">Login</a>
			          </div>
			        </div>	
				</div>
				<input type="text" id="statu" value="1" hidden="hidden"/>				    	
		      </form>		      
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/scripts/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/bootstrap.min.js"></script>
</body>
</html>
