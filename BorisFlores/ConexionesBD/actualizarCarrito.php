<?php 
session_start();
$arreglo = $_SESSION['carritoSS'];
for ($i=0; $i < count($arreglo); $i++) { 
    if($arreglo[$i]['Id'] == $_POST['id']){
        $arreglo[$i]['Cantidad'] = $_POST['cantidad'];
        $_SESSION['carritoSS'] = $arreglo;
    break;
    }
}
 ?>