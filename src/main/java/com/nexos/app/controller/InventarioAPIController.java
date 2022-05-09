package com.nexos.app.controller;


import com.nexos.app.model.Mercancia;
import com.nexos.app.service.IMercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventarioAPIController {

    @Autowired
    private IMercanciaService iMercanciaService;


    @RequestMapping(value  = "/usuario/crearInventario", method = RequestMethod.POST)
    public ResponseEntity<?> crearInventario(@RequestBody Mercancia mercancia){
        try {
            iMercanciaService.addMercancia(mercancia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value  = "/usuario/mercancia", method = RequestMethod.GET)
    public ResponseEntity<?> getAllInventario(){
        try{
            return new ResponseEntity<>(iMercanciaService.getAllMercancia(),HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value  = "/usuario/mercanciaFiltro/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllInventarioFiltro(@PathVariable(name = "nombre") String  nombre){
        try{
            return new ResponseEntity<>(iMercanciaService.getAllMercanciaByRegistrador(nombre),HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value  = "/usuario/editarMercancia", method = RequestMethod.PUT)
    public ResponseEntity<?> changeUsuario(@RequestBody Mercancia mercancia){
        try {
            iMercanciaService.editMercancia(mercancia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value  = "/usuario/mercancia/{nombreMercancia}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeLike(@PathVariable(name = "nombreMercancia") String mercancia) {
        try {
            iMercanciaService.removeMercanciaByNombre(mercancia);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
