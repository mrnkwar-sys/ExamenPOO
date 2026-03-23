package ExamenPOOMaríaRaquel;

public class Empleado {
	private String dni;
	private String nombre;
	private double salarioBase;
	private double porcentajeBonificacion;
	private double precioHoraExtra;
	private int horasExtrasRealizadas;
	
	public Empleado(String dni, String nombre, double salarioBase, double porcentajeBonificacion,
			double precioHoraExtra, int horasExtrasRealizadas) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonificacion = porcentajeBonificacion;
		this.precioHoraExtra = precioHoraExtra;
		this.horasExtrasRealizadas = horasExtrasRealizadas;
	}
	
	public Empleado(String dni, String nombre, double salarioBase, double porcentajeBonificacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcentajeBonificacion = porcentajeBonificacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getPorcentajeBonificacion() {
		return porcentajeBonificacion;
	}

	public void setPorcentajeBonificacion(double porcentajeBonificacion) {
		this.porcentajeBonificacion = porcentajeBonificacion;
	}

	public double getPrecioHoraExtra() {
		return precioHoraExtra;
	}

	public void setPrecioHoraExtra(double precioHoraExtra) {
		this.precioHoraExtra = precioHoraExtra;
	}

	public int getHorasExtrasRealizadas() {
		return horasExtrasRealizadas;
	}

	public void setHorasExtrasRealizadas(int horasExtrasRealizadas) {
		this.horasExtrasRealizadas = horasExtrasRealizadas;
	}
	
	/**
	 * Calcula el valor final de la bonificación
	 * @param salarioBase
	 * @param porcentajeBonificacion
	 * @return Ese valor final
	 */
	public double importeBonificacion(double salarioBase, double porcentajeBonificacion) {
		double valorBonificacion;
		
		valorBonificacion = (salarioBase*porcentajeBonificacion)/100;
		
		return valorBonificacion;
	}
	
	/**
	 * Calcula el valor de lo que el emplpeado cobrará por las horas extras realizadas
	 * @param horasExtrasRealizadas
	 * @param precioHorasExtra
	 * @return Valor del ese pago
	 */
	public double pagoHorasExtras(int horasExtrasRealizadas, double precioHoraExtra) {
		double valorPago;
		
		valorPago = horasExtrasRealizadas*precioHoraExtra;
		
		return valorPago;
	}
	
	/**
	 * Calcula el total bruto, que es la suma del salario base, la bonificacion y el salario por las horas extras
	 * @param salarioBase
	 * @param importeBonificacion
	 * @param pagoHorasExtra
	 * @return El valor del total bruto
	 */
	public double totalBruto(double salarioBase, double importeBonificacion, double pagoHorasExtra) {
		double valorFinal;
		
		valorFinal = salarioBase + importeBonificacion(salarioBase, porcentajeBonificacion) + pagoHorasExtra*horasExtrasRealizadas;
		
		return valorFinal;
	}
	
	public boolean bonificacionSuperior(double porcentajeBonificacion) {
		return (porcentajeBonificacion > 15);
	}
	
	public String toString() {
		String datos = dni + " - " + nombre + "\n Salario Base: " + salarioBase + " | Bonificación: " + importeBonificacion(salarioBase, porcentajeBonificacion) + "(" + porcentajeBonificacion + ") \n Horas Extra: " + horasExtrasRealizadas + " | Total Bruto: " + totalBruto(salarioBase, importeBonificacion(salarioBase, porcentajeBonificacion), pagoHorasExtras(horasExtrasRealizadas, precioHoraExtra));
		return datos;
	}
	
	public boolean equals(Object objeto) {
		boolean mismoEmpleado = false;
		
		//El casteo
		Empleado otroEmpleado = (Empleado) objeto;
		
		//Dos empleados se coinsiderarán iguales si comparten el mismo DNI
		if (this.dni.equalsIgnoreCase(otroEmpleado.dni)) {
			mismoEmpleado = true;
		}
		
		return mismoEmpleado;
	}

}
