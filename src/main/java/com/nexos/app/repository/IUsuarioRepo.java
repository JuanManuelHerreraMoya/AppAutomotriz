package com.nexos.app.repository;

import com.nexos.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {
    Usuario getByNombre(String usuarioresgistra);
}
