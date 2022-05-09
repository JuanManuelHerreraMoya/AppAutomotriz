package com.nexos.app.service;


import com.nexos.app.model.Mercancia;

import java.util.List;


public interface IMercanciaService {
    void addMercancia(Mercancia mercancia) throws Exception;

    List<Mercancia> getAllMercancia() throws Exception;

    void editMercancia(Mercancia mercancia) throws Exception;

    void removeMercanciaByNombre(String mercancia) throws Exception;

    List<Mercancia> getAllMercanciaByRegistrador(String nombre) throws Exception;
}
