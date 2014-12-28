

(function($) {
	$.fn.validationEngineLanguage = function() {};
	$.validationEngineLanguage = {
		newLang: function() {
			$.validationEngineLanguage.allRules = 	{
					"required":{    			// Add your regex rules here, you can take telephone as an example
						"regex":"none",
						"alertText":"* 此选项是必填",
						"alertTextOk":"",	
						"alertTextCheckboxMultiple":"* 请选择一个项目",
						"alertTextCheckboxe":"* 这个多选框是必填项"},
					"length":{
						"regex":"none",
						"alertText":"*要求要有 ",
						"alertText2":" 到 ",
						"alertText3": " 字符"},
					"maxCheckbox":{
						"regex":"none",
						"alertText":"* Checks allowed Exceeded"},	
					"minCheckbox":{
						"regex":"none",
						"alertText":"* 请选择至少",
						"alertText2":" 个选项"},	
					"confirm":{
						"regex":"none",
						"alertText":"* 你的两次输入不匹配"},		
					"telephone":{
						"regex":"/^[0-9\-\(\)\ ]+$/",
						"alertText":"* 非法的电话号码"},	
					"email":{
						"regex":"/^[a-zA-Z0-9_\.\-]+\@([a-zA-Z0-9\-]+\.)+[a-zA-Z0-9]{2,4}$/",
						"alertText":"* 非法的email地址"},	
					"date":{
                         "regex":"/^[0-9]{4}\-\[0-9]{1,2}\-\[0-9]{1,2}$/",
                         "alertText":"* 非法的日期格式，格式必须是： YYYY-MM-DD"},
					"onlyNumber":{
						"regex":"/^[0-9\ ]+$/",
						"alertText":"* 只能是数字"},	
					"noSpecialCaracters":{
						"regex":"/^[0-9a-zA-Z]+$/",
						"alertText":"* No special caracters allowed"},	
					"ajaxUser":{
						"file":"testuser.jsp",
						"extraData":"name=eric",
						"alertTextOk":"* 可以使用该用户名",	
						"alertTextLoad":"* 检索中...",
						"alertText":"* 此用户名已经存在，请输入其他的用户名"},	
					"ajaxName":{
						"file":"testuser.jsp",
						"alertText":"* 此用户名已经存在，请输入其他的用户名",
						"alertTextOk":"* 可以使用该用户名",	
						"alertTextLoad":"* 检索中..."},		
					"onlyLetter":{
						"regex":"/^[a-zA-Z\ \']+$/",
						"alertText":"* 只能是英文字母"}
					}	
		}
	}
})(jQuery);

$(document).ready(function() {	
	$.validationEngineLanguage.newLang()
});