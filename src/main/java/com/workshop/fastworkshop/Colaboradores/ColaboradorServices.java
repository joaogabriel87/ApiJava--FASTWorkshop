package com.workshop.fastworkshop.Colaboradores;

import com.workshop.fastworkshop.Erro.ColaboradorDuplicadoException;
import com.workshop.fastworkshop.Erro.ColaboradorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ColaboradorServices {

    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private ColaboradorMapper colaboradorMapper;


    public ColaboradorEntity criar(ColaboradorDto dto) {
        boolean existe = colaboradorRepository.existsByNomeIgnoreCase(dto.nome());

        if (existe) {
            throw new ColaboradorDuplicadoException(dto.nome());
        }

        ColaboradorEntity colaborador = colaboradorMapper.toEntity(dto);
        return colaboradorRepository.save(colaborador);
    }

    public List<ColaboradorEntity> listarTodos() {
        return colaboradorRepository.findAll().stream()
                .sorted(Comparator.comparing(ColaboradorEntity::getNome))
                .toList();
    }

    public ColaboradorEntity buscarPorId(Long id) {
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new ColaboradorNotFoundException(id));
    }
}
