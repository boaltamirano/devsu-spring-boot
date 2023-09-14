package com.omar.omar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Moves;
import com.omar.omar.service.MovesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movements")
public class MoveController {

    @Autowired
    private MovesService movesService;

    @PostMapping()
    public ResponseEntity<?> createMovement(@Valid @RequestBody Moves movement, BindingResult result) {
        return CustomUtils.createEntityResponse(movement, () -> movesService.createMoves(movement), result);
    }

    @GetMapping()
    public ResponseEntity<List<Moves>> getAllMovements() {
        List<Moves> movements = movesService.getAllMovements();
        return ResponseEntity.ok(movements);
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<Moves> getMovementById(@PathVariable Long movementId) {
        Moves movement = movesService.getMovementById(movementId);
        if (movement != null) {
            return ResponseEntity.ok(movement);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{movementId}")
    public ResponseEntity<Void> deleteMovement(@PathVariable Long movementId) {
        movesService.deleteMoves(movementId);
        return ResponseEntity.noContent().build();
    }

}
