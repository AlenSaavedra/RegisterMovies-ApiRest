window.onload = function() {
    ocultarModificar();
    listarPeliculas();
    
    // Asegúrate de que btnModificar esté accesible después de la carga del DOM
    document.getElementById("btnModificar").addEventListener("click", () => {
        aplicarActualizacion(idEditar);
    });
};

// LISTAR PELICULAS
let listarPeliculas = async () => {
    const peticion = await fetch("https://registermovies-apirest.onrender.com/api/peliculas", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }, 
    });

    const peliculas = await peticion.json();
    let contenidoTabla = "";

    for (const pelicula of peliculas) {
        let contenidoFila = `<tr>
            <td>${pelicula.id}</td>
            <td>${pelicula.titulo}</td>
            <td>${pelicula.director}</td>
            <td>${pelicula.genero}</td>
            <td>
              <i onClick="borrarPelicula(${pelicula.id})" class="material-icons" 
                 style="font-size: 16px; vertical-align: middle; color: red; cursor: pointer;">
                 delete
              </i>
              <i onClick="editarPelicula(${pelicula.id})" class="material-icons" 
                 style="font-size: 16px; vertical-align: middle; color: #ccc; cursor: pointer;">
                 edit
              </i>
            </td>
        </tr>`;
        contenidoTabla += contenidoFila;
    }
    
    document.querySelector("#tabla tbody").innerHTML = contenidoTabla; // Cambiado a innerHTML
};

// BORRAR UNA PELICULA
let borrarPelicula = async (id) => {
    await fetch("https://registermovies-apirest.onrender.com/api/peliculas/" + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }, 
    });

    listarPeliculas();
};

let idEditar;

// EDITAR UNA PELICULA
let editarPelicula = async (id) => {
    idEditar = id;
    mostrarModificar();

    const peticion = await fetch("https://registermovies-apirest.onrender.com/api/peliculas/" + id, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }, 
    });

    const pelicula = await peticion.json();

    document.getElementsByClassName("formbold-form-input")[0].value = pelicula.titulo;
    document.getElementsByClassName("formbold-form-input")[1].value = pelicula.director;
    document.getElementsByClassName("formbold-form-input")[2].value = pelicula.genero;
};

// APLICAR MODIFICACIONES
let aplicarActualizacion = async (id) => {
    let campos = {
        id: id,
        titulo: document.getElementById("titulo").value,
        director: document.getElementById("director").value,
        genero: document.getElementById("genero").value
    };

    await fetch("https://registermovies-apirest.onrender.com/api/peliculas/" + id, { // Agregado "/" antes de id
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(campos)
    });

    listarPeliculas();
};

// OCULTAR Y MOSTRAR EL FORMULARIO DE EDICIÓN
function ocultarModificar() {
    document.getElementById("formulario").style.visibility = "hidden";
    document.getElementsByTagName("h1")[0].style.visibility = "hidden";
}

function mostrarModificar() {
    document.getElementById("formulario").style.visibility = "visible";
    document.getElementsByTagName("h1")[0].style.visibility = "visible";
}
