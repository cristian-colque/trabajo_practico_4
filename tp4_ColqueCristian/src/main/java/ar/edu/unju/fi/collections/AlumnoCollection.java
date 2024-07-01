package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Optional;

import ar.edu.unju.fi.model.Alumno;

public class AlumnoCollection {
    private static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void listar() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public static Optional<Alumno> buscar(int dni) {
        return alumnos.stream().filter(a -> a.getDni() == dni).findFirst();
    }

    public static void agregar(Alumno alumno) {
        alumnos.add(alumno);
    }

    public static boolean modificar(Alumno alumnoModificado) {
        Optional<Alumno> optionalAlumno = buscar(alumnoModificado.getDni());
        if (optionalAlumno.isPresent()) {
            Alumno alumno = optionalAlumno.get();
            alumno.setNombre(alumnoModificado.getNombre());
            alumno.setApellido(alumnoModificado.getApellido());
            alumno.setEmail(alumnoModificado.getEmail());
            alumno.setTelefono(alumnoModificado.getTelefono());
            alumno.setFechaNacimiento(alumnoModificado.getFechaNacimiento());
            alumno.setDomicilio(alumnoModificado.getDomicilio());
            alumno.setLU(alumnoModificado.getLU());
            return true;
        }
        return false;
    }

    public static boolean eliminar(int dni) {
        return alumnos.removeIf(a -> a.getDni() == dni);
    }

	public static ArrayList<Alumno> getAlumnos() {
		// TODO Auto-generated method stub
		return alumnos;
	}
}
