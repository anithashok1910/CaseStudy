var app = angular.module('myApp', []);
app.controller('MainCtrl', function ($scope, $http) {
    $scope.c = {};

    $scope.getCarData = function () {
        $http({
            method : "GET",
            url : "/list.do"
        }).then(function mySuccess(response) {
            $scope.cars = response.data;
        }, function myError(response) {
            alert(response.statusText);
            $scope.cars = response.statusText;
        });
    }

    $scope.demo = function(c){
        $scope.id = c.id;
        $scope.make = c.make;
        $scope.image = c.image;
        $scope.model = c.model;
        $scope.year=c.year;
        $scope.price = c.price;
        $scope.description = c.description;
    }

    $scope.sendData = function (car,customer) {
        var order_ID = null;
        orderRequest = mergeRecursive(order_ID,customer);
        orderRequest = mergeRecursive(orderRequest,car);
        $http({
            url: "add.do",
            method: 'POST',
            params: orderRequest,
        }).success(function(response){
            $scope.order = response.data;
        });
    }

});



function mergeRecursive(obj1, obj2) {
    for (var p in obj2) {
        try {
            // Property in destination object set; update its value.
            if ( obj2[p].constructor==Object ) {
                obj1[p] = MergeRecursive(obj1[p], obj2[p]);
            } else {
                obj1[p] = obj2[p];
            }
        } catch(e) {
            // Property in destination object not set; create it and set its value.
            obj1[p] = obj2[p];
        }
    }
    return obj1;
}