package com.omar.omar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Moves;
import com.omar.omar.service.MovesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movements")
public class MoveController {

    @Autowired
    private MovesService movesService;

    private static final Logger logger = LoggerFactory.getLogger(MoveController.class);

    @PostMapping()
    public ResponseEntity<?> createMovement(@Valid @RequestBody Moves movement, BindingResult result) {
        logger.info("createMovement: Se creo un movimiento de cuenta correctamente");
        return CustomUtils.createEntityResponse(movement, () -> movesService.createMoves(movement), result);
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<Moves> getMovementById(@PathVariable Long movementId) {
        Moves movement = movesService.getMovementById(movementId);
        if (movement != null) {
            logger.info("Se ha consultado el movimiento con ID: {}", movementId);
            return ResponseEntity.ok(movement);
        }
        logger.info("No se ha encontrado el movimiento con ID: {}", movementId);
        return ResponseEntity.notFound().build();
    }

}
