package com.example.apiRestSB.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiRestSB.modelos.Pelicula;
import com.example.apiRestSB.repository.PeliculaRepository;

@RestController
public class PeliculaController {
    //Crear variable para guardar objetos
    PeliculaRepository repositorio;

    //Inyectar objetos mediante un contructor
    public PeliculaController(PeliculaRepository repositorio){
        this.repositorio = repositorio;
    }

    //Metodo que nos cree objetos
    @GetMapping("/api/crearPeliculas")
    public void crearPeliculas(){
        Pelicula pelicula1 = new Pelicula("Titanic", "James Cameron", "Drama");
        Pelicula pelicula2 = new Pelicula("Forrest Gump", "robert Zemekis", "Drama");
        Pelicula pelicula3 = new Pelicula("Stars Wars", "George Lucas", "Ciencia Ficción");
        
        //Guardar objetos creados en la base de datos
        repositorio.save(pelicula1);
        repositorio.save(pelicula2);
        repositorio.save(pelicula3);
    }

    //Accede a todas las peliculas
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/api/peliculas")
    public List<Pelicula> obtenerPelicula(){
        return repositorio.findAll();
    }

    //Accede a una por id
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/api/peliculas/{id}")
    public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable Long id){
      Optional<Pelicula> opt = repositorio.findById(id);

      if (opt.isEmpty()) {
        return ResponseEntity.badRequest().build();
        
      }else{
        return ResponseEntity.ok(opt.get());
      }
    }

    //Metodo para guardar dato desde el Frontend
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/api/peliculas")
    public ResponseEntity<Pelicula> guardarPelicula(@RequestBody Pelicula pelicula){
        if (pelicula.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        
        repositorio.save(pelicula);
        return ResponseEntity.ok(pelicula);

    }

    //Metodo actualizar
    @CrossOrigin("http://127.0.0.1:5500")
	@PutMapping("/api/peliculas/{id}")
	public ResponseEntity<Pelicula> actulizarPelicula(@RequestBody Pelicula pelicula) {
		
		if (pelicula.getId()==null || !repositorio.existsById(pelicula.getId()))
		{
			return ResponseEntity.badRequest().build();
		}
		
		repositorio.save(pelicula);
		return ResponseEntity.ok(pelicula);
	}
	
    //Metodo eliminar
	@CrossOrigin("http://127.0.0.1:5500")
	@DeleteMapping("/api/peliculas/{id}")
	public ResponseEntity<Pelicula> borrarPelicula(@PathVariable Long id) {
		
		if (id == null || !repositorio.existsById(id))
		{
			return ResponseEntity.badRequest().build();
		}
		
		repositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
    
}