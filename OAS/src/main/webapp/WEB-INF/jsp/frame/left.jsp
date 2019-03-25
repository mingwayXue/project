<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-plugin-ztree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/oa_menuitem.js"></script>
<html>
<head>
<title>导航菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body style="margin: 0">
<TABLE border=0 width="700">
	<TR>
		<TD width=340px align=center valign=top>
		<div class="zTreeDemoBackground">
			<ul id="menuTree" class="tree"></ul>
		</div>		
		</TD>
	</TR>
</TABLE>
</body>
</html>
