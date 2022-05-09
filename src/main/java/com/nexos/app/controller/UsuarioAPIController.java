package com.nexos.app.controller;

import com.nexos.app.model.Usuario;
import com.nexos.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsuarioAPIController {

    @Autowired
    IUsuarioService iUsuarioService;

    @RequestMapping(value  = "/usuario/crearUsuario", method = RequestMethod.POST)
    public ResponseEntity<?> postUsuario(@RequestBody Usuario user){
        try {
            iUsuarioService.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value  = "/usuario/usuarios", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsuarios(){
        try{
            return new ResponseEntity<>(iUsuarioService.getAllUsuarios(),HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
