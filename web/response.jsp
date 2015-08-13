<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : response
    Created on : 02/08/2015, 3:41:27 PM
    Author     : Gus
--%>



<main class="mdl-layout__content  mdl-color--grey-100" ng-controller="CustomerListCtrl">
    
    <!-- Popup menu -->
<div class="mdl-card mdl-shadow--2dp demo-card-wide pop-up" ng-show="showPopUp">
   
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Maintain Customer</h2>
        </div>
        <div class="mdl-card__supporting-text">
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
                    Save
                </button>

            </div>
        </div>
        </div>
</div>
    
    <!-- main content -->
    <div class="page-content" >
        <div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate mdl-progress_appointment full-progress" ng-show="showProgressBar"></div>
        <div class="main-content">
        <!-- MDL Progress Bar with Indeterminate Progress -->
        <!-- Colored mini FAB button -->
<button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-button--colored" style="top: 80px; right:50px; position:absolute; z-index:2;" ng-click="maintainNewCustomer()">
  <i class="material-icons">add</i>
</button>
        
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tr ng-repeat="customer in customers">
                <td class="mdl-data-table__cell--non-numeric">{{customer.id}}</td>
                <td>{{customer.firstName}}</td>
                <td>{{customer.lastName}}</td>
                <td>
                    <button class="mdl-button mdl-js-button mdl-button--icon" ng-click="maintainCustomer(customer)">
                    <i class="mdl-color-text--blue-grey-400 material-icons md-icon dp48">save</i>
                </button>
                    </td>
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

