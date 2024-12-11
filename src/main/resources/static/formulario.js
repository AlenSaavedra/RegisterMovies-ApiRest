let button = document.getElementById("btnRegistrar");

button.addEventListener("click", evento => {
    registrarPelicula();
});

let registrarPelicula = async () => {

    // Obtener los valores de los campos
    let campos = {};
    campos.titulo = document.getElementById("titulo").value;
    campos.director = document.getElementById("director").value;
    campos.genero = document.getElementById("genero").value;

    try {
        // Realizar la solicitud POST
        const peticion = await fetch("http://localhost:8080/api/peliculas", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(campos)
        });

        // Si la petición es exitosa, redirigir a la página de la tabla
        if (peticion.ok) {
            alert("Película registrada exitosamente");
            window.location.href = "tabla.html";  // Redirigir a la página tabla.html
        } else {
            alert("Error al registrar la película");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Error al conectar con la API");
    }
};
