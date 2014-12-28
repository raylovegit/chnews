<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/fjs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${ctx}/js/util.js"></script>
        <script type="text/javascript">
            window.onload=function(){
            startTime("time");
            }
 </script>
<title>首页</title>
</head>
<body>
<div id="content2">
<div id="leftBar2">
<div id="leftTop2"><img src="${ctx}/skin/images/frame/news2_03.jpg" width="214" height="34" /></div>
<div id="leftMid2">

<div class="imgs"></div>
<div style="margin-left:5px;">
<form id="myform" name="myform" action="${ctx}/FrontServlet?status=doSearch" method="post">
    <p><label style=" font-size:14px;"></label>
      <label style="padding-left:2px; text-align:left; font-size:14px;">关&nbsp;键&nbsp;字：</label>
      <input name="keyword" id="key"  type="text"  value="" size="15" style="margin-left:0px;"/>
</p>
      <input id="sub"  type="image" src="${ctx}/skin/images/frame/news2_19.jpg" style="margin-left:60px;" />
      <input id="baidu"  type="image"  src="${ctx}/skin/images/frame/news2_21.jpg"  style=" padding-left:10px;"/>
</form>
</div>
</div>
<div id="leftDown2">
<div class="imgs2"></div>
<ul>
   <c:forEach items="${vlist}" var="v">
     <li><a href="${ctx}/FrontServlet?status=read&id=${v.id}">${fn:substring(v.title,0,13)}... </a></li>
   </c:forEach>
</ul>
</div>
</div>
<div id="rightBar2">
<div id="rightTop"><span><img src="${ctx}/skin/images/frame/news2_06.jpg" /></span><span style="color:#ff0000;font-size:16px;font:blod;"><a href="${ctx}/index.jsp">磁湖新闻网</a>--><a href="${ctx}/FrontServlet?status=page&kindid=${items.id }&num=1">${items.title }</a></span></div>
<div id="rightDown">
<div id="biaoti"><span style=" float:right; padding-right:100px;">时间</span><span style="float:left; padding-left:100px;">主题</span><span style=" float:right; margin-right:50px;">点击量</span></div>
<div id="xinwen">
<ul>
<c:forEach items="${nlist}" var="n">
    <li><span style=" float:right; padding-right:40px;">${n.time }</span><span style="float:left;"><img src="${ctx}/skin/images/frame/news2_tb.gif" /><a href="${ctx}/FrontServlet?status=read&id=${n.id }">${n.title}</a></span><span style=" float:right; margin-right:50px;">${n.visitnum }</span></li>
</c:forEach>
</ul>
</div>

<div id="yemian">
<form action="${ctx}/FrontServlet?status=page" method="post">
<p>共<span class="red">${sessionScope.page.totalcounts}</span>条新闻&nbsp;&nbsp;
分为<span class="red">${sessionScope.page.totalpages }</span>页&nbsp;&nbsp;
<!--  以上是第<span class="red">${sessionScope.page.beginindex+1}</span>至<span class="red">${sessionScope.page.lastindex}</span>条-->&nbsp;&nbsp;
<a href="${ctx}/FrontServlet?status=page&kindid=${items.id}&num=1">首页</a>&nbsp;&nbsp;
<a href="${ctx}/FrontServlet?status=page&kindid=${items.id}&num=${sessionScope.page.prepage }">上一页</a>&nbsp;&nbsp;
<a href="${ctx}/FrontServlet?status=page&kindid=${items.id}&num=${sessionScope.page.nextpage }">下一页</a>&nbsp;&nbsp;
<a href="${ctx}/FrontServlet?status=page&kindid=${items.id}&num=${sessionScope.page.totalpages }">尾页</a>
&nbsp;&nbsp;跳转至第<input type="text" name="num" size="5"/>页
 <input type="submit" name="" id="go" onclick="check" value="跳转"/>
  <input type="hidden" name="kindid" value="${items.id }"/>
</p>
</form>
</div>
</div>
</div><div id="line"></div>
</div>
</body>
</html>
