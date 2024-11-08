package com.grupo1.demo.controllers;

import com.grupo1.demo.models.HistoriaMedica;
import com.grupo1.demo.services.HistoriaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historia-medica")
public class HistoriaMedicaController {

    @Autowired
    private HistoriaMedicaService historiaMedicaService;

    @GetMapping("/{pacienteId}")
    public ResponseEntity<HistoriaMedica> getHistoriaMedica(@PathVariable Long pacienteId) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaService.getHistoriaMedicaByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            return new ResponseEntity<>(historiaMedicaOpt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear/{pacienteId}")
    public ResponseEntity<HistoriaMedica> createHistoriaMedica(@PathVariable Long pacienteId) {
        HistoriaMedica historiaMedica = historiaMedicaService.createHistoriaMedica(pacienteId);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{pacienteId}/add-antecedentes-medicos")
    public ResponseEntity<HistoriaMedica> addAntecedentesMedicos(@PathVariable Long pacienteId, 
                                                                @RequestBody List<String> antecedentesMedicos) {
        HistoriaMedica historiaMedica = historiaMedicaService.addAntecedentesMedicos(pacienteId, antecedentesMedicos);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{pacienteId}/add-alergias")
    public ResponseEntity<HistoriaMedica> addAlergias(@PathVariable Long pacienteId, 
                                                      @RequestBody List<String> alergias) {
        HistoriaMedica historiaMedica = historiaMedicaService.addAlergias(pacienteId, alergias);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{pacienteId}/add-cirugias-anteriores")
    public ResponseEntity<HistoriaMedica> addCirugiasAnteriores(@PathVariable Long pacienteId, 
                                                               @RequestBody List<String> cirugias) {
        HistoriaMedica historiaMedica = historiaMedicaService.addCirugiasAnteriores(pacienteId, cirugias);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{pacienteId}/add-antecedentes-familiares")
    public ResponseEntity<HistoriaMedica> addAntecedentesFamiliares(@PathVariable Long pacienteId, 
                                                                   @RequestBody List<String> antecedentesFamiliares) {
        HistoriaMedica historiaMedica = historiaMedicaService.addAntecedentesFamiliares(pacienteId, antecedentesFamiliares);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{pacienteId}/edit-antecedentes-medicos")
    public ResponseEntity<HistoriaMedica> updateAntecedentesMedicos(@PathVariable Long pacienteId, 
                                                                   @RequestBody List<String> antecedentesMedicos) {
        HistoriaMedica historiaMedica = historiaMedicaService.updateAntecedentesMedicos(pacienteId, antecedentesMedicos);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{pacienteId}/edit-alergias")
    public ResponseEntity<HistoriaMedica> updateAlergias(@PathVariable Long pacienteId, 
                                                         @RequestBody List<String> alergias) {
        HistoriaMedica historiaMedica = historiaMedicaService.updateAlergias(pacienteId, alergias);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{pacienteId}/edit-cirugias-anteriores")
    public ResponseEntity<HistoriaMedica> updateCirugiasAnteriores(@PathVariable Long pacienteId, 
                                                                  @RequestBody List<String> cirugiasAnteriores) {
        HistoriaMedica historiaMedica = historiaMedicaService.updateCirugiasAnteriores(pacienteId, cirugiasAnteriores);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{pacienteId}/edit-antecedentes-familiares")
    public ResponseEntity<HistoriaMedica> updateAntecedentesFamiliares(@PathVariable Long pacienteId, 
                                                                      @RequestBody List<String> antecedentesFamiliares) {
        HistoriaMedica historiaMedica = historiaMedicaService.updateAntecedentesFamiliares(pacienteId, antecedentesFamiliares);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{pacienteId}/delete-atributo/{atributo}/{valor}")
    public ResponseEntity<HistoriaMedica> deleteAtributoHistoria(@PathVariable Long pacienteId, 
                                                                 @PathVariable String atributo,
                                                                 @PathVariable String valor) {
        HistoriaMedica historiaMedica = historiaMedicaService.deleteAtributoHistoria(pacienteId, atributo, valor);
        if (historiaMedica != null) {
            return new ResponseEntity<>(historiaMedica, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{pacienteId}/eliminar")
    public ResponseEntity<Void> deleteHistoriaMedica(@PathVariable Long pacienteId) {
        boolean deleted = historiaMedicaService.deleteHistoriaMedica(pacienteId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
