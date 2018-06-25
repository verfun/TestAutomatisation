var routerApp = angular.module('routerApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider

        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'register.html',
            controller: 'loginController'
        })
    
        // HOME STATES AN ========================================
        .state('intranet', {
            url: '/intranet',
            templateUrl: 'Home.html'
        })

        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('signIn', {
             url: '/signIn',
             templateUrl: 'login.html',
             controller: 'loginController'
        });
    
    

});


routerApp.controller('loginController', function($scope,$window) {
   
    $scope.message = 'test';
    $scope.newUser = {};
    $scope.temperature = 0;
    $scope.resultTempFahrenheit = 32;
    
   
    $scope.users = [
        {
            lname: 'Lester',
            fname: 'Marck',
            email: 'Lester.Marck@capgemini.com',
            pwd: 'testPwd1'
        },
        {
            lname: 'Lochet',
            fname: 'Alex',
            email: 'Lochet.Alex@capgemini.com',
            pwd: 'testPwd2'
        },
        {
            lname: 'Alaoui',
            fname: 'Amine',
            email: 'Alaoui.Amine@capgemini.com',
            pwd: 'testPwd3'
        }
    ];
    $scope.numberOfUsers = $scope.users.length ;
    $scope.addUser = function(user){
        $scope.users.push(user);
        $scope.numberOfUsers = $scope.users.length;
        $scope.newUser ={}
    };
    
    $scope.email;
    $scope.pwd;
    
    $scope.connect = function(){
      
    };
    
    $scope.fount = function(email, pwd) {$scope.users.find(function(element) {
        if(element.email == email && element.pwd == pwd){
            return true;
    }})};
    
    $scope.converter = function(temp) {
        $scope.resultTempFahrenheit = Math.round((temp * 1.8 + 32)*100)/100;
    };
});