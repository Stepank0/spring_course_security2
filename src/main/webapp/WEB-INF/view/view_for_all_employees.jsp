<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: stepa
  Date: 11.03.2023
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security</title>
</head>
<body>
<h3>Information for all employees</h3>
<br><br>
<security:authorize access="hasRole('HR')"> <%-- запрет видеть эту кнопку другим ролям --%>
<input type="button" value="Salary" onclick="window.location.href='hr_info'">
Only for HR staff
</security:authorize>
<br><br>
<security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance" onclick="window.location.href='manager_info'">
Only for Managers
</security:authorize>
<br><br>

</body>
</html>
