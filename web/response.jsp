
<%@page import="appointment.businessobject.customer.Customer"%>
<%@page import="appointment.data.ObjectFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ObjectFactory afactory = new ObjectFactory();
    Customer test = afactory.getCustomer(2);
    //String userID = request.getParameter("userid");
    //String userStatus = getUserStatus(userID);
    //String audioFile = "";
    //if (userStatus.equals(UserStatus.NEW)) {
    //    audioFile = "new.wav";
    // } else {
    //    audioFile = "existing.wav";
            // }
%>
<%-- 
    Document   : response
    Created on : 02/08/2015, 3:41:27 PM
    Author     : Gus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Placeholder</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <table border="0">
            <thead>
                <tr>
                    <th colspan="2">{<%= request.getRemoteAddr()%>}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><strong>Description: </strong></td>
                    <td><span style="font-size:smaller; font-style:italic;">{placeholder}</span></td>
                </tr>
                <tr>
                    <td><strong>Counselor: </strong></td>
                    <td><%= test.getFirstName() + " " + test.getLastName()%>
                        <br>
                        <span style="font-size:smaller; font-style:italic;">
                            member since: {placeholder}</span>
                    </td>
                </tr>
                <tr>
                    <td><strong>Contact Details: </strong></td>
                    <td><strong>email: </strong>
                        <a href="mailto:{placeholder}">{placeholder}</a>
                        <br><strong>phone: </strong>{placeholder}
                    </td>
                </tr>
                <tr>
            <table>
                <c:forEach items="${test}" var="test">
                    <tr>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </table>
        </tr>
    </tbody>
</table>
</body>
</html>
