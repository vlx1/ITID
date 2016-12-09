<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OWNERS</title>
</head>
<body>
<h1>List of owners</h1>
<table>
    <c:forEach items="${user_list}" var="currentUser">
        <%--<jsp:useBean id="currentUser" scope="page" type="model.Owner"/>--%>
    <tr>
        <td>"${currentUser.id}"</td>
        <td>"${currentUser.name}"</td>
        <td>"${currentUser.city}"</td>
        <td>"${currentUser.age}"</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
