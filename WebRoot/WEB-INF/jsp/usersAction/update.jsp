<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=7" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>用户信息更新</title>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/css/base.css"/>
<% if(request.getAttribute("msg")!=null) {
   String msg=(String)request.getAttribute("msg");
%>
<script type="text/javascript">
   alert("<%=msg%>");
</script>
<%
 }
 %>
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>
<form name="myform" action="${ctx}/UsersServlet?status=update" method="post" onSubmit= "return check(this);">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">用户信息更新</td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td width="48%" align="center"><div align="right">
	  <!--翻页代码 -->
	  用户名：</div>
	  <label></label></td>
    <td width="52%" align="center"><label>
      <div align="left">
        <input type="text" name="loginName" id="loginName" size="20" value="${sessionScope.user.loginName}"/>
      </div>
    </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">旧密码：</div></td>
  <td align="center"><label>
    <div align="left">
      <input type="password" name="old_p" id="old" size="20"/>
      </div>
  </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">新密码：</div></td>
  <td align="center"><label>
    <div align="left">
      <input type="password" name="new_p" id="new" size="20" />
      </div>
  </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">重复新密码：</div></td>
  <td align="center"><label>
    <div align="left">
      <input type="password" name="repeat_p" id="repeat" size="20" />
      </div>
  </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">描述：</div></td>
  <td align="center"><label>
    <div align="left">
      <textarea rows="3" cols="20" name="des" id="des">${sessionScope.user.des }</textarea>
     </div>
  </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right"><input type="submit" class="coolbg" value="确定" /></div></td>
  <td align="center"><div align="left"><input type="reset" class="coolbg" value="重置"/></div></td>
</tr>
</table>
 <input type="hidden" name="id" value="${sessionScope.user.id }"/>
</form>
</body>
</html>

