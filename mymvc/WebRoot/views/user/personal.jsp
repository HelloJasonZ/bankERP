<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="/commons/taglibs.jsp" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>网上个人银行</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/style/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/style/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${ctx}/style/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${ctx}/style/css/style.css" rel="stylesheet">
    <link href="${ctx}/style/css/style-responsive.css" rel="stylesheet" />
    <script type="text/javascript">
    <script type="text/javascript" src="${ctx}/scripts/jquery-1.8.2.min.js"></script>
     <script type="text/javascript">
     window.onload=function(){
    	 //每30秒刷新一次
    	 setInterval("freshen()",1000*30);
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
            
         	<h2 style="text-align:center;">网上个人银行</h2>
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading" style="">
                          欢迎用户：${user.userName} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="loginOut.do">退出</a><br/>
       	  上次登录时间 ：  ${user.loginTime} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;         <button class="btn btn-danger btn-xs" onclick="freshen();">
                                       <img src="${ctx}/images/load.png" style="width=20px;height:20px;"/>刷新</button>    <br/> 
                             	本账户下有 ${list.size()}张卡   
                             	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                             	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                             	  <a href="${ctx}/views/card/card_regist.jsp">申请卡</a>
                          </header>
                          <table class="table table-striped table-advance table-hover" style="table-layout: fixed;">
                              <thead>
                              <tr>
                                  <th>持卡人</th>
                                  <th>卡号</th>
                                  <th>币种</th>
                                  <th>开户地址</th>
                                  <th>开户时间</th>
                                  <th>卡的状态</th>
                                  <th>余额</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                            
                              <c:forEach var="show" items="${requestScope.list}">
                              	<tr>
                              	 <td><a href="#">${user.userName}</a></td>
                              	 <td class="hidden-phone" style="overflow:hidden;
                                   width:100px;
						white-space:nowrap;
						text-overflow:ellipsis;
						-o-text-overflow:ellipsis;">
                              	 ${show.cardNum}
                                  </td>
                                  <td>${show.cardType}</td>
                              	 <td class="hidden-phone" style="overflow:hidden;
                                   width:100px;
						white-space:nowrap;
						text-overflow:ellipsis;
						-o-text-overflow:ellipsis;">${show.address}</td>
								<td>${show.createTime}</td>
								 <td>
                                  <!-- 0代表不通过  1代表通过  2代表审核中  -->
                                  <c:if test="${show.cardStatu==0}">
                                  <span class="label label-warning label-mini">初始状态</span>
                                  </c:if>
                                  <c:if test="${show.cardStatu==1}">
                                  <span class="label label-success label-mini">正常</span>
                                  </c:if>
                                  <c:if test="${show.cardStatu==2}">
                                  <span class="label label-warning label-mini">已挂失/已锁定</span>
                                  </c:if>
                                   <c:if test="${show.cardStatu==3}">
                                  <span class="label label-warning label-mini">已销户</span>
                                  </c:if>
                                  </td>
                                  <td>
                                   <span class="label label-info label-mini" id="${show.cardNum}">${show.money}</span>
									</td>
							<td>
							 <a class="btn btn-danger btn-xs" href="/mymvc/card/getCardMessage.do?cardNum=${show.cardNum}" onclick="pMethod();"target="_blank">
                                       <img src="${ctx}/images/f.png" style="width=20px;height:20px;"/></a>
                                  </td>
							 
						
                              	</tr>
                              </c:forEach>
                            
                              </tbody> 
                          </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
     
  </section>



  </body>
</html>
