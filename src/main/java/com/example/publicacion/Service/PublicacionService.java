package com.example.publicacion.Service;

import com.example.publicacion.Model.Publicacion;
import java.util.List;
import java.util.Optional;

public interface PublicacionService {
    //esto es lo que vamos a implementar en los endpotin traemos una lista de estudiantes
    List<Publicacion> getAllPublicaciones();
    //traemos un estudiante por ID
    Optional<Publicacion> getPublicacionById(Long id);
    
    // Metodos para CREAR 
    Publicacion createPublicacion(Publicacion publicacionModel);
    
    //Metodo para ACTUALIZAR 
    Publicacion updatePublicacion(Long id, Publicacion publicacionModel);

    //Metodo para ELIMINAR
    void deletePublicacion(Long id);
    
}