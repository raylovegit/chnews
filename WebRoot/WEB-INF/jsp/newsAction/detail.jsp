<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ include file="/common/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文档管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>

<table width="98%" border="0" cellpadding="2" cellspacing="0" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="6" background="skin/images/tbg.gif">详细新闻</td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td width="14%" align="center">
	  <div align="right">
	    <!--翻页代码 -->
      新闻标题：</div></td>
    <td width="15%" align="left">${news.title }</td>
    <td width="15%" align="center"><div align="right">题肩：</div></td>
    <td width="15%" align="left">${news.subTitle }</td>
    <td width="20%" align="center"><div align="right">小标题：</div></td>
    <td width="21%" align="left">${news.sub2Title }</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"> <div align="right">新闻类型：</div></td>
  <td align="left">${news.kindName }</td>
  <td align="center"><div align="right">新闻类别：</div></td>
  <td align="left">${news.typeName }</td>
  <td align="center"><div align="right">作者：</div></td>
  <td align="left">${news.author }</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><label>
    <div align="right">新闻来源：</div>
  </label></td>
  <td colspan="5" align="left"><div align="left">${news.newsFrom }</div></td>
  </tr>
<tr align="right" bgcolor="#EEF4EA">
  <td colspan="6" align="left"><div align="left"> 新闻内容：</div></td>
 </tr>
<tr align="right" bgcolor="#EEF4EA">
  <td colspan="6" align="left"><label>
    <FCK:editor instanceName="caption" width="800px" height="350px" value="${news.caption}"></FCK:editor>
    </label></td>
</tr>
<tr bgcolor="#E7E7E7">
  <td height="12" colspan="6" background="skin/images/tbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
