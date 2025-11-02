package com.workshop.fastworkshop.Ata;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/atas")
@Validated
public class AtaController {


   @Autowired
   private AtaServices ataServices;
   @Autowired
   AtaMapper ataMapper;




    @PostMapping
    public ResponseEntity<ResponseAta> criarAta(@RequestBody @Valid AtaDto dto) {
        AtaEntity entity = ataServices.criarAta(dto);
        ResponseAta response = ataMapper.toResponse(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/workshops/{workshopId}/atas/{ataId}")
    public ResponseEntity<ResponseAta> adicionarColaborador(
            @PathVariable Long workshopId,
            @PathVariable Long ataId,
            @RequestParam Long colaboradorId) {

        AtaEntity entity = ataServices.adicionarColaborador(ataId, colaboradorId);
        ResponseAta response = ataMapper.toResponse(entity);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{ataId}/colaboradores/{colaboradorId}")
    public ResponseEntity<ResponseAta> removerColaborador(
            @PathVariable Long ataId,
            @PathVariable Long colaboradorId) {

        AtaEntity entity = ataServices.removerColaborador(ataId, colaboradorId);
        ResponseAta response = ataMapper.toResponse(entity);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<?> listarAtas(
            @RequestParam(required = false) String workshopNome,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        if (workshopNome != null && !workshopNome.isBlank()) {
            var atas = ataServices.buscarPorWorkshopNome(workshopNome)
                    .stream().map(ataMapper::toResponse).toList();
            return ResponseEntity.ok(atas);
        }

        if (data != null) {
            var atas = ataServices.buscarPorData(data)
                    .stream().map(ataMapper::toResponse).toList();
            return ResponseEntity.ok(atas);
        }

        List<Map<String, Object>> response = ataServices.listarColaboradoresComWorkshops();
        return ResponseEntity.ok(response);
    }
}
