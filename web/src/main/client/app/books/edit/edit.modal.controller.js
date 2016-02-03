angular.module('app.books').controller('EditModalController', function ($scope, bookService, Flash, book) {
    'use strict';
    
    $scope.saveBook = function () {
        book.title = $scope.book.title;
        bookService.saveBook(book).then(function () {
            Flash.create('success', 'Książka została edytowana.', 'custom-class');
        });
    };
    
});