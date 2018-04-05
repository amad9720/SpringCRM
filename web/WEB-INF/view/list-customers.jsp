<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Costumer List</title>
    <%-- Reference our style sheet --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <div></div>
    <div id="container">
        <div id="content">

            <%-- put new button for adding user --%>
                <input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd'; return false;"  class="add-button"/>

            <%-- add our html table to list the customers--%>
            <table>
                <tr>
                    <th>id</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="customers" items="${customers}" >
                    <%--Link for updates--%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate" >
                        <c:param name="customerId" value="${customers.id}" />
                        <%--<c:param name="customerName" value="${customers.lastName}" />--%>
                    </c:url>

                    <%--Link for deletes--%>
                    <c:url var="deleteLink" value="/customer/delete" >
                        <c:param name="customerId" value="${customers.id}" />
                    </c:url>
                    <tr>
                        <td>${customers.id}</td>
                        <td>${customers.firstName}</td>
                        <td>${customers.lastName}</td>
                        <td>${customers.email}</td>
                        <td>
                            <%-- display the link for update --%>
                                <a href="${updateLink}">Update</a> |
                                <a href="${deleteLink}" onclick="if(!(confirm('Are you sure to delete this customer ?'))) return false" >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>