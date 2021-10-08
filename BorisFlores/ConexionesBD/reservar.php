<?php 
    if(isset($_POST['submit'])){
        include("./conexion.php");
        $nombre = $_POST['nombre'];
        $empresa = $_POST['empresa'];
        $email = $_POST['email'];
        $celular = $_POST['celular'];
        $fecha = $_POST['fecha'];
        $hora = $_POST['hora'];
        $cantidad = $_POST['cantidad'];
        $comentario = $_POST['comentario'];
        if(!empty($nombre) || !empty($empresa) || !empty($email) || !empty($celular) || !empty($fecha)
            || !empty($hora) || !empty($cantidad) || $celular<900000000 || $celular>999999999){        
            $conexion -> query("insert into reservas(nombre,empresa,correo,celular,fecha,hora,cantidad,comentario)
            values(
                '$nombre',
                '$empresa',
                '$email',
                $celular,
                '$fecha',
                '$hora',
                $cantidad,
                '$comentario'
            )") or die ($conexion -> error);                        
            echo '<script> window.location="../Inicio.html"; </script>'; 	
    }else{                
        echo '<script> window.location="../Reservaciones.php"; </script>'; 	
    }
    }
?> 
