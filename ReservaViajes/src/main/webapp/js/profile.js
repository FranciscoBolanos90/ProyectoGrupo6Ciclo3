var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-saldo").html("$" + user.saldo.toFixed());

        getReservas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-clave").val(parsedResult.clave);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-email").val(parsedResult.email);
                $("#input-saldo").val(parsedResult.saldo.toFixed(2));

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getReservas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservasListar",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(servicios) {
    let contenido = "";
    if (servicios.length >= 1) {
        $.each(servicios, function (index, servicio) {
            servicio = JSON.parse(servicio);

            contenido += '<tr><th scope="row">' + servicio.ruta + '</th>' +
                    '<td>' + servicio.placa + '</td>' +
                    '<td>' + servicio.fecha + '</td>' ;
            contenido += '></td><td>' + servicio.hora + '</td>' +
                    '<td><button id="devolver-btn" onclick= "eliminarviaje(' + servicio.ruta
                    + ');" class="btn btn-danger">Eliminar viaje</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverPelicula(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletViajeEliminar",
        data: $.param({
            username: username,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el Pelicula");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let clave = $("#input-clave").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let saldo = $("#input-saldo").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            clave: clave,
            nombre: nombre,
            apellidos: apellidos,
            email: email,
            saldo: saldo,
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}