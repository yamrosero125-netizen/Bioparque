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
}
