package com.nexos.app.service.impl;

import com.nexos.app.model.Mercancia;
import com.nexos.app.model.Usuario;
import com.nexos.app.repository.IMercanciaRepo;
import com.nexos.app.repository.IUsuarioRepo;
import com.nexos.app.service.IMercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MercanciaService implements IMercanciaService {

    @Autowired
    private IMercanciaRepo iMercanciaRepo;

    @Autowired
    private IUsuarioRepo iUsuarioRepo;


    @Override
    public void addMercancia(Mercancia mercancia) throws Exception  {
        try{
            iMercanciaRepo.save(mercancia);
        }catch (Exception e){
            throw new Exception("Error trying to create new merchandise");
        }
    }

    @Override
    public List<Mercancia> getAllMercancia() throws Exception  {
        try{
            return iMercanciaRepo.findAll();
        }catch (Exception e){
            throw new Exception("Error finding all merchandaise");
        }
    }

    @Override
    public void editMercancia(Mercancia mercancia) throws Exception {
        Mercancia mercanciaOld = iMercanciaRepo.getBynombremercancia(mercancia.getNombremercancia());
        if ((mercanciaOld==null)){
            throw new Exception("Error trying to edit merchandaise");
        }else{
            mercanciaOld.setCantidad(mercancia.getCantidad());
            mercanciaOld.setFechaIngreso(new Date());
            iMercanciaRepo.save(mercanciaOld);
        }
    }

    @Override
    public void removeMercanciaByNombre(String nombreMercancia) throws Exception {
        Mercancia mercancia = iMercanciaRepo.getBynombremercancia(nombreMercancia);
        try{
            iMercanciaRepo.delete(mercancia);
        }catch (Exception e){
            throw new Exception("Error deleting  merchandaise");
        }
    }

    @Override
    public List<Mercancia> getAllMercanciaByRegistrador(String nombreregistra) throws Exception {
        try{
            return iMercanciaRepo.findMercanciasByUsuarioresgistra(nombreregistra);
        }catch (Exception e){
            throw new Exception("Error finding by User name");
        }
    }
}
