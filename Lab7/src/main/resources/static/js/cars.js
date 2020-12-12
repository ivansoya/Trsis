//$(":button").on("click", function(){
 //   console.log($(this).attr("value"));
 //   if ($(this).attr("id") === '1') {
 //       delete_ajax("/public/rest/cars/", $(this).attr("value"));
 //       $(this).text("DELETED");
 //       $(this).attr("disabled","");
 //   }
 //})
 
//var delete_ajax = function(url, id){
//  return $.ajax({
//   type:'DELETE',
//    url: url+id,
//   error: function (jqXHR, textStatus, errorThrown) {
//    }
//  });
//}

//var deleteCar = function(id) {
//   $(this).text("DELETED");
//   $(this).attr("disabled","");
//   return $.ajax({
//    type:'DELETE',
//   url: "/public/rest/cars/" + id,
//    error: function (jqXHR, textStatus, errorThrown) {
//    }
//  });
//}

 $("#add").on("click", function(){
  
   var car = {
     "id": $("#carID").val(),
     "model": $("#carModel").val(),
     "price": $("#carPrice").val(),
     "company": $("#carCompany").val(),
     "shop": $("#carShop").val()
   }
  
   $.ajax({
     type:'POST',
     url: '/public/rest/cars',
     headers: {
                   "Content-Type": "application/json"
               },
     data: JSON.stringify(car),
     success: function (data) {
         location.reload();
     },
     error: function (jqXHR, textStatus, errorThrown) {
     }
   });

 })