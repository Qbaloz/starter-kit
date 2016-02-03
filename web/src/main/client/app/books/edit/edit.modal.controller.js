angular.module('app.books').controller('EditModalController', function ($scope, bookService, Flash, book) {
    'use strict';
    
    $scope.saveBook = function () {
    	console.log (book);
    	book.title = $scope.book.title;
    	console.log (book);
    	bookService.saveBook(book).then(function () {
            Flash.create('success', 'Książka została edytowana.', 'custom-class');
        });
    };
    
});