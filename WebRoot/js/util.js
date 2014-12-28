//当前日期时间
function startTime(divId)
{
	var today=new Date();
	//年月日
	var y=today.getFullYear();
	var M=today.getUTCMonth()+1;
	var d=today.getDate();
	var h=today.getHours();
	var m=today.getMinutes();
	var s=today.getSeconds();
	// add a zero in front of numbers<10
	m=checkTime(m);
	s=checkTime(s);
	var div=document.getElementById(divId);
        if(!div)return;
        div.innerHTML=y+"年"+M+"月"+d+"日 "+
	' 星期'+'日一二三四五六'.charAt(today.getDay())+
	h+":"+m+":"+s;
	t=setTimeout("startTime('"+divId+"')",500);
}

function checkTime(i)
{
	if (i<10)
	  {i="0" + i;}
	  return i;
}
function changeSize(id,targetId,size,lineHight){
    var a = document.getElementById(id);
    var target = document.getElementById(targetId);
    if(!target) return;
    a.onclick=function(){
        target.style.fontSize=size+"px";
        target.style.lineHeight=lineHight+"px";
    }
}
function prints(targetId){
    var target = document.getElementById(targetId);
    if(!target) return;
    target.onclick=function(){
        window.print();
    }
}
function closes(targetId){
    var target = document.getElementById(targetId);
    if(!target) return;
    target.onclick=function(){
        window.close();
    }
}