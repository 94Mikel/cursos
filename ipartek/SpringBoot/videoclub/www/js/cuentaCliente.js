
        function validarCliente(){
            alert("asdfas");

            // Validate Title
           var nombre = $("#nombre").val();
            if (nombre==='' || nombre===null) { 
                alert("Escriba el nombre");
                return false;
            }

            var apellidos = $("#apellidos").val();
            if (apellidos==='' || apellidos==null) { 
                alert("Escriba los apellidos");
                return false;
            }

            var direccion = $("#direccion").val();
            if (direccion==='' || direccion==null) { 
                alert("Escriba la direccion");
                return false;
            }

            // Validate Email
            var email = $("#email").val();
            if(email==='' || email===null){
                alert("Escriba el email");
                return false;
            }else if (!(/(.+)@(.+){2,}\.(.+){2,}/.test(email))) { 
                alert("Escriba el email correctamente");
                return false;
            }



            var telefono = $("#telefono").val();
            if (telefono==='' || telefono===null) { 
                alert("Escriba el telefono");
                return false;
            } else {
                if(telefono.length<9){
                    alert("El telefono no es correcto tiene menos de 9 caracteres");
                    return false;
                }
            }

            var seguridadSocial = $("#numSeguridadSocial").val();
            if (seguridadSocial==='' || seguridadSocial===null) { 
                alert("Escriba el numero de la seguridad social");
                return false;
            }

            var contrasena1 = $("#contrasena1").val();
            if (contrasena1==='' || contrasena1===null) { 
                alert("Escriba la primera contrasena");
                return false;
            }

            var contrasena2 = $("#cuentaBancaria").val();
            if (cuentaBancaria==='' || cuentaBancaria===null) {
                alert("Escriba la cuenta Bancaria");
                return false;
            }

            var contrasena2 = $("#contrasena2").val();
            if(contrasena1 !== contrasena2){
                alert("las contraseñas no son las mismas");
                return false;
            }

            return true;
        }

