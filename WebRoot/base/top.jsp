<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
<title>top</title>
<link href="${ctx}/skin/css/base.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/skin/css/top.css" rel="stylesheet" type="text/css"/>

</head>
<body bgColor='#ffffff'>
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="${ctx }/skin/images/frame/topbg.jpg">
  <tr>
    <td width='20%' height="60"><img src="${ctx }/skin/images/frame/logo.gif" /></td>
    <td width='80%' align="right" valign="bottom">
    	<table width="750" border="0" cellspacing="0" cellpadding="0">
      <tr>
      <td align="right" height="60">
        	<span class="username ">您好：${sessionScope.user.loginName} 欢迎登陆！
        	[<a href="${ctx}/UsersServlet?status=exit" target="_top">注销退出</a>]&nbsp; </span>      </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

