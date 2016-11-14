<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人事工资管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">人事工资管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" >员工信息</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="WorkerQuery.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    
                    <td width="72%">查询：
					<label id="workno">员工编号</label>
					 <input id="workerno" name="workerno" value="" />
					
                      <input type="submit" name="button" id="button" value="点击查询"/></td>
                  </tr>
                </table>
              </form>
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                  <tr align="center"  class="t1">
                    <td width="14%"  bgcolor="#D5E4F4"><strong>员工编号</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>姓名</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>部门</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>性别</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>职位</strong></td>
					 <td width="14%" bgcolor="#D5E4F4"><strong>状态</strong></td>
                    <td width="16%" bgcolor="#D5E4F4"><strong>银行卡号</strong></td>
				
                  </tr>
                  <s:iterator id="aa" value="w">
                    <tr align="center">
                      <td height="25" align="center">${wno}</td>
                      <td>${wname}</td>
                      <td>${dno}</td>
                      <td>${sex}</td>
                      <td >${post}</td>
                       <td >${state}</td>
					   <td >${bankcode}</td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
