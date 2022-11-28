package com.fixed_asset.appasset.infrastructure.http_rest;

import com.fixed_asset.appasset.domain.Person;
import com.fixed_asset.appasset.domain.services.PersonServices;
import com.fixed_asset.appasset.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *  Controlador del recurso persona
 *  @author Jose Gomez
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    /***
     *
     * @param page nuemro de la pagina
     * @param size cantidad de registros por pagina
     * @return Listado de personas creadas
     * @throws ApiException
     */
    @GetMapping("/search/{page}/{size}")
    public ResponseEntity<List<Person>> findByType(@PathVariable("page") int page,
                                                   @PathVariable("size") int size) throws ApiException {
        return new ResponseEntity<>(service.searchAll(page, size), HttpStatus.OK);
    }

}
