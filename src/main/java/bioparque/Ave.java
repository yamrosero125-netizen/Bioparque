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

    
    // IMPLEMENTACIÓN ABSTRACTA
    

    @Override
    public String emitirSonido() {

        return "El ave emite un canto.";
    }



    public Double getEnvergadura() {
        return envergadura;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }



    public void setEnvergadura(Double envergadura) {

        if (envergadura == null || envergadura < 0) {
            throw new IllegalArgumentException(
                    "La envergadura no puede ser negativa."
            );
        }

        this.envergadura = envergadura;
    }

    public void setPuedeVolar(boolean puedeVolar) {
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