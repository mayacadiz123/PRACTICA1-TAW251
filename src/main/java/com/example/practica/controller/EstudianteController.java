package com.example.practica.controller;
import com.example.practica.model.Estudiante;
import com.example.practica.service.EstudianteService;
import com.example.practica.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listarTodos() {
        return estudianteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteService.buscarPorId(id);
        return estudiante.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante(null, estudianteDTO.getNombre(), estudianteDTO.getEmail(), estudianteDTO.getEdad());
        Estudiante nuevoEstudiante = estudianteService.guardar(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        if (estudianteService.buscarPorId(id).isPresent()) {
            estudianteService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        Optional<Estudiante> estudianteExistente = estudianteService.buscarPorId(id);
        if (estudianteExistente.isPresent()) {
            Estudiante estudiante = estudianteExistente.get();
            estudiante.setNombre(estudianteDTO.getNombre());
            estudiante.setEdad(estudianteDTO.getEdad());
            estudiante.setEmail(estudianteDTO.getEmail());
            Estudiante actualizado = estudianteService.guardar(estudiante);  
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
