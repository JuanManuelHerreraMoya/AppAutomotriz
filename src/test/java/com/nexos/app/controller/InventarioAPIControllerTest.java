package com.nexos.app.controller;

import com.nexos.app.model.Mercancia;
import com.nexos.app.service.IMercanciaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith()
class InventarioAPIControllerTest {
    @Mock
    IMercanciaService iMercanciaService;
    @InjectMocks
    InventarioAPIController inventarioAPIController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPostUsuario() {
        ResponseEntity<?> result = inventarioAPIController.crearInventario(new Mercancia(Integer.valueOf(0), "nombremercancia", Integer.valueOf(0), new GregorianCalendar(2022, Calendar.MAY, 8, 23, 19).getTime(), "usuarioresgistra"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllInventario() {
        when(iMercanciaService.getAllMercancia()).thenReturn(List.of(new Mercancia(Integer.valueOf(0), "nombremercancia", Integer.valueOf(0), new GregorianCalendar(2022, Calendar.MAY, 8, 23, 19).getTime(), "usuarioresgistra")));

        ResponseEntity<?> result = inventarioAPIController.getAllInventario();
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllInventarioFiltro() {
        when(iMercanciaService.getAllMercanciaByRegistrador(anyString())).thenReturn(List.of(new Mercancia(Integer.valueOf(0), "nombremercancia", Integer.valueOf(0), new GregorianCalendar(2022, Calendar.MAY, 8, 23, 19).getTime(), "usuarioresgistra")));

        ResponseEntity<?> result = inventarioAPIController.getAllInventarioFiltro("nombre");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testChangeUsuario() {
        ResponseEntity<?> result = inventarioAPIController.changeUsuario(new Mercancia(Integer.valueOf(0), "nombremercancia", Integer.valueOf(0), new GregorianCalendar(2022, Calendar.MAY, 8, 23, 19).getTime(), "usuarioresgistra"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRemoveLike() {
        ResponseEntity<?> result = inventarioAPIController.removeLike("mercancia");
        Assertions.assertEquals(null, result);
    }
}
