<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<head>
	<title>密码修改</title>
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
			var password=$("#password").val();
			var password_confirm=$("#password_confirm").val();
			var statu=$("#statu").val();
			
			
			 if(password==""||password.length==0)
				{
				alert("密码框不能为空！");
				return false;
				}
			else if(password!=password_confirm)
			{
			alert("密码不一致！");
			return false;
			}
			
			else
				{
				$.ajax({
					type: 'POST',
					 async:false,
		             data: {
		            	 "password":password
		            	 },
		             dataType:'json',
		             url: '${ctx}/userInfo/update_passowrd.do',
		             error:function (date)
		             {
		            	 alert(date.status);
		             },
		             success: function(data){
		                if(data=="1")
		                	{
		                	//alert("手机模式登录成功");
		                	alert("修改成功！牢记密码");
		                	return true;
		                	}
		                else
		                	{
		                	alert("修改失败！");
		                	return false;
		                	}
		              }
					
					
				});
				return true;
				
				}
			
		}
		
		
		
		
		
		
			
	</script>
	
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">密码修改</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="${ctx}/views/user/login.jsp" method="post" onsubmit="return check()">
				<div class="form-inner">
			        
			        			
			        
			           
			           
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
