package com.grupo1.demo.controllers;

import com.grupo1.demo.models.Consulta;
import com.grupo1.demo.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    @GetMapping("/ultima")
    public ResponseEntity<Consulta> getUltimaConsulta() {
        Optional<Consulta> ultimaConsulta = consultaService.getUltimaConsulta();
        return ultimaConsulta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Consulta> getConsultasByPacienteId(@PathVariable Long pacienteId) {
        return consultaService.getConsultasByPacienteId(pacienteId);
    }

    @PostMapping("/{pacienteId}")
    public ResponseEntity<Consulta> createConsulta(@PathVariable Long pacienteId, @RequestParam String motivoConsulta) {
        Consulta nuevaConsulta = consultaService.createConsulta(pacienteId, motivoConsulta);
        return nuevaConsulta != null ? ResponseEntity.ok(nuevaConsulta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{consultaId}")
    public ResponseEntity<String> deleteConsulta(@PathVariable Long consultaId) {
        if (consultaService.deleteConsulta(consultaId)) {
            return ResponseEntity.ok("Consulta eliminada exitosamente.");
        } else {
            return ResponseEntity.status(404).body("Consulta no encontrada.");
        }
    }

    @PatchMapping("/{consultaId}")
    public ResponseEntity<Consulta> updateMotivoConsulta(@PathVariable Long consultaId, @RequestParam String nuevoMotivo) {
        Optional<Consulta> consultaActualizada = consultaService.updateMotivoConsulta(consultaId, nuevoMotivo);
        return consultaActualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
