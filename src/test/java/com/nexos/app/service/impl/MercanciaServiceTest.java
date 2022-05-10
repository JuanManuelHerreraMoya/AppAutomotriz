package com.nexos.app.service.impl;

import com.nexos.app.model.Mercancia;
import com.nexos.app.repository.IMercanciaRepo;
import com.nexos.app.repository.IUsuarioRepo;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MercanciaServiceTest.TestConfiguration.class})
public class MercanciaServiceTest {

    @Mock
    IMercanciaRepo iMercanciaRepo;

    @Mock
    IUsuarioRepo iUsuarioRepo;

    @InjectMocks
    MercanciaService mercanciaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMercancia() throws Exception {
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");
        mercancia.setId(1);

        when(iMercanciaRepo.save(any())).thenReturn(mercancia);

        mercanciaService.addMercancia(mercancia);
    }



    @Test
    public void testGetAllMercancia() throws Exception {
        List<Mercancia> mercanciaList = new ArrayList<>();
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");
        mercancia.setId(1);
        mercanciaList.add(mercancia);

        when(iMercanciaRepo.findAll()).thenReturn(mercanciaList);

        List<Mercancia> result = mercanciaService.getAllMercancia();

        Assertions.assertEquals(result.size(),1);
        Assertions.assertEquals(result.get(0).getId(),1);
    }

    @Test
    public void testEditMercancia() throws Exception {
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Tornillo de motoro");
        mercancia.setUsuarioresgistra("carlos Prueba");
        mercancia.setId(1);

        Mercancia mercanciaOld= new Mercancia();
        mercanciaOld.setFechaIngreso(new Date());
        mercanciaOld.setCantidad(6);
        mercanciaOld.setNombremercancia("Tornillo de motoro");
        mercanciaOld.setUsuarioresgistra("carlos Prueba");
        mercanciaOld.setId(1);

        when(iMercanciaRepo.getBynombremercancia("Tornillo de motoro")).thenReturn(mercanciaOld);
        when(iMercanciaRepo.save(any())).thenReturn(mercancia);

        mercanciaService.editMercancia(mercancia);
    }

    @Test
    public void testRemoveMercanciaByNombre() throws Exception {
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Tornillo de motoro");
        mercancia.setUsuarioresgistra("carlos Prueba");
        mercancia.setId(1);

        doNothing().when(iMercanciaRepo).delete(mercancia);
        mercanciaService.removeMercanciaByNombre("Tornillo de motor");
    }

    @Test
    public void testGetAllMercanciaByRegistrador() throws Exception {
        List<Mercancia> mercanciaList = new ArrayList<>();
        Mercancia mercancia= new Mercancia();
        mercancia.setFechaIngreso(new Date());
        mercancia.setCantidad(12);
        mercancia.setNombremercancia("Filtro de aire DS3");
        mercancia.setUsuarioresgistra("Juan Prueba");
        mercancia.setId(1);
        mercanciaList.add(mercancia);

        when(iMercanciaRepo.findMercanciasByUsuarioresgistra(any())).thenReturn(mercanciaList);

        List<Mercancia> result = mercanciaService.getAllMercanciaByRegistrador("Juan Prueba");

        Assertions.assertEquals(result.size(),1);
        Assertions.assertEquals(result.get(0).getId(),1);
    }



    public static class TestConfiguration{
        @Bean
        public MercanciaService mercanciaService(){return new MercanciaService();}
    }
}