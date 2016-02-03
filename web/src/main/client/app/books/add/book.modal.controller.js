angular.module('app.books').controller('BookModalController', function ($scope, bookService, Flash, $modal, $window, $location) {
    'use strict';

    $scope.book = {id: null, title: ''};
    $scope.book.authors = [];
    $scope.prefix = '';
    
    $scope.saveBook = function () {
    	console.log ($scope.book);
    	console.log ($scope.book.authors);
    	bookService.saveBook($scope.book).then(function () {
            Flash.create('success', 'Książka została dodana.', 'custom-class');
        });
    };
    
    $scope.addAuthor = function (author) {
    	var modalInstance = $modal.open({
            templateUrl: 'books/add/add-author-modal.html',
            controller: 'AuthorModalController',
            size: 'lg',
        });
    	
    	modalInstance.result.then(function(author){
        	$scope.book.authors.push(author);
       });
    };
    
});
