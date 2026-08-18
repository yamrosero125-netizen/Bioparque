package bioparque;

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
            opcion = leerEntero("Seleccione una opción: ");

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

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {

        System.out.println();
        System.out.println("=== INVENTARIO DE ANIMALES - BIOPARQUE PASTO ===");
        System.out.println("1. Registrar animal");
        System.out.println("2. Listar animales");
        System.out.println("3. Buscar animal por código");
        System.out.println("4. Actualizar datos de un animal");
        System.out.println("5. Retirar animal");
        System.out.println("0. Salir");
    }

    private void registrarAnimal() {

        try {

            System.out.println();
            System.out.println("=== REGISTRAR ANIMAL ===");
            System.out.println("1. Mamífero");
            System.out.println("2. Ave");
            System.out.println("3. Reptil");

            int categoria = leerEntero("Seleccione categoría: ");

            if (categoria < 1 || categoria > 3) {
                System.out.println("Categoría inválida.");
                return;
            }

            int codigo = leerEntero("Código: ");

            if (inventario.buscarPorCodigo(codigo) != null) {
                System.out.println("El código ya está registrado.");
                return;
            }

            String nombre = leerTexto("Nombre: ");
            int edad = leerEntero("Edad: ");
            double peso = leerDouble("Peso: ");
            String sexo = leerTexto("Sexo: ");
            String habitat = leerTexto("Hábitat: ");

            Animal animal;

            switch (categoria) {

                case 1:

                    String tipoPelaje =
                            leerTexto("Tipo de pelaje: ");

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

                    double envergadura =
                            leerDouble("Envergadura: ");

                    boolean puedeVolar =
                            leerBoolean("¿Puede volar? (s/n): ");

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

                    String tipoEscamas =
                            leerTexto("Tipo de escamas: ");

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

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarAnimales() {

        System.out.println();
        System.out.println("=== LISTA DE ANIMALES ===");

        if (inventario.listarAnimales().isEmpty()) {
            System.out.println(
                    "No hay animales registrados."
            );
            return;
        }

        for (Animal animal : inventario.listarAnimales()) {
            System.out.println(animal);
        }
    }

    private void buscarAnimal() {

        int codigo = leerEntero("Ingrese el código: ");

        Animal animal = inventario.buscarPorCodigo(codigo);

        if (animal != null) {

            System.out.println("Animal encontrado:");
            System.out.println(animal);

        } else {

            System.out.println(
                    "No existe un animal con ese código."
            );
        }
    }

    private void actualizarAnimal() {

        System.out.println();
        System.out.println("=== ACTUALIZAR ANIMAL ===");

        int codigo = leerEntero(
                "Ingrese el código del animal: "
        );

        Animal animal = inventario.buscarPorCodigo(codigo);

        if (animal == null) {

            System.out.println(
                    "No existe un animal con ese código."
            );

            return;
        }

        try {

            System.out.println("Animal actual:");
            System.out.println(animal);

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

            System.out.println();
            System.out.println("Estado de salud:");
            System.out.println("1. SALUDABLE");
            System.out.println("2. EN_TRATAMIENTO");
            System.out.println("3. ENFERMO");

            int opcionSalud = leerEntero(
                    "Seleccione: "
            );

            EstadoSalud estadoSalud;

            switch (opcionSalud) {

                case 1:
                    estadoSalud = EstadoSalud.SALUDABLE;
                    break;

                case 2:
                    estadoSalud =
                            EstadoSalud.EN_TRATAMIENTO;
                    break;

                case 3:
                    estadoSalud = EstadoSalud.ENFERMO;
                    break;

                default:
                    System.out.println(
                            "Estado de salud inválido."
                    );
                    return;
            }

            inventario.actualizarAnimal(
                    codigo,
                    nombre,
                    edad,
                    peso,
                    sexo,
                    estadoSalud,
                    habitat
            );

            System.out.println(
                    "Animal actualizado correctamente."
            );

        } catch (IllegalArgumentException |
                 IllegalStateException e) {

            System.out.println(
                    "No se pudo actualizar: "
                    + e.getMessage()
            );
        }
    }

    private void retirarAnimal() {

        System.out.println();
        System.out.println("=== RETIRAR ANIMAL ===");

        int codigo = leerEntero(
                "Ingrese el código del animal: "
        );

        Animal animal = inventario.buscarPorCodigo(codigo);

        if (animal == null) {

            System.out.println(
                    "No existe un animal con ese código."
            );

            return;
        }

        try {

            inventario.retirarAnimal(codigo);

            System.out.println(
                    "El animal fue retirado correctamente."
            );

            System.out.println(
                    "El registro permanece en el inventario "
                    + "con estado RETIRADO."
            );

        } catch (IllegalStateException e) {

            System.out.println(
                    "No se pudo retirar: "
                    + e.getMessage()
            );
        }
    }

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

                double valor = Double.parseDouble(
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

            String texto = scanner.nextLine().trim();

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
                    scanner.nextLine().trim().toLowerCase();

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