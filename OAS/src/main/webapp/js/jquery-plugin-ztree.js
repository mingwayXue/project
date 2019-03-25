(function($){
	var setting = {
        isSimpleData: true,
        treeNodeKey: "id",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    }
	var config = {
		setting:setting,
		url:'',
		data:null
	};
	$.fn.createTree = function(json){
		var tree = $(this);
		$.extend(config,json);
		$.post(config.url,config.data,function(data){
			tree.zTree(setting,data);
		});
	}
})($);
