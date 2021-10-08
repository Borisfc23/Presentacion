<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservaciones - Siete Sopas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="icon" href="Imagenes/ImgInicio/iconofavicon2.svg">    
    <link rel="stylesheet" href="Estilos/Reservaciones/formReservacion.css?ver=1.0">
    <link rel="stylesheet" href="Estilos/Inicio/Footer.css">
</head>
<body>
<main>
<header>
  <div id="contenedor-preloader">
      <div id="preloader"></div>
    </div>
        <nav id="nv-s" class="navbar navbar-expand-md navbar-dark fixed-top" style="background: rgba(28, 35, 49, 0.9);">
            <a class="navbar-brand" href="Inicio.html"> Siete Sopas</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>        
                <div class="collapse navbar-collapse text-center justify-content-sm-end " id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                          <a class="nav-link" href="Nosotros.html">Nosotros</a>
                        </li>
                        <li class="nav-item active">
                          <a class="nav-link" href="Ubicacion.html">Ubicacion</a>
                        </li>                        
                        <li class="nav-item active">
                          <a class="nav-link" href="Delivery.html">Delivery</a>
                        </li>
                        <li class="nav-item active">
                          <a class="nav-link" href="Reservaciones.php">Reservas</a>
                        </li>            
                    </ul>
                </div>        
            </nav>
    </header>
        <section class="section-portada">
            <div class="img"></div>                        
        </section>
        <div class="container col-md-9 col-lg-7 mt-4">
            <h2>Reservaciones</h2>
            <form action="./ConexionesBD/reservar.php" method="POST" onsubmit="return validar()">              
                <div class="d-flex justify-content-center">                    
                    <span>Atendemos las 24 horas.</span>
                </div>
                <div class="form-row">
                  <div class=" col col-12 col-sm-6 mt-3">
                    <input type="datetime" class="form-control" id="nombre" placeholder="Nombre y Apellido*" name="nombre">
                  </div>
                  <div class=" col col-12 col-sm-6 mt-3">
                    <input type="text" class="form-control" placeholder="Empresa*" name="empresa" id="empresa">
                  </div>
                  <div class=" col col-12 col-sm-6 mt-3">
                    <input type="email" class="form-control" id="email" placeholder="Email*" name="email">
                  </div>
                  <div class=" col col-12 col-sm-6 mt-3">
                    <input type="number" class="form-control" minlength="9" placeholder="Celular*" name="celular" id="celular">
                  </div>
                  <div class=" col col-12 col-sm-4 mt-3">
                    <input type="date" class="form-control" name="fecha" id="fecha">
                  </div>
                  <div class=" col col-12 col-sm-4 mt-3">
                    <input type="time" class="form-control" name="hora" id="hora">
                  </div>
                  <div class=" col col-12 col-sm-4 mt-3">
                    <input type="number" class="form-control" placeholder="N° personas*" id="cantidad" name="cantidad">
                  </div>
                  <div class=" col col-12 col-sm-12 mt-3">
                    <textarea name="comentario" class="form-control" placeholder="Comentario" cols="30" rows="10"></textarea>
                  </div>
                </div>
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn-primary mt-3" name="submit">Enviar</button>                           
                </div>
              </form> 
        </div> 
    </main>
    <footer class="contenedor-footer mt-5">   
      <!-- <div class="sociales">
        <a href="https://www.facebook.com/SieteSopas/"><img src="Imagenes/ImgInicio/face.png"> Facebook</a>
        <a href="https://www.instagram.com/sietesopas/?hl=es-la"><img src="Imagenes/ImgInicio/insta.png"> Instagram</a>        
        <a href="Trabajos.html"><img src="Imagenes/ImgInicio/chef.png">Trabajo</a>
      </div>                  -->
      <span id="footer-autor">Boris Flores Cordova &copy;2020</span>                          
    </footer>   
    <script src="https://widget.sirena.app/get?token=ef8a14b8922f452da4f07e96909fdb01"></script>    
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="Estilos/Reservaciones/validarReserva.js"></script>
    <script src="Estilos/Inicio/general.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>