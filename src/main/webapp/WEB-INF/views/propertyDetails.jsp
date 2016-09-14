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
<div class="topright"><a href="Logout.htm"><b>Logout</b></a></div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>Property List</legend>
                    <table class="table table-striped">
                        <tr>
                            <td><b>BHK</b></td>
                            <td><b>RENT</b></td>
                            <td><b>PRICE</b></td>
                            <td><b>DESCRIPTION</b></td>
                            <td><b>POSTED ON</b></td>
                        </tr>
                        <tr>
                            <td><b>${details.bhk}</b></td>
                            <td><b>${details.rent}</b></td>
                            <td><b>${details.price}</b></td>
                            <td><b>${details.description}</b></td>
                            <td><b>${details.postdate}</b></td>
                        </tr>          
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