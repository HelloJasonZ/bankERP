<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>卡具体信息</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/style/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/style/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/style/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/style/css/style.css" rel="stylesheet">
    <link href="${ctx}/style/css/style-responsive.css" rel="stylesheet" />
   <link rel="Stylesheet" type="text/css" href="${ctx}/style/openDialog.css" />
    
     <script type="text/javascript" src="${ctx}/scripts/jquery-1.8.2.min.js"></script>
     
     <script type="text/javascript">
			$(function ($) {
		//弹出
		$("#out").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask'></div>");
			$("#mask").addClass("mask").fadeIn("slow");
			$("#LoginBox").fadeIn("slow");
		});
		//
		
		$("#intMoney").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask_1'></div>");
			$("#mask_1").addClass("mask_1").fadeIn("slow");
			$("#LoginBox_1").fadeIn("slow");
		});
		
		$("#checkTrade").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask_2'></div>");
			$("#mask_2").addClass("mask_2").fadeIn("slow");
			$("#LoginBox_2").fadeIn("slow");
			checkTrade();
		});
		
		$("#checkFloat").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask_3'></div>");
			$("#mask_3").addClass("mask_3").fadeIn("slow");
			$("#LoginBox_3").fadeIn("slow");
			checkFloat();
		});
		
		
		$("#transferMoney").hover(function () {
			$(this).stop().animate({
				opacity: '1'
			}, 600);
		}, function () {
			$(this).stop().animate({
				opacity: '0.6'
			}, 1000);
		}).on('click', function () {
			$("body").append("<div id='mask_t'></div>");
			$("#mask_t").addClass("mask_t").fadeIn("slow");
			$("#LoginBox_t").fadeIn("slow");
			/* //checkFloat(); */
		});
		
		//关闭
		$(".close_btn").hover(function () 
				{ $(this).css({ color: 'black' }) }, function () { $(this).css({ color: '#999' }) }).on('click', function () {
			$("#LoginBox").fadeOut("fast");
			$("#mask").css({ display: 'none' });
		});
	});
			
			$("#loginbtn_1").hover(function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 600);
			}, function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 1000);
			});						
			//关闭
			$(".close_btn_1").hover(function () 
					{ 
				$(this).css({ color: 'black' }) 
				}, function () {
					$(this).css({ color: '#999' }) 
					}).on('click', function () {
						alert(0);
				$("#LoginBox_1").fadeOut("fast");
				$("#mask_1").css({ display: 'none' });
			});
			function cencle()
			{
				$("#LoginBox_1").fadeOut("fast");
				$("#mask_1").css({ display: 'none' });
			}
			
			
			
			$("#loginbtn_2").hover(function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 600);
			}, function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 1000);
			});						
			//关闭
			$(".close_btn_2").hover(function () 
					{ 
				$(this).css({ color: 'black' }) 
				}, function () {
					$(this).css({ color: '#999' }) 
					}).on('click', function () {
						alert(0);
				$("#LoginBox_2").fadeOut("fast");
				$("#mask_2").css({ display: 'none' });
			});
			function cencle_2()
			{
				$("#LoginBox_2").fadeOut("fast");
				$("#mask_2").css({ display: 'none' });
			}
			
			
			//转账记录流水
			$("#loginbtn_3").hover(function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 600);
			}, function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 1000);
			});						
			//关闭
			$(".close_btn_3").hover(function () 
					{ 
				$(this).css({ color: 'black' }) 
				}, function () {
					$(this).css({ color: '#999' }) 
					}).on('click', function () {
						alert(0);
				$("#LoginBox_3").fadeOut("fast");
				$("#mask_3").css({ display: 'none' });
			});
			function cencle_3()
			{
				$("#LoginBox_3").fadeOut("fast");
				$("#mask_3").css({ display: 'none' });
			}
			
			//转账模块
			$("#loginbtn_t").hover(function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 600);
			}, function () {
				$(this).stop().animate({
					opacity: '0.8'
				}, 1000);
			});						
			//关闭
			$(".close_btn_t").hover(function () 
					{ 
				$(this).css({ color: 'black' }) 
				}, function () {
					$(this).css({ color: '#999' }) 
					}).on('click', function () {
						alert(0);
				$("#LoginBox_t").fadeOut("fast");
				$("#mask_t").css({ display: 'none' });
			});
			function cencle_t()
			{
				$("#LoginBox_t").fadeOut("fast");
				$("#mask_t").css({ display: 'none' });
			}
			
			
			function freshen()
			{
				location.reload();
			}
			</script>
  </head>
