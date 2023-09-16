package com.omar.omar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.omar.omar.Helpers.CustomUtils;
import com.omar.omar.model.Account;
import com.omar.omar.model.Moves;
import com.omar.omar.service.MovesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movements")
public class MoveController {

    @Autowired
    private MovesService movesService;

    @PostMapping()
    public ResponseEntity<?> createMovement(@Valid @RequestBody Moves movement, BindingResult result) {
        return CustomUtils.createEntityResponse(movement, () -> movesService.createMoves(movement), result);
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<Moves> getMovementById(@PathVariable Long movementId) {
        Moves movement = movesService.getMovementById(movementId);
        if (movement != null) {
            return ResponseEntity.ok(movement);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/account/{account}")
    public ResponseEntity<List<Moves>> getMovementByAccount(@PathVariable Account account) {
        try {
            List<Moves> movement = movesService.getMovementByAccount(account);
            if (movement != null) {
                return ResponseEntity.ok(movement);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
