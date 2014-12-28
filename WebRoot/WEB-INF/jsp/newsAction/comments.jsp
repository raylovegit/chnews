<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻评论</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="30" colspan="6" background="skin/images/tbg.gif"><p align="center"><font size="18" color="red">评论</font></p></td>
 </tr>
 <tr align="right" background="skin/images/tbg.gif">
	<td width="10%" align="center">
	 评论者</td>
    <td width="80%" align="center">内容</td>
    <td width="10%" align="center">操作</td>
</tr>
<c:forEach items="${clist}" var="c">
<tr align="right" bgcolor="#EEF4EA">
    <td align="center">${c.author }</td>
    <td align="center">${c.content}</td>
    <td align="center">
    <c:choose>
    <c:when test="${c.flag eq 'true'}">
    <font color="red">显示</font>&nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp; <a href="${ctx}/NewsServlet?status=deleteC&cid=${c.id}&id=${c.newsId }">删除</a>
    </c:when>
    <c:otherwise>
     <a href="${ctx}/NewsServlet?status=updateC&cid=${c.id}&id=${c.newsId }">显示</a>&nbsp;&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;&nbsp; <a href="${ctx}/NewsServlet?status=deleteC&cid=${c.id}&id=${c.newsId }">删除</a>
    </c:otherwise>
    </c:choose>
    </td>
</tr>
</c:forEach>
<tr bgcolor="#E7E7E7">
  <td height="12" colspan="6" background="skin/images/tbg.gif">&nbsp;</td>
</tr>
</table>
</body>
</html>
