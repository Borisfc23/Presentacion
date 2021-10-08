 <?php 
if(isset($_POST['submit'])){
    if(!empty($correo) || !empty($usuario) || !empty($contraseña) || !empty($nombre) || !empty($apellido)
    || !empty($dni) || !empty($celular)){
        $host = 'localhost';
        $BDusername = 'root';
        $BDpassword = "";
        $BDname = "SieteSopasPeru";        
        $conectar = new mysqli($host,$BDusername,$BDpassword,$BDname);
        if(mysqli_connect_error()){
            die('connect error('.mysqli_connect_errno().')'.mysqli_connect_error());
        }else{
            $SELECT = "SELECT correo from usuarios where correo=? limit 10";
            $INSERT = "INSERT INTO usuarios (nombre,apellido,correo,celular,dni,usuario,contraseña) values(?,?,?,?,?,?,?)"; 

                $stmt = $conectar ->prepare($SELECT);                
                $stmt ->bind_param("s",$correo);
                $stmt ->execute();
                $stmt ->bind_result($correo);
                $stmt ->store_result();
                $rnum =$stmt->num_rows;
                if($rnum == 0){
                    $stmt -> close();
                    $stmt =$conectar->prepare($INSERT);
                    $stmt -> bind_param("sssiiss",$nombre,$apellido,$correo,$celular,$dni,$usuario,$contraseña);
                    $stmt ->execute();               
                    // echo '<script>alert ("Usuario Registrado");</script>';                                                         
                    echo '<script> window.location="./Login.php"; </script>'; 
                }else{                    
                    echo "<p style='color:red;font-size:12px'>Correo Repetido</p>";                        
                }
                $stmt->close();
                $conectar->close();
        }
    }else{        
        echo "<p style='color:red'>*Llena los campos</p>";         
    }
}        
?> 