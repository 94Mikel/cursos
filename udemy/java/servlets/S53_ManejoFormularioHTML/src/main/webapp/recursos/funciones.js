function validarForma(forma){
    var usuario = forma.usuario;
    if(!usuario.value){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    if(usuario.value === "Escribir usuario"){
        alert("Escriba un nombre de usuario correcto");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var password = forma.password;
    if(!password.value){
        alert("Debe proporcionar un la contraseña de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    if(password.value.length < 3){
        alert("Debe proporcionar un la contraseña al menos con 3 caracteres");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    
    for (var i = 0; i < tecnologias.length; i++) {
        if(tecnologias[i].checked){
            checkSeleccionado = true;
            break;
        }
    }
    
    if(!checkSeleccionado){
        alert("Debe seleccionar una tecnologia");
        return false;
    }
    
    var generos = forma.genero;
    var radioSeleccionado = false;
    
    for (var i = 0; i < generos.length; i++) {
        if(generos[i].checked){
            radioSeleccionado = true;
            break;
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }
    
    var ocupacion = forma.ocupacion;
    if(!ocupacion.value){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    //Formulario es valido
    alert("Formulario valido, enviado datos al servidor");
    return true;
    
}

