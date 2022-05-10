package com.nexos.app.controller;

import com.nexos.app.model.Usuario;
import com.nexos.app.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioAPIController {


    private IUsuarioService iUsuarioService;

    public UsuarioAPIController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @RequestMapping(value  = "/usuario/crearusuario", method = RequestMethod.POST)
    public ResponseEntity<?> postUsuario(@RequestBody Usuario usuario){
        try {
            iUsuarioService.addUser(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value  = "/usuario/usuarios", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsuarios(){
        try{
            return new ResponseEntity<>(iUsuarioService.getAllUsuarios(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
