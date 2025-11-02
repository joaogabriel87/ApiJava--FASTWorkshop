package com.workshop.fastworkshop.Workshop;

import com.workshop.fastworkshop.Erro.DataInvalidaException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/workshops")
@Validated
public class WorkshopController {

    @Autowired
    private WorkshopServices workshopServices;
    @Autowired
    private WorkshopMapper workshopMapper;


    // POST /api/workshops
    @PostMapping
    public ResponseEntity<ResponseWorkshop> criar(@RequestBody @Valid WorkshopDto dto) throws DataInvalidaException {
       WorkshopEntity entity = workshopServices.createWorkshop(dto);
       ResponseWorkshop response = workshopMapper.toResponse(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ResponseWorkshop>> listarTodos() {
        List<ResponseWorkshop> response = workshopServices.listarTodos().stream()
                .map(workshopMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    // GET /api/workshops/search?nome=Java
    @GetMapping("/search")
    public ResponseEntity<List<ResponseWorkshop>> buscarPorNome(@RequestParam String nome) {
        List<ResponseWorkshop> response = workshopServices.buscarPorNome(nome).stream()
                .map(workshopMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    // GET /api/workshops/data?data=2025-11-02
    @GetMapping("/data")
    public ResponseEntity<List<ResponseWorkshop>> buscarPorData(@RequestParam String data) {
        LocalDate localDate = LocalDate.parse(data);
        List<ResponseWorkshop> response = workshopServices.buscarPorData(localDate).stream()
                .map(workshopMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }
}
