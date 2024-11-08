package com.grupo1.demo.services;

import com.grupo1.demo.models.HistoriaMedica;
import com.grupo1.demo.models.Paciente;
import com.grupo1.demo.repositories.HistoriaMedicaRepository;
import com.grupo1.demo.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaMedicaService {

    @Autowired
    private HistoriaMedicaRepository historiaMedicaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Optional<HistoriaMedica> getHistoriaMedicaByPacienteId(Long pacienteId) {
        return historiaMedicaRepository.findByPacienteId(pacienteId);
    }

    public HistoriaMedica createHistoriaMedica(Long pacienteId) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(pacienteId);
        if (pacienteOpt.isPresent()) {
            Paciente paciente = pacienteOpt.get();
            HistoriaMedica historiaMedica = HistoriaMedica.builder()
                    .paciente(paciente)
                    .antecedentesMedicos(List.of("No tiene"))
                    .cirugiasAnteriores(List.of("No tiene"))
                    .alergias(List.of("No tiene"))
                    .antecedentesFamiliares(List.of("No tiene"))
                    .build();
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica addAntecedentesMedicos(Long pacienteId, List<String> antecedentesMedicos) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            for (String antecedente : antecedentesMedicos) {
                if (!historiaMedica.getAntecedentesMedicos().contains(antecedente)) {
                    historiaMedica.getAntecedentesMedicos().add(antecedente);
                }
            }
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica addAlergias(Long pacienteId, List<String> alergias) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            for (String alergia : alergias) {
                if (!historiaMedica.getAlergias().contains(alergia)) {
                    historiaMedica.getAlergias().add(alergia);
                }
            }
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica addCirugiasAnteriores(Long pacienteId, List<String> cirugias) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            for (String cirugia : cirugias) {
                if (!historiaMedica.getCirugiasAnteriores().contains(cirugia)) {
                    historiaMedica.getCirugiasAnteriores().add(cirugia);
                }
            }
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica addAntecedentesFamiliares(Long pacienteId, List<String> antecedentesFamiliares) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            for (String antecedente : antecedentesFamiliares) {
                if (!historiaMedica.getAntecedentesFamiliares().contains(antecedente)) {
                    historiaMedica.getAntecedentesFamiliares().add(antecedente);
                }
            }
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica updateAntecedentesMedicos(Long pacienteId, List<String> antecedentesMedicos) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            historiaMedica.setAntecedentesMedicos(antecedentesMedicos);
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica updateAlergias(Long pacienteId, List<String> alergias) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            historiaMedica.setAlergias(alergias);
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica updateCirugiasAnteriores(Long pacienteId, List<String> cirugiasAnteriores) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            historiaMedica.setCirugiasAnteriores(cirugiasAnteriores);
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica updateAntecedentesFamiliares(Long pacienteId, List<String> antecedentesFamiliares) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            historiaMedica.setAntecedentesFamiliares(antecedentesFamiliares);
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public HistoriaMedica deleteAtributoHistoria(Long pacienteId, String atributo, String valor) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            HistoriaMedica historiaMedica = historiaMedicaOpt.get();
            switch (atributo) {
                case "antecedentesMedicos":
                    historiaMedica.getAntecedentesMedicos().remove(valor);
                    break;
                case "cirugiasAnteriores":
                    historiaMedica.getCirugiasAnteriores().remove(valor);
                    break;
                case "alergias":
                    historiaMedica.getAlergias().remove(valor);
                    break;
                case "antecedentesFamiliares":
                    historiaMedica.getAntecedentesFamiliares().remove(valor);
                    break;
                default:
                    return null; 
            }
            return historiaMedicaRepository.save(historiaMedica);
        }
        return null;
    }

    public boolean deleteHistoriaMedica(Long pacienteId) {
        Optional<HistoriaMedica> historiaMedicaOpt = historiaMedicaRepository.findByPacienteId(pacienteId);
        if (historiaMedicaOpt.isPresent()) {
            historiaMedicaRepository.delete(historiaMedicaOpt.get());
            return true;
        }
        return false;
    }
}
