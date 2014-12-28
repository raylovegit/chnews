<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="js/jquery_pagination/pagination.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery_pagination/jquery.pagination.js"></script>
<script type="text/javascript">
                $(document).ready(function(){
                     //全选 
                      $("#allcheck").click(function(){
                        $("input[@type='checkbox']").each(function(){   
                      $(this).attr("checked",true);   
                         });   
                              return false;
               });
                                
                          //反选
                           $("#uncheck").click(function(){
                          $("input[@type='checkbox']").each(function(){   
                                  if($(this).attr("checked")){   
                                               $(this).attr("checked",false);   
                                  }else{   
                                          $(this).attr("checked",true);   
                                }   
                             });      
                                return false;  
                    });
                
                        });
                        
       function submit(id){
         var form = document.getElementById(id);
         form.submit();
         return false;
       }  


</script>