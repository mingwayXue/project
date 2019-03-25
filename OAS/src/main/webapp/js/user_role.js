/**
 * js的代码的结构可以这样分析：
 *    1、所有的js代码都是以事件的形式触发的
 *    2、数据的传递
 *    3、写一些方法
 */
 /*
  * 非常值得学习的js架构代码...
  */
var user_role = {
	/**
	 * 存放数据
	 */
	data:{
		user:{
			username:'',
			uid:''
		}
	},
	/**
	 * 操作
	 */
	option:{
		/**
		 * 关于div的操作
		 */
		divOpt:{
			showDiv:function(){
				/**
				 * 把隐藏的div显示出来
				 */
				$("div:hidden").show();
			}
		},
		/**
		 * 关于用户的操作
		 */
		userOpt:{
			showUserName:function(){
				$("#userImage").text(user_role.data.user.username);
			}
		},
		/**
		 * 关于角色树
		 */
		roleTree:{
			zTreePlugin:'',
			setting:{
				isSimpleData: true,
				/**
				 * 因为加载的是Role对象，主键为rid
				 */
		        treeNodeKey: "rid",
		        treeNodeParentKey: "pid",
		        showLine: true,
		        root: {
		            isRoot: true,
		            nodes: []
		        },
				checkable:true,
				/**
				 * 声明事件
				 */
				callback:{
					change:function(event, treeId, treeNode){
						user_role.option.roleTree.setAllCheckedOnTree();
					}
				}
			},
			/**
			 * 加载角色树
			 */
			loadRoleTree:function(){
				$.post("roleAction_showRoleTree.action",{
					uid:user_role.data.user.uid
				},function(data){
					/**
					 * 创建角色树
					 */
					user_role.option.roleTree.zTreePlugin = $("#roleTree").zTree(user_role.option.roleTree.setting,data);
					/**
					 * 当角色树加载完毕以后，应该把全选复选框的状态从不可用转变成可用
					 */
					$("#allchecked").attr("disabled",false);
					/**
					 * 当角色树加载完毕以后，显示角色树，隐藏loading
					 */
					user_role.option.roleTree.changeLoadingAndRoleTree({
						roleTree:true
					});
					
					//设置全选复选框的初始化值
					user_role.option.roleTree.setAllCheckedOnTree();
				});
			},
			/**
			 * 等待图片和角色树的切换
			 */
			changeLoadingAndRoleTree:function(jsonObj){
				if(jsonObj.roleTree){
					$("#roleTree").show();
					/**
					 * 设置全选复选框可用
					 */
					//$("#allchecked").attr("disabled","");
					$("#loading").hide();
				}else{
					$("#roleTree").hide();
					$("#loading").show();
				}
			},
			/**
			 * 完成全选复选框的功能
			 */
			allChecked:function(){
				/**
				 * 判断全选复选框是否被选中
				 */
				if($("#allchecked").attr("checked")){//让角色树上的复选框全部被选中
					user_role.option.roleTree.zTreePlugin.checkAllNodes(true);
				}else{
					user_role.option.roleTree.zTreePlugin.checkAllNodes(false);
				}
			},
			/**
			 * 判断角色树上的复选框是否被全部选中
			 */
			setAllCheckedOnTree:function(){
				/**
				 * 获取未被选中的节点
				 */
				var uncheckedNodes = user_role.option.roleTree.zTreePlugin.getCheckedNodes(false);
				if(uncheckedNodes.length==0){//全部被选中
					$("#allchecked").attr("checked",true);
				}else{//未被选中
					$("#allchecked").attr("checked",false);
				}
			},
			/**
			 * 建立用户和角色之间的关系
			 */
			buildUsernameAndRole:function(){
				var checkedStr = "";
				/**
				 * 被选中的节点
				 */
				var checkedNodes = user_role.option.roleTree.zTreePlugin.getCheckedNodes(true);
				for(var i=0;i<checkedNodes.length;i++){
					if(i==checkedNodes.length-1){
						checkedStr = checkedStr + checkedNodes[i].rid;
					}else{
						checkedStr = checkedStr + checkedNodes[i].rid + ",";
					}
				}
				//这里的parameter属性是传入Action中的属性，Action通过getter和setter获取。。
				var parameter = {
					uid:user_role.data.user.uid,
					checkedStr:checkedStr
				};
				$.post("userAction_buildUserAndRole.action",parameter,function(data){
					alert("操作成功");
				});
				
				var $td = $("input[value='"+user_role.data.user.uid+"']").siblings("td[item='role']");
				$td.empty();
				var temp = [];
				for(var i=0;i<checkedNodes.length;i++){
					temp.push(checkedNodes[i].name);
				}
				$td.text(temp.join(" "));
			}
		}
	},
	/**
	 * 初始化的操作
	 */
	init:{
		/**
		 * 初始化数据
		 */
		initData:function(){
			user_role.data.user.username = $(this).parent().siblings("td:first").text();
			user_role.data.user.uid = $(this).parent().siblings("input[type='hidden']").val();
		},
		/**
		 * 初始化事件
		 */
		initEvent:function(){
			/**
			 * 给设置角色添加click事件
			 */
			$("a").each(function(){
				if($(this).text()=="设置角色"){
					$(this).css("cursor","pointer");
					$(this).unbind("click");
					$(this).bind("click",function(){
						/**
						 * 1、显示所有被隐藏的div
						 * 2、动态的显示用户名称
						 * 3、加载角色树
						 * 4、建立用户和被选中的角色之间的关系
						 */
						user_role.option.divOpt.showDiv();
						//初始化全选复选框的状态
						$("#allchecked").attr("disabled",true);
						
						//把username和uid赋值给user_role.data.user.username/uid
						//this代表当前对象即设置角色的超级链接   该方法为初始化数据
						user_role.init.initData.call(this);
						//动态的显示用户名称
						user_role.option.userOpt.showUserName();
						/**
						 * 初始化loading和roleTree
						 */
						user_role.option.roleTree.changeLoadingAndRoleTree({
							roleTree:false
						});
						//动态加载角色树
						user_role.option.roleTree.loadRoleTree();
					});
				}
			});
			
			/**
			 * 给全选复选框添加change事件
			 */
			$("#allchecked").change(function(){
				user_role.option.roleTree.allChecked();
			});
			
			/**
			 * 给保存按钮添加click事件
			 */
			$("#saveRole").click(function(){
				user_role.option.roleTree.buildUsernameAndRole();
			});
		}
	}
};

$().ready(function(){
	user_role.init.initEvent();
});
