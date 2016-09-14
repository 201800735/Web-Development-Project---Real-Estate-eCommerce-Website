<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.neu.project.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

        SellerDAO sellerDao = new SellerDAO();
        java.util.List cityList = sellerDao.list();
        pageContext.setAttribute("sellers", cityList);
%>
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
    <title>Add City Form</title>
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
				<legend>In which city your property is located?</legend>
				
				<form:form class="form-horizontal" action="addcity.htm" commandName="city" method="post">
					<div class="control-group">
						
						<div class="controls">
							<td><form:input path="city" size="30" /> <font color="red"><form:errors path="city"/></font></td><br><br>
						</div>
					</div>
					
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Submit</button>
						<button type="button" class="btn">Cancel</button>
					</div>
				</form:form>
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