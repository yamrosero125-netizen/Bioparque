package bioparque;

public class Ave extends Animal {

    private Double envergadura;
    private boolean puedeVolar;

    public Ave(int codigo, String nombre, int edad, Double peso,
               String sexo, EstadoSalud estadoSalud,
               EstadoInventario estadoInventario, String habitat,
               Double envergadura, boolean puedeVolar) {

        super(codigo, nombre, edad, peso, sexo,
                estadoSalud, estadoInventario, habitat);

        if (envergadura == null || envergadura < 0) {
            throw new IllegalArgumentException(
                    "La envergadura no puede ser negativa."
            );
        }

        this.envergadura = envergadura;
        this.puedeVolar = puedeVolar;
    }

    public Double getEnvergadura() {
        return envergadura;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    public void actualizarEnvergadura(Double envergadura) {

        if (envergadura == null || envergadura < 0) {
            throw new IllegalArgumentException(
                    "La envergadura no puede ser negativa."
            );
        }

        if (getEstadoInventario() == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "No se puede modificar un ave retirada."
            );
        }

        this.envergadura = envergadura;
    }

    public void actualizarPuedeVolar(boolean puedeVolar) {

        if (getEstadoInventario() == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "No se puede modificar un ave retirada."
            );
        }

        this.puedeVolar = puedeVolar;
    }

    @Override
    public String toString() {
        return "Ave{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", peso=" + getPeso() +
                ", sexo='" + getSexo() + '\'' +
                ", estadoSalud=" + getEstadoSalud() +
                ", estadoInventario=" + getEstadoInventario() +
                ", habitat='" + getHabitat() + '\'' +
                ", envergadura=" + envergadura +
                ", puedeVolar=" + puedeVolar +
                '}';
    }
}
