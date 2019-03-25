<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>person的list页面</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>pid</td>
				<td>name</td>
				<td>description</td>
				<td>修改</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#dataList">
				<tr>
					<td><s:property value="pid"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="description"/></td>
					<td><s:a action="personAction_updateUI?id=%{pid}">修改</s:a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>