package com.nexos.app.controller;

import com.nexos.app.model.Usuario;
import com.nexos.app.service.IUsuarioService;
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

class UsuarioAPIControllerTest {
    @Mock
    IUsuarioService iUsuarioService;
    @InjectMocks
    UsuarioAPIController usuarioAPIController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPostUsuario() {
        ResponseEntity<?> result = usuarioAPIController.postUsuario(new Usuario(Integer.valueOf(0), "nombre", "cargo", new GregorianCalendar(2022, Calendar.MAY, 8, 23, 19).getTime(), Integer.valueOf(0)));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllUsuarios() {
        when(iUsuarioService.getAllUsuarios()).thenReturn(List.of(new Usuario(Integer.valueOf(0), "nombre", "cargo", new GregorianCalendar(2022, Calendar.MAY, 8, 23, 19).getTime(), Integer.valueOf(0))));

        ResponseEntity<?> result = usuarioAPIController.getAllUsuarios();
        Assertions.assertEquals(null, result);
    }
}