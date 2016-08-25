<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<head>
	<title>注册账号</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="${ctx}/style/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/style/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/style/templatemo_style.css" rel="stylesheet" type="text/css">	
	
	<script type="text/javascript">
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
		
			//手机失去焦点事件
			function search()
			{
				var phone=$("#phone").val();
				if (phone== '') {
					document.getElementById("phone").value="请输入手机号码";
					document.getElementById("show").innerHTML="<span style='color:red;'>该手机不能空</span>";
					document.getElementById("statu").value=1;
					return false;
					}
				else
					{
					
				//手机校验
				if(isnum(phone))
					{
					//手机格式正确
					//alert("格式正确");
					//查询是否存在该手机ajax
					$.ajax({
						 type: 'POST',
						 async:false,
			             data: {
			            	 "content":phone,
			            	 "type":1
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
			                	document.getElementById("show").innerHTML="<span style='color:red;'>该手机已存在</span>";
			                	document.getElementById("statu").value=1;
			                	return false;
			                	}
			                else
			                	{
			                	document.getElementById("show").innerHTML="<span style='color:#00EC00;'>该手机可以注册</span>";
			                	document.getElementById("statu").value=0;
			                	return true;
			                	}
			              }
						});
					}
				else
					{
					document.getElementById("show").innerHTML="<span style='color:red;'>该手机格式有误</span>";
                	document.getElementById("statu").value=1;
                	return false;
					}
					}
			}
			
			//邮箱校验
			function searchEmail()
			{
				var email=$("#email").val();
				if (email== '') {
					document.getElementById("email").value="请输入Email";
					document.getElementById("email_show").innerHTML="<span style='color:red;'>该email不能空</span>";
					document.getElementById("statu").value=1;
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
				                	document.getElementById("email_show").innerHTML="<span style='color:red;'>该邮箱已存在</span>";
				                	document.getElementById("statu").value=1;
				                	return false;
				                	}
				                else
				                	{
				                	document.getElementById("email_show").innerHTML="<span style='color:#00EC00;'>该邮箱可以注册</span>";
				                	document.getElementById("statu").value=0;
				                	return true;
				                	}
				              }
							});
						
						
						}
					else
						{
						//邮箱校验失败
						document.getElementById("email_show").innerHTML="<span style='color:red;'>该邮箱格式有误</span>";
	                	document.getElementById("statu").value=1;
	                	return false;
						}
					}
				
			}
			
	</script>
	
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">网银会员注册</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="${ctx}/views/user/login.jsp" method="post" onsubmit="return check()">
				<div class="form-inner">
					<div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="first_name" class="control-label">手机号码</label>
			            <input type="text" class="form-control" id="phone" name="phone" placeholder="" maxlength="11" value="请输入手机号码" onfocus="this.value = '';" onblur="search();">		            		            		            
			          </div>  
			          <div class="col-md-6">	
			         <label for="last_name" class="control-label"></label>
			         <br/><br/>
			         <div  id="show"></div>
			           </div>    	
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">Email</label>
			            <input type="email" class="form-control" id="email" name="email" placeholder="" value="请输入Email" onfocus="this.value = '';" onblur="searchEmail();">		            		            		            
			          </div>              
			        </div>
			        
			        <div class="form-group">
			            <div  id="email_show"></div>             
			        </div>
			        
			        			
			        <div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="username" class="control-label">昵称</label>
			            <input type="text" class="form-control" id="userName" name="userName" placeholder="" onblur="check_username()"/>		            		            		            
			          </div>
			        </div>
			        
			           
			           
			        <div class="form-group">
			          <div class="col-md-6">
			            <label for="password" class="control-label">密码</label>
			            <input type="password" class="form-control" id="password" name="password" placeholder="" maxlength="18" >
			          </div>
			          <div class="col-md-6">
			            <label for="password" class="control-label">再次确认密码</label>
			            <input type="password" class="form-control" id="password_confirm" placeholder="" maxlength="18"/>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <input type="submit" value="Create account" class="btn btn-info">
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
