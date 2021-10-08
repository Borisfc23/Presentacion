<?php 
  session_start();
  // unset($_SESSION['carritoSS']);//Borrar Session
  include('./ConexionesBD/conexion.php');
  if(isset($_SESSION['carritoSS'])){
    if(isset($_GET['id'])){
      $arreglo = $_SESSION['carritoSS'];
      $encontro = false;
      $posicion = 0;
      for($i=0;$i<count($arreglo);$i++){
        if($arreglo[$i]['Id']==$_GET['id']){
          $encontro =true;
          $posicion = $i;
        }
      }
      if($encontro == true){        
        $arreglo[$posicion]['Cantidad'] = $arreglo[$posicion]['Cantidad'] + $_POST['cant'];
        $_SESSION['carritoSS'] = $arreglo;
        header("Location: ./Carrito.php");
      }else{        
        $nombre = "";
        $cantidad = "";
        $imagen = "";
        $res = $conexion -> query("select * from productos where id=".$_GET['id']) or die($conexion -> error);
        $fila = mysqli_fetch_row($res);
        $nombre = $fila[1];
        $precio = $fila[3];
        $imagen = $fila[5];        
        $arregloNuevo = array(
          'Id'=> $_GET['id'],
          'Nombre' => $nombre,
          'Precio' => $precio,
          'Imagen' => $imagen,
          'Cantidad' => $_POST['cant']
        );
        array_push($arreglo,$arregloNuevo);
        $_SESSION['carritoSS'] = $arreglo;
        header("Location: ./Carrito.php");
      }
    }   
  }else{
    if(isset($_GET['id'])){
      $nombre = "";
      $precio = "";      
      $imagen = "";
      $res = $conexion -> query("select *from productos where id=".$_GET['id']) or die($conexion -> error);
      $fila = mysqli_fetch_row($res);
      $nombre = $fila[1];
      $precio = $fila[3];
      $imagen = $fila[5];
      $arreglo[] = array(
        'Id'=>$_GET['id'],
        'Nombre'=>$nombre,
        'Precio'=>$precio,
        'Imagen'=>$imagen,                
        'Cantidad'=>$_POST['cant']        
      );
      $_SESSION['carritoSS']=$arreglo;
      header("Location: ./Carrito.php");
    }
  }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito - Siete Sopas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script type="text/javascript"src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="icon" href="Imagenes/ImgInicio/iconofavicon2.svg">    
    <link rel="stylesheet" href="Estilos/Delivery/deliveryCompra.css">    
    <link rel="stylesheet" href="Estilos/Delivery/btnMinPlus.css">    
    <link rel="stylesheet" href="Estilos/Preloader/carga.css">  
    <link rel="stylesheet"  href="Estilos/Delivery/deliveryCarrito.css">
    <style>
        *{
            font-family: sans-serif;
        }  
        body{
          background: #fff;
        }         
    </style>
