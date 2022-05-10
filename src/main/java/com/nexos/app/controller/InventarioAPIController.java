package com.nexos.app.controller;


import com.nexos.app.model.Mercancia;
import com.nexos.app.service.IMercanciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventarioAPIController {

    private IMercanciaService iMercanciaService;

    public InventarioAPIController(IMercanciaService iMercanciaService) {
        this.iMercanciaService = iMercanciaService;
    }

    @RequestMapping(value  = "/usuario/crearinventario", method = RequestMethod.POST)
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

    @RequestMapping(value  = "/usuario/mercanciafiltro", method = RequestMethod.POST)
    public ResponseEntity<?> getAllInventarioFiltro(@RequestBody String  nombre){
        try{
            return new ResponseEntity<>(iMercanciaService.getAllMercanciaByRegistrador(nombre),HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value  = "/usuario/editarmercancia", method = RequestMethod.PUT)
    public ResponseEntity<?> changeMercancia(@RequestBody Mercancia mercancia){
        try {
            iMercanciaService.editMercancia(mercancia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value  = "/usuario/mercancia", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeMercancia(@RequestBody String mercancia) {
        try {
            iMercanciaService.removeMercanciaByNombre(mercancia);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
