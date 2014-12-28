<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/taglib.jsp"%>
<div id="header">
<div id="banner">
<div class="subTitle">设为首页 | 加入收藏 | 联系我们</div>
<div class="weather">
  <iframe src="http://m.weather.com.cn/m/pn4/weather.htm " width="160" height="20" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0"  allowtransparency="true" scrolling="no"></iframe>
</div>
<div id="time"></div>
</div>
<div id="nav">
<ul style="font-size:15px;">
<li><a  href="http://www.hbnu.edu.cn/">学校首页</a> </li>
<li><a href="${ctx}/index.jsp">网站首页</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=1&num=1">学校要闻</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=3&num=1">磁湖言论</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=10&num=1">综合新闻</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=4&num=1">时政要闻</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=9&num=1">教育论坛</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=5&num=1">媒体湖师</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=7&num=1">磁湖群英</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=6&num=1">图片新闻</a> </li>
<li><a href="${ctx}/FrontServlet?status=page&kindid=8&num=1">美丽校园</a> </li>
<li><a href="http://www.epaper.hbnu.edu.cn/">学校校报</a> </li>
</ul>
</div>
</div>
