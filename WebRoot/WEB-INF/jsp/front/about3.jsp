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
                changeSize("small","contents",12,25);
                changeSize("middle","contents",14,30);
                changeSize("big","contents",16,35);
                prints("print");
                closes("close");
                startTime("nowTime");}
 </script>
<title>欢迎来到湖北师范学院磁湖新闻网</title>
</head>
<body>
<div id="content2">
  <div id="leftBar2">
    <div id="leftTop2"><img src="${ctx}/skin/images/frame/news2_03.jpg" width="214" height="34" /></div>
    <div id="leftMid2">
    <div class="imgs"></div>
      <div style="margin-left:5px;" >
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
         <li><a href="${ctx}/FrontServlet?status=read&id=${v.id}">${fn:substring(v.title,0,13)}...</a></li>
         </c:forEach>
         </ul>
      </div>
   </div>
<div id="rightBar3">
      <div id="rightTop3"><span><img src="${ctx}/skin/images/frame/news2_06.jpg" /></span><span style="color:#ff0000;font-size:16px;font:blod;"><a href="${ctx}/index.jsp">磁湖新闻网</a>--><a href="${ctx}/FrontServlet?status=page&kindid=${news.kindid }&num=1">${news.kindName }</a></span></div>
      <div id="rightDown3">
          <div id="tongzhi">
             <h2 style="text-align:center; margin-top:10px;">${news.title}</h2>
             <div id="xian3"></div>
             <div id="zuozhe">  <span style="margin-left:100px;">新闻来源：${news.newsFrom }</span>    
                                <span style="margin-left:100px;">发布时间：${news.time }</span>
                                <span style="margin-left:100px;">点击次数：${news.visitnum }</span>
             </div>
             <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${news.caption}</div>
          </div>
                 <div id="ziti"><table width="342" border="0">
                             <tr>
                               <td width="20"><img src="${ctx}/skin/images/frame/news3_07.jpg" width="12" height="12" />                               </td>
                                <td width="129">&nbsp;&nbsp;字体【<a href="#" id="big">大</a><a href="#" id="middle">中</a><a href="#" id="small">小</a>】</td>
             <td width="21"><img src="${ctx}/skin/images/frame/news3_09.jpg" width="12" height="12" /></td>
            <td width="36"><a href="#"id="print">打印</a></td>
             <td width="20"><img src="${ctx}/skin/images/frame/news3_11.jpg" width="12" height="12" /></td>
            <td width="90"><a href="#" id="close">关闭</a></td>
               </tr>
                             </table>
             </div>
          <hr  style="width:650px;"></hr>
          <div id="xgxinwen">
          <p style="color:#990000;">相关新闻:</p>
          <ul>
          <c:forEach items="${about}" var="a">
              <li><a href="${ctx}/FrontServlet?status=read&id=${a.id}">${a.title }</a><span style="color:#c0c0c0;">&nbsp;&nbsp;&nbsp;&nbsp;[${a.time }]</span></li>
          </c:forEach> 
          </ul>
          </div>

  </div>
      
     <div id="liuyan">
          <h3 class="zi">留言区</h3>
          <c:forEach items="${clist}" var="c">
          <span style="margin-left:30px; margin-top:50px; font-size:12px;"><span style="color:#5ab3ed;">${c.author}&nbsp;*.*</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#5181a2;">&nbsp;主题：Re ${news.title}</span><span style="color:#c0c0c0;margin-left:150px">&nbsp;${c.time }发表</span></span>
          <p style="margin-left:40px; font-size:12px;margin-top:10px">${c.content}</p>
          <div id="xuexian"></div>
          </c:forEach>
          <form action="${ctx}/FrontServlet?status=pingLun" method="post" name="myform">
          <input type="hidden" name="id" value="${news.id }"/>
            <input type="hidden" name="newsId" value="${news.id }"/>
             <span style="margin-left:30px; margin-top:50px; font-size:12px;">主题：</span>
            <input name="input3" type="text" value="${news.title }" size="60" />
            <span style="margin-left:80px">用户：</span>
            <input style="width:130px;" name="author" type="text" value="游客" size="15" />
            <textarea name="content" style=" width:700px; height:100px;padding:0;margin-top:10px; margin-left:30px;">文明发言，营造网络文明</textarea>
           <span style="font-size:14px; color:red; margin-left:100px;">欢迎您在此留下评论，评论需审核后才能发布<input name="imageSubmit" type="image" src="${ctx}/skin/images/frame/news3_20.jpg" style=" margin-top:10px; margin-left:250px;" onclick="this.myform.submit();return false"/></span>
         </form>
</div>
  </div>

</div>
</body>
</html>
