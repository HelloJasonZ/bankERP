<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>

<!DOCTYPE html>
<head>
	<title>申请卡号</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="${ctx}/style/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/style/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/style/templatemo_style.css" rel="stylesheet" type="text/css">	
	<script type="text/javascript" src="${ctx}/scripts/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
	window.onload=function(){
		$.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js', function(_result) {
            if (remote_ip_info.ret == '1') {
            var mess=remote_ip_info.province+"省"+remote_ip_info.city+"市";
            document.getElementById("address").value=mess;
                //alert(remote_ip_info.country + '<BR>省：' + remote_ip_info.province + '<BR>市：' + remote_ip_info.city + '<BR>区：' + remote_ip_info.district + '<BR>ISP：' + remote_ip_info.isp + '<BR>类型：' + remote_ip_info.type + '<BR>其他：' + remote_ip_info.desc);
            } else {
                alert('没有找到匹配的IP地址信息！');
                //没有网络手动输入
                document.getElementById("address").readOnly=false;
            }
        });
		autoGetNum();
	}
			
	
	function autoGetNum()
	{
		//获取获取卡号
		$.ajax({
			type:'POST',
			dataType:'json',
			url:'${ctx}/card/autoGetCardNum.do',
			 error:function (date)
             {
            	 alert(date.status);
             },
             success: function(data){
            	 document.getElementById("cardNum").value=data;
             }
		});
	}
	
	function check()
	{
		var cardNum=$("#cardNum").val();
		var address=$("#address").val();
		var password=$("#password").val();
		var password_confirm=$("#password_confirm").val();
		
		if(address==""||address.length==0)
		{
		alert("地址不能为空！");
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
	else
		{
		$.ajax({
			type:'POST',
			 async:false,
			data:{cardNum:cardNum,address:address,password:password},
			 dataType:'json',
				url:'${ctx}/card/registerCardNum.do',
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
                else if(data=="0")
                	{
                	alert("用户过期，重新登陆");
                	window.top.location.href="${ctx}/views/user/login.jsp";
                	return false;
                	}
                else if(data=="-1"){
                	alert("操作失败,稍后重新试");
                	return false;
                }
                	
                	
             }
		});
		
		
		}
	}
	</script>
	
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">网银卡号注册</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="${ctx}/userInfo/returnPersonal.do" method="post" onsubmit="return check()">
				<div class="form-inner">
					<div class="form-group">
			          <div class="col-md-6">		          	
			            <label for="first_name" class="control-label">卡号(自动生成)</label> <a href="javascript:void(0);" onclick="autoGetNum();">刷新</a>
			            <input type="text" class="form-control" readonly="readonly" id="cardNum" name="cardNum" placeholder="" maxlength="11"  >		            		            		            
			          </div>  
			          <div class="col-md-6">	
			         <label for="last_name" class="control-label"></label>
			         <br/><br/>
			         <div  id="show"></div>
			           </div>    	
			          <!-- <div class="col-md-6">		          	
			            <label for="last_name" class="control-label">Last Name</label>
			            <input type="text" class="form-control" id="last_name" placeholder="">		            		            		            
			          </div>    -->          
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">开户地点(连接网络自动获取)</label>
			            <input type="email" readonly="readonly" class="form-control" id="address" name="address" placeholder=""  >		            		            		            
			          </div>              
			        </div>
			        
			        <div class="form-group">
			            <div  id="email_show"></div>             
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
