var app = angular.module('cars', []);

app.controller("CarsController", function ($scope, $http) {

    $scope.successGetCarCallback = function (response) {                
         $scope.carsList = response.data;
        $scope.errormessage="";
    };

    $scope.errorGetCarCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get list of cars";
    };

    $scope.getCars = function () {
        $http.get('/public/rest/cars').then($scope.successGetCarCallback, $scope.errorGetCarCallback);
    };

    $scope.successDeleteCarCallback = function (response) {
        for (var i = 0; i < $scope.carsList.length; i++) {
            var j = carsList[i];
            if (j === $scope.deletedCar) {
                $scope.carsList.splice(i, 1);
                break;
            }
        }
        $scope.errormessage="";
    };

    $scope.errorDeleteCarCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to delete car; check if there are any related records exist. Such records should be removed first";
    };

    $scope.deleteCar = function (car) {
        $scope.deletedCar = car;
        $http.delete('/public/rest/cars/' + car.getId() + '/' + car.getModel() + '/' 
                       + car.getShop() + '/' + car.getPrice() + '/' + car.getCompany()).then($scope.successDeleteCarCallback, $scope.errorDeleteCarCallback);
    };


    $scope.successGetCarCallback = function (response) {
        $scope.carsList.splice(0, 0, response.data);
        $scope.errormessage="";
    };

    $scope.errorGetCarCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on car number " + $scope.inputnumber;
    };

    $scope.successAddCarCallback = function (response) {
        $http.get('/public/rest/cars/' + $scope.inputnumber).then($scope.successGetCarCallback, $scope.errorGetCarCallback);
        $scope.errormessage="";
    };

    $scope.errorAddCarCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to add new car; check if it's number is unique";
    };

    $scope.addCar = function () {
        $http.post('/public/rest/schools/' + $scope.inputnumber + "/" + $scope.inputmodel 
                   + $scope.inputshop + $scope.inputprice + $scope.inputcompany).then($scope.successAddCarCallback, $scope.errorAddCarCallback);
    };

});


