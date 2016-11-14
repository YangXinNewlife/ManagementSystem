<%@ page language="java"  pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>login </title>
	<link rel="stylesheet" href="style.css" type="text/css" />

	<style type="text/css">
	.STYLE1 {
	font-family: "Courier New", Courier, monospace;
	font-weight: bold;
}
    </style>
	</head>
	
	<script language="JavaScript">

function mycheck(){
   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
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

	<body >
	
		<div id="container" align="center">
			 <form name="form1" action="GoLogin.action" method="post" onSubmit="return mycheck()">
				<div class="login STYLE1">LOGIN<%if(request.getAttribute("Msg")!=null){%>
                    <%=request.getAttribute("Msg")%>
                    <%}%>
               </div>
				<div class="username-text">Username:</div>
				<div class="password-text" >Password:</div>
				<div class="username-field">
				  <input type="text" name="Username"  value="张三" />
				</div>
				<div class="password-field" >
				  <input type="password" name="Password" value="123"/>
				</div >
		
				  <table width="100%" border="0" align="center"  id="RadioButtonList1"  >
                    <tr align="center" valign="top">
                      <td><input id="Type" type="radio" name="Type" value="worker"  checked="checked"  >
                          <label for="Type"><span class="STYLE9">员工</span></label></td>
                      <td width="117" ><input id="Type" type="radio" name="Type" value="manager" >
                          <label for="Type"><span class="STYLE9">经理</span></label>                      </td>
                      <td width="121" ><input id="Type" type="radio" name="Type" value="other" >
                          <label for="Type"><span class="STYLE9">其他</span></label>                      </td>
                      <th width="116" valign="top" ><input type="submit" name="submit" value="GO"  src="images/go-hover.png" />
                    </tr>
                  </table>
			 </form>
		</div>
		
		<div id="footer" >版权所有@计科11物联</div>
	</body>
</html>
