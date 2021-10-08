function validar(){
    var correo = document.getElementById("correo").value;
    var usuario = document.getElementById("usuario").value;
    var contraseña = document.getElementById("contraseña").value;
    /* Validar correo */
    var expresion = /\w+@\w+\.+[a-z]/;
    if(correo == "" || usuario == "" || contraseña == ""){
        swal.fire('Completa los Campos');
        return false;
    }
    else if(usuario.length >20){
        Swal.fire('El usuario es muy grande');
        return false;
    }
    else if(contraseña.length >20){
        Swal.fire('La contraseña es muy grande');
        return false;
    }
    else if(correo.length >20){
        Swal.fire('Correo    muy grande');
        return false;        
    }
    else if(!expresion.test(correo)){
        Swal.fire('Correo Invalido');
        return false;
    }
}
