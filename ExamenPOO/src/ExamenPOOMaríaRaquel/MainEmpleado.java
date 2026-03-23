package ExamenPOOMaríaRaquel;

import java.util.Scanner;

public class MainEmpleado {
	
	public static Scanner sc = new Scanner(System.in);
	public static ListadoEmpleados trabajador = new ListadoEmpleados();

	public static void main(String[] args) {
		
		//La opcion del menú elegida por el usuario
		int opcion;
		
		//El dni del empleado
		String dni;
		
		//El nombre del empleado
		String nombre;
		
		//El porcentaje de bonificacion del empleado
		double porcentaje;
		
		//El salario base del empleado
		double salarioBase;
		
		//La cantidad de horas extras realizadas por el empleado
		int horas;
		
		//Precio pagado por las horas extras
		double precio;
		
		//El usuario tiene que elegir una de las opciones del menú
		System.out.println("BIENVENIDO AL SISTEMA DE GESTIÓN DE EMPLEADOS");
		
		do {
			menuPrincipal();
			opcion = sc.nextInt();
			
			sc.nextLine();
			
			switch(opcion) {
			case 1 -> {
				System.out.println("Introduzca el dni del empleado: ");
				dni = sc.nextLine();
				
				System.out.println("Introduzca el nombre del empleado: ");
				nombre = sc.nextLine();
				
				System.out.println("Introduzca el salario base del empleado: ");
				salarioBase = sc.nextDouble();
				
				System.out.println("Introduzca el porcentaje de bonificación por desempeño, que debe ser del 0-30, del empleado: ");
				porcentaje = sc.nextDouble();
				
				if (verificarYAnadir(dni, nombre, salarioBase, porcentaje)) {
					System.out.println("El empleado ha sido añadido correctamente");
				} else {
					System.out.println("No se ha podido añadir al empleado a la lista");
				}
			}
			case 2 -> {
				System.out.println(trabajador.listarTodos());
			}
			case 3 -> {
				System.out.println("Introduzca el dni del empleado: ");
				dni = sc.nextLine();
				
				if (trabajador.buscarPorDni(dni) == null) {
					System.out.println("El empleado que busca no se encuentra en la lista");
				} else {
					System.out.println(trabajador.buscarPorDni(dni));
				}
			}
			case 4 -> {
				System.out.println("Introduzca el dni del empleado: ");
				dni = sc.nextLine();
				
				System.out.println("Introduzca la nueva cantidad de horas extras del empleado: ");
				horas = sc.nextInt();
				
				if (trabajador.modificarHorasExtra(dni, horas)) {
					System.out.println("Se han modificado sus horas extras correctamente");
				} else {
					System.out.println("No se han podido modificar las horas del empleado");
				}
			}
			case 5 -> {
				System.out.println("Introduzca el dni del empleado: ");
				dni = sc.nextLine();
				
				System.out.println("Introduzca el nuevo porcentaje de bonificación por desempeño, que deber ser del 0-30, del empleado: ");
				porcentaje = sc.nextDouble();
				
				while (porcentaje > 30 || porcentaje < 0) {
					System.out.println("El porcentaje no es válido, introduzca un porcentaje entre 0-30");
					porcentaje = sc.nextDouble();
				} 
				
				if(trabajador.modificarBonificacion(dni, porcentaje)) {
					System.out.println("Se ha modificado el porcentaje correctamente");
				} else {
					System.out.println("No se ha podido modificar el porcentaje");
				}
			}
			case 6 -> {
				System.out.println("Introduzca el nuevo precio de las horas extras: ");
				precio = sc.nextDouble();
				
				for (Empleado e : trabajador.listaEmpleados) {
					e.setPrecioHoraExtra(precio);
				}
				
				System.out.println("Se ha modificado el precio de las horas extras");
			}
			case 7 -> {
				System.out.println("Introduzca el dni del empleado: ");
				dni = sc.nextLine();
				
				if (trabajador.eliminarPorDni(dni)) {
					System.out.println("Se ha eliminado al empleado correcrtamente");
				} else {
					System.out.println("No se ha podido eliminar al empleado de la lista, compruebe que lo ha añadido");
				}
			}
			case 8 -> {
				System.out.println("El gasto tal en bonificaciones es de " + trabajador.calcularGastoBonificaciones());
				System.out.println(trabajador.listarEmpleadosAltoDesempeno());
			}
			case 9 -> System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
			default -> System.out.println("La opción introducida no existe");
			}
		} while (opcion != 9);

	}
	
	public static void menuPrincipal() {
		System.out.println();
		System.out.println("1. Añadir empleado");
		System.out.println("2. Listar empleados");
		System.out.println("3. Buscar empleado por DNI");
		System.out.println("4. Modificar horas extra");
		System.out.println("5. Modificar bonificación");
		System.out.println("6. Modificar precio hora extra");
		System.out.println("7. Eliminar empleado");
		System.out.println("8. Ver estadísticas");
		System.out.println("9. Salir");
		System.out.println();
		System.out.println("Elija una de las opciones del menú");
	}
	
	public static boolean verificarYAnadir(String dni, String nombre, double salario, double porcentaje) {
		boolean empleadoExiste = false;
		boolean empleadoAnadido = false;
		
		for (Empleado e : trabajador.listaEmpleados) {
			if (e.getDni().equalsIgnoreCase(dni)) {
				empleadoExiste = true;
			}
		}
		
		if (!empleadoExiste) {
			trabajador.añadirEmpleado(new Empleado(dni, nombre, salario, porcentaje));
			empleadoAnadido = true;
		}
		
		return empleadoAnadido;
	}
	
	

}
