app.controller('MainCtrl', function ($scope, $http) {
    $http.get('/list.do').success(function(data) {
        $scope.car = data;
    });
    $scope.demo = function(c){
        console.log(x);
        $scope.x=c;
    }
});