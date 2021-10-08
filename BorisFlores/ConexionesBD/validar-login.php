<?php   
if(isset($_POST['submit'])){
   if(!empty($usuario) || !empty($clave)){
       $host = 'localhost';
       $BDuser = 'root';
       $BDcontra = "";
       $BDtabla = "SieteSopasPeru";
       $conexion = new mysqli($host,$BDuser,$BDcontra,$BDtabla);
       if(mysqli_connect_error()){
           die('connect error('.mysqli_connect_errno().')'.mysqli_connect_error());
       }else{            
           $consulta = "SELECT *FROM usuarios WHERE usuario='$usuario' AND contraseña='$contraseña'";           
           $resultado = mysqli_query($conexion,$consulta);
           $filas = mysqli_num_rows($resultado);
           if($filas > 0){                                          
               header("Location: ./checkout.php");                  
           }else{                
               echo "<p style='color:red'>Contraseña o Usuario Incorrecto</p>";                
           }
           mysqli_free_result($resultado);
           mysqli_close($conexion);
       }
   }else{
    echo "<p style='color:red'>*Completa los Campos</p>";
   }
}
    
?>