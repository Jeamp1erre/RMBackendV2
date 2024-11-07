package com.grupo1.demo.controllers;

import com.grupo1.demo.models.Paciente;
import com.grupo1.demo.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Paciente> searchPaciente(@RequestParam String search) {
        return pacienteService.searchPaciente(search);
    }

    @PostMapping
    public Paciente savePaciente(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente updatedPaciente) {
        return pacienteService.updatePaciente(id, updatedPaciente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Paciente> patchPaciente(@PathVariable Long id, @RequestBody Paciente updatedPaciente) {
        return pacienteService.patchPaciente(id, updatedPaciente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id) {
        String message = pacienteService.deletePaciente(id);
        if (message.contains("eliminado")) {
            return ResponseEntity.ok(message); 
        } else {
            return ResponseEntity.status(404).body(message); 
        }
    }
}
