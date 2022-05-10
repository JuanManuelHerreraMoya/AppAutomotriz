package com.nexos.app.service.impl;

import com.nexos.app.model.Usuario;
import com.nexos.app.repository.IUsuarioRepo;
import com.nexos.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepo iUsuarioRepo;

    @Override
    public void addUser(Usuario usuario) throws Exception {
        try{
            iUsuarioRepo.save(usuario);
        }catch (Exception e){
            throw new Exception("Error creating new User");
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() throws Exception {
        try{
            return iUsuarioRepo.findAll();
        }catch (Exception e){
            throw new Exception("Error finding all Users");
        }
    }
}
