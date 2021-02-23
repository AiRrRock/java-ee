<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">


<jsp:include page="head.jsp">
    <jsp:param name="header" value="Categories"/>
</jsp:include>

<body>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/category" var="userSubmitUrl"/>

            <form action="${userSubmitUrl}" method="post">

                <input type="hidden" id="id" name="id" value="${category.id}">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${category.name}" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input type="text" class="form-control" id="description" name="description"  value="${category.description}" placeholder="Enter description">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


<%@include file="scripts.jsp" %>

</body>