<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/js.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>栏目管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <form name="form3" action="ItemsServlet?status=readAll&pageNum=1" method="post">
      <table width='100%'  border='0' cellpadding='1' cellspacing='1' align="center" style="margin-top:5px">
  <tr>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='key' style='width:150'>
          	<option value='title'>栏目名称</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='value' value='' style='width:150px' />
        </td>
        <td>
          <input class="coolbg" type="submit"  width="45" height="20" border="0" value="搜索" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
 </td>
 </tr>
</table>
</td>
</tr>
</table>
<form id="form2" name="form2" action="ItemsServlet?status=bentchdetele" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp;栏目列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="6%">用户ID</td>
	<td width="10%">栏目名称</td>
	<td width="15%">操作</td>
</tr>
<c:forEach items="${ilist}" var="i">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="ids" type="checkbox" id="ids" value=${i.id}" class="np"></td>
	<td align="left">${i.title }</td>
	<td><a href="ItemsServlet?status=preUpdate&id=${i.id}">编辑</a> | <a href="ItemsServlet?status=delete&id=${i.id}" onclick="if(!confirm('确定要删除吗？')) return false;">删除</a></td>
</tr>
</c:forEach>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="4">
	&nbsp;
	<a id="allcheck" href="#" class="coolbg">全选</a>
	<a id="uncheck" href="#" class="coolbg">取消</a>
	<a id="delete" href="#" onclick="return submit('form2');" class="coolbg">&nbsp;删除&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
 <td height="36" colspan="10" align="center">
   <div>${sessionScope.page.currentpage}/${sessionScope.page.totalpages }</div>
   <a href="ItemsServlet?status=pageBreak&pageNum=1" class="coolbg">首页</a>
   <a href="ItemsServlet?status=pageBreak&pageNum=${sessionScope.page.prepage }" class="coolbg">上一页</a>
   <a href="ItemsServlet?status=pageBreak&pageNum=${sessionScope.page.nextpage }" class="coolbg">下一页</a>
   <a href="ItemsServlet?status=pageBreak&pageNum=${sessionScope.page.totalpages }" class="coolbg">尾页</a>
 </td>
</tr>
</table>
</form>
</body>
</html>
