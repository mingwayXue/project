<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user_role.js"></script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">用户名</td>
                <td width="100">所属部门</td>
                <td>所属岗位</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        	<s:iterator value="#userList">
            <tr class="TableDetail1 template">
                <td item="username"><s:property value="username"/></td>
                <s:hidden name="uid"></s:hidden>
                <!-- 在这里实现了OpenSessionInViewFilter,解决懒加载带来的问题 -->
                <td item="department"><s:property value="department.getName()"/></td>
                <td item="role">
                	<!-- 
                		因为用户中角色是一个集合，所以在这里需要迭代角色
                	 -->
                	<s:iterator value="roles">
                		<s:property value="name"/>
                	</s:iterator>
                </td>
                <td>
                	<s:a action="userAction_delete.action?uid=%{uid}">删除</s:a>
                    <s:a action="userAction_updateUI.action?uid=%{uid}">修改</s:a>
					<a>设置角色</a>
                </td>
            </tr>
            </s:iterator>
        </tbody>
    </table>
    
     <div id="TableTail"><!-- 添加用户的action -->
        <div id="TableTail_inside">
            <a href="userAction_addUI.action"><img src="${pageContext.request.contextPath}/css/images/createNew.png" /></a>
        </div>
    </div>
    
    <!-- 以下均是隐藏的div --> 
    <div class="ItemBlock_Title1" id="userTitle" style="display: none;"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif"/>
        	<s:label id="userImage"></s:label>
        </div>
    <div class="ItemBlock_Title1" id="privilegeTitle" style="display: none;"><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" />选择角色</div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder" style="display: none;" id="privilegeContent">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="checkbox" id="allchecked" disabled="disabled"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
								<ul id='roleTree' class="tree"></ul>
								<img id="loading" src="css/images/loading.gif"/>
							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <image id="saveRole" src="${pageContext.request.contextPath}/css/images/save.png"/>
        </div>
</div>

</body>
</html>
