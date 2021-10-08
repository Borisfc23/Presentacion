$(function(){
    $(".btnEliminar").click(function(event){
      // event.preventDefault();
      var id =$(this).attr('data-id');
      var boton = $(this);
      $.ajax({
        method:'POST',
        url:'./ConexionesBD/borrarRegCarrito.php',
        data:{
          id:id
        }
      }).done(function(respuesta){
        boton.parent('td').parent('tr').remove();
        location.reload();
        alert(respuesta)
      });
    });
      $(".btnIncrementar").click(function(){
        let precio = $(this).parent("div").parent("td").find("input").attr("data-precio");
        let id = $(this).parent("div").parent("td").find("input").attr("data-id");
        let cant = $(this).parent("div").parent("td").find("input").val();                                
        incrementar(id,precio,cant);
        
      });      
      function incrementar(id,precio,cant){             
        var subTotal = parseFloat(precio)*parseInt(cant);                
        $(".cant"+id).text("S/."+subTotal.toFixed(2));                    
        $.ajax({
          method:'POST',
          url:'../BorisFlores/ConexionesBD/actualizarCarrito.php',
          data:{
            id:id,
            cantidad:cant
          }
        }).done(function(respuesta){
          location.reload();
        })
      }
  });