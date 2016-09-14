<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="com.neu.project.dao.SellerDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<c:if test = "${!empty param.error}">
            <p style =" color:red;"> Please enter valid credentials</p>
    </c:if>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>Login:</legend>
                <form:form class="form-horizontal" action="UserLogin.htm" commandName="user" method="POST">
                    <div class="control-group">
                        <label class="control-label">User Name:</label>
                        <div class="controls">
                            <td><form:input path="name" name="userName" value="${cookie.userName.value}" size="30" /> <font color="red"><form:errors path="name"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                       <label class="control-label">Password</label>
                        <div class="controls">
                            <td><form:password path="password" name="password" value="${cookie.passWord.value}" size="30" /> <font color="red"><form:errors path="password"/></font></td><br><br> 
                        </div>
                    </div>
                    <div class="control-group">
                       <label class="control-label">Remember Me</label>
                        <div class="controls">
                            <input type="checkbox" name="rememberMe" value="rememberMe" /><br/><br/>
                        </div>
                    </div>
                    
                 <div class="form-actions">
                        <button type="submit" class="btn btn-success">Submit</button>
                        <button type="button" class="btn">Cancel</button>
                    </div>
                </form:form>
                 
                <div class="control-group">
                        <div class="controls">
                            Not Registered Yet?<a href="adduser.htm">Register here!</a><br>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
    </div>
     
</body>
</html>