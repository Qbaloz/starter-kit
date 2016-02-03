angular.module('app.books').controller('AuthorModalController', function ($scope, bookService, Flash, $modalInstance) {
    'use strict';

    $scope.author = {firstName: '', lastName: ''};
    
    $scope.addAuthor = function () {
        $modalInstance.close($scope.author);
    };
    
});