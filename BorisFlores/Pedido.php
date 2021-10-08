<?php 
  include('./ConexionesBD/conexion.php');
  if(isset($_GET['id'])){
    $resultado = $conexion -> query("select *from productos where id=".$_GET['id']) or die($conexion -> error);
    if(mysqli_num_rows($resultado)>0){
        $fila = mysqli_fetch_row($resultado);
    }else{
      header("Location: ./Delivery.html");
    }
  }else{
    header("Location: ./Delivery.html");
  }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedido - Siete Sopas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="icon" href="Imagenes/ImgInicio/iconofavicon2.svg">    
    <link rel="stylesheet" href="Estilos/Delivery/deliveryPedido.css">
    <link rel="stylesheet" href="Estilos/Delivery/btnMinPlus.css">
    <link rel="stylesheet" href="Estilos/Preloader/carga.css">
    <style>
        *{
            font-family: sans-serif;
        }        
    </style>
</head>
<body>
  <div id="contenedor-preloader">
      <div id="preloader"></div>
  </div>
  <header>
      <nav id="nv-p" class="navbar navbar-dark bg-warning d-flex justify-content-end fixed-top" style="padding-top: 3px;padding-bottom: 2px;">
          <a class="navbar-brand" href="Login.php" style="font-size: 14px;font-weight: bold;padding-bottom: 0;"><label class="icon-user"></label>Mi Cuenta</a>        
          <a class="navbar-brand" href="Carrito.php" style="font-size: 14px;font-weight: bold;padding-bottom: 0;"><label class="icon-basket"></label>Compras</a>
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
      <div class="atras-contenedor">
            <a href="javascript:history.back()"><img src="./Imagenes/ImgInicio/back.png" alt=""> Volver</a>
      </div>             
      <form action="Carrito.php?id=<?php echo $fila['0']?>" method="post">
      <div class="grid-container-pedido">                    
          <div class="item-img">
            <img src="Imagenes/ImgDelivery/<?php echo $fila['5']?>" alt="<?php echo $fila['1']?>">                             
          </div>
          <div class="item-descripcion">
              <h2><?php echo $fila['1']?></h2>
              <p><?php echo $fila['2']?></p>
              <hr>
              <h4>Cantidad</h4>
              <div class="cant-container">
                <div class="item-menos" id="menos"><span>-</span></div>
                  <input type="text" size="2" min="1" value="1" id="txtcantidad" class="item-cantidad" name="cant">
                <div class="item-mas" id="mas"><span>+</span></div>
              </div>              
              <hr>              
              <div class="item-salida">                                                            
                <p class="item-precio">Precio: S/.<input class="importe" readonly type="text" min="1" id="importe" precio="<?php echo $fila['3']?>" value="<?php echo $fila['3']?>"></p>                                             
                <button class="item-btn btn-warning icon-basket">Agregar</button>
              </div>
          </div>          
      </div>
      </form>          
  </main>  
  <footer class="contenedor-footer fixed-bottom">        
      <span id="footer-autor">Boris Flores Cordova &copy;2020</span>                          
  </footer>    
    <script src="./Estilos/Delivery/MinusPlusPedido.js"></script>
    <script src="Estilos/Preloader/carga.js"></script>
    <script src="https://widget.sirena.app/get?token=ef8a14b8922f452da4f07e96909fdb01"></script>      
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>        
</body>
</html>