<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>栏目管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>
<form name="myform" action="ItemsServlet?status=update" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">添加栏目</td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td width="48%" align="center"><div align="right">
	  <!--翻页代码 -->
	  栏目名称：</div>
	 </td>
    <td width="52%" align="center"><label>
      <div align="left">
        <input type="text" name="title" id="title" size="20" value="${items.title }">
        </div>
    </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right"><input type="submit" class="coolbg" value="提交"></div></td>
  <td align="center"><div align="left"><input type="reset" class="coolbg" value="取消"></div></td>
</tr>
</table>
<input type="hidden" name="id" value="${items.id }">
</form>
</body>
</html>

