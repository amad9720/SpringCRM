<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Costumer List</title>
    <%-- Reference our style sheet --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div></div>
<div id="container">
    <h3>Save customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post" >
        <table>
            <tbody>
                <tr>
                    <td><label for="firstname">Firstname :</label></td>
                    <td><form:input name="firstname" path="firstName"/></td>
                </tr>
                <tr>
                    <td><label for="lastname">Firstname :</label></td>
                    <td><form:input name="lastname" path="lastName"/></td>
                </tr>
                <tr>
                    <td><label for="email">Email :</label></td>
                    <td><form:input name="email" path="email"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </tbody>
        </table>
    </form:form>

    <div style="clear: both"></div>

    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </p>

</div>
</body>
</html>