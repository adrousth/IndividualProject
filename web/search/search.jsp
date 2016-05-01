<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 1/29/2016
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${pageTitle}</title>
    <link href="/website.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:import url="${pageHeader}"/>

<c:import url="${PageContent}"/>
<c:import url="/sections/footer.jsp"/>
</body>
</html>
