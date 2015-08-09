/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var appointmentServices = angular.module('appointmentServices', ['ngResource']);

appointmentServices.factory('Customer', ['$resource',
  function($resource){
    return $resource('customers/:customerId', {}, {
      query: {method:'GET', params:{customerId:''}, isArray:true}
    });
  }]);
