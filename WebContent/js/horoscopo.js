$(document).ready(function(){
    var strBarraNavegacion='        <nav class="navbar navbar-expand-lg navbar-light bg-light">'+
                                    ' <a class="navbar-brand" href="preConsultaHoroscopo">Horoscopo Chino</a>'+
                                    '  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">'+
                                    '  <span class="navbar-toggler-icon"></span>'+
                                    '  </button>'+
                                    '  <div class="collapse navbar-collapse" id="navbarNav">'+
                                    '  <ul class="navbar-nav">'+
                                    '    <li class="nav-item active">'+
                                    '    <a class="nav-link" href="preConsultaHoroscopo">Inicio <span class="sr-only">(current)</span></a>'+
                                    '    </li>'+
                                    '    <li class="nav-item">'+
                                    '    <a class="nav-link" href="preListarUsuarios">Listar Usuarios</a>'+
                                    '    </li>'+
                                    '   <li class="nav-item">'+
                                    '    <a class="nav-link" href="preModificarUsuario">Modificar Usuario</a>'+
                                    '    </li>'+
                                    '    <li class="nav-item">'+
                                    '    <a class="nav-link" href="preEliminarUsuario">Eliminar Usuario</a>'+
                                    '    </li>'+
                                    '    <li class="nav-item">'+
                                    '    <a class="nav-link" href="preCierreSesionExitoso">Cerrar Sesión</a>'+
                                    '    </li>'+
                                    '  </ul>'+
                                    '  </div>'+
                                     ' </nav>'

    $("#barraNavegacion").html(strBarraNavegacion);
})

$("select#usuarios").change(function(){
	$("#nombre").text = $("select#usuarios").text()
})