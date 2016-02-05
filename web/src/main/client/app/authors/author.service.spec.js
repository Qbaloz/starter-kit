describe('author service', function () {
    'use strict';

    beforeEach(function () {
        module('app.authors');
    });
    
    var $authorService;
    
    beforeEach(inject(function(authorService) {
    	$authorService = authorService;
    }));
    
    it('authorService search is defined', inject(function () {
        //then
        expect($authorService.search).toBeDefined();
    }));
    
    it('search should call authorService.search', inject(function () {
        //given
        spyOn($authorService, 'search');
        //when
        $authorService.search();
        //then
        expect($authorService.search).toHaveBeenCalled();
    }));

});
