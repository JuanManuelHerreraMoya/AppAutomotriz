package com.nexos.app.service;

import com.nexos.app.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    void addUser(Usuario usuario) throws  Exception;

    List<Usuario> getAllUsuarios() throws  Exception;

}
