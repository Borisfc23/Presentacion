<?php 
    ob_start();
    if(isset($_POST['submit'])){
        $nombre = $_POST['nombre'];
        $apellido = $_POST['apellido'];
        $correo = $_POST['correo'];
        $celular = $_POST['celular'];
        $dni = $_POST['dni'];
        $usuario = $_POST['usuario'];
        $contraseña = $_POST['contraseña'];
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse - Siete Sopas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="icon" href="Imagenes/ImgInicio/iconofavicon2.svg">    
    <link rel="stylesheet" href="Estilos/Inicio/Header.css">    
    <link rel="stylesheet" href="Estilos/Inicio/Menu.css">
    <link rel="stylesheet" href="Estilos/Inicio/Footer.css">    
    <link rel="stylesheet" href="Estilos/Login/login.css">
</head>
<body>    
    <nav id="nv-p" class="navbar navbar-dark bg-warning d-flex justify-content-end fixed-top" style="padding-top: 3px;padding-bottom: 2px;">
      <form class="form-inline my-2 my-lg-0" action="./Busqueda.php" method="GET">            
        <input class="form-control mr-sm-2 mr-2"  type="search" name="buscar" placeholder="Buscar" aria-label="Search" style="height: 26px;border:none;border-radius:0;">            
      </form>
        <a class="navbar-brand" href="Login.php" style="font-size: 14px;font-weight: bold;padding-bottom: 0; display: inline-block;"><label class="icon-user"></label><span class="d-none d-sm-none d-md-inline" style="color: #fff;font-style:normal">Mi cuenta</span></a>        
        <a class="navbar-brand" href="Carrito.php" style="font-size: 14px;font-weight: bold;padding-bottom: 0;"><label class="icon-basket"></label><span class="d-none d-sm-none d-md-inline" style="color: #fff;font-style:normal"> Compras</span></a>
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
    <div class="contenedor-registro">              
        <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" class="form-caja" method="POST" onsubmit="return validar()">
            <div class="caja-btn">                
                <h2>Registrarse</h2>
            </div>
            <div class="redes-sociales">
                <img  class="rs-f" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/1200px-Facebook_f_logo_%282019%29.svg.png" alt="">
                <img class="rs-t" src="https://hipertextual.com/files/2012/06/twitter-bird-white-on-blue.jpg" alt="">
                <img class="rs-g" src="https://logodownload.org/wp-content/uploads/2017/05/google-chrome-logo.png" alt="">
            </div>                                  
            <div id="registro" class="input-group mt-3">            
                <?php include("../BorisFlores/ConexionesBD/validar-registro.php");?>            
              <div class="form-row">
                <div class="form-group col-sm-6">                  
                  <input type="text" class="form-control" placeholder="Nombre" name="nombre" id="nombre">
                </div>
                <div class="form-group col-sm-6">                  
                  <input type="text" class="form-control" placeholder="Apellido" name="apellido" id="apellido">
                </div>
              </div>                                  
              <div class="form-group w-100">                  
                  <input type="email" class="form-control" placeholder="Ingrese Correo"  name="correo" id="correo">                  
              </div>                                
              <div class="form-row">
                <div class="form-group col-sm-6">                  
                  <input type="number" class="form-control" placeholder="Celular" name="celular" id="Celular">
                </div>
                <div class="form-group col-sm-6">                  
                  <input type="number" class="form-control" placeholder="DNI" name="dni" id="dni">
                </div>
              </div>
              <div class="form-group w-100">                  
                  <input type="text" class="form-control" placeholder="Nombre de Usuario"  name="usuario" id="usuario">                  
              </div>                
              <div class="form-group w-100">                  
                  <input type="password" class="form-control" placeholder="Contraseña"  name="contraseña" id="contraseña">                  
              </div>                                                
                <input type="submit" class="submit-btn btn-warning" value="Registrar" name="submit">                               
            </div>
        </form>
    </div>
    
    <footer class="contenedor-footer fixed-bottom">           
        <span id="footer-autor">Boris Flores Cordova &copy;2020</span>                          
    </footer>    
    <script src="https://widget.sirena.app/get?token=ef8a14b8922f452da4f07e96909fdb01"></script>
    <script src="Estilos/Inicio/general.js"></script>    
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="Estilos/Login/validarRegistro.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>       
</body>
</html>
<?php 
  ob_end_flush();
 ?>