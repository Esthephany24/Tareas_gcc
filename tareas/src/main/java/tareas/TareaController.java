package com.ejemplo.tareas;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    // MÉTODO GET: mostrar todas las tareas
    @GetMapping
    public List<Tarea> listarTareas() {
        return tareas;
    }

    // MÉTODO POST: registrar una nueva tarea
    @PostMapping
    public Tarea registrarTarea(@RequestBody Tarea tarea) {
        tareas.add(tarea);
        return tarea;
    }
}
