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
                <legend>List of all Properties</legend>
                    <table class="table table-striped">
                        <tr>
                            <td><b>DETAILS</b></td>
                            <td><b>CITY</b></td>
                            <td><b>STREET</b></td>
                            <td><b>STATE</b></td>
                            <td><b>ZIP</b></td>
                            <td><b>SELLER</b>
                        </tr>
                    <c:forEach var="prop" items="${properties}">
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
                    
                        <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
         <td><a href="listproperties.htm?page=${currentPage - 1}">Previous</a></td>
    </c:if>
    <%--For displaying Page numbers. The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" cellspacing="5">
       <tr>
           <c:forEach begin="1" end="${noOfPages}" var="i">
           <c:choose>
              <c:when test="${currentPage eq i}">
                <td>${i}</td>
                 </c:when>
                 <c:otherwise>
                      <td width="20%"><a href="listproperties.htm?page=${i}">${i}</a></td>
                 </c:otherwise>
               </c:choose>
           </c:forEach>
       </tr>
    </table>
    <%--For displaying Next link --%>
       <c:if test="${currentPage lt noOfPages}">
           <td><a href="listproperties.htm?page=${currentPage + 1}">Next</a></td>
       </c:if>
                    
                    
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