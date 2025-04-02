package com.example.practica.repository;
import com.example.practica.model.Estudiante;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteRepository {
    private final List<Estudiante> estudiantes = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Estudiante> listarTodos() {
        return estudiantes;
    }

    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudiantes.stream()
                .filter(est -> est.getId().equals(id))
                .findFirst();
    }

    public Estudiante guardar(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(contadorId++);
        }
        estudiantes.add(estudiante);
        return estudiante;
    }
    public void eliminar(Long id) {
        Optional<Estudiante> estudianteOptional = obtenerPorId(id);
        estudianteOptional.ifPresent(estudiantes::remove);
    }
    
    public boolean existsById(Long id) {
        return estudiantes.stream().anyMatch(est -> est.getId().equals(id));
    }
    public Estudiante actualizar(Long id, Estudiante estudiante) {
        Optional<Estudiante> estudianteExistente = obtenerPorId(id);
        if (estudianteExistente.isPresent()) {
            Estudiante estudianteActualizar = estudianteExistente.get();
            estudianteActualizar.setNombre(estudiante.getNombre());
            estudianteActualizar.setEdad(estudiante.getEdad());
            estudianteActualizar.setEmail(estudiante.getEmail());
            return estudianteActualizar;
        }
        return null; 
    }
    
}

    
