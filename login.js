/**
 * Created by zhangfa on 7/29/2015.
 */

+ function(angular, $) {

    "use strict"

    var loginModule = angular.module("loginModule", ["ers.components.login", "ngCookies", 'LocalStorageModule', "app.userAccess"]);

    loginModule.config(['localStorageServiceProvider', '$httpProvider',
        function(localStorageServiceProvider, $httpProvider) {
            localStorageServiceProvider.setPrefix('RB');

            if ($httpProvider.defaults.headers.get) {
                $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
                $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
            } else {
                $httpProvider.defaults.headers.get = {
                    'Cache-Control': 'no-cache',
                    'Pragma': 'no-cache'
                };
            }
        }
    ]);

    loginModule.controller("LoginController", ["$scope", "$q", "loginService", "$cookieStore", "$window", "$timeout", "$http",
        function($scope, $q, loginService, $cookieStore, $window, $timeout, $http) {

            $scope.login = function(username, password) {
                console.log('==login.login:force logout first:');
                $http.get('/logout'); //
                var deferred = $q.defer();
                loginService.login(username, password)
                    .success(function(result) {
                        deferred.resolve(result);
                        $window.location.href = "app.html";
                    })
                    .error(function(error) {
                        // console.error('ERROR!', error);
                        var errorMessage = error.message ? error.message : error
                        deferred.reject({
                            credentialsError: true,
                            message: errorMessage
                        });
                    });

                return deferred.promise;
            };
        }
    ]);

    loginModule.service("loginService", ["$http", "userAccessFactory", "localStorageService",
        function($http, userAccessFactory, localStorageService) {
            this.login = function(username, password) {
                userAccessFactory.setUserInfoForCmmAccess(username, password);
                return $http.post("/login", {
                    username: username,
                    password: password
                }, {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    transformRequest: $.param,
                    transformResponse: function(resp) {
                        return resp;
                    }
                });
            }
        }
    ]);
}(angular, $);
