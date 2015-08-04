
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="appointment.businessobject.customer.Customer"%>
<%@page import="appointment.data.ObjectFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
    Document   : response
    Created on : 02/08/2015, 3:41:27 PM
    Author     : Gus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="test" class="appointment.bean.TestBean" />
<jsp:setProperty name="test" property="message" value="think i broke your box, but this is how to use tags..." />
<jsp:useBean id="customertest1" class="appointment.data.ObjectFactory" />

<div class="mdl-card mdl-shadow--2dp demo-card-wide" style="width: 700px; margin-left: auto; margin-right: auto; margin-top: 15px;">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text"><jsp:getProperty name="test" property="message" /></h2>
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
            <c:forEach items="${customertest1.allCustomers}" var="customer">
                <tr>
                    <td>${customer.getID()}</td>
                    <td>${customer.getLastName()}</td>
                    <td>${customer.getFirstName()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
