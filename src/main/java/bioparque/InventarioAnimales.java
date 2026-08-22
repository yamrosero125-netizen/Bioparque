package bioparque;

import java.util.ArrayList;

public class InventarioAnimales {

    private ArrayList<Animal> animales;

    public InventarioAnimales() {
        animales = new ArrayList<>();
    }

    public boolean registrarAnimal(Animal animal) {

        if (buscarPorCodigo(animal.getCodigo()) != null) {
            return false;
        }

        animales.add(animal);
        return true;
    }

    public ArrayList<Animal> listarAnimales() {
        return animales;
    }

    public Animal buscarPorCodigo(int codigo) {

        for (Animal animal : animales) {

            if (animal.getCodigo() == codigo) {
                return animal;
            }
        }

        return null;
    }

    // Filtro por tipo de animal.
    // Devuelve una nueva lista y no modifica el inventario original.
    public ArrayList<Animal> filtrarPorTipo(String tipo) {

        ArrayList<Animal> resultado = new ArrayList<>();

        for (Animal animal : animales) {

            if (tipo.equalsIgnoreCase("mamifero")
                    && animal instanceof Mamifero) {

                resultado.add(animal);

            } else if (tipo.equalsIgnoreCase("ave")
                    && animal instanceof Ave) {

                resultado.add(animal);

            } else if (tipo.equalsIgnoreCase("reptil")
                    && animal instanceof Reptil) {

                resultado.add(animal);
            }
        }

        return resultado;
    }
}