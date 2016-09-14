<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
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
    <title>Update User Form</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
function validate()
{
    var msg;
    if(document.myForm.password.value.length > 5)
        {
            msg = "good";
        }
    else
        {
            msg = "poor";
        }
    document.getElementById('mylocation').innerText = msg;
}


var xmlHttp;
xmlHttp = GetXmlHttpObject();

function checkUsername()
{
    
    if(xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }
    
    var name = document.getElementById("name").value;
    
    var query = "action=checkusername&name=" + name;
    
    xmlHttp.onreadystatechange = function stateChanged()
    {
        if(xmlHttp.readyState >= 2 && xmlHttp.readyState < 4)
            {
                
            }
        if(xmlHttp.readyState == 4 )
            {
                var json = JSON.parse(xmlHttp.responseText);
                document.getElementById("success").innerHTML = json.Message;
            }
    };
    
    xmlHttp.open("POST", "checkusername.htm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(query);
    
    return false;
}

function GetXmlHttpObject()
{
    var xmlHttp = null;
    try
    {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e)
    {
        // Internet Explorer
        try
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}
</script>


<body>
<c:choose>
<c:when test="${!empty sessionScope.loggedUser}">
<div class="topright"><a href="Logout.htm"><b>Logout</b></a></div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <fieldset>
                <legend>Update User</legend>
                <form:form class="form-horizontal" action="updateUser.htm" commandName="user" method="post" name="myForm">
                    <div class="control-group">
                        <label class="control-label">First Name</label>
                        <div class="controls">
                            <form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Last Name</label>
                        <div class="controls">
                               <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Email</label>
                        <div class="controls">
                            <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Username:</label>
                        <div class="controls">
                            <td><form:input path="name" id="name" size="30" onkeyup="return checkUsername()"/> <span id="success"></span> <font color="red"><form:errors path="name"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Password:</label>
                        <div class="controls">
                            <td><form:password path="password" size="30" name="userPass" onkeyup="validate()"/>Strength: <span id="mylocation"><strong>No Strength</strong></span> <font color="red"><form:errors path="password"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">User Type:</label>
                        <div class="controls">
                            <td>
                                <form:radiobutton path="userType" value="Buyer" label="Buyer" /> 
                                <form:radiobutton path="userType" value="Seller" label="Seller" />
                            </td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Street:</label>
                        <div class="controls">
                            <td><form:input path="street" size="30" /> <font color="red"><form:errors path="street"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">City:</label>
                        <div class="controls">
                            <td><form:input path="city" size="30" /> <font color="red"><form:errors path="city"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">State:</label>
                        <div class="controls">
                            <td><form:input path="state" size="30" /> <font color="red"><form:errors path="state"/></font></td>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">ZIP:</label>
                        <div class="controls">
                            <td><form:input path="zip" size="30" /> <font color="red"><form:errors path="zip"/></font></td><br><br>
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
</html>