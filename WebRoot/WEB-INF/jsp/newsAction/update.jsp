<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>新闻管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/css/base.css"/>
<script  type="text/javascript" src="${ctx}/js/calendar.js"></script>

</head>

<body leftmargin="8" topmargin="0" background='skin/images/allbg.gif'>
<form name="myform" action="NewsServlet?status=update" method="post">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="4" background="skin/images/tbg.gif">更新新闻</td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td width="14%" align="center">
	  <div align="right">
	    <!--翻页代码 -->
      新闻标题：</div></td>
    <td width="30%" align="center"><label>
      <div align="left">
        <input type="text" name="title" id="title" value="${news.title }"/>
        </div>
    </label></td>
    <td width="15%" align="center"><div align="right">题肩：</div></td>
    <td width="41%" align="center"><label>
      <div align="left">
        <input type="text" name="subTitle" id="subTitle" value="${news.subTitle }"/>
        </div>
    </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"> <div align="right"> 小标题： 
  </div></td>
  <td align="center"><label>
    <div align="left">
      <input type="text" name="sub2Title" id="sub2Title" value="${news.sub2Title }"/>
      </div>
  </label></td>
  <td align="center"><div align="right">新闻类型：</div></td>
  <td align="center"><div align="left">
    <select name="kindid">
    <c:forEach items="${ilist}" var="i">
      <option value="${i.id},${i.title }" <c:if test="${news.kindid eq i.id }">selected</c:if>>${i.title }</option>
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
      <option value="0,一般新闻" <c:if test="${news.newsType eq 0 }">selected</c:if>>一般新闻</option>
      <option value="1,图片新闻" <c:if test="${news.newsType eq 1 }">selected</c:if>>图片新闻</option>
      <option value="2,视频新闻" <c:if test="${news.newsType eq 2 }">selected</c:if>>视频新闻</option>
    </select>
  </div></td>
  <td align="center"><div align="right">作者：</div></td>
  <td align="center"><label>
    <div align="left">
      <input type="text" name="author" id="author" value="${news.author}"/>
      </div>
  </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">新闻来源：</div></td>
  <td align="center"><label>
      <div align="left">
        <input type="text" name="newsFrom" id="newsFrom" value="${news.newsFrom}"/>
      </div>
  </label></td>
   <td align="center"><div align="right">新闻发布时间：</div></td>
  <td align="center"><label>
     <div align="left">
       <input type="text" id="newsTime" name="newsTime" value="${news.time}" onfocus="setday(this)" allownull="false" class="validate[required]"/>
     </div></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right">新闻排序:</div></td>
  <td align="center"><label>
      <div align="left">
      <select name="orderNum">
       <option value="1" <c:if test="${news.orderNum eq 1 }">selected</c:if>>1</option>
       <option value="2" <c:if test="${news.orderNum eq 2 }">selected</c:if>>2</option>
       <option value="3" <c:if test="${news.orderNum eq 3 }">selected</c:if>>3</option>
       <option value="4" <c:if test="${news.orderNum eq 4 }">selected</c:if>>4</option>
       <option value="5" <c:if test="${news.orderNum eq 5 }">selected</c:if>>5</option>
       <option value="6" <c:if test="${news.orderNum eq 6 }">selected</c:if>>6</option>
       <option value="7" <c:if test="${news.orderNum eq 7 }">selected</c:if>>7</option>
       <option value="8" <c:if test="${news.orderNum eq 8 }">selected</c:if>>8</option>
       <option value="9" <c:if test="${news.orderNum eq 9 }">selected</c:if>>9</option>
       <option value="10" <c:if test="${news.orderNum eq 10 }">selected</c:if>>10</option>
       <option value="11" <c:if test="${news.orderNum eq 11 }">selected</c:if>>11</option>
       <option value="12"<c:if test="${news.orderNum eq 12 }">selected</c:if>>12</option>
       <option value="13" <c:if test="${news.orderNum eq 13 }">selected</c:if>>13</option>
       <option value="14" <c:if test="${news.orderNum eq 14 }">selected</c:if>>14</option>
       <option value="15" <c:if test="${news.orderNum eq 15 }">selected</c:if>>15</option>
       <option value="16" <c:if test="${news.orderNum eq 16 }">selected</c:if>>16</option>
       <option value="17" <c:if test="${news.orderNum eq 17 }">selected</c:if>>17</option>
       <option value="18" <c:if test="${news.orderNum eq 18 }">selected</c:if>>18</option>
       <option value="19" <c:if test="${news.orderNum eq 19}">selected</c:if>>19</option>
       <option value="20" <c:if test="${news.orderNum eq 20 }">selected</c:if>>20</option>
      </select>
      </div>
  </label></td>
  <td></td><td></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td colspan="4" align="center">新闻内容：</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
 <td colspan="4" align="center"><label>
     <FCK:editor instanceName="caption" width="800px" height="400px" value="${news.caption}"></FCK:editor>
  </label>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td colspan="4" align="center">&nbsp;</td>
</tr>
<tr bgcolor="#E7E7E7">
  <td height="12" background="skin/images/tbg.gif">&nbsp;</td>
  <td height="12" background="skin/images/tbg.gif"><div align="right">
    <input type="submit" class="coolbg" value="确定"/>
  </div></td>
  <td height="12" background="skin/images/tbg.gif"><div align="right">
    <input type="submit" class="coolbg" value="取消"/>
  </div></td>
  <td height="12" background="skin/images/tbg.gif">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="id" value="${news.id }"/>
</form>
</body>
</html>

