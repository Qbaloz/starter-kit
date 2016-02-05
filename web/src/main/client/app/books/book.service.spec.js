describe('book service', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });
    
    var $bookService;
    
    beforeEach(inject(function(bookService) {
    	$bookService = bookService;
    }));
    
    it('bookService search is defined', inject(function () {
        //then
        expect($bookService.search).toBeDefined();
    }));
    
    it('bookService deleteBook is defined', inject(function () {
        //then
        expect($bookService.deleteBook).toBeDefined();
    }));
    
    it('bookService saveBook is defined', inject(function () {
        //then
        expect($bookService.saveBook).toBeDefined();
    }));
    
    it('search should call bookService.search', inject(function () {
        //given
    	var prefix = 'test';
        spyOn($bookService, 'search');
        //when
        $bookService.search(prefix);
        //then
        expect($bookService.search).toHaveBeenCalledWith(prefix);
    }));
    
    it('deleteBook should call bookService.deleteBook', inject(function () {
        //given
    	var id = 1;
        spyOn($bookService, 'deleteBook');
        //when
        $bookService.deleteBook(id);
        //then
        expect($bookService.deleteBook).toHaveBeenCalledWith(id);
    }));
    
    it('saveBook should call bookService.saveBook', inject(function () {
        //given
    	var book = {};
        spyOn($bookService, 'saveBook');
        //when
        $bookService.saveBook(book);
        //then
        expect($bookService.saveBook).toHaveBeenCalledWith(book);
    }));

});
