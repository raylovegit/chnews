<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/fjs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/move2.js"></script><!-- 导入的js -->
<link type="text/css" rel="stylesheet" href="${ctx}/skin/css/move2.css"/><!-- 导入的css样式 -->
<title>首页</title>
<script type="text/javascript" src="${ctx}/js/util.js"></script>
        <script type="text/javascript">
            window.onload=function(){
            startTime("time");
            }
 </script>
</head>
<body>
<div id="main">
<div id="left">
<div class="leftNews">
<div class="title">
 <img src="${ctx}/skin/images/frame/001.gif" width="21" height="22"  style="float:left; margin-top:2px;"  />
   <h1> 教育论坛</h1><a href="${ctx}/FrontServlet?status=page&kindid=9&num=1"><span style="float:right; margin-right:15px; color:#3F9EB4;">更多...</span></a></div>
<ul class="content">
 <c:forEach items="${map}" var="map">
    <c:if test="${9 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
<li><a href="${ctx}/FrontServlet?status=read&id=${n.id }">
 <c:choose>
 <c:when test="${fn:length(n.title)>13}">
     ${fn:substring(n.title,0,13)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     
</a></li>
</c:forEach>
</c:if>
</c:forEach>

</ul>
</div>
<div class="leftNews">
<div class="title">
  <img src="${ctx}/skin/images/frame/002.gif" width="20" height="25"  style="float:left;"  />
   <h1>媒体湖师</h1><a href="${ctx}/FrontServlet?status=page&kindid=5&num=1"><span style="float:right; margin-right:15px; color:#3F9EB4;">更多...</span></a></div>
<ul class="content">
 <c:forEach items="${map}" var="map">
    <c:if test="${5 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
<li><a href="${ctx}/FrontServlet?status=read&id=${n.id }">
<c:choose>
 <c:when test="${fn:length(n.title)>13}">
     ${fn:substring(n.title,0,13)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     
</a></li>
</c:forEach>
</c:if>
</c:forEach>
</ul>
</div>
<div class="leftNews">
<div class="title">
  <img src="${ctx}/skin/images/frame/003.gif" width="20" height="21"  style="float:left; margin-top:2px;"  />
   <h1>湖师群英</h1><a href="${ctx}/FrontServlet?status=page&kindid=7&num=1"><span style="float:right; margin-right:15px; color:#3F9EB4;">更多...</span></a></div>
<ul class="content">
 <c:forEach items="${map}" var="map">
    <c:if test="${7 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
<li><a href="${ctx}/FrontServlet?status=read&id=${n.id }">
<c:choose>
 <c:when test="${fn:length(n.title)>13}">
     ${fn:substring(n.title,0,13)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     
</a></li>
</c:forEach>
</c:if>
</c:forEach>
</ul>
</div>
<div class="leftNews">
<div class="title">
  <img src="${ctx}/skin/images/frame/004.gif" width="20" height="22"  style="float:left; margin-top:2px;"  />
   <h1>友情链接</h1></div>
 <div id="link">
  <table width="100%">
       <tr>
         <td><div class="tab"><a href="http://www.pku.edu.cn/">北大新闻网</a></div></td>
         <td> <div class="tab1"><a href="http://www.tsinghua.edu.cn/qhdwzy/index.jsp">清华新闻网</a></div></td>
       </tr>
       <tr>
         <td><div class="tab"><a href="http://www.whu.edu.cn/index.html">武大新闻网</a> </div></td>
         <td> <div class="tab1"><a href="http://www.hust.edu.cn/">华科新闻网</a></div></td>
       </tr>
       <tr>
         <td><div class="tab"><a href="http://www.bnu.edu.cn/">北师大新闻网</a></div></td>
         <td>  <div class="tab1"><a href="http://www.nenu.edu.cn/">东北师大新闻网</a> </div></td>
       </tr>
       <tr>
         <td><div class="tab"><a href="http://www.ecnu.edu.cn/">华东师大新闻网</a> </div></td>
         <td> <div class="tab1"><a href="http://www.ccnu.edu.cn/">华中师大新闻网</a></div></td>
       </tr>
       <tr>
         <td><div class="tab"><a href="http://www.swnu.edu.cn/index.jsp">西南大学新闻网</a></div></td>
         <td> <div class="tab1"><a href="http://www.sxu.edu.cn/"> 陕西师大新闻网</a></div></td>
       </tr>
     </table>
</div>
</div>
<div id="img">
<img src="${ctx}/skin/images/frame/005.gif"/>
 <a href="http://www.news.hbnu.edu.cn/"><img src="${ctx}/skin/images/frame/006.gif"/></a></div>
</div>

<div id="right">
<div id="rightU">
<div id="pic">
<table width="360" border="1" align="center" cellpadding="0" cellspacing="0">
<tr>
<td>
<div class="play">    
   <div class="play_bg"></div><!-- 显示图片标题的灰色层 -->  
   <div class="play_info"></div> <!-- 显示图片的标题的层 --> 
    <div class="play_text"> 
       <ul>  
          <li>1</li>  
          <li>2</li>  
          <li>3</li>  
          <li>4</li>
          <li>5</li>
          <li>6</li>
      </ul>  
  </div>  
   <div class="play_list"> 
     <c:forEach items="${map}" var="map">
      <c:if test="${map.key=='6'}"> 
     <c:forEach items="${map.value}" var="n">
    <a href="${ctx}/FrontServlet?status=read&id=${n.id}">  
        <img src=${n.url} width="360px;" height="270px;" alt="${n.title }" />  
    </a> 
    </c:forEach>
    </c:if></c:forEach>
   </div>  
</div>
</td>
</tr>
<tr>
<td height="25"><div align="center">
	 <form id="myform" name="myform" action="${ctx}/FrontServlet?status=doSearch" method="post">
      新闻搜索：<input type="text" name="keyword" id="key" />
      <input id="sub" style="margin-left:20px;height:20px;width:50px;" type="button"  value="站内搜" />
      <input id="baidu" style="margin-left:1px;height:20px;width:50px;" type="button"  value="站外搜" />
      </form> </div> 
</td>
</tr>
</table>
</div>

<div class="schoolNews">
<div class="bt">
  <img src="${ctx}/skin/images/frame/007.gif"  style="float:left; margin-bottom:2px; margin-left:10px;" />
   <h1>学校要闻</h1><a href="${ctx}/FrontServlet?status=page&kindid=1&num=1"><span style="float:right; margin-right:15px; color: #FF0000; font-size:14px; font-weight:bold;">more...</span></a></div>
<ul class="detail">
 <c:forEach items="${map}" var="map">
    <c:if test="${1 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
<li><span class="date">${n.time }</span><a href="FrontServlet?status=read&id=${n.id }">
<c:choose>
 <c:when test="${fn:length(n.title)>15}">
     ${fn:substring(n.title,0,15)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     
     </a></li>
</c:forEach>

</c:if>
</c:forEach>
</ul>

</div>
</div>
<div id="rightM1">
<div class="generalNews">
<div class="bt">
  <img src="${ctx}/skin/images/frame/008.gif"  style="float:left;  margin-left:10px;" />
   <h1>综合新闻</h1><a href="${ctx}/FrontServlet?status=page&kindid=10&num=1"><span style="float:right; margin-right:15px; color: #FF0000; font-size:14px; font-weight:bold;">more...</span></a></div>
<ul class="detai2">
 <c:forEach items="${map}" var="map">
    <c:if test="${10 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
     <li><span class="date">${n.time }</span><a href="FrontServlet?status=read&id=${n.id }"><c:choose>
 <c:when test="${fn:length(n.title)>15}">
     ${fn:substring(n.title,0,15)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     </a></li>
</c:forEach>
</c:if>
</c:forEach>
</ul>
</div>

<div class="generalNews1">
<div class="bt">
  <img src="${ctx}/skin/images/frame/008.gif"  style="float:left;  margin-left:10px;" />
   <h1>磁湖言论</h1><a href="${ctx}/FrontServlet?status=page&kindid=3&num=1"><span style="float:right; margin-right:15px; color: #FF0000; font-size:14px; font-weight:bold;">more...</span></a></div>
<ul class="detai2">
 <c:forEach items="${map}" var="map">
    <c:if test="${3 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
     <li><span class="date">${n.time }</span><a href="FrontServlet?status=read&id=${n.id }"><c:choose>
 <c:when test="${fn:length(n.title)>15}">
     ${fn:substring(n.title,0,15)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     </a></li>
</c:forEach>
</c:if>
</c:forEach>
</ul>
</div>

</div>
<div id="rightM2">

<div class="generalNews2">
<div class="bt">
  <img src="${ctx}/skin/images/frame/008.gif"  style="float:left;  margin-left:10px;" />
   <h1>图片新闻</h1><a href="${ctx}/FrontServlet?status=page&kindid=6&num=1"><span style="float:right; margin-right:15px; color: #FF0000; font-size:14px; font-weight:bold;">more...</span></a></div>
<ul class="detai2">
 <c:forEach items="${map}" var="map">
    <c:if test="${6 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
     <li><span class="date">${n.time }</span><a href="FrontServlet?status=read&id=${n.id }"><c:choose>
 <c:when test="${fn:length(n.title)>15}">
     ${fn:substring(n.title,0,15)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose>     </a></li>
</c:forEach>
</c:if>
</c:forEach>
</ul>
</div>

<div class="generalNews3">
<div class="bt">
  <img src="${ctx}/skin/images/frame/008.gif"  style="float:left;  margin-left:10px;" />
   <h1>时政要闻</h1><a href="${ctx}/FrontServlet?status=page&kindid=4&num=1"><span style="float:right; margin-right:15px; color: #FF0000; font-size:14px; font-weight:bold;">more...</span></a></div>
<ul class="detai2">
 <c:forEach items="${map}" var="map">
    <c:if test="${4 eq map.key }"> 
     <c:forEach items="${map.value}" var="n">
     <li><span class="date">${n.time }</span><a href="FrontServlet?status=read&id=${n.id }"><c:choose>
 <c:when test="${fn:length(n.title)>15}">
     ${fn:substring(n.title,0,15)}...
  </c:when>
  <c:otherwise>${n.title}</c:otherwise>
</c:choose></a></li>
</c:forEach>
</c:if>
</c:forEach>
</ul>
</div>
</div>
<div id="rightD">
<h1 style=" float:left;margin-left:45px;_margin-left:22px; margin-top:2px;">美丽校园</h1>
<div id="demo" onmouseover="stopscroll()"; style="overflow: hidden; width:700px; margin:30px 20px 0 30px;" onmouseout="doscroll()">
<div id="demo1" style="PADDING:0; WHITE-SPACE: nowrap">

  <c:forEach items="${map}" var="map">
    <c:if test="${map.key=='8'}"> 
     <c:forEach items="${map.value}" var="n">
              <a href="${ctx}/FrontServlet?status=read&id=${n.id}"><img height="78" src=${n.url} width="114" border="0"/></a>
    </c:forEach>
    </c:if></c:forEach>
</div>
</div>
<script>
var demo = document.getElementById("demo");
var demo1 = document.getElementById("demo1");
var t=demo.scrollWidth
demo1.innerHTML+=demo1.innerHTML

function doMarquee()
{
demo.scrollLeft=demo.scrollLeft<demo.scrollWidth-demo.offsetWidth?demo.scrollLeft+1:t-demo.offsetWidth
}

function doscroll()
{
  sc=setInterval(doMarquee,20)
}

function stopscroll()
{
  clearInterval(sc)
}
doscroll()
</script>
</div>
</div>
</div>
</body>
</html>
