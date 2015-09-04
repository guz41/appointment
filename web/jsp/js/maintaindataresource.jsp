<%-- 
    Document   : maintainresource
    Created on : Aug 22, 2015, 7:18:32 PM
    Author     : Marrows
    Comments   : Dynamic Javascript is required to make the manage resource/resource reusable.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script>
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 //Services
var appointmentServices = angular.module('appointmentServices', ['ngResource']);

appointmentServices.factory('DataResource', ['$resource',
  function($resource){
    return $resource('${baseResource}s/:${baseResource}Id', {}, {});
  }]);
  
  
//Controllers
var appointmentApp = angular.module('appointmentApp', ['appointmentServices']);

appointmentApp.controller('DataResourceListCtrl', ['$scope', 'DataResource', function($scope, DataResource) {
  //componentHandler.upgradeElement(button); is required to re-render material design
  $scope.showProgressBar = true;
  $scope.${baseResource}s = DataResource.query({}, function(){
      $scope.showProgressBar = false;
  });
  $scope.addDataResource = function() {
      $scope.showProgressBar = true;
      var newDataResource = $scope.newDataResource;
      $scope.removeUnusedDataResourceChar(newDataResource);
      DataResource.save({},newDataResource, function(returnedDataResource){
          
          // Loop though resources to determine if new
          var index = -1;		
		var comArr = eval( $scope.${baseResource}s );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].id === returnedDataResource.id ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			$scope.${baseResource}s.push(returnedDataResource);
		}
          $scope.showProgressBar = false;
          $scope.showPopUp = false;
      });
    };
    $scope.deleteDataResource = function(${baseResource}) {
      $scope.showProgressBar = true;
      
      DataResource.delete({${baseResource}Id:${baseResource}},null, function(){
          
          var index = -1;		
		var comArr = eval( $scope.${baseResource}s );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].id === ${baseResource} ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			alert( "Something gone wrong" );
		}
		$scope.${baseResource}s.splice( index, 1 );	
          $scope.showProgressBar = false;
      });
    };
 
    $scope.maintainDataResource = function(${baseResource}) {
        $scope.newDataResource = ${baseResource};
        $scope.showPopUp = true;  
    };
    $scope.maintainNewDataResource = function() {
        $scope.maintainDataResource({}); 
    };
    $scope.removeResourceChar = function(item) { 
        var index = $scope.newDataResource.${baseResource}Characteristics.indexOf(item);
        $scope.newDataResource.${baseResource}Characteristics.splice(index, 1);     
    }
    $scope.addDataResourceChar = function() {  
        $scope.newDataResource.${baseResource}Characteristics.push({});
      }   
    //Remove any chars that have been added but will not be used
    $scope.removeUnusedDataResourceChar = function(dataResource) {
        <c:choose>
            <c:when test="${charResourceFields.size() > 0}">
        var characteristics = dataResource.${baseResource}Characteristics;
        var arrayLength = characteristics.length;
        for (var i = 0; i < arrayLength; i++) {
            if (!characteristics[i].hasOwnProperty('charType')) {
                $scope.removeResourceChar(characteristics[i]);
        }
       
      }
      </c:when>
        </c:choose>
  }
}]);
</script>