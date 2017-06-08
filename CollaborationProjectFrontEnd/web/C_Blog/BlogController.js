myApp.controller("BlogController",function($scope,$http){
    $scope.header = "Hello";
    $http.get("http://localhost:8080/CollaborationProject/getBlogs")
    .then(function(response){
        $scope.blogdata = response.data;
        console.log(response.data);
    });
    
});