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
<title>Added City</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<div class="right"><a href="Logout.htm"><b>Logout</b></a></div>
<div class="topright"><a href="SellerHome.htm"><b>Home</b></a></div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>City Added Successfully!</legend>
                    <table class="table table-striped">
                        <tr>
                            <td>City Name</td>
                        </tr>
                        <tr>
                        	<td>${seller.city}</td>
                    	</tr>           
                    </table>
                </fieldset>
            </div>
        </div>
    </div> 
    <div class="control-group">
                    <label class="control-label">City</label><br>
                    <div class="controls">
                    <a href="addproperty.htm">Now a Post Property</a><br>
            </div>
    </div> 
    	</c:when>
	<c:otherwise>
	Please Login <a href="UserLogin.htm"><b>here</b></a> first!
	</c:otherwise>
	</c:choose>    
</body>
</html>