<body>
<!-- <div class="adcenter"><script src="http://www.cssmoban.com/include/new/ggad2_728x90.js"></script></div> -->

  <section id="container" class="">
      <!--header start-->
      
      <!--header end-->
      <!--sidebar start-->
      
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!-- page start-->
            
         
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             	<h2>卡详细信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button class="btn btn-danger btn-xs" onclick="freshen();">
           <img src="${ctx}/images/load.png" style="width=20px;height:20px;"/>&nbsp;刷新
          </button>
	</h2>
                             	卡状态
                             	 <c:if test="${card.cardStatu==0}">
                                  <span class="label label-warning label-mini">初始状态</span>
                                  </c:if>
                                  <c:if test="${card.cardStatu==1}">
                                  <span class="label label-success label-mini">正常</span>
                                  </c:if>
                                  <c:if test="${card.cardStatu==2}">
                                  <span class="label label-warning label-mini">已挂失/已锁定</span>
                                  </c:if>
                                   <c:if test="${card.cardStatu==3}">
                                  <span class="label label-warning label-mini">已销户</span>
                                  </c:if>
                                  
                          </header>
                       <h4>户名:&nbsp;${user.userName}</h4>  
                         <h4> 卡号:&nbsp;${card.cardNum}
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
账户类型:${card.cardType}</h4>
<input type="text" id="cardNum" hidden="hidden" value="${card.cardNum}" />
						<h4> 开户地点:&nbsp;${card.address}
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
办卡时间:${card.createTime}</h4>

 <!-- 取款 -->
			<div id="LoginBox">
        				<div class="row1">
            			取款窗口<a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="closeBtn">×</a>
        			</div>
					<div class="roow">
					<!-- <form action="/pages/UserBasic/updateImg.do" method="post" enctype="multipart/form-data" accept=".jpg,.bmp,.gif" >
					 上传头像<input type="file" name="file" accept=".jpg,.bmp,.gif" /><br/>
				 <input type="submit" value="确定上传"/>
				</s:form> -->
				请输入金额(${card.money}~1)：
				<input type="text" id="draw_money" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><br/>
				请输入支付密码:<input type="password" id="draw_password"/><br/>
				<br/>
				<button onclick="drawMoney();">
				 <img src="${ctx}/images/Ok.png" style="width=20px;height:20px;"/>&nbsp;确定
				</button>
		</div>      
    </div>



<!-- 存款 -->
    <div id="LoginBox_1">
        				<div class="row1_1">
            			存款窗口<!-- <a href="javascript:void(0)" title="关闭窗口" class="close_btn_1" id="closeBtn_1">×</a> -->
        			</div>
					<div class="roow_1">
					<!-- <form action="/pages/UserBasic/updateImg.do" method="post" enctype="multipart/form-data" accept=".jpg,.bmp,.gif" >
					 上传头像<input type="file" name="file" accept=".jpg,.bmp,.gif" /><br/>
				 <input type="submit" value="确定上传"/>
				</s:form> -->
				<input  type="text" value="${card.cardId}" hidden="hidden" id="myCardId"/>
				请输入存款金额：<input type="text" id="putMoney" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><br/>
				<br/>
				<button onclick="putMoney();">
				 <img src="${ctx}/images/Ok.png" style="width=20px;height:20px;"/>&nbsp;确定
				</button>
				<button onclick="cencle();">
				 <img src="${ctx}/images/cancel.png" style="width=20px;height:20px;"/>&nbsp;取消
				</button>
		</div>      
    </div>


