<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.neu.project.dao.SellerDAO"%>
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
</style>

<html>
<head>
    <title>Buyer Login</title>
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
                <form class="form-horizontal" action="searchproperty.htm" method="get">
                    <div class="control-group">
                        <label class="control-label">Enter City: </label><br>
                        <div class="controls">
                         <td><input type="text" name="searchElement"/></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Search By:</label><br>
                        <div class="controls">
                            <input type="radio" name="searchBy" value="zip"> ZIP
                            <input type="radio" name="searchBy" value="city"> City<br>
                        </div>
                    </div>
                    <div class="row">
  						<div class="col-xs-3">
                    	<div class="control-group">
                        <label class="control-label">Number of Rooms:</label><br>
                        <div class="controls">
                            <select class="form-control" name="bhk">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select><br>
                        </div>
                   		 </div>
                    	 </div>
					</div>
					
					<div class="row">
  						<div class="col-xs-3">
                    <div class="control-group">
                        <label class="control-label">Rent Range:</label><br>
                        <div class="controls">
                            <select class="form-control" name="rentRange">
                            <option value="2000">Less than 2000</option>
                            <option value="3000">Less than 3000</option>
                            <option value="4000">Less than 4000</option>
                            <option value="4000">4000 Above</option>
                        </select><br>
                        </div>
                    </div>
                     </div>
					</div>
					<div class="row">
  						<div class="col-xs-3">
                    <div class="control-group">
                        <label class="control-label">Price Range:</label><br>
                        <div class="controls">
                            <select class="form-control" name="rentRange">
                            <option value="200000">Less than 200000</option>
                            <option value="300000">Less than 300000</option>
                            <option value="400000">Less than 400000</option>
                            <option value="500000">Less than 500000</option>
                        </select><br>
                        </div>
                    </div>
                    </div>
					</div>
                    
                    <div class="form-actions">
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="button" class="btn">Cancel</button>
                        <input type="hidden" name="to" value="${requestScope.email}"/>
                    </div>
                </form>
                    <div class="control-group">
                        <div class="controls">
                            <a href="sellerInbox.htm" target="contents">Inbox</a><br>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <a href="updateUser.htm">Update Profile</a><br>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <a href="listproperties.htm" target="contents">List All Properties</a><br>
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