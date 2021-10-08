var sumar = document.getElementById("mas");
var menos = document.getElementById("menos");
var contador = document.getElementById("txtcantidad");
var importe = document.getElementById("importe");
const precio = importe.getAttribute("precio");
var prevValor;

function calcular(){    
    var valor = contador.value;
    var isvalid = /^[1-9][0-9]*$/.test(valor);
    
    if(!isvalid){
        contador.value = prevValor;
    }else{
        prevValor = valor;
    }
    importe.value = Number.parseFloat(contador.value*precio).toFixed(2);    
}

sumar.onclick = function(){
    contador.value = Number(contador.value) + 1;
    calcular();
};

menos.onclick = function(){
    contador.value = Number(contador.value) - 1 ;
    calcular();
};

contador.onchange = function(){
    calcular();
};

contador.onkeyup = function(){
    if(contador.value === ""){
        return;
    }
    calcular();    
};
calcular();

