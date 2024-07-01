package ar.edu.unju.fi.collections;


import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.fi.model.Carrera;

public class CarreraCollection {
    private static ArrayList<Carrera> carreras = new ArrayList<>();

    public static void listar() {
        for (Carrera carrera : carreras) {
            System.out.println(carrera);
        }
    }

    public static Optional<Carrera> buscar(String codigo) {
        return carreras.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
    }

    public static void agregar(Carrera carrera) {
        carreras.add(carrera);
    }

    public static boolean modificar(Carrera carreraModificada) {
        Optional<Carrera> optionalCarrera = buscar(carreraModificada.getCodigo());
        if (optionalCarrera.isPresent()) {
            Carrera carrera = optionalCarrera.get();
            carrera.setNombre(carreraModificada.getNombre());
            carrera.setCantidadAnios(carreraModificada.getCantidadAnios());
            carrera.setEstado(carreraModificada.isEstado());
            return true;
        }
        return false;
    }

    public static boolean eliminar(String codigo) {
        return carreras.removeIf(c -> c.getCodigo().equals(codigo));
    }

	public static ArrayList<Carrera> getCarreras() {
		// TODO Auto-generated method stub
		return carreras;
	}
}