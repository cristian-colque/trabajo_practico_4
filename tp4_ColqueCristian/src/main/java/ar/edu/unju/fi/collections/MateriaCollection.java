package ar.edu.unju.fi.collections;


import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.fi.model.Materia;

public class MateriaCollection {
    private static ArrayList<Materia> materias = new ArrayList<>();

    public static void listar() {
        for (Materia materia : materias) {
            System.out.println(materia);
        }
    }

    public static Optional<Materia> buscar(String codigo) {
        return materias.stream().filter(m -> m.getCodigo().equals(codigo)).findFirst();
    }

    public static void agregar(Materia materia) {
        materias.add(materia);
    }

    public static boolean modificar(Materia materiaModificada) {
        Optional<Materia> optionalMateria = buscar(materiaModificada.getCodigo());
        if (optionalMateria.isPresent()) {
            Materia materia = optionalMateria.get();
            materia.setNombre(materiaModificada.getNombre());
            materia.setCurso(materiaModificada.getCurso());
            materia.setCantidadHoras(materiaModificada.getCantidadHoras());
            materia.setModalidad(materiaModificada.getModalidad());
            materia.setDocente(materiaModificada.getDocente());
            materia.setCarrera(materiaModificada.getCarrera());
            return true;
        }
        return false;
    }

    public static boolean eliminar(String codigo) {
        return materias.removeIf(m -> m.getCodigo().equals(codigo));
    }

	public static ArrayList<Materia> getMaterias() {
		// TODO Auto-generated method stub
		return materias;
	}
}
