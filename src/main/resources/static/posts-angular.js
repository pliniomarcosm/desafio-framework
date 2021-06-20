var app = angular.module("Post", [])

app.controller("IndexController", function($scope, $http, $window) {
	// entra na listagem buscando posts.
	loadPosts();
	
	function loadPosts(){
		$http.get('/posts').
        then(
            function(res) { 
                $scope.posts = res.data;
            });
	}
	
            
   // clicando em alterar busca os dados para alteração
    $scope.editPost = function(post) {
	    $window.location.href = '/postEntrada?idPost=' + post.id;
    };
    
    $scope.deletePost = function(post) {
        $http({
            method: 'GET',
            url: '/deletePost?idPost=' + post.id
        }).then(_success, _error);
    };
 
 	$scope.detalhePost = function(post){
 		$window.location.href = '/detalhePost?idPost=' + post.id;
 	};
 
 	function _success(res) {
        loadPosts();
    }
    
    function _error(res) {
        var data = res.data;
        var status = res.status;
        //var header = res.header;
        //var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
 	
 	
});

app.controller("PostController", function($scope, $http, $window) {
	 
	 //Em caso de edição pega o id do post pela url chamada no IndexController
	 const urlParams = new URLSearchParams(window.location.search);
	 const idPost = urlParams.get('idPost');

	 $http.get('/getPostById' + '?idPost=' + idPost).
	   		then(
	        	function(res) { 
	            	$scope.post = res.data;
	       	});
	 
	 $scope.submitPost = function() {
 
        method = "POST";
        url = '/submitPost';
        var conteudo = $scope.post;
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.post),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
    
    function _success(res) {
        $window.location.href = '/';
    }
    
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
});

app.controller("DetalhePostController", function($scope, $http, $window) {
	//pega o id do post pela url chamada no DetalhePostController
	 const urlParams = new URLSearchParams(window.location.search);
	 const idPost = urlParams.get('idPost');
	
	// carrega post detalhado.
	loadPost();
	
	function loadPost(){
	
		$http.get('/getPostById' + '?idPost=' + idPost).
			then(
		        function(res) { 
		        $scope.post = res.data;
		    });
		}
	       	   	
	  $scope.submitComentario = function(post){
			method = "POST";
		    url = '/submitComentario';
 
		    $http({
		        method: method,
		        url: url,
		        data: angular.toJson($scope.post),
		        headers: {
		            'Content-Type': 'application/json'
		        }
		    }).then(_success, _error);
	  };
	  
	  function _success(res) {
	  	loadPost();
      }
    
      function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
     }
});