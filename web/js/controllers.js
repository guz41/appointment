/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var appointmentApp = angular.module('appointmentApp', ['appointmentServices']);

appointmentApp.controller('CustomerListCtrl', ['$scope', 'Customer', function($scope, Customer) {
  //$scope.customers = Customer.query();
  $scope.showProgressBar = true;
  $scope.customers = Customer.query({}, function(){
      $scope.showProgressBar = false;
  });
  $scope.addCustomer = function() {
      $scope.showProgressBar = true;
      var newCustomer = $scope.newCustomer;
      
      Customer.save({},newCustomer, function(returnedCustomer){
          $scope.customers.push(returnedCustomer);
          $scope.showProgressBar = false;
          $scope.newCustomer = {};
      });
    };
    $scope.deleteCustomer = function(customer) {
      $scope.showProgressBar = true;
      
      Customer.delete({customerId:customer},null, function(){
          
          var index = -1;		
		var comArr = eval( $scope.customers );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].id === customer ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			alert( "Something gone wrong" );
		}
		$scope.customers.splice( index, 1 );	
          $scope.showProgressBar = false;
      });
    };
    
}]);