<!-- json显示交易记录信息 -->
    	<div id="LoginBox_2">
        				<div class="row1_2">
            			交易记录窗口<!-- <a href="javascript:void(0)" title="关闭窗口" class="close_btn_1" id="closeBtn_1">×</a> -->
        			</div>
					<div class="roow_2">
					<span >时间</span>
					<span style="margin-left: 240px;">操作</span>
					<span style="margin-left: 50px;">金额</span>
					<table cellspacing="2" cellpadding="2" style="border: 2px solid #5B5B5B;width:100%;"id="showContent">
					</table>
				<button onclick="cencle_2();">
				 <img src="${ctx}/images/cancel.png" style="width=20px;height:20px;"/>&nbsp;取消
				</button>
		</div>      
    </div>
    
    <!-- json显示交易记录信息end -->
    
     <!-- json显示交易记录信息 -->
    	 <div id="LoginBox_3">
        				<div class="row1_3">
            			交易记录窗口
        			</div>
					<div class="roow_3">
					<span>流水号</span>
					<span style="margin-left: 60px;">出账账号</span>
					<span style="margin-left: 50px;">入账账号</span>
					<span style="margin-left: 50px;">交易金额</span>
					<span style="margin-left: 10px;">交易日期</span>
					<span style="margin-left: 10px;">交易状态</span>
					<span style="margin-left: 20px;">交易原因</span>
					<!-- <span style="margin-left: 240px;">操作</span>
					<span style="margin-left: 50px;">金额</span> -->
					<table cellspacing="10" cellpadding="4" style="border: 2px solid #5B5B5B;width:100%;"id="showTransfe" >
					</table>
				<button onclick="cencle_3();">
				 <img src="${ctx}/images/cancel.png" style="width=20px;height:20px;"/>&nbsp;取消
				</button>
		</div>      
    </div> 
    
    <!-- json显示交易记录信息end -->

 <!-- 转账 -->
    <div id="LoginBox_t">
        				<div class="row1_t">
            			存款窗口<!-- <a href="javascript:void(0)" title="关闭窗口" class="close_btn_1" id="closeBtn_1">×</a> -->
        			</div>
					<div class="roow_t">
					<!-- <form action="/pages/UserBasic/updateImg.do" method="post" enctype="multipart/form-data" accept=".jpg,.bmp,.gif" >
					 上传头像<input type="file" name="file" accept=".jpg,.bmp,.gif" /><br/>
				 <input type="submit" value="确定上传"/>
				</s:form> -->
				目标账户:<input type="text" id="transfer_num" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><br/>
				请输入转账金额：<input type="text" id="transfer_money" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" /><br/>
				请输入支付密码:<input type="password" id="transfer_password"/><br/>
				<br/>
				<button onclick="transferMoney();">
				 <img src="${ctx}/images/Ok.png" style="width=20px;height:20px;"/>&nbsp;确定
				</button>
				<button onclick="cencle_t();">
				 <img src="${ctx}/images/cancel.png" style="width=20px;height:20px;"/>&nbsp;取消
				</button>
		</div>      
    </div>



<h4>卡的余额 <span class="label label-info label-mini">￥${card.money}</span></h4>
<input type="text" id="cardMoney" hidden="hidden" value="${card.money}" />
 <br/>     
      <h3>相关账户操作</h3> <br/> 
          ${notice.noticeType}    
          <br/>
          &nbsp;&nbsp;
          <c:if test="${card.cardStatu==1}">
          <button class="btn btn-danger btn-xs" id="out">
           <img src="${ctx}/images/withdraw.png" style="width=20px;height:20px;"/>&nbsp;取款
          </button>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <button class="btn btn-danger btn-xs" id="intMoney">
           <img src="${ctx}/images/deposit.png" style="width=20px;height:20px;"/>&nbsp;存款
          </button>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <button class="btn btn-danger btn-xs" id="transferMoney">
           <img src="${ctx}/images/transfer.png" style="width=20px;height:20px;"/>&nbsp;转账
          </button>
          </c:if>
           &nbsp;&nbsp;&nbsp;&nbsp;
          <button class="btn btn-danger btn-xs" id="checkTrade">
           <img src="${ctx}/images/f.png" style="width=20px;height:20px;"/>&nbsp;查看交易记录
          </button>
           &nbsp;&nbsp;&nbsp;&nbsp;
          <button class="btn btn-danger btn-xs" id="checkFloat">
           <img src="${ctx}/images/f.png" style="width=20px;height:20px;"/>&nbsp;查看转账流水
          </button>
          <hr/>
          <!-- 如果受理显示 -->
          
                   
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
     
  </section>
