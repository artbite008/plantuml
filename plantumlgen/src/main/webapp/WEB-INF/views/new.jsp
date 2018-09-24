<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>uml</title>
    <%
        String url = "https://" + request.getServerName() + ":" + request.getServerPort() + "/uml/";
    %>
</head>
<body>
New Plant UML diagram has been created, pelase copy below url to edit it anywhere.<br/><br/>
<a href="<%=url%>${umlid}"><%=url%>${umlid}</a>
</body>
</html>
