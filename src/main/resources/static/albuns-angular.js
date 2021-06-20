var app = angular.module("Album", [])

app.controller("IndexAlbumController", function($scope, $http, $window) {
	// entra na listagem buscando albuns.
	loadAlbuns();
	function loadAlbuns(){
		$http.get('/albuns').
        then(
            function(res) { 
                $scope.albuns = res.data;
            });
	}
	
            
   // clicando em alterar busca os dados para alteração
    $scope.editAlbum = function(album) {
	    $window.location.href = '/albumEntrada?idAlbum=' + album.id;
    };
    
    $scope.deleteAlbum = function(album) {
        $http({
            method: 'GET',
            url: '/deleteAlbum?idAlbum=' + album.id
        }).then(_success, _error);
    };
 
 	$scope.detalheAlbum = function(album){
 		$window.location.href = '/detalheAlbum?idAlbum=' + album.id;
 	};
 
 	function _success(res) {
        loadAlbuns();
    }
    
    function _error(res) {
        var data = res.data;
        var status = res.status;
        //var header = res.header;
        //var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
 	
 	
});

app.controller("AlbumController", function($scope, $http, $window) {
	 
	 //Em caso de edição pega o id do post pela url chamada no IndexAlbumController
	 const urlParams = new URLSearchParams(window.location.search);
	 const idAlbum = urlParams.get('idAlbum');

	 $http.get('/getAlbumById' + '?idAlbum=' + idAlbum).
	   		then(
	        	function(res) { 
	            	$scope.album = res.data;
	       	});
	 
	 $scope.submitAlbum = function() {
 
        method = "POST";
        url = '/submitAlbum';
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.album),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
    
    
    
    function _success(res) {
        $window.location.href = './indexAlbuns';
    }
    
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
});

app.controller("DetalheAlbumController", function($scope, $http, $window) {
	//pega o id do album pela url chamada no DetalheAlbumController
	 const urlParams = new URLSearchParams(window.location.search);
	 const idAlbum = urlParams.get('idAlbum');
	
	// carrega album detalhado.
	loadAlbum();
	
	function loadAlbum(){
	
		$http.get('/getAlbumById' + '?idAlbum=' + idAlbum).
			then(
		        function(res) { 
		        $scope.album = res.data;
		    });
		}
	       	   	
	  $scope.submitFoto = function(album){
			method = "POST";
		    url = '/submitFoto';
 			
		    $http({
		        method: method,
		        url: url,
		        data: angular.toJson($scope.album),
		        headers: {
		            'Content-Type': 'application/json'
		        }
		    }).then(_success, _error);
	  };
	  
	  function _success(res) {
	  	loadAlbum();
      }
    
      function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
     }
});