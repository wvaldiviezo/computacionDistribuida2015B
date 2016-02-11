var app = angular.module('app', []);

app.controller('main', ['$scope', '$http', function($scope, $http) {
  $scope.comprobar = function() {
    console.log($scope.pwd);
    var expreg = /^[A-Z]{1,2}\s\d{4}\s([B-D]|[F-H]|[J-N]|[P-T]|[V-Z]){3}$/;
    if (expreg.test($scope.pwd))
      alert("Password segura");
    else
      alert("Password insegura");
  }
}]);
