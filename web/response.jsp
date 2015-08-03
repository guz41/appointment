
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="appointment.businessobject.customer.Customer"%>
<%@page import="appointment.data.ObjectFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    ObjectFactory afactory = new ObjectFactory();
    Customer test = afactory.getCustomer(2);
    Customer test1 = afactory.getCustomer(1);
    List<Customer> allCustomers = new ArrayList();
    allCustomers.add(test);
    allCustomers.add(test1);
    request.setAttribute("allCustomers", allCustomers);
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

<div class="mdl-card mdl-shadow--2dp demo-card-wide" style="width: 700px; margin-left: auto; margin-right: auto; margin-top: 15px;">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">Customers</h2>
    </div>
    <div class="mdl-card__supporting-text">
        <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
            </thead>
            <c:forEach items="${allCustomers}" var="customer">
                <tr>
                    <td>${customer.getID()}</td>
                    <td>${customer.getLastName()}</td>
                    <td>${customer.getFirstName()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
