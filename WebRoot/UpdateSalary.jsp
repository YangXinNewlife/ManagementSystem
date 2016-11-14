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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:150px;">修改工资   ( <span style="color:red;">*</span>可不填)</td>
			  
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="UpdateSalary.action"  >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">员工编号：</td>
                    <td width="67%"><input name="wno" type="text" class="text2" id="wno" value="001"/></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>基本工资：</td>
                    <td><input name="basic" type="text" class="text2" id="basic" value="1000"></td>
                  </tr>
				   
				  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>岗位工资：</td>
                    <td><input name="post" type="text" class="text2" id="post" value="2000"></td>
                  </tr>
				  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>津 &nbsp;&nbsp; &nbsp;&nbsp;贴：</td>
                    <td><input name="allowance" type="text" class="text2" id="allowance" value="500"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>考 &nbsp;&nbsp; &nbsp;&nbsp;勤：</td>
                    <td><input name="checking" type="text" class="text2" id="checking" value="400"></td>
                  </tr>
				   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>个人税：</td>
                    <td><input name="insurance" type="text" class="text2" id="insurance" value="200"></td>
                  </tr>
				<tr>
                    <td height="30" align="right"><span style="color:red;">*</span>五险一金：</td>
                    <td><input name="tax" type="text" class="text2" id="tax" value="200"></td>
                  </tr>
                   
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="取消" ></td>
                  </tr>
                </table>
              </form></td>
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
