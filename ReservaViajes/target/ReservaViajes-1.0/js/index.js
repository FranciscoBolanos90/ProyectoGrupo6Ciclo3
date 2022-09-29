$(document).ready(function() {
    
    $("#form-login").submit(function (event) {
        
        event.preventDefault();
        autenticarUsuario();
    });
    
    $("#form-register").submit(function (event){
        
        event.preventDefault();
        registrarUsuario();
    });
    
});

function autenticarUsuario() {
    
    let username = $("#usuario").val();
    let clave = $("#clave").val();
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            clave: clave
        }),
        success: function (result){
            let parsedResult = JSON.parse(result);
            if (parsedResult != false){
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registrarUsuario () {
    
    let username = $("#input-username").val();
    let clave  = $("#input-clave").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let saldo = $("#input-saldo").val();
    
    if ( clave == contrasenaConfirmacion) {
        
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username : username,
                clave: clave,
                nombre: nombre,
                apellidos: apellidos,
                email: email,
                saldo: saldo
            }),
            success: function (result){
                let parsedResult =JSON.parse(result);
                
                if(parsedResult != false){
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}

