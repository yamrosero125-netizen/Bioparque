package bioparque;

import java.util.ArrayList;

public class InventarioAnimales {

    private ArrayList<Animal> animales;

    public InventarioAnimales() {
        animales = new ArrayList<>();
    }

    public boolean registrarAnimal(Animal animal) {

        if (animal == null) {
            throw new IllegalArgumentException(
                    "El animal no puede ser nulo."
            );
        }

        if (buscarPorCodigo(animal.getCodigo()) != null) {
            return false;
        }

        animales.add(animal);
        return true;
    }

    public ArrayList<Animal> listarAnimales() {

        return new ArrayList<>(animales);
    }

    public Animal buscarPorCodigo(int codigo) {

        for (Animal animal : animales) {

            if (animal.getCodigo() == codigo) {
                return animal;
            }
        }

        return null;
    }

    public boolean actualizarAnimal(int codigo,
                                    String nombre,
                                    int edad,
                                    double peso,
                                    String sexo,
                                    EstadoSalud estadoSalud,
                                    String habitat) {

        Animal animal = buscarPorCodigo(codigo);

        if (animal == null) {
            return false;
        }

        animal.actualizarNombre(nombre);
        animal.actualizarEdad(edad);
        animal.actualizarPeso(peso);
        animal.actualizarSexo(sexo);
        animal.actualizarEstadoSalud(estadoSalud);
        animal.trasladarHabitat(habitat);

        return true;
    }

    public boolean retirarAnimal(int codigo) {

        Animal animal = buscarPorCodigo(codigo);

        if (animal == null) {
            return false;
        }

        animal.retirar();

        return true;
    }
}
