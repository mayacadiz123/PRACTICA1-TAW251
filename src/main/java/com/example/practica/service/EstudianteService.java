package com.example.practica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.practica.model.Estudiante;
import com.example.practica.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public Estudiante guardar(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            return repository.guardar(estudiante);
        } else {
            Optional<Estudiante> estudianteExistente = repository.obtenerPorId(estudiante.getId());
            if (estudianteExistente.isPresent()) {
                Estudiante estudianteActualizar = estudianteExistente.get();
                estudianteActualizar.setNombre(estudiante.getNombre());
                estudianteActualizar.setEdad(estudiante.getEdad());
                estudianteActualizar.setEmail(estudiante.getEmail());
                return repository.guardar(estudianteActualizar);  
            } else {
                
                return null;  
            }
        }
    }

    public List<Estudiante> listar() {
        return repository.listarTodos();
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        return repository.obtenerPorId(id);
    }

    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}


