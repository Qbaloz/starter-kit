describe('book rest service', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $bookRestService;
    var httpBackend;

    beforeEach(inject(function(bookRestService, $httpBackend) {
    	$bookRestService = bookRestService;
    	httpBackend = $httpBackend;
    }));

    it('bookRestService search is defined', inject(function () {
        //then
        expect($bookRestService.search).toBeDefined();
    }));

    it('bookRestService deleteBook is defined', inject(function () {
        //then
        expect($bookRestService.deleteBook).toBeDefined();
    }));

    it('bookRestService saveBook is defined', inject(function () {
        //then
        expect($bookRestService.saveBook).toBeDefined();
    }));

    it('bookRestService search should search book by title', inject(function (currentContextPath) {
        //then
        var title = 'Pierwsza';
        var url = currentContextPath.get() + 'services/books/books-by-title?titlePrefix=' + title;
        var book = {id: null, title: 'Pierwsza książka', authors: [{id: null, firstName: 'Jan', lastName: 'Kowalski'}]};


        httpBackend.expectGET(url).respond(200, book);
        $bookRestService.search(title);
        httpBackend.flush();
    }));
    
    it('bookRestService search should search book by title', inject(function (currentContextPath) {
        //then
        var title = 'Pierwsza';
        var url = currentContextPath.get() + 'services/books/books-by-title?titlePrefix=' + title;
        var book = {id: null, title: 'Pierwsza książka', authors: [{id: null, firstName: 'Jan', lastName: 'Kowalski'}]};


        httpBackend.expectGET(url).respond(200, book);
        $bookRestService.search(title);
        httpBackend.flush();
    }));
    
    it('bookRestService deleteBook should delete book', inject(function (currentContextPath) {
        //then
        var id = 4;
        var url = currentContextPath.get() + 'services/books/book/' + id;

        httpBackend.expectDELETE(url).respond(200);
        $bookRestService.deleteBook(id);
        httpBackend.flush();
    }));

    it('bookRestService saveBook should save book', inject(function (currentContextPath) {
        //then
        var id = 4;
        var url = currentContextPath.get() + 'services/books/book/';

        var book = {id: null, title: 'Pierwsza książka', authors: [{id: null, firstName: 'Jan', lastName: 'Kowalski'}]};
        
        httpBackend.expectPOST(url).respond(200);
        $bookRestService.saveBook(book);
        httpBackend.flush();
    }));
    
});
