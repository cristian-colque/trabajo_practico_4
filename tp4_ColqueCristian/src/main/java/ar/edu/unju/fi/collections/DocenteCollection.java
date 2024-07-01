package ar.edu.unju.fi.collections;


import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.fi.model.Docente;

public class DocenteCollection {
    private static ArrayList<Docente> docentes = new ArrayList<>();
    
    static {
        docentes.add(new Docente(1001, "Pedro", "González", "pedro@example.com", "555123456"));
        docentes.add(new Docente(1002, "Laura", "López", "laura@example.com", "555987654"));
        // Agregar más docentes según necesidad
    }
  

    public static void listar() {
        for (Docente docente : docentes) {
            System.out.println(docente);
        }
    }

    public static Optional<Docente> buscar(int legajo) {
        return docentes.stream().filter(d -> d.getLegajo() == legajo).findFirst();
    }

    public static void agregar(Docente docente) {
        docentes.add(docente);
    }

    public static boolean modificar(Docente docenteModificado) {
        Optional<Docente> optionalDocente = buscar(docenteModificado.getLegajo());
        if (optionalDocente.isPresent()) {
            Docente docente = optionalDocente.get();
            docente.setNombre(docenteModificado.getNombre());
            docente.setApellido(docenteModificado.getApellido());
            docente.setEmail(docenteModificado.getEmail());
            docente.setTelefono(docenteModificado.getTelefono());
            return true;
        }
        return false;
    }

    public static boolean eliminar(int legajo) {
        return docentes.removeIf(d -> d.getLegajo() == legajo);
    }

	public static ArrayList<Docente> getDocentes() {
		// TODO Auto-generated method stub
		return docentes;
	}
}
