var app = angular.module('myApp', []);
app.controller('MainCtrl', function ($scope, $http) {
    $scope.c = {};

    $scope.getCarData = function () {
        $http({
            method: "GET",
            url: "/list.do"
        }).then(function mySuccess(response) {
            $scope.cars = response.data;
        }, function myError(response) {
            alert(response.statusText);
            $scope.cars = response.statusText;
        });
    }

    $scope.demo = function (c) {
        $scope.id = c.id;
        $scope.make = c.make;
        $scope.imageURL = c.imageURL;
        $scope.model = c.model;
        $scope.year = c.year;
        $scope.price = c.price;
        $scope.description = c.description;
    }

    $scope.sendData = function (car, customer) {
        var order_ID = 0;
        var order = new Order(order_ID,car,customer);
        var params = {
            "carId": car.id,
            "model": car.model,
            "make": car.make,
            "price": car.price,
            "year": car.year,
            "name":customer.name,
            "address":customer.address,
            "email":customer.email,
            "mob_no":customer.mob_no
        }
        console.log(params);
        $http({
            url: "/placeOrder.do",
            method: 'POST',
            params: params,
            paramSerializer: '$httpParamSerializerJQLike',
            dataType:"JSON"

        }).then(function mySucces(response) {
            $scope.order = response.data;
        }, function myError(response) {
            console.log(response);
            alert(response);
            //$scope.myWelcome = response.statusText;
        });
    }
    $scope.sendValues=function() {
        var customerId = 0;
        var name = $("#name").val();
        var address = $("#address").val();
        var email = $("#email").val();
        var contactNo = $("#phone").val();
        var Id = $("#id_label").text();
        var make = $("#make_label").text();
        var model = $("#model_label").text();
        var price = $("#price_label").text();
        var year = $("#year_label").text();
        var car = new Car(Id, make, model, price, year);
        console.log(car);
        var customer = new Customer(customerId, name, address, email, contactNo);
        $scope.sendData(car, customer);
        var t = "{{order.orderID}} <br>";
        t += "{{order.customer.customerId}} <br>";
        t += "{{order.customer.name}} <br>";
        t += "{{order.customer.email}} <br>";
        t += "{{order.customer.address}} <br>";
        t += "{{order.customer.mob_no}} <br>";

        $("#envelope").html(t);

    }

    Car = function(Id, make, model, price, year) {
        this.id = Id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;

    }

    Order = function (orderID,car,customer) {
        this.orderID = orderID;
        this.car = car;
        this.customer = customer;
    }
   Customer = function(Id, name, address, email, contactNo) {
        this.customerId = Id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mob_no = contactNo;

    }

});




$(document).ready(function () {
    $("#about").click(function () {
        $("#whole").load("about.html");

    });
});
$(document).ready(function () {
    $("#contact").click(function () {
        $("#whole").load("contactus.html");

    });
});
$(document).ready(function () {
    $("#R").click(function () {
        $("#w").load("images2.html");

    });

});


