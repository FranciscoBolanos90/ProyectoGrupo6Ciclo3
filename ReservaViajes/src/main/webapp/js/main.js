var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getViajes(false, "ASC");

        $("#ordenar-fecha").click(ordenarServicio);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getViajes(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletServicioListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarViajes(parsedResult);
            } else {
                console.log("Error recuperando los datos de las peliculas");
            }
        }
    });
}
function mostrarViajes(servicios) {

    let contenido = "";

    $.each(servicios, function (index, servicio) {

        servicio = JSON.parse(servicio);
        let precio;

            contenido += '<tr><th scope="row">' + servicio.ruta + '</th>' +
                    '<td>' + servicio.placa + '</td>' +
                    '<td>' + servicio.fecha + '</td>' +
                    '<td>' + servicio.hora + '</td>' +
                    '<td>' + servicio.valor + '</td>' +
                    '<td>' + servicio.puestos + '</td>' ;
            contenido += '></td>' +
                    '<td><button onclick="reservarViaje(' + servicio.ruta + ',' + precio + ');" class="btn btn-success" ';

            contenido += '>Reservar</button></td></tr>'

    });
    $("#viajes-tbody").html(contenido);
}
