package biblioteca;

public class GestionBiblioteca {
	private static GestionLibros gl=new GestionLibros();
	private static GestionRevistas gr=new GestionRevistas();
	private static GestionCdrom gc=new GestionCdrom();
	private static GestionArticulos ga=new GestionArticulos();
	private static GestionUsuarios gu=new GestionUsuarios();
	
	public static void menu() {
		int opcion=0;
		System.out.println("BIBLIOTECA DEL I.E.S. POLÍGONO SUR");
		System.out.println("----------------------------------");
		System.out.println("1. Gestión de libros.");
		System.out.println("2. Gestión de revistas.");
		System.out.println("3. Gestión de CD-ROM.");
		System.out.println("4. Gestión de artículos.");
		System.out.println("5. Gestión de usuarios.");
		System.out.println("0. Salir.");
		opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
		switch (opcion) {
		case 1:
			gestionLibros();
			break;
		case 2:
			gestionRevistas();
			break;
		case 3:
			gestionCdrom();
			break;
		case 4:
			gestionArticulos();
			break;
		case 5:
			gestionUsuarios();
			break;
		case 0:
			System.out.println("¡Adiós!");
			break;
		default:
			System.out.println("Debe introducir una opción entre 0 y 5.");
			break;
		}
	}

	private static void gestionLibros() {
		gl.menu();
	}

	private static void gestionRevistas() {
		gr.menu();
	}

	private static void gestionCdrom() {
		gc.menu();
	}

	private static void gestionArticulos() {
		ga.menu();
	}

	private static void gestionUsuarios() {
		gu.menu();
	}
}
