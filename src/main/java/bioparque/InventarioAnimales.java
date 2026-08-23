package bioparque;

import java.util.ArrayList;

public class InventarioAnimales {

    private ArrayList<Animal> animales;

    public InventarioAnimales() {
        animales = new ArrayList<>();
    }

    public boolean registrarAnimal(Animal animal) {

        if (animal == null) {
            return false;
        }

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

    public boolean actualizarAnimal(int codigo, String nombre,
                                    int edad, double peso,
                                    String sexo, String habitat) {

        Animal animal = buscarPorCodigo(codigo);

        if (animal == null) {
            return false;
        }

        if (animal.getEstadoInventario() == EstadoInventario.RETIRADO) {
            return false;
        }

        animal.setNombre(nombre);
        animal.setEdad(edad);
        animal.actualizarPeso(peso);
        animal.setSexo(sexo);
        animal.setHabitat(habitat);

        return true;
    }

    public boolean retirarAnimal(int codigo) {

        Animal animal = buscarPorCodigo(codigo);

        if (animal == null) {
            return false;
        }

        if (animal.getEstadoInventario() == EstadoInventario.RETIRADO) {
            return false;
        }

        animal.retirar();

        return true;
    }

    // Filtro por estado del inventario
    public ArrayList<Animal> filtrarPorEstado(
            EstadoInventario estado) {

        ArrayList<Animal> resultado = new ArrayList<>();

        for (Animal animal : animales) {

            if (animal.getEstadoInventario() == estado) {
                resultado.add(animal);
            }
        }

        return resultado;
    }

    // Recorrido polimórfico
    public void ejecutarComportamientos() {

        if (animales.isEmpty()) {
            System.out.println(
                    "No hay animales registrados."
            );
            return;
        }

        System.out.println();
        System.out.println("=== COMPORTAMIENTOS DE LOS ANIMALES ===");

        for (Animal animal : animales) {

            System.out.println(
                    animal.getNombre() + ": "
                    + animal.emitirSonido()
            );
        }
    }

    // Resumen total y conteo por categoría
    public void mostrarResumen() {

        int mamiferos = 0;
        int aves = 0;
        int reptiles = 0;

        int activos = 0;
        int observacion = 0;
        int retirados = 0;

        for (Animal animal : animales) {

            if (animal instanceof Mamifero) {
                mamiferos++;
            } else if (animal instanceof Ave) {
                aves++;
            } else if (animal instanceof Reptil) {
                reptiles++;
            }

            if (animal.getEstadoInventario()
                    == EstadoInventario.ACTIVO) {

                activos++;

            } else if (animal.getEstadoInventario()
                    == EstadoInventario.EN_OBSERVACION) {

                observacion++;

            } else if (animal.getEstadoInventario()
                    == EstadoInventario.RETIRADO) {

                retirados++;
            }
        }

        System.out.println();
        System.out.println("=== RESUMEN DEL INVENTARIO ===");
        System.out.println("Total de animales: " + animales.size());

        System.out.println();
        System.out.println("--- POR CATEGORÍA ---");
        System.out.println("Mamíferos: " + mamiferos);
        System.out.println("Aves: " + aves);
        System.out.println("Reptiles: " + reptiles);

        System.out.println();
        System.out.println("--- POR ESTADO ---");
        System.out.println("Activos: " + activos);
        System.out.println("En observación: " + observacion);
        System.out.println("Retirados: " + retirados);
    }
}