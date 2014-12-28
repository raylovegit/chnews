<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<!-- 添加greybox -->
  <script type="text/javascript">
        var GB_ROOT_DIR ="./greybox/";
    </script>
    <script type="text/javascript" src="greybox/AJS.js"></script>
    <script type="text/javascript" src="greybox/AJS_fx.js"></script>
    <script type="text/javascript" src="greybox/gb_scripts.js"></script>
    <link href="greybox/gb_styles.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="greybox/help.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <%@ include file="/common/js.jsp" %>
</head>
<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="0"bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
  <form name="myform" action="NewsServlet?status=readAll&pageNum=1" method='post'>
 <table width='100%'  border='0' cellpadding='1' cellspacing='1' align="center" style="margin-top:1px">
  <tr>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>类型：</td>
          <td width='160'>
          <select name="key1" style='width:150'>
            <c:forEach items="${ilist}" var="i">
              <option value="${i.id}">${i.title }</option>
            </c:forEach>
          </select>
        </td>
        <td width='90' align='center'>其他条件：</td>
        <td width='160'>
          <select name="key2" style='width:150'>
            <option value="title">标题</option>
            <option value="author">作者</option>
         </select>
        </td>
        <td width='50'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='value' value='' style='width:150px' />
        </td>
        <td>
          <input  type="submit" class="coolbg" width="50" height="40" border="0" value="搜索" />
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
<form id="form2" name="myform" action="NewsServlet?status=bentchDetele" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="13" background="skin/images/tbg.gif">&nbsp;新闻列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="6%">新闻ID</td>
	<td width="10%">新闻标题</td>
	<td width="10%">题肩</td>
	<td width="10%">小标题</td>
	<td width="7%">类别</td>
	<td width="8%">类型</td>
	<td width="10%">来源</td>
	<td width="5%">作者</td>
	<td width="10%">发布时间</td>
	<td width="23%" colspan="4">操作</td>
</tr>
<c:forEach items="${nlist}" var="n">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="ids" type="checkbox" id="ids" value="${n.id}" class="np"></td>
	<td align="left">${n.title}</td>
	<td>${n.subTitle}</td>
	<td>${n.sub2Title}</td>
	<td>${n.typeName }</td>
	<td>${n.kindName }</td>
	<td>${n.newsFrom}</td>
	<td>${n.author}</td>
	<td>${n.time}</td>
	<td><a href="NewsServlet?status=query&id=${n.id }"  onclick="return GB_showFullScreen('查看评论', this.href)">查看评论</a></td>
	<td><a href="NewsServlet?status=read&id=${n.id}" onclick="return GB_showFullScreen('新闻预览', this.href)">预览</a></td>
	<td><a href="NewsServlet?status=preUpdate&id=${n.id}" onclick="return GB_showFullScreen('新闻编辑', this.href);">编辑</a></td>
	<td><a href="NewsServlet?status=delete&id=${n.id }" onclick="if(!confirm('确定要删除吗？')) return false;">删除</a></td>
</tr>
</c:forEach>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="20">
	&nbsp;
	<a id="allcheck" href="#" class="coolbg">全选</a>
	<a id="uncheck" href="#" class="coolbg">反选</a>
	<a id="delete" href="#" onclick="return submit('form2');" class="coolbg">&nbsp;删除&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
   <td height="36" colspan="13" align="center">
   <div>${sessionScope.page.currentpage}/${sessionScope.page.totalpages }</div>
   <a href="NewsServlet?status=pageBreak&pageNum=1" class="coolbg">首页</a>
   <a href="NewsServlet?status=pageBreak&pageNum=${sessionScope.page.prepage }" class="coolbg">上一页</a>
   <a href="NewsServlet?status=pageBreak&pageNum=${sessionScope.page.nextpage }" class="coolbg">下一页</a>
   <a href="NewsServlet?status=pageBreak&pageNum=${sessionScope.page.totalpages }" class="coolbg">尾页</a>
 </td>
</tr>
</table>
</form>
</body>
</html>
