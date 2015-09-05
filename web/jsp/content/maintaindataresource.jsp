<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : response
    Created on : 02/08/2015, 3:41:27 PM
    Author     : Gus
--%>



<main class="mdl-layout__content  mdl-color--grey-100" ng-controller="DataResourceListCtrl">

    <!-- Popup menu -->
    <div class="mdl-card mdl-shadow--2dp demo-card-wide pop-up" ng-show="showPopUp">

        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Maintain</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <div class="mdl-grid">
                <table>
                <c:forEach var="field" items="${baseResourceFields}" varStatus="loop">
                    <c:if test="${!field.isReadOnly()}">
                        <tr>
                            <td>
                            <label  for="${field.getFieldName()}">${field.getFieldLabel()}</label>
                            </td>
                            <td colspan="2">
                            <div class="mdl-textfield mdl-js-textfield">
                            <input class="mdl-textfield__input" type="text" id="${field.getFieldName()}" ng-model="newDataResource.${field.getFieldName()}" />
                            </div> 
                            </td>
                            </tr>
                    </c:if>
                </c:forEach>
                
                    <tr ng-repeat="charField in newDataResource.${baseResource}Characteristics">
                        <td>
                            <div class="mdl-textfield mdl-js-textfield">
                                <select class="mdl-textfield__input" ng-model="charField.charType">
                                    <c:forEach var="field" items="${charResourceFields}" varStatus="loop">
                                    <c:if test="${true}">
                                        <option value="${field.getFieldName()}">${field.getFieldLabel()}</option>
                                    </c:if>
                                    </c:forEach>
                                </select>
                               <!-- <input class="mdl-textfield__input" type="text" ng-model="charField.charType" />-->
                            </div>
                        </td>
                        <td>
                            <div class="mdl-textfield mdl-js-textfield">
                                <input class="mdl-textfield__input" type="text" ng-model="charField.charValue" />
                            </div>
                        </td>
                        <td>
                            <button class="mdl-button mdl-js-button mdl-button--icon" ng-click="removeResourceChar(item)">
                                <i class="mdl-color-text--blue-grey-400 material-icons md-icon dp48">delete</i>
                            </button>
                        </td>
                    </tr>
                    <c:choose>
                        <c:when test="${charResourceFields.size() > 0}">
                    <tr>
                        <td colspan="3" style="text-align: right;">
                            <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab"  ng-click="addDataResourceChar()">
                                <i class="material-icons">add</i>
                            </button>
                        </td>
                    </tr>
                    </c:when>
                    </c:choose>
                </table>
                <div class="mdl-cell mdl-cell--2-col">
                    <button class="mdl-button mdl-js-button mdl-button--raised" ng-click="addDataResource()">
                        Ok
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
            <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-button--colored" style="top: 80px; right:50px; position:absolute; z-index:2;" ng-click="maintainNewDataResource()">
                <i class="material-icons">add</i>
            </button>

            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                <thead>
                    <tr>
                        <c:forEach var="field" items="${baseResourceFields}" varStatus="loop">
                            <c:if test="${field.isDisplayInTable()}">
                                <th>${field.getFieldLabel()}</th>
                                </c:if>
                            </c:forEach>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tr ng-repeat="${baseResource} in ${baseResource}s">
                    <c:forEach var="field" items="${baseResourceFields}" varStatus="loop">
                        <c:if test="${field.isDisplayInTable()}">
                            <td>{{${baseResource}.${field.getFieldName()}}}</td>
                        </c:if>
                    </c:forEach>
                    <td>
                        <button class="mdl-button mdl-js-button mdl-button--icon" ng-click="maintainDataResource(${baseResource})">
                            <i class="mdl-color-text--blue-grey-400 material-icons md-icon dp48">edit</i>
                        </button>
                    </td>
                    <td>
                        <button class="mdl-button mdl-js-button mdl-button--icon" ng-click="deleteDataResource(${baseResource}.id)">
                            <i class="mdl-color-text--blue-grey-400 material-icons md-icon dp48">delete</i>
                        </button>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</main>

