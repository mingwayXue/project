var role_privilege = {
	data:{
		role:{
			name:'',
			rid:''
		}
	},
	init:{
		initData:function(){
			role_privilege.data.role.name = $(this).parent().siblings("td:first").text();
			role_privilege.data.role.rid = $(this).parent().siblings("input[type='hidden']").val();
		},
		initEvent:function(){
			//给设置权限添加click事件
			$("a").each(function(){
				if($(this).text()=="设置权限"){
					$(this).css("cursor","pointer");
					$(this).click(function(){
						//显示隐藏的div
						role_privilege.opt.divOpt.showDiv();
						//设置data.role中的值
						role_privilege.init.initData.call(this);
						//显示角色的名称
						role_privilege.opt.roleOpt.showRoleName();
						//一开始的时候，显示loading,隐藏privilegeTree
						role_privilege.opt.privilegeTree.controlLoadingAndPrivilegeTree({
							loading:true
						});
						//设置全选复选框的不可用
						role_privilege.opt.privilegeTree.isAbleAllchecked({
							able:false
						});
						//加载权限树
						role_privilege.opt.privilegeTree.loadPrivilegeTree();
					});
				}
			});
			
			//给全选复选框添加change事件
			$("#allchecked").change(function(){
				role_privilege.opt.privilegeTree.setAllChecked();
			});
			//给保存按钮添加click事件
			$("#savePrivilege").click(function(){
				role_privilege.opt.privilegeTree.buildRoleAndPrivilege();
			});
		}
	},
	opt:{
		divOpt:{
			showDiv:function(){
				$("div:hidden").show();
			}
		},
		roleOpt:{
			showRoleName:function(){
				$("#roleImage").text("角色:"+role_privilege.data.role.name);
			}
		},
		privilegeTree:{
			zTreePlugin:'',
			setting:{
				isSimpleData: true,
				/**
				 * 因为加载的是Role对象，主键为rid
				 */
		        treeNodeKey: "id",
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
						role_privilege.opt.privilegeTree.setAllCheckedValue();
					}
				}
			},
			/**
			 * 控制loading和privilegeTree的显示
			 */
			controlLoadingAndPrivilegeTree:function(obj){
				if(obj.loading){
					$("#privilegeTree").hide();
					$("#loading").show();
				}else{
					$("#privilegeTree").show();
					$("#loading").hide();
				}
			},
			/**
			 * 控制全选复选框是否可用
			 */
			isAbleAllchecked:function(obj){
				if(obj.able){
					$("#allchecked").attr("disabled",false);
				}else{
					$("#allchecked").attr("disabled",true);
				}
			},
			/**
			 * 加载权限树
			 */
			loadPrivilegeTree:function(){
				$.post("privilegeAction_showPrivlegeTreeByRid.action",{
					rid:role_privilege.data.role.rid
				},function(data){
					role_privilege.opt.privilegeTree.zTreePlugin = $("#privilegeTree").zTree(role_privilege.opt.privilegeTree.setting,data);
					/**
					 * 显示privilegeTree,隐藏loading
					 */
					role_privilege.opt.privilegeTree.controlLoadingAndPrivilegeTree({
						loading:false
					});
					//设置全选复选框的不可用
					role_privilege.opt.privilegeTree.isAbleAllchecked({
						able:true
					});
					//设置全选复选框的默认值
					role_privilege.opt.privilegeTree.setAllCheckedValue();
				});
			},
			/**
			 * 设置全选复选框的功能
			 */
			setAllChecked:function(){
				if($("#allchecked").attr("checked")){//被选中
					role_privilege.opt.privilegeTree.zTreePlugin.checkAllNodes(true);	
				}else{
					role_privilege.opt.privilegeTree.zTreePlugin.checkAllNodes(false);
				}
			},
			/**
			 * 判断权限树上的复选框是否被全部选中
			 */
			setAllCheckedValue:function(){
				var uncheckedNodes = role_privilege.opt.privilegeTree.zTreePlugin.getCheckedNodes(false);
				if(uncheckedNodes.length==0){//树上的复选框全部被选中
					$("#allchecked").attr("checked",true);
				}else{
					$("#allchecked").attr("checked",false);
				}
			},
			/**
			 * 建立角色与权限的关系
			 */
			buildRoleAndPrivilege:function(){
				var checkedStr = "";
				var checkedNodes = role_privilege.opt.privilegeTree.zTreePlugin.getCheckedNodes(true);
				for(var i=0;i<checkedNodes.length;i++){
					if(i==checkedNodes.length-1){
						checkedStr = checkedStr + checkedNodes[i].id;
					}else{
						checkedStr = checkedStr + checkedNodes[i].id + ",";
					}
				}
				var parameter = {
					rid:role_privilege.data.role.rid,
					checkedStr:checkedStr
				};
				$.post("roleAction_buildRoleAndPrivilege.action",parameter,function(data){
					alert("操作成功");
				});
			}
		}
	}
};

$().ready(function(){
	role_privilege.init.initEvent();
});
