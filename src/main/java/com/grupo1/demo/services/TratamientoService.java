package com.grupo1.demo.services;

import com.grupo1.demo.models.Tratamiento;
import com.grupo1.demo.repositories.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<Tratamiento> getAllTratamientos() {
        return tratamientoRepository.findAllByOrderByIdDesc();  
    }

    public List<Tratamiento> getTratamientosByDiagnosticoId(Long diagnosticoId) {
        return tratamientoRepository.findByDiagnosticoIdOrderByIdDesc(diagnosticoId);  
    }

    public Tratamiento createTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Optional<Tratamiento> updateTratamiento(Long id, Tratamiento updatedTratamiento) {
        return tratamientoRepository.findById(id).map(existingTratamiento -> {
            existingTratamiento.setDescripcionTratamiento(updatedTratamiento.getDescripcionTratamiento());
            existingTratamiento.setDuracionDias(updatedTratamiento.getDuracionDias());
            return tratamientoRepository.save(existingTratamiento);
        });
    }

    public boolean deleteTratamiento(Long id) {
        if (tratamientoRepository.existsById(id)) {
            tratamientoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
