/**
 * 这是一个工具js，封装公用的js方法，每个页面都要引入
 */

/**
 * 这是一个封装ajax的方法
 */
function Submit(Url,param,fnSuccess,fnError){
	$.ajax({
		type:"post",
		dataType:"json",
		data:param,
		url:Url,
		success:fnSuccess,
		error:fnError
	});
}