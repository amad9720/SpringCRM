<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Costumer List</title>
</head>
<body>
    <p>List Customer</p>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <div class="container">
        <div class="content">
            <table>
                <tr>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="customers" items="${customers}" >
                    <tr>
                        <td>${customers.id}</td>
                        <td>${customers.firstName}</td>
                        <td>${customers.lastName}</td>
                        <td>${customers.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>