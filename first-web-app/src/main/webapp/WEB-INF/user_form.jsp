<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">


<jsp:include page="head.jsp">
    <jsp:param name="header" value="User"/>
</jsp:include>

<body>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/user" var="userSubmitUrl"/>

            <form action="${userSubmitUrl}" method="post">

                <input type="hidden" id="id" name="id" value="${user.id}">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${user.name}"
                           placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}"
                           placeholder="Enter email">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<%@include file="scripts.jsp"0%>

</body>