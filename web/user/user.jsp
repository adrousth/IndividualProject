<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${pageTitle}</title>
    <link href="/website.css" rel="stylesheet" type="text/css" />
</head>
    <body>
        <c:import url="/user/userHeader.jsp"/>
        <c:import url="${PageContent}"/>
        <c:import url="../sections/footer.jsp"/>
    </body>
</html>