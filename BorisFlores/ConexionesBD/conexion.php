<?php
    $host = "localhost";
    $user = "root";
    $pass = "";
    $bd = "sietesopasperu";

    $conexion = new mysqli($host,$user,$pass,$bd);
    
    if($conexion ->connect_error){
        die("No hay conexion");
    }
?>
