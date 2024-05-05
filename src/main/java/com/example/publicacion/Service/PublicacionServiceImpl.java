package com.example.publicacion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.publicacion.Model.Publicacion;
import com.example.publicacion.Repository.PublicacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServiceImpl implements PublicacionService {
   
    //hace las conexiones entre la interfase y la implementacion(internamente hace un constructor)
    @Autowired
    private PublicacionRepository publicacionRepository;

    // Es para asegurarnos de que estamos reemplazando correctamente los métodos heredados en nuestras clases de Spring Boot
    @Override
    //Define un método público llamado getAllPublicaciones()
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    //codigo para listar estudiantes por ID
    public Optional<Publicacion> getPublicacionById(Long id) {
        //Aquí, estamos devolviendo el resultado de la llamada al método findAll()
        return publicacionRepository.findById(id);
    }

    //Metodo para crear un estudiante
    @Override
    public Publicacion createPublicacion(Publicacion publicacionModel){
        return publicacionRepository.save(publicacionModel);
    }

    //Metodo para Actualizar estudiante
    @Override
    public Publicacion updatePublicacion(Long id, Publicacion publicacionModel){
        if(publicacionRepository.existsById(id)){
            publicacionModel.setId(id);
            return publicacionRepository.save(publicacionModel);
        }else{
            return null;
        }
    }

    //Metodo para eliminar estudiantes
    @Override
    public void deletePublicacion(Long id){
        publicacionRepository.deleteById(id);
    }
    
}
