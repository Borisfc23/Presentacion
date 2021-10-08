<?php 
    session_start();
    $arreglo = $_SESSION['carritoSS'];
    for ($i=0; $i < count($arreglo); $i++) { 
        if($arreglo[$i]['Id']!=$_POST['id']){
            $arregloNuevo[]=array(
                'Id'=>$arreglo[$i]['Id'],
                'Nombre'=>$arreglo[$i]['Nombre'],
                'Precio'=>$arreglo[$i]['Precio'],
                'Imagen'=>$arreglo[$i]['Imagen'],
                'Cantidad'=>$arreglo[$i]['Cantidad']
            );
        }
    }
    if(isset($arregloNuevo)){
        $_SESSION['carritoSS']=$arregloNuevo;
    }else{        
        unset($_SESSION['carritoSS']);
    }
    echo "Registro Borrado";
?>