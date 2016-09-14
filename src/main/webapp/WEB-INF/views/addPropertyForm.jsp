<%@page import="com.neu.project.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
        <title>Add Property Form</title>
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
                <legend>Add Property</legend>
                <form:form class="form-horizontal" action="addproperty.htm" commandName="property" method="post">
                    <div class="row">
  					<div class="col-xs-3">
                    <div class="control-group">
                        <div class="controls">
                            <td>City:</td>
                            <td>
                                <form:select class="form-control" path="city_name">
                                    <c:forEach var="categ" items="${sellers}">
                                        <form:option value="${categ.city}"/>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </div>
                    </div>
                     </div>
					</div>
                    <div class="control-group">
                        <label class="control-label">Street</label>
                        <div class="controls">
                               <td><form:input path="street" size="30" /> <font color="red"><form:errors path="street"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">City</label>
                        <div class="controls">
                            <td><form:input path="city" size="30" /> <font color="red"><form:errors path="city"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">State</label>
                        <div class="controls">
                            <td><form:input path="state" size="30" /> <font color="red"><form:errors path="state"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">ZIP</label>
                        <div class="controls">
                            <td><form:input path="zip" size="30" /> <font color="red"><form:errors path="zip"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">BHK</label>
                        <div class="controls">
                            <td><form:input path="bhk" size="30" /> <font color="red"><form:errors path="bhk"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Rent</label>
                        <div class="controls">
                            <td><form:input path="rent" size="30" /> <font color="red"><form:errors path="rent"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Price</label>
                        <div class="controls">
                            <td><form:input path="price" size="30" /> <font color="red"><form:errors path="price"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Description</label>
                        <div class="controls">
                            <td><form:input path="description" size="30" /> <font color="red"><form:errors path="description"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Posted By</label>
                        <div class="controls">
                            <td><form:input path="postedBy" size="30" /> <font color="red"><form:errors path="postedBy"/></font></td>
                        </div>
                    </div><br>
                    
                    
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