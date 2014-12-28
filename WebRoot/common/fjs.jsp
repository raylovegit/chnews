<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	window.onload = function() {
		var sub = document.getElementById("sub");
		var url = document.getElementById("baidu");
		var form = document.getElementById("myform");
		sub.onclick = function() {
			var key=form.keyword.value;
			if(key&&key!=null&&key!="")
				form.submit();
		}
		url.onclick = function(){
		    var key=form.keyword.value;
			if(key&&key!=null&&key!=""){
		    var href="http://www.baidu.com/s?wd=hbnu "+key;
		    window.open(href);
		}
	}
	}

</script>