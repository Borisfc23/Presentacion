function validar(){
    var usuario,contraseña;
    usuario = document.getElementById("usuario").value;
    contraseña = document.getElementById("contraseña").value;

    if(usuario == "" || contraseña == ""){        
        Swal.fire('Completa los Datos')
        return false;//Con el retorno se queda en la misma pagina
    }    
    
}