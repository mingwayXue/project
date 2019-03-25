(function(jQuery){
	$.myconfirm = function(){
		/**
		 * 获取当前页面的所有的超级链接,过滤删除的超级链接,给删除的超级链接添加一个
		 *  click事件
		 */
		$("a").each(function(){
			if($(this).text()=="删除"){
				$(this).unbind("click");
				$(this).bind("click",function(){
					return window.confirm("您确认要删除吗?");
				});
			}
		});
	}
})(jQuery);
