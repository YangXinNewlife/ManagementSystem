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

<script language="JavaScript">

function mycheck(){
   if(isNull(form1.wno.value)){  
   alert("请输入员工编号！"); 
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
</script>  

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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:150px;">修改员工信息   ( <span style="color:red;">*</span>可不填)</td>
			  
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="WorkerUpdate.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">员工编号：</td>
                    <td width="67%"><input name="wno" type="text" class="text2" id="wno" /></td>
                  </tr>
                  <tr>
                    <td width="33%" height="30" align="right"><span style="color:red;">*</span>员工姓名：</td>
                    <td width="67%"><input name="wname" type="text"  class="text2" id="wname"  value="<s:property value='worker.wname'/>" /></td>
                  </tr>
                   <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>所属部门：</td>
                    <td><select name="dno" id="dno">   
                     <option value="00" >请选择</option>
                      <option value="01" >人事部</option>
                      <option value="02" >财务部</option>
                       <option value="03" >技术部</option>
					    <option value="04" >销售部</option>
						 <option value="05" >人力资源部</option>
						  <option value="06" >市场部</option>
						   <option value="07" >生产部</option>
						    <option value="08" >后勤部</option>
                    </select></td>
                  </tr>
                        <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>职 &nbsp; &nbsp; &nbsp; &nbsp;位：</td>
                    <td><select name="post" id="post">
                     <option value="00">请选择</option>
                      <option value="01" >经理</option>
                      <option value="02">员工 </option>
                        <option value="03">boss </option>                    
                    </select></td>
                  </tr>
                     <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>状 &nbsp; &nbsp; &nbsp; &nbsp;态：</td>
                    <td><select name="state" id="state">
                      <option value="00">请选择</option>
                      <option value="01">在职</option>
                      <option value="02">离职</option>
					   <option value="03">休假   </option>                 
                    </select></td>
                  </tr>
                    <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>银行卡号：</td>
                    <td><input name="bankcode" type="text" class="text2" id="bankcode" value=""></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td ><input type="submit" name="button" id="button" value="修改">
                      &nbsp;&nbsp;
					  
                <input type="submit" name="button" id="button" value="取消">
                 
					  
                     </td>
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
