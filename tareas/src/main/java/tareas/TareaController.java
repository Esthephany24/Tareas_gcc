package com.ejemplo.tareas;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    // GET: consultar tareas
    @GetMapping
    public List<Tarea> listarTareas() {
        return tareas;
    }

    // POST: registrar tareas
    @PostMapping
    public ResponseEntity<?> registrarTarea(@RequestBody Tarea tarea) {
        
        //vamos comprobar si ID existe
        boolean existe = tareas.stream()
            .anyMatch(t -> t.id().equals(tarea.id()));

        if (existe){
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Error: Ya existe una tarea con ese ID");
        }    
        tareas.add(tarea);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(tarea);
    }
}