</head>
<body>
  <header>
    <nav id="nv-p" class="navbar navbar-dark bg-warning d-flex justify-content-end fixed-top" style="padding-top: 3px;padding-bottom: 2px;">
        <form class="form-inline my-2 my-lg-0" action="./Busqueda.php" method="GET">            
          <input class="form-control mr-sm-2 mr-2"  type="search" name="buscar" placeholder="Buscar" aria-label="Search" style="height: 26px;border:none;border-radius:0;">            
        </form>
          <a class="navbar-brand" href="Login.php" style="font-size: 14px;font-weight: bold;padding-bottom: 0; display: inline-block;"><label class="icon-user"></label><span class="d-none d-sm-none d-md-inline">Mi cuenta</span></a>        
          <a class="navbar-brand" href="Carrito.php" style="font-size: 14px;font-weight: bold;padding-bottom: 0;"><label class="icon-basket"></label><span class="d-none d-sm-none d-md-inline"> Compras</span></a>
    </nav>    
    <nav id="nv-s" class="navbar navbar-expand-lg navbar-dark" style="background: rgba(28, 35, 49,0.9);">
      <a class="navbar-brand" href="Delivery.html"> Siete Sopas</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-center justify-content-sm-end" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
              <a class="nav-link" href="Inicio.html">Home</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="Piqueos.php">Piqueos</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="Pastas.php">Pastas</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="Tradicional.php">Tradicional</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="Pollo.php">Pollo</a>
            </li>            
            <li class="nav-item active">
              <a class="nav-link" href="Sopas.php">Sopas</a>
            </li>            
          </ul>
        </div>
    </nav>
  </header>
    <main>
        <h2 class="titulo-tabla mb-2">Lista de Compras en Carrito</h2>
        <div class="tabla-carrito mb-5">
        <table style="text-align: center;">          
          <colgroup>
            <col style="width: 20%;">
            <col style="width: 38%;">
            <col style="width: 15%;">
            <col style="width: 7%;">
            <col style="width: 15%;">
            <col style="width: 5%;">            
          </colgroup>
          <thead >
            <th>Imagen</th>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
            <th>Borrar</th>            
          </thead>
          <tbody> 
            <?php 
              $tot = 0;
              if(isset($_SESSION['carritoSS'])){
                $arregloCarrito = $_SESSION['carritoSS'];                
                for($i=0; $i < count($arregloCarrito); $i++){                  
                  $tot = $tot + ($arregloCarrito[$i]['Precio']*$arregloCarrito[$i]['Cantidad']);                  
            ?>         
              <tr>
                <td>
                  <img src="Imagenes/ImgDelivery/<?php echo $arregloCarrito[$i]['Imagen']?>" alt="<?php echo $arregloCarrito[$i]['Nombre']?>">
                </td>
                <td>
                  <?php echo $arregloCarrito[$i]['Nombre']?>
                </td>
                <td>
                  S/. <?php echo $arregloCarrito[$i]['Precio']?>
                </td>
                <td>     
                <div class="cant-container">
                    <div class="item-menos js-btn-minus btnIncrementar">
                      <span >-</span>
                    </div>
                      <input type="text" min="1" size="1" class="item-cantidad form-control" 
                        data-precio="<?php echo $arregloCarrito[$i]['Precio']?>"
                        data-id="<?php echo $arregloCarrito[$i]['Id']?>"
                        value="<?php echo $arregloCarrito[$i]['Cantidad']?>" class="txtcantidad" >
                    <div class="item-mas js-btn-plus btnIncrementar" >
                      <span >+</span>
                    </div>
                  </div>                                     
                </td>
                <td marca="" class="cant<?php echo $arregloCarrito[$i]['Id']?>">S/. <?php echo $arregloCarrito[$i]['Precio'] *  $arregloCarrito[$i]['Cantidad'];?></td>                                                
                <td><img src="../BorisFlores/Imagenes/ImgInicio/eliminar.png" alt="boton Eliminar" class="btnEliminar"  data-id="<?php echo $arregloCarrito[$i]['Id']?>" style="width: 24px;height:24px"></td>                
              </tr>
            <?php } } ?>
          </tbody>
          <tfoot >
            <tr>
              <th colspan="4"><span class="d-flex justify-content-end">-----TOTAL-----</span></th>              
              <th colspan="1">S/.<?php echo $tot?></th>
              <th colspan="1"></th>
            </tr>               
          </tfoot>
        </table> 
        </div>   
        <div class=" container contenedor-botones d-flex justify-content-end">
           <a href="Login.php"><button class="btn-warning pl-5 pt-2 pr-5 pb-2 text-white"><strong>Pagar Ahora</strong></button></a>
        </div>        
    </main>        
    <footer class="contenedor-footer fixed-bottom mt-5">        
        <span id="footer-autor">Boris Flores Cordova &copy;2020</span>                          
    </footer>      
    <script src="./Estilos/Delivery/MinusPlusCarrito.js"></script>
    <script src="Estilos/Preloader/carga.js"></script>
    <script src="https://widget.sirena.app/get?token=ef8a14b8922f452da4f07e96909fdb01"></script>       
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>            
    <script src="./Estilos/Delivery/MantRegCarrito.js"></script>
    <script type="text/javascript"src="https://code.jquery.com/jquery-3.5.1.min.js"></script>         
</body>
</html>