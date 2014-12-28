<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>test jsp</title>
    <script> 
    function   up()   { 
    s   =   document.all.s1; 
    v   =   new   Array(); 
    for(i=0;i <s.length-1;i++)   { 
        if(!   s.options[i].selected   &&   s.options[i+1].selected)   { 
            v.value   =   s.options[i].value; 
            v.text   =   s.options[i].text; 
            v.selected   =   s.options[i].selected; 
            s.options[i].value   =   s.options[i+1].value; 
            s.options[i].text   =   s.options[i+1].text; 
            s.options[i].selected   =   s.options[i+1].selected; 
            s.options[i+1].value   =   v.value; 
            s.options[i+1].text   =   v.text; 
            s.options[i+1].selected   =   v.selected; 
        } 
    } 
} 

function   down()   { 
    s   =   document.all.s1; 
    v   =   new   Array(); 
    for(i=s.length-1;i> 0;i--)   { 
        if(!   s.options[i].selected   &&   s.options[i-1].selected)   { 
            v.value   =   s.options[i].value; 
            v.text   =   s.options[i].text; 
            v.selected   =   s.options[i].selected; 
            s.options[i].value   =   s.options[i-1].value; 
            s.options[i].text   =   s.options[i-1].text; 
            s.options[i].selected   =   s.options[i-1].selected; 
            s.options[i-1].value   =   v.value; 
            s.options[i-1].text   =   v.text; 
            s.options[i-1].selected   =   v.selected; 
        } 
    } 
} 

function   show()   { 
    s   =   document.all.s1; 
    v   =   " "; 
    for(i=0;i <s.length;i++) 
        v   +=   s.options[i].value   +   ": "   +   s.options[i].text   +   "\n "; 
    alert(v); 
} 
</script>
  </head>
  
  <body>
<select name=s1   multiple size=4> 
<option   value=1> aaaaaa 
<option   value=2> bbbbbb 
<option   value=3> cccccc 
<option   value=4> dddddd 
<option   value=5> eeeeee 
<option   value=6> ffffff 
<option   value=7> gggggg 
<option   value=8> hhhhhh 
</select> 
<input   type=button   name=b1   value=向上   onClick= "up() "> 
<input   type=button   name=b2   value=向下   onClick= "down() "> 
<input   type=button   name=b3   value=查看   onClick= "show() "> 
  </body>
</html>
