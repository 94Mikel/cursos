
$(document).ready(function() {


$('#bsubmit').click(function(event) {


	var formData = {
            'email':$("#email").val(),
            'contrasena':$("#contrasena").val()
        };

     $.ajax({
            type        : 'POST', 
            url         : 'http://localhost:8080/clientes/login', 
            data        : formData, 
            dataType    : 'json', 
            encode          : true
        }).done(function(data) {

                console.log(data); 

            });

	})


})

