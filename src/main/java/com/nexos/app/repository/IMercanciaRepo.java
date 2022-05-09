package com.nexos.app.repository;

import com.nexos.app.model.Mercancia;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMercanciaRepo extends JpaRepository<Mercancia,Integer> {
    Mercancia getBynombremercancia(String nombremercancia);

    List<Mercancia> findMercanciasByUsuarioresgistra(String usuarioresgistra);
}
