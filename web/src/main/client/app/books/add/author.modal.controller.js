angular.module('app.books').controller('AuthorModalController', function ($scope, bookService, Flash) {
    'use strict';

    $scope.author = {id: null, firstName: '', lastName: ''};
    
    $scope.addAuthor = function () {
    	console.log ($scope.author);
    };
    
});