package bioparque;

public abstract class Animal {

    private final int codigo;
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

        if (sexo == null || sexo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El sexo no puede estar vacío."
            );
        }

        if (estadoSalud == null) {
            throw new IllegalArgumentException(
                    "El estado de salud es obligatorio."
            );
        }

        if (estadoInventario == null) {
            throw new IllegalArgumentException(
                    "El estado del inventario es obligatorio."
            );
        }

        if (habitat == null || habitat.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El hábitat no puede estar vacío."
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

    // Metodos de Dominio 

    public void actualizarPeso(double nuevoPeso) {

        if (nuevoPeso < 0) {
            throw new IllegalArgumentException(
                    "El peso no puede ser negativo."
            );
        }

        verificarNoRetirado();

        this.peso = nuevoPeso;
    }

    public void trasladarHabitat(String nuevoHabitat) {

        if (nuevoHabitat == null || nuevoHabitat.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El hábitat no puede estar vacío."
            );
        }

        verificarNoRetirado();

        this.habitat = nuevoHabitat;
    }

    public void ponerEnObservacion() {

        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "Un animal retirado no puede pasar a observación."
            );
        }

        this.estadoInventario = EstadoInventario.EN_OBSERVACION;
    }

    public void retirar() {

        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "El animal ya se encuentra retirado."
            );
        }

        this.estadoInventario = EstadoInventario.RETIRADO;
    }

    // La actualizacion ya esta controlada

    public void actualizarNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        verificarNoRetirado();

        this.nombre = nombre;
    }

    public void actualizarEdad(int edad) {

        if (edad < 0) {
            throw new IllegalArgumentException(
                    "La edad no puede ser negativa."
            );
        }

        verificarNoRetirado();

        this.edad = edad;
    }

    public void actualizarSexo(String sexo) {

        if (sexo == null || sexo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El sexo no puede estar vacío."
            );
        }

        verificarNoRetirado();

        this.sexo = sexo;
    }

    public void actualizarEstadoSalud(EstadoSalud estadoSalud) {

        if (estadoSalud == null) {
            throw new IllegalArgumentException(
                    "El estado de salud es obligatorio."
            );
        }

        verificarNoRetirado();

        this.estadoSalud = estadoSalud;
    }

    private void verificarNoRetirado() {

        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalStateException(
                    "No se puede modificar un animal retirado."
            );
        }
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