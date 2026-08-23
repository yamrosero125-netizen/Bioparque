package bioparque;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsola {

    private Scanner scanner;
    private InventarioAnimales inventario;

    public MenuConsola() {

        scanner = new Scanner(System.in);
        inventario = new InventarioAnimales();
    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    registrarAnimal();
                    break;

                case 2:
                    listarAnimales();
                    break;

                case 3:
                    buscarAnimal();
                    break;

                case 4:
                    actualizarAnimal();
                    break;

                case 5:
                    retirarAnimal();
                    break;

                case 6:
                    filtrarInventario();
                    break;

                case 7:
                    ejecutarComportamientos();
                    break;

                case 8:
                    mostrarResumen();
                    break;

                case 0:
                    System.out.println();
                    System.out.println(
                            "Saliendo del sistema..."
                    );
                    break;

                default:
                    System.out.println();
                    System.out.println(
                            "Opción inválida."
                    );
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {

        System.out.println();
        System.out.println(
                "=============================================="
        );
        System.out.println(
                "       INVENTARIO DE ANIMALES - BIOPARQUE"
        );
        System.out.println(
                "=============================================="
        );

        System.out.println("1. Registrar animal");
        System.out.println("2. Listar animales");
        System.out.println("3. Buscar animal por código");
        System.out.println("4. Actualizar datos de un animal");
        System.out.println("5. Retirar animal");
        System.out.println("6. Filtrar inventario");
        System.out.println("7. Ejecutar comportamientos");
        System.out.println("8. Ver resumen del inventario");
        System.out.println("0. Salir");
    }

    // =====================================================
    // OPCIÓN 1
    // =====================================================

    private void registrarAnimal() {

        System.out.println();
        System.out.println("=== REGISTRAR ANIMAL ===");

        System.out.println("1. Mamífero");
        System.out.println("2. Ave");
        System.out.println("3. Reptil");

        int categoria = leerEntero(
                "Seleccione categoría: "
        );

        if (categoria < 1 || categoria > 3) {

            System.out.println(
                    "Categoría inválida."
            );

            return;
        }

        int codigo = leerEntero(
                "Código: "
        );

        if (inventario.buscarPorCodigo(codigo) != null) {

            System.out.println(
                    "El código ya está registrado."
            );

            return;
        }

        String nombre = leerTexto(
                "Nombre: "
        );

        int edad = leerEntero(
                "Edad: "
        );

        if (edad < 0) {

            System.out.println(
                    "La edad no puede ser negativa."
            );

            return;
        }

        double peso = leerDouble(
                "Peso: "
        );

        String sexo = leerTexto(
                "Sexo: "
        );

        String habitat = leerTexto(
                "Hábitat: "
        );

        Animal animal;

        try {

            switch (categoria) {

                case 1:

                    String tipoPelaje = leerTexto(
                            "Tipo de pelaje: "
                    );

                    animal = new Mamifero(
                            codigo,
                            nombre,
                            edad,
                            peso,
                            sexo,
                            EstadoSalud.SALUDABLE,
                            EstadoInventario.ACTIVO,
                            habitat,
                            tipoPelaje
                    );

                    break;

                case 2:

                    double envergadura = leerDouble(
                            "Envergadura: "
                    );

                    boolean puedeVolar = leerBoolean(
                            "¿Puede volar? (s/n): "
                    );

                    animal = new Ave(
                            codigo,
                            nombre,
                            edad,
                            peso,
                            sexo,
                            EstadoSalud.SALUDABLE,
                            EstadoInventario.ACTIVO,
                            habitat,
                            envergadura,
                            puedeVolar
                    );

                    break;

                case 3:

                    String tipoEscamas = leerTexto(
                            "Tipo de escamas: "
                    );

                    animal = new Reptil(
                            codigo,
                            nombre,
                            edad,
                            peso,
                            sexo,
                            EstadoSalud.SALUDABLE,
                            EstadoInventario.ACTIVO,
                            habitat,
                            tipoEscamas
                    );

                    break;

                default:
                    return;
            }

            if (inventario.registrarAnimal(animal)) {

                System.out.println(
                        "Animal registrado correctamente."
                );

            } else {

                System.out.println(
                        "No fue posible registrar el animal."
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // =====================================================
    // OPCIÓN 2
    // =====================================================

    private void listarAnimales() {

        System.out.println();
        System.out.println("=== LISTA DE ANIMALES ===");

        if (inventario.listarAnimales().isEmpty()) {

            System.out.println(
                    "No hay animales registrados."
            );

            return;
        }

        for (Animal animal :
                inventario.listarAnimales()) {

            System.out.println(animal);
        }
    }

    // =====================================================
    // OPCIÓN 3
    // =====================================================

    private void buscarAnimal() {

        System.out.println();
        System.out.println("=== BUSCAR ANIMAL ===");

        int codigo = leerEntero(
                "Ingrese el código: "
        );

        Animal animal =
                inventario.buscarPorCodigo(codigo);

        if (animal != null) {

            System.out.println(
                    "Animal encontrado:"
            );

            System.out.println(animal);

        } else {

            System.out.println(
                    "No existe un animal con ese código."
            );
        }
    }

    // =====================================================
    // OPCIÓN 4
    // =====================================================

    private void actualizarAnimal() {

        System.out.println();
        System.out.println(
                "=== ACTUALIZAR DATOS DE ANIMAL ==="
        );

        int codigo = leerEntero(
                "Ingrese el código del animal: "
        );

        Animal animal =
                inventario.buscarPorCodigo(codigo);

        if (animal == null) {

            System.out.println(
                    "No existe un animal con ese código."
            );

            return;
        }

        if (animal.getEstadoInventario()
                == EstadoInventario.RETIRADO) {

            System.out.println(
                    "No se puede actualizar un animal retirado."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Datos actuales:"
        );

        System.out.println(animal);

        System.out.println();
        System.out.println(
                "Ingrese los nuevos datos:"
        );

        String nombre = leerTexto(
                "Nuevo nombre: "
        );

        int edad = leerEntero(
                "Nueva edad: "
        );

        double peso = leerDouble(
                "Nuevo peso: "
        );

        String sexo = leerTexto(
                "Nuevo sexo: "
        );

        String habitat = leerTexto(
                "Nuevo hábitat: "
        );

        try {

            boolean actualizado =
                    inventario.actualizarAnimal(
                            codigo,
                            nombre,
                            edad,
                            peso,
                            sexo,
                            habitat
                    );

            if (actualizado) {

                System.out.println();
                System.out.println(
                        "Animal actualizado correctamente."
                );

            } else {

                System.out.println(
                        "No fue posible actualizar el animal."
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // =====================================================
    // OPCIÓN 5
    // =====================================================

    private void retirarAnimal() {

        System.out.println();
        System.out.println(
                "=== RETIRAR ANIMAL ==="
        );

        int codigo = leerEntero(
                "Ingrese el código del animal: "
        );

        Animal animal =
                inventario.buscarPorCodigo(codigo);

        if (animal == null) {

            System.out.println(
                    "No existe un animal con ese código."
            );

            return;
        }

        System.out.println();
        System.out.println(
                "Animal seleccionado:"
        );

        System.out.println(animal);

        System.out.println();
        System.out.println(
                "¿Está seguro de retirar este animal?"
        );

        boolean confirmar = leerBoolean(
                "Confirmar (s/n): "
        );

        if (!confirmar) {

            System.out.println(
                    "Operación cancelada."
            );

            return;
        }

        try {

            if (inventario.retirarAnimal(codigo)) {

                System.out.println();
                System.out.println(
                        "Animal retirado correctamente."
                );

            } else {

                System.out.println(
                        "No fue posible retirar el animal."
                );
            }

        } catch (IllegalStateException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // =====================================================
    // OPCIÓN 6
    // =====================================================

    private void filtrarInventario() {

        System.out.println();
        System.out.println(
                "=== FILTRAR INVENTARIO ==="
        );

        System.out.println(
                "1. Animales activos"
        );

        System.out.println(
                "2. Animales en observación"
        );

        System.out.println(
                "3. Animales retirados"
        );

        int opcion = leerEntero(
                "Seleccione un filtro: "
        );

        EstadoInventario estado;

        switch (opcion) {

            case 1:
                estado = EstadoInventario.ACTIVO;
                break;

            case 2:
                estado =
                        EstadoInventario.EN_OBSERVACION;
                break;

            case 3:
                estado =
                        EstadoInventario.RETIRADO;
                break;

            default:

                System.out.println(
                        "Filtro inválido."
                );

                return;
        }

        ArrayList<Animal> resultado =
                inventario.filtrarPorEstado(estado);

        System.out.println();
        System.out.println(
                "=== RESULTADO DEL FILTRO ==="
        );

        if (resultado.isEmpty()) {

            System.out.println(
                    "No hay animales con ese estado."
            );

            return;
        }

        for (Animal animal : resultado) {

            System.out.println(animal);
        }
    }

    // =====================================================
    // OPCIÓN 7
    // =====================================================

    private void ejecutarComportamientos() {

        System.out.println();
        System.out.println(
                "=== EJECUTAR COMPORTAMIENTOS ==="
        );

        inventario.ejecutarComportamientos();
    }

    // =====================================================
    // OPCIÓN 8
    // =====================================================

    private void mostrarResumen() {

        inventario.mostrarResumen();
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    private int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un número entero."
                );
            }
        }
    }

    private double leerDouble(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                double valor =
                        Double.parseDouble(
                                scanner.nextLine()
                        );

                if (valor < 0) {

                    System.out.println(
                            "El valor no puede ser negativo."
                    );

                } else {

                    return valor;
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un número."
                );
            }
        }
    }

    private String leerTexto(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String texto =
                    scanner.nextLine().trim();

            if (!texto.isEmpty()) {

                return texto;
            }

            System.out.println(
                    "El campo no puede estar vacío."
            );
        }
    }

    private boolean leerBoolean(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String respuesta =
                    scanner.nextLine()
                            .trim()
                            .toLowerCase();

            if (respuesta.equals("s")) {
                return true;
            }

            if (respuesta.equals("n")) {
                return false;
            }

            System.out.println(
                    "Ingrese solamente s o n."
            );
        }
    }
}