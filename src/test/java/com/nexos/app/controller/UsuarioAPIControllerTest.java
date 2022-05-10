package com.nexos.app.controller;

import com.nexos.app.model.Usuario;
import com.nexos.app.service.IUsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UsuarioAPIController.class)
@ContextConfiguration(classes = UsuarioAPIControllerTest.TestConfiguration.class)
public class UsuarioAPIControllerTest {

    private MockMvc mockMvc;

    @Mock
    IUsuarioService iUsuarioService;

    UsuarioAPIController usuarioAPIController;

    @Before
    public void setUp() {
        usuarioAPIController = new UsuarioAPIController(iUsuarioService);
        mockMvc = MockMvcBuilders.standaloneSetup(iUsuarioService).build();
    }
/*
    @Test
    public void testPostUsuario() throws Exception {
        Usuario user = new Usuario();
        user.setFechaingreso(new Date());
        user.setId(1);
        user.setCargo("ADMIN");
        user.setEdad(21);
        user.setNombre("Juan");

        doNothing().when(iUsuarioService).addUser(any());

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/usuario/crearusuario")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\":\"Juan\",\"cargo\":\"ADMIN\",\"fechaingreso\":\"2022-05-09T22:09:00.000+00:00\",\"edad\":\"21\"}"));
        verify(iUsuarioService).addUser(any());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

/*
    @Test
    public void testGetAllUsuarios() throws Exception {
        List<Usuario> usuarioList = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Prueba");
        usuario.setEdad(22);
        usuario.setCargo("ADMIN");
        usuario.setFechaingreso(new Date());
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Juan Prueba 2");
        usuario2.setEdad(22);
        usuario2.setCargo("ADMIN 2");
        usuario2.setFechaingreso(new Date());
        usuarioList.add(usuario);
        usuarioList.add(usuario2);

        when(iUsuarioService.getAllUsuarios()).thenReturn(usuarioList);

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/usuario/usuarios"));

        verify(iUsuarioService).getAllUsuarios();
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

 */

    public static class TestConfiguration{
        @Bean
        public UsuarioAPIController controller(IUsuarioService iUsuarioService){
            return new UsuarioAPIController(iUsuarioService);
        }
    }
}

