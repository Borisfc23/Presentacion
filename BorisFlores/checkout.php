<?php 
  session_start();
  include("ConexionesBD/conexion.php");                
  if(!isset($_SESSION['carritoSS'])){
    header("Location: ./Delivery.html");
  }
  $arreglo = $_SESSION['carritoSS'];  
  $usuario = $_POST['usuario'];        
  $nombre = $conexion -> query("select *from usuarios  where usuario='$usuario'");
  $fila= mysqli_fetch_array($nombre);  
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - Siete Sopas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="icon" href="Imagenes/ImgInicio/iconofavicon2.svg">    
    <link rel="stylesheet" href="Estilos/Delivery/deliveryCompra.css">
    <link rel="stylesheet" href="Estilos/Preloader/carga.css">
    <link rel="stylesheet" href="Estilos/Delivery/checkout.css">
    
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
<div id="contenedor-preloader">   
    <div id="preloader"></div>
  </div>
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
      <main>
      <form action="Final.php" method="POST">
        <div class="contenedor-titulo mb-4">
            <h1>Revisión de Pedido</h1>                   
        </div>        
        <div class="Contenedor-checkout container d-md-flex">
          <div class="contenedor-detalles_envio col-md-6 col-12 mb-4">
            <h3>Detalles de Entrega</h3>
            <form class="mt-3">
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="nombre">Nombre</label>                  
                  
                  <input type="text" class="form-control" id="nombre" value="<?php echo $fila['nombre']?>" name="nombre">
                </div>
                <div class="form-group col-md-6">
                  <label for="dni">DNI</label>
                  <input type="number" class="form-control" id="dni" value="<?php echo $fila['dni']?>" name="dni">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="inputAddress">E-mail</label>                                               
                  <input type="email" class="form-control" value="<?php echo $fila['correo']?>">
                </div>
                <div class="form-group col-md-6">
                  <label for="inputAddress">Telefono</label>
                  <input type="number" class="form-control" value="<?php echo $fila['celular']?>">
                </div>
              </div>              
              <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="inputCity">Direccion de Envio</label>
                  <input type="text" class="form-control" id="inputCity" name="direccion">
                </div>
                <div class="form-group col-md-6">
                  <label for="inputState">Distrito</label>
                  <select id="inputState" class="form-control" name="distrito">
                    <option selected>Seleccione Distrito</option>
                    <option value="1">Comas</option>
                    <option value="2">Los Olivos</option>
                    <option value="3">Miraflores</option>
                    <option value="4">Santa Anita</option>                    
                    <option value="5">Rimac</option>
                  </select>
                </div>                
              </div>                            
          </form>
          </div>
          <div class="contenedor-orden col-md-6 col-12 mb-4">
              <h3>Orden de Delivery</h3>
              <table style="text-align: center" class="col-12 mt-3">
                <colgroup>
                  <col style="width: 50%;">
                  <col style="width: 20%;">
                  <col style="width: 30%;">                  
                </colgroup>
                <thead>
                  <tr>
                    <th>Producto</th>
                    <th>Cant.</th>
                    <th>Total</th>
                  </tr>
                </thead>  
                <tbody>
                  <?php 
                      $total = 0;
                      for ($i=0; $i < count($arreglo); $i++) { 
                        $total = $total + ($arreglo[$i]['Precio']*$arreglo[$i]['Cantidad']);                      
                   ?>
                  <tr>
                    <td><?php echo $arreglo[$i]['Nombre'] ?></td>                    
                    <td><?php echo $arreglo[$i]['Cantidad'] ?></td>                    
                    <td>S/. <?php echo number_format(($arreglo[$i]['Cantidad']*$arreglo[$i]['Precio']),2,'.',''); ?></td>                    
                  </tr>
                  <?php } ?>
                </tbody>
                <tfoot>
                  <tr>
                    <th colspan="2">Total</th>
                    <th style="font-size:;">S/. <?php echo number_format($total,2,'.',''); ?></th>
                  </tr>
                </tfoot>
              </table>
              <div class=" d-flex justify-content-center mt-3">
                <button class="btn-warning text-white p-2 col-11" >Pagar Orden</button>
              </div>              
              <!-- <div class=" d-flex justify-content-center mt-3">
                <button class="btn-danger text-white p-2 col-11" >Cancelar Orden</button>
              </div>                             -->
          </div>
        </div>
      </form>
      </main>      
      <footer class="contenedor-footer fixed-bottom mt-4">          
        <span id="footer-autor">Boris Flores Cordova &copy;2020</span>                          
    </footer>    
    <script src="Estilos/Preloader/carga.js"></script>
    <script src="https://widget.sirena.app/get?token=ef8a14b8922f452da4f07e96909fdb01"></script><!-- El de RT -->         
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>        
</body>
</html>