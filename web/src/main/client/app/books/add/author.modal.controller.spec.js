describe('book controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $modalInstance;
    var $scope;
    var author;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
        
        $modalInstance = {
                close: jasmine.createSpy('modalInstance.close'),
                dismiss: jasmine.createSpy('modalInstance.dismiss'),
                result: {
                  then: jasmine.createSpy('modalInstance.result.then')
                }
        };
        
        author = {firstName: '', lastName: ''};
    }));
    
    it('addAuthor is defined', inject(function ($controller) {
        // when
        $controller('AuthorModalController', {$scope: $scope, $modalInstance: $modalInstance, author: author});
        // then
        expect($scope.addAuthor).toBeDefined();
    }));
    
});