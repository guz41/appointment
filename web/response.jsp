<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : response
    Created on : 02/08/2015, 3:41:27 PM
    Author     : Gus
--%>



<div class="mdl-card mdl-shadow--2dp demo-card-wide" style="width: 700px; margin-left: auto; margin-right: auto; margin-top: 15px;" >
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">Customers</h2>
    </div>
    <div class="mdl-card__supporting-text">
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" ng-controller="CustomerListCtrl">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
            </thead>
                <tr ng-repeat="customer in customers">
                    <td class="mdl-data-table__cell--non-numeric">{{customer.id}}</td>
                    <td>{{customer.firstName}}</td>
                    <td>{{customer.lastName}}</td>
                </tr>
        </table>
    </div>
</div>
        