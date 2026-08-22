package bioparque;

public class Mamifero extends Animal {

    private String tipoPelaje;

    public Mamifero(int codigo, String nombre, int edad, Double peso,
                    String sexo, EstadoSalud estadoSalud,
                    EstadoInventario estadoInventario, String habitat,
                    String tipoPelaje) {

        super(codigo, nombre, edad, peso, sexo,
                estadoSalud, estadoInventario, habitat);

        if (tipoPelaje == null || tipoPelaje.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de pelaje no puede estar vacío."
            );
        }

        this.tipoPelaje = tipoPelaje;
    }

    
    // IMPLEMENTACIÓN ABSTRACTA
    

    @Override
    public String emitirSonido() {
        return "El mamífero Gruñe.";
    }

 

    public String getTipoPelaje() {
        return tipoPelaje;
    }



    public void setTipoPelaje(String tipoPelaje) {

        if (tipoPelaje == null || tipoPelaje.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de pelaje no puede estar vacío."
            );
        }

        this.tipoPelaje = tipoPelaje;
    }



    @Override
    public String toString() {

        return "Mamifero{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                ", sexo='" + getSexo() + '\'' +
                ", estadoSalud=" + getEstadoSalud() +
                ", estadoInventario=" + getEstadoInventario() +
                ", habitat='" + getHabitat() + '\'' +
                ", tipoPelaje='" + tipoPelaje + '\'' +
                '}';
    }
}
