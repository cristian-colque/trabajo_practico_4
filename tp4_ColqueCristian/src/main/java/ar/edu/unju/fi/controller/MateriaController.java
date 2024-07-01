package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @GetMapping("/listar")
    public String listarMaterias(Model model) {
        model.addAttribute("materias", MateriaCollection.getMaterias());
        return "materia-lista";
    }

    @GetMapping("/agregar")
    public String agregarMateriaForm(Model model) {
        model.addAttribute("materia", new Materia());
        return "materia-form";
    }

    @PostMapping("/agregar")
    public String agregarMateria(@ModelAttribute Materia materia) {
        MateriaCollection.agregar(materia);
        return "redirect:/materia-lista";
    }

    @GetMapping("/modificar/{codigo}")
    public String modificarMateriaForm(@PathVariable String codigo, Model model) {
        MateriaCollection.buscar(codigo).ifPresent(materia -> model.addAttribute("materia", materia));
        return "materia-form";
    }

    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute Materia materia) {
        MateriaCollection.modificar(materia);
        return "redirect:/materia-lista";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable String codigo) {
        MateriaCollection.eliminar(codigo);
        return "redirect:/materia-lista";
    }
}
