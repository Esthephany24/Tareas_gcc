package com.ejemplo.tareas;

public record Tarea(
    Integer id,
    String nombre,
    String descripcion,
    String prioridad,
    Boolean completada
) {}
