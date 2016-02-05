angular.module('app.books').controller('EditModalController', function ($scope, bookService, Flash, book) {
    'use strict';
    
    $scope.book = angular.copy(book);
    
    $scope.saveBook = function () {
        bookService.saveBook($scope.book).then(function () {
            Flash.create('success', 'Książka została edytowana.', 'custom-class');
        });
    };
    
});