<script type="text/javascript">
// 转账
	function transferMoney()
	{
		var cardNum=$("#cardNum").val();
		var objectNum=$("#transfer_num").val();
		var password=$("#transfer_password").val();
		var money=$("#transfer_money").val();
		if(objectNum.length==0||password.length==0||money.length==0)
			{
			alert("请输入完整");
			}
		else{
			$.ajax({
				type:'POST',
				data:{cardNum:cardNum,password:password,intNum:objectNum,money:money},
				dataType:'json',
				url: '${ctx}/card/transferMoney.do',
	             error:function (date)
	             {
	            	 alert(date.status);
	             },
	             success: function(data){
	            	 if(data=="1")
	                	{
	                	alert("转账成功");
	                	//window.top.location.href="localhost:8080/MyWeb/GetCardMessageServlet?cardNum="+cardNum;
	                	location.reload();
	                	}
	                else if(data=="0"){
	                	alert("用户失效,重新登陆");
	                	window.top.location.href="localhost:8080/mymvc/views/user/login.jsp";
	                }
	                else if(data=="-1")
	                	{
	                	alert("交易密码错误，谨慎输入，错误过多将锁住卡！");
	                	//window.top.location.href="localhost:8080/MyWeb/GetCardMessageServlet?cardNum="+cardNum;
	                	location.reload();
	                	}
	                else if(data=="-2")
	                	{
	                	alert("交易失败，请查看转账日志");
	                	location.reload();
	                	}
	             }
			});
		}
	
	}
	//查看转账流程
	function checkFloat()
	{
		var cardNum=$("#cardNum").val();
		$.ajax({
			type:'POST',
			data:{cardNum:cardNum},
			dataType:'json',
			url: '${ctx}/logmsg/findCardTransferFloat.do',
             error:function (date)
             {
            	 alert(date.status);
             },
             success: function(data){
            	 if(data[0].statue=="0")
            		 {
            		 location.reload();
            		 }
            	 else 
            		 {
            		//获取json数据
            		 document.getElementById("showTransfe").innerHTML ="";
            		 for(var index in data)
             		{
             			 var mess=data[index];
             			 var str="";
             			 if(mess.tranfer.tradeStau)
             				 {
             				str="成功";
             				 }
             			 else
             				 {
             				str="失败";
             				 }
             			 //alert(mess.logmsg.creatDate);
             			 $("#showTransfe").append("<tr><td style='border: 1px solid #5B5B5B;'>"+mess.tranfer.floatNum+"</td>"
             					 +"<td style='border: 1px solid #5B5B5B;'>"+mess.tranfer.putNum+"</td>"
             					+"<td style='border: 1px solid #5B5B5B;'>"+mess.tranfer.intNum+"</td>"
             					+"<td style='border: 1px solid #5B5B5B;'>"+mess.tranfer.money+"</td>"
             					+"<td style='border: 1px solid #5B5B5B;'>"+mess.tranfer.createTime+"</td>"
             					+"<td style='border: 1px solid #5B5B5B;'>"+str+"</td>"
             					 +"<td style='border: 1px solid #5B5B5B;'>"+mess.tranfer.result+"</td></tr>");
             		}
            		 }
             }
		});
	}


	function checkTrade()
	{
		var cardNum=$("#cardNum").val();
		var cardId=$("#myCardId").val();
		//查看交易记录
		$.ajax({
			type:'POST',
			data:{cardId:cardId},
			dataType:'json',
			url: '${ctx}/logmsg/findCardLog.do',
             error:function (date)
             {
            	 alert(date.status);
             },
             success: function(data){
            	 if(data[0].statue=="0")
            		 {
            		 location.reload();
            		 }
            	 else 
            		 {
            		 //获取json数据
            		 document.getElementById("showContent").innerHTML ="";
            		 for(var index in data)
            		{
            			 var mess=data[index];
            			 //alert(mess.logmsg.creatDate);
            			 $("#showContent").append("<tr><td style='border: 1px solid #5B5B5B;'>"+mess.logmsg.creatDate+"</td>"
            					 +"<td style='border: 1px solid #5B5B5B;'>"+mess.logmsg.action+"</td>"
            					 +"<td style='border: 1px solid #5B5B5B;'>"+mess.logmsg.money+"</td></tr>");
            		}
            		 }
             }
		});
	}
		//取款
		function drawMoney()
		{
			var cardNum=$("#cardNum").val();
			var draw_money=$("#draw_money").val();
			var draw_password=$("#draw_password").val();
			var cardMoney=$("#cardMoney").val();
			
			var cM=parseInt(cardMoney);
			var dM=parseInt(draw_money);
			if(cM<dM)
				{
				//余额小于取款
				alert("余额不足，无法取款");
				}
			else if(draw_money.length==0||draw_password.length==0)
				{
				alert("请输入完整！");
				}
			else
				{
				//前提判断通过进行ajax通讯
				$.ajax({
					type:'POST',
					data:{cardNum:cardNum,password:draw_password,money:draw_money},
					dataType:'json',
					url: '${ctx}/card/widthDrawMoney.do',
		             error:function (date)
		             {
		            	 alert(date.status);
		             },
		             success: function(data){
		                if(data=="1")
		                	{
		                	//alert("登录成功");
		                	alert("取款成功");
		                	//window.top.location.href="localhost:8080/MyWeb/GetCardMessageServlet?cardNum="+cardNum;
		                	location.reload();
		                	}
		                else if(data=="0"){
		                	alert("用户失效,重新登陆");
		                	
		                	window.top.location.href="${ctx}/views/user/login.jsp";
		                }
		                else if(data=="-1")
		                	{
		                	alert("交易密码错误，谨慎输入，错误过多将锁住卡！");
		                	//window.top.location.href="localhost:8080/MyWeb/GetCardMessageServlet?cardNum="+cardNum;
		                	location.reload();
		                	}
		                else if(data=="-2")
		                	{
		                	alert("操作失败");
		                	location.reload();
		                	}
		                	
		              }
					
				});
				}
			
		}
		
		function putMoney()
		{
			//存款
			var cardNum=$("#cardNum").val();
			var putMoney=$("#putMoney").val();
			var pM=parseInt(putMoney);
			if(pM==0)
				{
				alert("转入价格不能为0");
				}
			else if(putMoney.length==0)
				{
				alert("输入框不能为空");
				}
			else
				{
				//存入逻辑
				$.ajax({
					type:'POST',
					data:{cardNum:cardNum,money:putMoney},
					dataType:'json',
					url: '${ctx}/card/depositMoney.do',
		             error:function (date)
		             {
		            	 alert(date.status);
		             },
		             success: function(data){
		                if(data=="1")
		                	{
		                	alert("存款成功");
		                	location.reload();
		                	}
		                else if(data=="0"){
		                	alert("用户失效,重新登陆");
		                	window.top.location.href="${ctx}/views/user/login.jsp";
		                }
		                else if(data=="-2")
	                	{
	                	alert("操作失败");
	                	location.reload();
	                	}
		             }
					
				});
				
				}
		}

	
	function toVaild()
	{
		var elm =document.getElementsByName("organizationApply.organizationApplyState");
		var content=document.getElementById("reContent").value;
		var c=content.replace(/(^\s+)|(\s+$)/g, "");
		checked=false;
		for(i=0;i<elm.length;i++)
		{
			if(elm[i].checked)
			{
			checked=true;
			}
		}
			if (!checked)
			{
			alert("请选择是否通过");
			return false;
			}
			if(c=="")
			{
			alert("请填写反馈信息");
			return false;
			}
			return true;
		}
	
	function show()
	{
		var d=document.getElementById("content");
		if(d.style.display=="none")
		{
		d.style.display="block";
		}
	}
</script>

  </body>
</html>
