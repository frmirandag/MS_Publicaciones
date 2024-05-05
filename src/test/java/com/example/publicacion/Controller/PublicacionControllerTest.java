package com.example.publicacion.Controller;

import com.example.publicacion.Model.Publicacion;
import com.example.publicacion.Service.PublicacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PublicacionControllerTest {

    @Mock
    private PublicacionService publicacionService;

    @InjectMocks
    private PublicacionController publicacionController;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

   

    @Test
    void createPublicacion_ValidPublicacion_ReturnsCreatedPublicacion() {
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo("Título de la publicación");
        publicacion.setComentario("Comentario de la publicación");
        publicacion.setCalificacion("Bueno");

        when(publicacionService.createPublicacion(publicacion)).thenReturn(publicacion);

        ResponseEntity<Object> responseEntity = publicacionController.createPublicacion(publicacion);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(publicacion, responseEntity.getBody());
    }

    @Test
    void deletePublicacion_ExistingId_ReturnsSuccessMessage() {
        Long id = 1L;

        when(publicacionService.getPublicacionById(id)).thenReturn(Optional.of(new Publicacion()));

        ResponseEntity<Object> responseEntity = publicacionController.deletePublicacion(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Publicación eliminada con éxito", responseEntity.getBody());
    }
}
