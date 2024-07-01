package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @GetMapping("/listar")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", AlumnoCollection.getAlumnos());
        return "alumno-lista";
    }

    @GetMapping("/agregar")
    public String agregarAlumnoForm(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "alumno-form";
    }

    @PostMapping("/agregar")
    public String agregarAlumno(@ModelAttribute Alumno alumno) {
        AlumnoCollection.agregar(alumno);
        return "redirect:/alumno-lista";
    }

    @GetMapping("/modificar/{dni}")
    public String modificarAlumnoForm(@PathVariable int dni, Model model) {
        AlumnoCollection.buscar(dni).ifPresent(alumno -> model.addAttribute("alumno", alumno));
        return "alumno-form";
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute Alumno alumno) {
        AlumnoCollection.modificar(alumno);
        return "redirect:/alumno-lista";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable int dni) {
        AlumnoCollection.eliminar(dni);
        return "redirect:/alumno-lista";
    }
}
