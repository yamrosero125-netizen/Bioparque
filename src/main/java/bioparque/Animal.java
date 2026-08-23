package bioparque;

public abstract class Animal {

    private int codigo;
    private String nombre;
    private int edad;
    private Double peso;
    private String sexo;
    private EstadoSalud estadoSalud;
    private EstadoInventario estadoInventario;
    private String habitat;

    public Animal(int codigo, String nombre, int edad, Double peso,
                  String sexo, EstadoSalud estadoSalud,
                  EstadoInventario estadoInventario, String habitat) {

        if (codigo <= 0) {
            throw new IllegalArgumentException(
                    "El código debe ser mayor que 0."
            );
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        if (edad < 0) {
            throw new IllegalArgumentException(
                    "La edad no puede ser negativa."
            );
        }

        if (peso == null || peso < 0) {
            throw new IllegalArgumentException(
                    "El peso no puede ser negativo."
            );
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.estadoSalud = estadoSalud;
        this.estadoInventario = estadoInventario;
        this.habitat = habitat;
    }

    // Método abstracto: cada tipo de animal responde diferente
    public abstract String emitirSonido();

    public void actualizarPeso(double nuevoPeso) {

        if (nuevoPeso < 0) {
            throw new IllegalArgumentException(
                    "El peso no puede ser negativo."
            );
        }

        this.peso = nuevoPeso;
    }

    public void retirar() {

        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "El animal ya se encuentra retirado."
            );
        }

        estadoInventario = EstadoInventario.RETIRADO;
    }

    public void ponerEnObservacion() {

        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "Un animal retirado no puede pasar a observación."
            );
        }

        estadoInventario = EstadoInventario.EN_OBSERVACION;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Double getPeso() {
        return peso;
    }

    public String getSexo() {
        return sexo;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public EstadoInventario getEstadoInventario() {
        return estadoInventario;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        this.nombre = nombre;
    }

    public void setEdad(int edad) {

        if (edad < 0) {
            throw new IllegalArgumentException(
                    "La edad no puede ser negativa."
            );
        }

        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEstadoSalud(EstadoSalud estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public void setHabitat(String habitat) {

        if (habitat == null || habitat.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El hábitat no puede estar vacío."
            );
        }

        this.habitat = habitat;
    }

    public String resumenBasico() {

        return "Código: " + codigo
                + " | Nombre: " + nombre
                + " | Edad: " + edad
                + " | Peso: " + peso
                + " | Estado: " + estadoInventario;
    }

    @Override
    public String toString() {

        return "Animal{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", sexo='" + sexo + '\'' +
                ", estadoSalud=" + estadoSalud +
                ", estadoInventario=" + estadoInventario +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}