describe('author rest service', function () {
    'use strict';

    beforeEach(function () {
        module('app.authors');
    });
    
    var $authorRestService;
    var httpBackend;
    
    beforeEach(inject(function(authorRestService, $httpBackend) {
    	$authorRestService = authorRestService;
    	httpBackend = $httpBackend;
    }));
    
    it('authorRestService search is defined', inject(function () {
        //then
        expect($authorRestService.search).toBeDefined();
    }));
    
    it('authorRestService search should search authors', inject(function (currentContextPath) {
        //then
        var url = currentContextPath.get() + 'services/authors/author';
        httpBackend.expectGET(url).respond(200);
        $authorRestService.search();
        httpBackend.flush();
    }));
    
});