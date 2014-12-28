<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/css/base.css"/>
<script  type="text/javascript" src="${ctx}/js/calendar.js"></script>
<link rel="stylesheet" href="${ctx}/skin/css/validationEngine.jquery.css"type="text/css" media="screen" title="no title" charset="utf-8" />
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validationEngine-cn.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validationEngine.js"></script>
<script type="text/javascript">
      $(document).ready(function(){
        $("#ajaxForm").validationEngine();
      });
 </script>
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>
<form name="myform" action="${ctx}/NewsServlet?status=create" method="post" id="ajaxForm">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="4" background="skin/images/tbg.gif">添加新闻</td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td width="14%" align="center">
	  <div align="right">
	    <!--翻页代码 -->
      新闻标题：</div></td>
    <td width="30%" align="center"><label>
      <div align="left">
        <input type="text" name="title" id="title" size="60" class="validate[required]" value=""/>
        </div>
    </label></td>
    <td width="15%" align="center"><div align="right">题肩：</div></td>
    <td width="41%" align="center"><label>
      <div align="left">
        <input type="text" name="subTitle" size="40" id="subTitle" class="validate[required]"/>
        </div>
    </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"> <div align="right"> 小标题： 
  </div></td>
  <td align="center"><label>
    <div align="left">
      <input type="text" name="sub2Title" id="sub2Title" size="40" class="validate[required]"/>
      </div>
  </label></td>
  <td align="center"><div align="right">新闻类型：</div></td>
  <td align="center"><div align="left">
    <select name="kindid">
    <c:forEach items="${ilist}" var="i">
      <option value="${i.id},${i.title }">${i.title }</option>
     </c:forEach>
    </select>
  </div></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><label>
    <div align="right">新闻类别：</div>
  </label></td>
  <td align="center"><div align="left">
    <select name="newsType">
      <option value="0,一般新闻">一般新闻</option>
      <option value="1,图片新闻">图片新闻</option>
      <option value="2,视频新闻">视频新闻</option>
    </select>
  </div></td>
  <td align="center"><div align="right">作者：</div></td>
  <td align="center"><label>
    <div align="left">
      <input type="text" name="author" id="author" class="validate[required]"/>
      </div>
  </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">新闻来源：</div></td>
  <td align="center"><label>
      <div align="left">
        <input type="text" name="newsFrom" id="newsFrom" class="validate[required]"/>
      </div>
  </label></td>
  <td align="center"><div align="right">新闻发布时间：</div></td>
  <td align="center"><label>
      <div align="left">
       <input type="text" id="newsTime" name="newsTime" onfocus="setday(this)" allownull="false" class="validate[required]"/>
      </div></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td colspan="4" align="center">新闻内容：</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td colspan="4" align="center"><label>
     <FCK:editor instanceName="caption" width="800px" height="400px"></FCK:editor>
  </label>
    <label></label></td>
</tr>

<tr bgcolor="#E7E7E7">
  <td height="12" background="skin/images/tbg.gif">&nbsp;</td>
  <td height="12" background="skin/images/tbg.gif"><div align="right">
    <input type="submit" class="coolbg" value="确定">
  </div></td>
  <td height="12" background="skin/images/tbg.gif"><div align="right">
    <input type="reset" class="coolbg" value="取消">
  </div></td>
  <td height="12" background="skin/images/tbg.gif">&nbsp;</td>
</tr>
</table>
</form>
</body>
</html>

