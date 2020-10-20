var app = angular.module('cars', []);

app.controller("CarsController", function ($scope, $http) {

    $scope.successGetCarsCallback = function (response) {                
         $scope.carsList = response.data;
        $scope.errormessage="";
    };

    $scope.errorGetCarsCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get list of cars";
    };

    $scope.getCars = function () {
        $http.get('/public/rest/cars').then($scope.successGetCarsCallback, $scope.errorGetCarsCallback);
    };
   

    $scope.successDeleteCarCallback = function (response) {
        for (var i = 0; i < $scope.carsList.length; i++) {
            var j = $scope.carsList[i].id;
            if (j === $scope.deletedId) {
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

    $scope.deleteCar = function (id) {
        $scope.deletedId = id;
        $http.delete('/public/rest/cars/' + id).then($scope.successDeleteCarCallback, $scope.errorDeleteCarCallback);
    };


    $scope.successAddCarCallback = function (response) {
        $scope.carsList.splice($scope.carsList.length, 0, response.data);
        $scope.errormessage="";
    };

    $scope.errorAddCarCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on car number " + $scope.inputnumber;
    };

    $scope.addCar = function () {
        $http.post('/public/rest/cars/' + $scope.inputnumber + "/" + $scope.inputmodel 
                   + "/" + $scope.inputshop + "/" + $scope.inputprice + "/" + 
                   $scope.inputcompany).then($scope.successAddCarCallback, $scope.errorAddCarCallback);
    };
    
    $scope.successShowShopCallback = function (response) {
        $scope.shop = response.data;
        let div = document.createElement('div');
        div.innerHTML = "<font class=\"styletest \">" +
                        "<strong> Shop name: </strong>" + $scope.shop.name + "<br>" + 
                        "<strong> Town: </strong>" + $scope.shop.town + "<br>" + 
                        "<strong> Adress: </strong>" + $scope.shop.adress +
                        "</font>" ;
        document.body.append(div);
        window.scrollBy(0, 200);
        $scope.errormessage="";
    };
    
    $scope.errorShowShopCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on shop id";
    };
    
    $scope.successFindCarCallback = function (response) {
        $scope.car = response.data;
        let id = $scope.car.shop;
        $http.get('/public/rest/shops/' + id).then($scope.successShowShopCallback, $scope.errorShowShopCallback);
        $scope.errormessage="";
    };

    $scope.errorFindCarCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on car number " + $scope.inputnid;
    };
    
    $scope.showShop = function () {
        $http.get('/public/rest/cars/' + $scope.inputid).then($scope.successFindCarCallback, $scope.errorFindCarCallback);
    };
});

