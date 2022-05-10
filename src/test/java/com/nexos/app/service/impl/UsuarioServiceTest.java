package com.nexos.app.service.impl;

import com.nexos.app.model.Mercancia;
import com.nexos.app.model.Usuario;
import com.nexos.app.repository.IUsuarioRepo;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UsuarioServiceTest.TestConfiguration.class})
public class UsuarioServiceTest {
    @Mock
    IUsuarioRepo iUsuarioRepo;
    @InjectMocks
    UsuarioService usuarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() throws Exception {
        Usuario user = new Usuario();
        user.setFechaingreso(new Date());
        user.setId(1);
        user.setCargo("ADMIN");
        user.setEdad(21);
        user.setNombre("Juan");
        when(iUsuarioRepo.save(any())).thenReturn(user);

        usuarioService.addUser(user);
    }

    @Test
    public void testGetAllUsuarios() throws Exception {
        List<Usuario> usuarioList = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Juan Prueba");
        usuario.setEdad(22);
        usuario.setCargo("ADMIN");
        usuario.setFechaingreso(new Date());
        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setNombre("Juan Prueba 2");
        usuario2.setEdad(22);
        usuario2.setCargo("ADMIN 2");
        usuario2.setFechaingreso(new Date());
        usuarioList.add(usuario);
        usuarioList.add(usuario2);

        when(iUsuarioRepo.findAll()).thenReturn(usuarioList);

        List<Usuario> result = usuarioService.getAllUsuarios();

        Assertions.assertEquals(result.size(),2);
        Assertions.assertEquals(result.get(0).getId(),1);
    }


    public static class TestConfiguration{
        @Bean
        public UsuarioService usuarioService(){return new UsuarioService();}
    }
}

