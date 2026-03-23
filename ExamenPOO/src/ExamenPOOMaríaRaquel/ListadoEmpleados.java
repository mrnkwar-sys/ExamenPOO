package ExamenPOOMaríaRaquel;

import java.util.ArrayList;

public class ListadoEmpleados {
	//La lista que va a contener a todos los empleados de la empresa
	ArrayList <Empleado> listaEmpleados;
	
	//La lista que va a contener a los empleados cuya bonificación sea superior al 15%
	ArrayList <Empleado> listaEmpleadosAltoDesempeno;
	
	//CONSTRUCTORES
	ListadoEmpleados(){
		listaEmpleados = new ArrayList<>();
		listaEmpleadosAltoDesempeno = new ArrayList<>();
	}
	
	ListadoEmpleados(ArrayList <Empleado> listaEmpleados, ArrayList <Empleado> listaEmpleadosAltoDesempeno){
		this.listaEmpleados = listaEmpleados;
		this.listaEmpleadosAltoDesempeno = listaEmpleadosAltoDesempeno;
	}
	
	/**
	 * Añade un empleado a la lista
	 * @param empleado
	 * @return True si el empleado ha sido añadido correctamente, false si no ha sido así
	 */
	public boolean añadirEmpleado(Empleado empleado) {
		if (empleado.bonificacionSuperior(empleado.getPorcentajeBonificacion())) {
			listaEmpleadosAltoDesempeno.add(empleado);
		}
		return listaEmpleados.add(empleado);
	}
	
	/**
	 * Devuelve la lista de todos los empleados
	 * @return La propia lista
	 */
	ArrayList <Empleado> listarTodos(){
		return listaEmpleados;
	}
	
	/**
	 * Busca si un empleado de determinado DNI se encuentra en la lista
	 * @param dni
	 * @return Null si el empleado no se encuentra en la lista, al propio empleado si sí lo encuentra
	 */
	public Object buscarPorDni(String dni) {
		Object empleadoBuscado = null;
		
		for (Empleado e : listaEmpleados) {
			if (e.getDni().equalsIgnoreCase(dni)) {
				empleadoBuscado = e;
			}
		}
		
		return empleadoBuscado;
	}
	
	/**
	 * Modifica las horas extras realizadas por un empleado
	 * @param dni
	 * @param horas
	 * @return True si se han podido modificar esas horas, false si no
	 */
	public boolean modificarHorasExtra(String dni, int horas) {
		boolean horasModificadas = false;
		
		for (Empleado e : listaEmpleados) {
			if (e.getDni().equalsIgnoreCase(dni)) {
				e.setHorasExtrasRealizadas(horas);
				horasModificadas = true;
			}
		}
		
		return horasModificadas;
	}
	
	/**
	 * Modifica el porcentaje de bonificacion de un empleado concreto
	 * @param dni
	 * @param porcentaje
	 * @return True si se han podido modificar el porcentaje, false si no
	 */
	public boolean modificarBonificacion(String dni, double porcentaje) {
		boolean porcentajeModificado = false;
		
		for (Empleado e : listaEmpleados) {
			if (e.getDni().equalsIgnoreCase(dni)) {
				e.setPorcentajeBonificacion(porcentaje);;
				porcentajeModificado = true;
			}
		}
		
		return porcentajeModificado; 
	}
	
	/**
	 * Elimina a un empleado de la lista
	 * @param dni
	 * @return True si se ha podido eliminar al empleado de la lista
	 */
	public boolean eliminarPorDni(String dni) {
		return listaEmpleados.removeIf(cualquierEmpleado -> cualquierEmpleado.getDni().equalsIgnoreCase(dni));
	}
	
	/**
	 * Calcula la suma total que resulta de sumar todas las bonifcaciones de la lista
	 * @return El valor de esa suma
	 */
	public double calcularGastoBonificaciones() {
		double sumaBonificaciones = 0;
		
		for (Empleado e : listaEmpleados) {
			sumaBonificaciones += e.importeBonificacion(e.getSalarioBase(), e.getPorcentajeBonificacion());
		}
		
		return sumaBonificaciones;
	}
	
	/**
	 * Muestra la lista de empleados cuyo porcentaje de bonificacion sea superior al 15%
	 * @return Esa misma lista
	 */
	ArrayList <Empleado> listarEmpleadosAltoDesempeno(){
		return listaEmpleadosAltoDesempeno;
	}
	
	
}
