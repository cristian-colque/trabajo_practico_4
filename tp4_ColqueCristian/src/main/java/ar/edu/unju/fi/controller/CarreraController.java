package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @GetMapping("/listar")
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", CarreraCollection.getCarreras());
        return "carrera-lista";
    }

    @GetMapping("/agregar")
    public String agregarCarreraForm(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "carrera-form";
    }

    @PostMapping("/agregar")
    public String agregarCarrera(@ModelAttribute Carrera carrera) {
        CarreraCollection.agregar(carrera);
        return "redirect:/carrera-lista";
    }

    @GetMapping("/modificar/{codigo}")
    public String modificarCarreraForm(@PathVariable String codigo, Model model) {
        CarreraCollection.buscar(codigo).ifPresent(carrera -> model.addAttribute("carrera", carrera));
        return "carrera-form";
    }

    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute Carrera carrera) {
        CarreraCollection.modificar(carrera);
        return "redirect:/carrera-lista";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarCarrera(@PathVariable String codigo) {
        CarreraCollection.eliminar(codigo);
        return "redirect:/carrera-lista";
    }
}
