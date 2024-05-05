package com.example.publicacion.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.publicacion.Model.Publicacion;
import com.example.publicacion.Repository.PublicacionRepository;

@ExtendWith(MockitoExtension.class)
public class PublicacionServiceTest {
    @InjectMocks
    private PublicacionServiceImpl publicacionServicio;

    @Mock
    private PublicacionRepository publicacionRepositoryMock;

    @Test
    public void guardarPublicacionTest() {

        Publicacion publicacionModel = new Publicacion();
        publicacionModel.setTitulo("Jose Rondon");
        publicacionModel.setComentario("Excelente nombre");
        publicacionModel.setCalificacion("7");

        when(publicacionRepositoryMock.save(any())).thenReturn(publicacionModel);

        Publicacion resultado = publicacionServicio.createPublicacion(publicacionModel);

        assertEquals("Jose Rondon", resultado.getTitulo());
    }
}
