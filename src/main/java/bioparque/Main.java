package bioparque;

public class Main {

    public static void main(String[] args) {

        MenuConsola menu = new MenuConsola();

        menu.iniciar();
    }
    
    
    // Evidencia: no se puede instanciar una clase abstracta.

// Animal animal = new Animal(
//         1,
//         "Animal genérico",
//         2,
//         10.0,
//         "Macho",
//         EstadoSalud.SALUDABLE,
//         EstadoInventario.ACTIVO,
//         "Hábitat"
// );
}