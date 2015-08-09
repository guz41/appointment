/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var appointmentApp = angular.module('appointmentApp', ['appointmentServices']);

appointmentApp.controller('CustomerListCtrl', ['$scope', 'Customer', function($scope, Customer) {
  //$scope.customers = Customer.query();
  $scope.customers = Customer.query();
  $scope.addCustomer = function() {
      var newCustomer = {"firstName":"Added","lastName":"Customer","id":1}
      $scope.customers.push(newCustomer);
    };
}]);