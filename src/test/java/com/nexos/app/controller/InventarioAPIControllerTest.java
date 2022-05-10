package com.nexos.app.controller;

import com.nexos.app.model.Mercancia;
import com.nexos.app.model.Usuario;
import com.nexos.app.service.IMercanciaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = InventarioAPIController.class)
@ContextConfiguration(classes = InventarioAPIControllerTest.TestConfiguration.class)
public class InventarioAPIControllerTest {

    private MockMvc mockMvc;

    @Mock
    IMercanciaService iMercanciaService;

    InventarioAPIController inventarioAPIController;

    @Before
    public void setUp() {
        inventarioAPIController = new InventarioAPIController(iMercanciaService);
        mockMvc = MockMvcBuilders.standaloneSetup(inventarioAPIController).build();
    }

    @Test
    public void testCrearInventario() throws Exception {
        Usuario user = new Usuario();
        user.setFechaingreso(new Date());
        user.setId(1);
        user.setCargo("ADMIN");
        user.setEdad(21);
        user.setNombre("Juan Prueba");

        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");
        mercancia.setId(1);

        doNothing().when(iMercanciaService).addMercancia(any());

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/usuario/crearinventario")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombremercancia\":\"Filtro de aire DS3\",\"cantidad\":\"12\",\"fechaIngreso\":\"2022-05-09T18:45:00.000+00:00\",\"usuarioresgistra\":\"Juan Prueba\"}"));
        verify(iMercanciaService).addMercancia(any());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }





    @Test
    public void testGetAllInventario() throws Exception {

        List<Mercancia> mercanciaList = new ArrayList<>();
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");
        mercancia.setId(1);
        mercanciaList.add(mercancia);

        when(iMercanciaService.getAllMercancia()).thenReturn(mercanciaList);
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/usuario/mercancia"));
        verify(iMercanciaService).getAllMercancia();
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testGetAllInventarioFiltro() throws Exception {
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");
        mercancia.setId(1);
        List<Mercancia> mercanciaListFiltro = new ArrayList<>();
        mercanciaListFiltro.add(mercancia);

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/usuario/mercanciafiltro")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"usuarioresgistra\":\"Juan Prueba\"}"));

        verify(iMercanciaService).getAllMercanciaByRegistrador(any());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testChangeMercancia() throws Exception {
        Mercancia mercancia= new Mercancia();
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .put("/usuario/editarmercancia")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombremercancia\":\"Filtro de aire DS3\",\"cantidad\":\"12\",\"fechaIngreso\":\"\",\"usuarioresgistra\":\"Juan Prueba\"}"));
        verify(iMercanciaService).editMercancia(any());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }

    @Test
    public void testRemoveMercancia() throws Exception {
        Mercancia mercancia= new Mercancia();
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");

        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/usuario/mercancia/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombremercancia\":\"Filtro de aire DS3\"}"));
        verify(iMercanciaService).removeMercanciaByNombre(any());
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }


    public static class TestConfiguration{
        @Bean
        public InventarioAPIController controller(IMercanciaService iMercanciaService){
            return new InventarioAPIController(iMercanciaService);
        }
    }
}
