function validar(){
    var nombre,cantidad,celular,email,empresa,fecha,hora;
    nombre = document.getElementById("nombre").value;
    cantidad = document.getElementById("cantidad").value;
    celular = document.getElementById("celular").value;
    fecha = document.getElementById("fecha").value;
    hora = document.getElementById("hora").value;
    empresa = document.getElementById("empresa").value;
    email = document.getElementById("email").value;
    var expresion = /\w+@\w+\.+[a-z]/;
    if(nombre == "" || cantidad == "" || celular == "" || fecha == ""
        || hora == "" || empresa == "" || email=="" || !expresion.test(email) || celular<900000000 || celular>999999999){
            Swal.fire('Datos Incorrectos o Incompletos')
            return false;
    }else{
        Swal.fire('Formulario Enviado')
    }
}