<%@ page language="java" pageEncoding="UTF-8"%>
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
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ManagerQuery2.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    
                    <td width="72%">查询：
					<label id="dno">部门编号</label>
					 <input id="dno" name="dno" value="" />
					
                      <input type="submit" name="button" id="button" value="点击查询"/></td>
                  </tr>
                </table>
              </form>
                <table border="0" cellspacing="0" cellpadding="0" width="100%">
                  <tr align="center"  class="t1">
                    <td width="14%"  bgcolor="#D5E4F4"><strong>员工编号</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>基本工资</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>岗位工资</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>津贴</strong></td>
                    <td width="14%" bgcolor="#D5E4F4"><strong>考勤</strong></td>
					 <td width="14%" bgcolor="#D5E4F4"><strong>个人所得税</strong></td>
					  <td width="16%" bgcolor="#D5E4F4"><strong>五险一金</strong></td>
                  </tr>
                  <s:iterator id="d" value="salary">
                    <tr align="center">
                      <td height="25" align="center">${wno}</td>
                      <td>${basic}</td>
                      <td >${post}</td>
                       <td >${allowance}</td>
					   <td >${checking}</td>
					     <td >${insurance}</td>
						 <td >${tax}</td>
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
