describe('book controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $scope;
    var $modalInstance;
    var book;
    var title;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
        
        $modalInstance = {
                close: jasmine.createSpy('modalInstance.close'),
                dismiss: jasmine.createSpy('modalInstance.dismiss'),
                result: {
                  then: jasmine.createSpy('modalInstance.result.then')
                }
        };
        
        book = {id: 1, title: 'title', authors: []};
    }));
    
    it('saveBook is defined', inject(function ($controller) {
    	$controller('EditModalController', {$scope: $scope, $modalInstance: $modalInstance, book: book});
        expect($scope.saveBook).toBeDefined();
    }));
    
    it('saveBook book should call bookService.saveBook', inject(function ($controller, $q, bookService, Flash) {
    	// given
    	var book = {title : 'Title'};
    	$controller('BookModalController', {$scope: $scope, book: book});

    	
    	
        var searchDeferred = $q.defer();
        spyOn(bookService, 'saveBook').and.returnValue(searchDeferred.promise);
        spyOn(Flash, 'create');
        // when
        $scope.saveBook();
        searchDeferred.resolve();
        $scope.$digest();
        //then
        expect(bookService.saveBook).toHaveBeenCalled();
        expect(Flash.create).toHaveBeenCalledWith('success', 'Książka została dodana.', 'custom-class');
    }));
    
});