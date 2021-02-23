<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="Users"/>
</jsp:include>

<body>

<div class="container">
    <div class="row py-2">
        <c:url value="/user/create" var="userCreateUrl"/>

        <div class="col-12">
            <a class="btn btn-primary" href="${userCreateUrl}">Add User</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <%-- <%for (Product product : (List<Product>) request.getAttribute("products")) --%>

                <c:forEach var="user" items="${requestScope.users}">

                    <tr>
                        <th scope="row">
                            <c:out value="${user.id}"/>
                        </th>
                        <td>
                            <c:out value="${user.name}"/>
                        </td>
                        <td>
                            <c:out value="${user.email}"/>
                        </td>
                        <td>
                            <c:url value="/user/edit" var="userEditUrl">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a class="btn btn-success" href="${userEditUrl}"><i class="fas fa-edit"></i></a>
                            <c:url value="/user/delete" var="userDeleteUrl">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a class="btn btn-danger" href="${userDeleteUrl}"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                <%--<% } %>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="scripts.jsp" %>

</body>
</html>