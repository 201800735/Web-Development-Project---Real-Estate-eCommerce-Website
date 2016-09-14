<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
.topright {
    position: absolute;
    top: 8px;
    right: 16px;
    font-size: 18px;
}

.right {
    position: absolute;
    top: 36px;
    right: 16px;
    font-size: 18px;
}
</style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Property List</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<div class="right"><a href="Logout.htm"><b>Logout</b></a></div>
<div class="topright"><a href="BuyerHome.htm"><b>Home</b></a></div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>Property List</legend>
                    <table class="table table-striped">
                        <tr>
                            <td><b>DETAILS</b></td>
                            <td><b>CITY</b></td>
                            <td><b>STREET</b></td>
                            <td><b>STATE</b></td>
                            <td><b>ZIP</b></td>
                            <td><b>SELLER</b>
                        </tr>
                    <c:forEach var="prop" items="${searchedProperties}">
                        <tr>
                            <td><a href = "propertyDetails.htm?id=${prop.id}">Get Details</a></td>
                            <td>${prop.city}</td>
                            <td>${prop.street}</td>
                            <td>${prop.state}</td>
                            <td>${prop.zip}</td>
                            <td><a href = "ContactSeller.htm?email=${prop.user.email}">${prop.user.name}</a></td>
                        </tr>
                    </c:forEach>           
                    </table>
                </fieldset>
            </div>
        </div>
    </div>
     </c:when>
	<c:otherwise>
	Please Login <a href="UserLogin.htm"><b>here</b></a></div> first!
	</c:otherwise>
	</c:choose>    
</body>
</html>