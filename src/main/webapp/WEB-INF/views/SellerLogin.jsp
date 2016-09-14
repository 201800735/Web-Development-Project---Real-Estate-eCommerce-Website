<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller Login</title>
<head>
    <title>Add City Form</title>
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
                <legend>Welcome ${user.name}!</legend>
                    <div class="control-group">
                        <div class="controls">
                            <a href="addcity.htm">Sell a Property?</a><br>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                             <a href="sellerInbox.htm">Inbox</a><br>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <a href="sellerProperties.htm">View Your Properties</a><br>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <a href="updateUser.htm">Update Profile</a><br>
                        </div>
                    </div>
                    
                    
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