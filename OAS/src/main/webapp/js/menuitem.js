var menuitem = {
    zTreePlugin: '',
    /**
     * 加载树
     */
    loadTree: function(){
        /**
         * 第三个参数是回调函数，是在服务器端成功响应完毕以后才要执行该函数
         * 如果js端的代码要用到回调函数的数据，这段代码必须写在回调函数中
         * @param {Object} data
         */
        $.post("menuitemAction_showMenuitems.action", null, function(data){
            $("#tree").zTree(menuitem.setting, data);  
        });
     
    },
    /**
     * 加载树的根节点，形成树
     */
    loadRoot: function(){
        $.post("menuitemAction_showMenuitemTreeByPid.action", {
            pid: 0
        }, function(data){
            menuitem.zTreePlugin = $("#tree").zTree(menuitem.setting, data);
            //alert(data);
        });
    },
    /**
     * 根据父节点加载子节点
     */
    loadSubNodesByPid: function(treeNode){
        /**
         * 发出ajax请求，加载制定节点的子节点
         */
        if (!menuitem.zTreePlugin.getNodeByParam("pid", treeNode.mid)) {//如果当前点击节点不存在子节点
            $.post("menuitemAction_showMenuitemTreeByPid.action", {
            	pid: treeNode.mid
            }, function(data){
                /**
                 * 往指定的父节点上追加子节点
                 */
                menuitem.zTreePlugin.addNodes(treeNode, data, true);
            });
        }
        
    },
    setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        },
        /**
         * 事件的声明
         */
        
        callback: {
            /**
             * @param {Object} event
             * @param {Object} treeId  树的容器ID
             * @param {Object} treeNode  当前点击的节点
             */
            expand: function(event, treeId, treeNode){
                menuitem.loadSubNodesByPid(treeNode);
            }
        }
    	
    }
};
$().ready(function(){
    /**
     * 加载树
     * 总结：loadTree()方法适合数据量小的，loadRoot()适合数据量大的，与数据库交互频繁的
     * 
     */
    //menuitem.loadTree();  //一次性加载全部的数据
    menuitem.loadRoot();  //动态加载子节点
    
});
