<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : response
    Created on : 02/08/2015, 3:41:27 PM
    Author     : Gus
--%>



<main class="mdl-layout__content  mdl-color--grey-100">
    <div class="page-content" ng-controller="CustomerListCtrl">
        <div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate mdl-progress_appointment full-progress" ng-show="showProgressBar"></div>
        <div class="main-content">
        <!-- MDL Progress Bar with Indeterminate Progress -->
        
        <div class="mdl-grid">
            <div class="mdl-cell mdl-cell--5-col">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="firstname" ng-model="newCustomer.firstName" />
                    <label class="mdl-textfield__label" for="firstname">First Name</label>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--5-col">
                <div class="mdl-textfield mdl-js-textfield">
                    <input class="mdl-textfield__input" type="text" id="lastname" ng-model="newCustomer.lastName" />
                    <label class="mdl-textfield__label" for="lastname">Last Name</label>
                </div>
            </div>
            <div class="mdl-cell mdl-cell--2-col">
                <button class="mdl-button mdl-js-button mdl-button--raised" ng-click="addCustomer()">
                    Add
                </button>

            </div>
        </div>




        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th></th>
                </tr>
            </thead>
            <tr ng-repeat="customer in customers">
                <td class="mdl-data-table__cell--non-numeric">{{customer.id}}</td>
                <td>{{customer.firstName}}</td>
                <td>{{customer.lastName}}</td>
                <td>
                    <button class="mdl-button mdl-js-button mdl-button--icon" ng-click="deleteCustomer(customer.id)">
                    <i class="mdl-color-text--blue-grey-400 material-icons md-icon dp48">delete</i>
                </button>
                    </td>
            </tr>
        </table>
    </div>
    </div>
</main>