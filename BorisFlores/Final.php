<?php 
session_start();
include('./ConexionesBD/conexion.php');
if(!isset($_SESSION['carritoSS'])){
  header('Location: ./Delivery.html');
}
$arreglo = $_SESSION['carritoSS'];
$total = 0;
for($i=0;$i<count($arreglo);$i++){
  $total = $total + $arreglo[$i]['Precio']*$arreglo[$i]['Cantidad'];
}
date_default_timezone_set("America/Lima");
$fecha = date('Y-m-d H:i:s');
$dni = $_POST['dni'];
$tes = $conexion -> query("select *from usuarios  where dni='$dni'");
$filaBuscada= mysqli_fetch_array($tes);  
$id_user = $conexion ->insert_id;
$conexion -> query("insert into ventas(dni_usuario,fecha,total) values($dni,'$fecha',$total)") or die($conexion -> error);
$id_venta = $conexion -> insert_id;
for ($i=0; $i < count($arreglo); $i++) { 
  $conexion -> query("insert into productos_ventas(id_venta,id_producto,cantidad,precio,subtotal) 
  values(
    $id_venta,
    ".$arreglo[$i]['Id'].",
    ".$arreglo[$i]['Cantidad'].",
    ".$arreglo[$i]['Precio'].",
    ".$arreglo[$i]['Cantidad']*$arreglo[$i]['Precio']."
  )") or die($conexion -> error);
}
$combo = $_POST['distrito'];
if($combo == 1){
  $combo = "Comas";
}
else if($combo == 2){
  $combo = "Los Olivos";
}
else if($combo == 3){
  $combo = "Miraflores";
}
else if($combo == 4){
  $combo = "Santa Anita";
}
else if($combo == 5){
  $combo = "Rimac";
}
$conexion -> query("insert into delivery(direccion,distrito,id_ventas) 
values(
'".$_POST['direccion']."',
'$combo',
$id_venta)") or die($conexion -> error);
unset($_SESSION['carritoSS']);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Siete Sopas</title>
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
    </style>
</head>
<body>
    <!-- <div id="contenedor-preloader">   
        <div id="preloader"></div>
    </div> -->
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
    <div id="contenedor-preloader">   
        <div id="preloader"></div>
    </div>
    <main>
        <div class="contenedor-msj">
            <div class="contenedor-titulo mb-4">
                <h1>Gracias por su Compra</h1>                   
            </div> 
            <h3>Su orden se guardo con exito</h3>
            <div class="d-flex justify-content-center mt-4">
            <a href="./Delivery.html"><button class="btn-warning text-white pt-2 pb-2 pl-4 pr-4">Seguir Comprando</button></a>
            </div>
        </div>
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