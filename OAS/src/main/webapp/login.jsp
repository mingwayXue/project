<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <meta http-equiv=Content-Type CONTENT="text/html; charset=gbk" />
	<title>OA系统</title>
	<link href="${pageContext.request.contextPath}/css/blue/login.css" type=text/css rel=stylesheet />
</head>

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" class="PageBody">
<s:form action="loginAction_login.action">
	
    <div id="CenterAreaBg">
        <div id="CenterArea">
            <div id="LogoImg"><img border="0" src="${pageContext.request.contextPath}/css/blue/images/logo.png" /></div>
            <div id="LoginInfo">
                <table border=0 width=100%>
                    <tr>
                        <td width=45 class="Subject"><img border="0" src="${pageContext.request.contextPath}/css/blue/images/login/userId.gif" /></td>
                        <!-- 显示错误信息 -->
                        <s:actionerror/>
                        <s:property value="#login"/>
                        <td><s:textfield name="username" cssClass="TextField"></s:textfield></td>
                        <td rowspan="2" style="padding-left:10px;"><input type="image" src="${pageContext.request.contextPath}/css/blue/images/login/userLogin_button.gif"/></td>
                    </tr>
                    <tr>
                        <td class="Subject"><img border="0" src="${pageContext.request.contextPath}/css/blue/images/login/password.gif" /></td>
                       	 <td><s:password name="password" cssClass="TextField"></s:password></td>
                    </tr>
                </table>
            </div>
            <div id="CopyRight"><a href="javascript:void(0)">&copy; 2010 版权所有 itcast</a></div>
        </div>
    </div>
</s:form>
</body>

</html>
