package com.omar.omar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.omar.model.Moves;
import com.omar.omar.service.MovesService;

@RestController
@RequestMapping("/movements")
public class MoveController {
    
    @Autowired
    private MovesService movesService;

    @PostMapping()
    public ResponseEntity<Moves> createMovement(@RequestBody Moves movement) {
        Moves createMovement = movesService.createMoves(movement);
        return ResponseEntity.ok(createMovement);
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
