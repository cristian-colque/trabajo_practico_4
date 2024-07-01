package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    @GetMapping("/listar")
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", DocenteCollection.getDocentes());
        return "docente-lista";
    }

    @GetMapping("/agregar")
    public String agregarDocenteForm(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente-form";
    }

    @PostMapping("/agregar")
    public String agregarDocente(@ModelAttribute Docente docente) {
        DocenteCollection.agregar(docente);
        return "redirect:/docente-lista";
    }

    @GetMapping("/modificar/{legajo}")
    public String modificarDocenteForm(@PathVariable int legajo, Model model) {
        DocenteCollection.buscar(legajo).ifPresent(docente -> model.addAttribute("docente", docente));
        return "docente-form";
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute Docente docente) {
        DocenteCollection.modificar(docente);
        return "redirect:/docente-lista";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable int legajo) {
        DocenteCollection.eliminar(legajo);
        return "redirect:/docente-lista";
    }
}
