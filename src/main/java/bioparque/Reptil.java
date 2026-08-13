package bioparque;

public class Reptil extends Animal {

    private String tipoEscamas;

    public Reptil(int codigo, String nombre, int edad, Double peso,
                  String sexo, EstadoSalud estadoSalud,
                  EstadoInventario estadoInventario, String habitat,
                  String tipoEscamas) {

        super(codigo, nombre, edad, peso, sexo,
                estadoSalud, estadoInventario, habitat);

        this.tipoEscamas = tipoEscamas;
    }

    public String getTipoEscamas() {
        return tipoEscamas;
    }

    public void setTipoEscamas(String tipoEscamas) {
        this.tipoEscamas = tipoEscamas;
    }

    @Override
    public String toString() {
        return "Reptil{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                ", sexo='" + getSexo() + '\'' +
                ", estadoSalud=" + getEstadoSalud() +
                ", estadoInventario=" + getEstadoInventario() +
                ", habitat='" + getHabitat() + '\'' +
                ", tipoEscamas='" + tipoEscamas + '\'' +
                '}';
    }
}
