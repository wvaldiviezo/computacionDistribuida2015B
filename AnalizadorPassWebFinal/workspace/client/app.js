var app = angular.module('app', []);

app.controller('main', ['$scope', '$http', function($scope, $http) {
  $scope.comprobar = function() {
    console.log($scope.pwd);
    var expreg = /(^(?=.*[a-z@])(?=.*[@*/_.!?'¿Ññ¡"#$%&+-])(?=.*[A-Z])(?=.*\d){10,}.+$)/;
    if (expreg.test($scope.pwd))
      alert("Password segura");
    else
      alert("Password insegura");
  }
}]);
