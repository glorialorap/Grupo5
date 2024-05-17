class Cuentas {
    private String numeroCuenta;
    private String nombreCliente;
    private double saldo;
    private String direccion;
    private String profesion;
    private String Ecivil;
    private String Ced;

    public Cuentas() {
    }

    public Cuentas(String numeroCuenta, String nombreCliente, double saldo, String direccion, String profesion,
            String ecivil, String ced) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
        this.direccion = direccion;
        this.profesion = profesion;
        Ecivil = ecivil;
        Ced = ced;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEcivil() {
        return Ecivil;
    }

    public void setEcivil(String ecivil) {
        Ecivil = ecivil;
    }

    public String getCed() {
        return Ced;
    }

    public void setCed(String ced) {
        Ced = ced;
    }

    @Override
    public String toString() {
        return "Cuentas [numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", saldo=" + saldo
                + ", direccion=" + direccion + ", profesion=" + profesion + ", Ecivil=" + Ecivil + ", Ced=" + Ced + "]";
    }

    
}



