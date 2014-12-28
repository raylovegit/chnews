<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="java.util.*,common.backup.FileInfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>栏目管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<link rel="stylesheet" href="js/jquery_pagination/pagination.css" />
<script type="text/javascript"src="js/jquery.js"></script>
<script type="text/javascript"src="js/jquery_pagination/jquery.pagination.js"></script>
<script type="text/javascript">
			function pageselectCallback(page_index, jq){
                var new_content = $('#hiddenresult div.result:eq('+page_index+')').clone();
                $('#Searchresult').empty().append(new_content);
            }
           
            function initPagination() {
                var num_entries = $('#hiddenresult div.result').length;
                $("#Pagination").pagination(num_entries, {
                // 导航条后面显示的页数
                    num_edge_entries: 2,
                // 导航条前面显示的页数
                    num_display_entries: 5,
                    callback: pageselectCallback,
                    items_per_page:1
                });
             }
            $(document).ready(function(){      
                initPagination();
            });    
        </script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<%!//定义每页显示的记录的条数
	private final int RECORD = 10;%>
		<%
			//从后台得到数据集list
			List list = null;
			int size = 0;
			if (request.getAttribute("list") != null) {
				list = (List) request.getAttribute("list");
				System.out.println("list:"+list.size());
				size = list.size();
			}
			//得到数据集list的长度size
		%>
		
<!--  快速转换位置按钮  -->
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="30" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <form name="myform" action="BackupServlet?status=backup" method="post">
      <table width='100%'  border='0' cellpadding='1' cellspacing='1' align="center" style="margin-top:5px">
  <tr>
    <td background='skin/images/wbg.gif' align='center'>
    <input type="submit" class="coolbg" value="开始备份">
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
<div id="hiddenresult" style="display:none">

			<%
				//得到显示的页数
				int pages = size / RECORD;
				if (size % RECORD != 0)
					pages++;
				System.out.println("pages=" + pages);

				for (int j = 0; j < pages; j++) {
			%>

 <div class="result" style="width:1200px">			
<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp;数据库备份&nbsp;</td>
</tr>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="30" >
  <td align="left">文件名</td>
  <td align="left">备份时间</td>
  <td align="center">操作</td>
</tr>

	<%
						for (int k = 0; k < RECORD; k++) {

								int num = k + RECORD * j;

								if (num > size - 1)
									break;
								FileInfo file = (FileInfo) list.get(num);
								String fileName = file.getFileName();
								String lastReadTime = file.getLastReadTime();
					%>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="30" >

	<td align="left"><%=fileName %></td>
	<td align="left"><%=lastReadTime %></td>
	<td><a href="BackupServlet?status=load&fileName=<%=fileName %>">恢复</a>
</tr>
<%
 }
 %>
</table>
</div>
<%
}
 %>
 </div>
 <table border='1' cellpadding='0' cellspacing='0'>
        <tr>
        <td>
	 <!-- 在id为“Searchresult”的div中显示分页数据集 -->
	  <div id="Searchresult">
		This content will be replaced when pagination inits.
	</div>
	<!-- 加入页面导航条 -->
	<div id="Pagination" class="pagination"></div>
	<br style="clear: both;" />
	</td>
     </tr>
      </table>
</body>
</html>
