<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=7" />
<title>文档管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/skin/css/base.css"/>
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
<form name="myform" action="ItemsServlet?status=create" method="post" id="ajaxForm">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">添加栏目</td>
    </tr>
<tr align="right" bgcolor="#EEF4EA">
	<td width="48%" align="center"><div align="right">
	  <!--翻页代码 -->
	  栏目名称：</div>
	 </td>
    <td width="52%" align="center"><label>
      <div align="left">
        <input type="text" name="title" id="title" size="20" class="validate[required]"/>
        </div>
    </label></td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
  <td align="center"><div align="right"><input type="submit" class="coolbg" value="提交"/></div></td>
  <td align="center"><div align="left"><input type="reset" class="coolbg" value="取消"/></div></td>
</tr>
</table>
</form>
</body>
</html>

