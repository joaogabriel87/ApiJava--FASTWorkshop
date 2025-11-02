package com.workshop.fastworkshop.Colaboradores;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@Validated
public class ColaboradorController {
    @Autowired
    private ColaboradorServices colaboradorServices;
    @Autowired
    private ColaboradorMapper colaboradorMapper;


    @PostMapping
    public ResponseEntity<ResponseColaborador> criar(@RequestBody @Valid ColaboradorDto dto) {
        ColaboradorEntity colaborador = colaboradorServices.criar(dto);
        ResponseColaborador response =  colaboradorMapper.toResponse(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
