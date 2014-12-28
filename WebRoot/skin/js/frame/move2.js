var t = n = count = 0;   
$(function(){   
    count = $(".play_list a").size();   //统计图片的数量
   $(".play_list a:not(:first-child)").hide();   //如果不是第一个子节点，就将其隐藏
  $(".play_info").html($(".play_list a:first-child").find("img").attr('alt'));   //默认将第一个节点的alt值赋值给play_info层
   $(".play_text li:first-child").css({"background":"red",'color':'#000'});   
   $(".play_info").click(function(){window.open($(".play_list a:first-child").attr('href'), "_blank")});   
   $(".play_text li").click(function() {   
       var i = $(this).text() - 1;   
       n = i;   
       if (i >= count) return;   
       $(".play_info").html($(".play_list a").eq(i).find("img").attr('alt'));   
       $(".play_info").unbind().click(function(){window.open($(".play_list a").eq(i).attr('href'), "_blank")})   
       $(".play_list a").filter(":visible").fadeOut(500).parent().children().eq(i).fadeIn(1000);   
       $(this).css({"background":"red",'color':'#000'}).siblings().css({"background":"#000",'color':'#fff'});   
   });   
   t = setInterval("showAuto()",1000);   
    $(".play").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()",1000);});   
})   
 
function showAuto()   
{   
    n = n >= (count - 1) ? 0 : n + 1;   
   $(".play_text li").eq(n).trigger('click');   
} 
 
