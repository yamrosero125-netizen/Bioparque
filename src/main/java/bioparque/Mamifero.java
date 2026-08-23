package bioparque;

public class Mamifero extends Animal {

    private String tipoPelaje;

    public Mamifero(int codigo, String nombre, int edad, Double peso,
                    String sexo, EstadoSalud estadoSalud,
                    EstadoInventario estadoInventario, String habitat,
                    String tipoPelaje) {

        super(codigo, nombre, edad, peso, sexo,
                estadoSalud, estadoInventario, habitat);

        this.tipoPelaje = tipoPelaje;
    }

    @Override
    public String emitirSonido() {
        return "El mamífero emite: ¡Grrrr!";
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void setTipoPelaje(String tipoPelaje) {
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