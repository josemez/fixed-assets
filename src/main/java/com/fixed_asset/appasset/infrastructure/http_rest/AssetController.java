package com.fixed_asset.appasset.infrastructure.http_rest;

import com.fixed_asset.appasset.domain.Asset;
import com.fixed_asset.appasset.domain.services.AssetServices;
import com.fixed_asset.appasset.exceptions.ApiException;
import com.fixed_asset.appasset.exceptions.BadRequestException;
import com.fixed_asset.appasset.exceptions.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

/***
 * Controlador del recurso activo-fijo
 * @author Jose Gomez
 */

@RestController
@RequestMapping("/fixed-asset")
public class AssetController {

    @Autowired
    private AssetServices service;

    /***
     * Crear un nuevo activo
     * @param asset activo a crear
     * @return activo creado
     * @throws ApiException
     */
    @PostMapping("/create")
    public ResponseEntity<Asset> create(@RequestBody Asset asset) throws ApiException {
        assignmentValidations(asset);
        return new ResponseEntity<>(service.create(asset), HttpStatus.CREATED);
    }

    /***
     * Buscar todos los activos
     * @param page nuemro de la pagina
     * @param size cantidad de registros por pagina
     * @return Listado de activos encontrados
     * @throws ApiException
     */
    @GetMapping("/search/{page}/{size}")
    public ResponseEntity<List<Asset>> searchAll(@PathVariable("page") int page,
                                                @PathVariable("size") int size) throws ApiException {
        return new ResponseEntity<>(service.searchAll(page, size), HttpStatus.OK);
    }

    /***
     * Buscar activo por tipo
     * @param type tipo de activo
     * @return lista de activos por tipo
     * @throws ApiException
     */
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Asset>> findByType(@PathVariable("type") String type) throws ApiException {
        return new ResponseEntity<>(service.findByType(type), HttpStatus.OK);
    }

    /***
     * Buscar activo por serial
     * @param serial serial del activo
     * @return activo encontrado segun el serial
     * @throws ApiException
     */
    @GetMapping("/serial/{serial}")
    public ResponseEntity<Asset> findBySerial(@PathVariable("serial") String serial) throws ApiException {
        return new ResponseEntity<>(service.findBySerial(serial), HttpStatus.OK);
    }

    /***
     * Buscar activo por fecha de alta
     * @param date fecha de alta del activo
     * @return activo encontrado en la fecha buscada
     * @throws ApiException
     */
    @GetMapping("/date-purchase/{date}")
    public ResponseEntity<List<Asset>> findByDatePurchase( @PathVariable("date") String date)
            throws ApiException {
        LocalDateTime localdatetime = LocalDateTime.parse(date);

        return new ResponseEntity<>(service.findByDatePurchase(localdatetime), HttpStatus.OK);
    }

    /***
     * Actualziar Activo
     * @param asset informacion de la actualizacion del activo
     * @return activo actualizado
     * @throws ApiException
     */
    @PutMapping("/update")
    public ResponseEntity<Asset> update(@RequestBody Asset asset) throws ApiException {
        return new ResponseEntity<>(service.update(asset), HttpStatus.OK);
    }

    private boolean assignmentValidations(Asset asset) throws BadRequestException {
        if (asset.getAreaId() != null && asset.getPersonId() != null) {
            throw new BadRequestException(ValidationError.INVALID_ASSIGNMENTS);
        }
        if (asset.getAreaId() == null && asset.getPersonId() == null) {
            throw new BadRequestException(ValidationError.INVALID_NO_ASSIGNMENTS);
        }
        return (asset.getAreaId() != null || asset.getPersonId() != null) ? true : false;
    }
}
