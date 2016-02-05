describe('book controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $scope;
    beforeEach(inject(function ($rootScope) {
        $scope = $rootScope.$new();
    }));

    it('saveBook is defined', inject(function ($controller) {
        // when
        $controller('BookModalController', {$scope: $scope});
        // then
        expect($scope.saveBook).toBeDefined();
    }));

    it('addAuthor is defined', inject(function ($controller) {
        // when
        $controller('BookModalController', {$scope: $scope});
        // then
        expect($scope.addAuthor).toBeDefined();
    }));

    it('saveBook book should call bookService.saveBook', inject(function ($controller, $q, bookService, Flash) {
    	// given
    	$controller('BookModalController', {$scope: $scope});

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

    it('addAuthor should add author to authors list', inject(function ($controller, $modal) {
    	// given

    	var author = {id: null, firstName: 'name', lastName: 'name'};

        $modal = {
                open: function() {
                    return {
                        result: {
                            then: function(callback) {
                                callback(author);
                            }
                        }
                    };
                }
        };

        $controller('BookModalController', {$scope: $scope, $modal: $modal});

        expect($scope.book.authors.length).toEqual(0);
        $scope.addAuthor();
        expect($scope.book.authors.length).toEqual(1);
        expect($scope.book.authors[0]).toEqual(author);
    }));

});
