package biblioteca;

public class GestionRevistas {
	private final int TAM=100;
	private int posicion=0;
	private Revista[] gestionrevistas=new Revista[TAM];
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("GESTIÓN DE REVISTAS");
			System.out.println("-------------------");
			System.out.println("1. Añadir revista.");
			System.out.println("2. Eliminar revista.");
			System.out.println("3. Modificar revista.");
			System.out.println("4. Mostrar revistas.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				addRevista();
				break;
			case 2:
				delRevista();
				break;
			case 3:
				setRevista();
				break;
			case 4:
				mostrarRevistas();
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				System.out.println();
				GestionBiblioteca.menu();
				break;
			default:
				break;
			}
		} while (opcion!=0);
	}

	private void addRevista() {
		if (posicion>=TAM) {
			System.out.println("No puede añadir más revistas porque el espacio para revistas está completo.");
			return;
		}
		long codrevista=PedirDatos.leerLong("Introduzca el código de la revista que desea añadir.");
		if (buscarRevista(codrevista)!=-1) {
			System.out.println("No puede añadir la revista con el código "+codrevista+" porque ya existe.");
			return;
		}
		String signatura=PedirDatos.leerCadena("Introduzca la signatura de la revista.");
		String nombre=PedirDatos.leerCadena("Introduzca el nombre de la revista.");
		String materia=PedirDatos.leerCadena("Introduzca la materia de la revista.");
		Revista r=new Revista(codrevista, signatura, nombre, materia);
		this.gestionrevistas[posicion]=r;
		posicion++;
		System.out.println("La revista con el código "+codrevista+" se ha añadido correctamente.");
	}

	private void delRevista() {
		if (posicion<=0) {
			System.out.println("No puede eliminar revistas porque no existe ninguna.");
			return;
		}
		long codrevista=PedirDatos.leerLong("Introduzca el código de la revista que desea eliminar.");
		int pos=buscarRevista(codrevista);
		if (pos==-1) {
			System.out.println("No se puede eliminar la revista con el código "+codrevista+" porque no existe.");
			return;
		}
		for (int i = pos; i < posicion-1; i++) {
			this.gestionrevistas[i]=this.gestionrevistas[i+1];
		}
		posicion--;
		this.gestionrevistas[posicion]=null;
		System.out.println("La revista con el código "+codrevista+" ha sido eliminada correctamente.");
	}

	private void setRevista() {
		if (posicion<=0) {
			System.out.println("No puede modificar revistas porque no existe ninguna.");
			return;
		}
		long codrevista=PedirDatos.leerLong("Introduzca el código de la revista que desea modificar.");
		int pos=buscarRevista(codrevista);
		if (pos==-1) {
			System.out.println("No se puede modificar la revista con el código "+codrevista+" porque no existe.");
			return;
		}
		System.out.println("Los datos de la revista con el código "+codrevista+" son:");
		System.out.println(this.gestionrevistas[pos]);
		String signatura=PedirDatos.leerCadena("Introduzca la nueva signatura de la revista.");
		String nombre=PedirDatos.leerCadena("Introduzca el nuevo nombre de la revista.");
		String materia=PedirDatos.leerCadena("Introduzca la nueva materia de la revista.");
		Revista r=new Revista(codrevista, signatura, nombre, materia);
		this.gestionrevistas[pos]=r;
		System.out.println("La revista con el código "+codrevista+" ha sido modificada correctamente.");
	}

	private void mostrarRevistas() {
		for (int i = 0; i < posicion; i++) {
			System.out.println(this.gestionrevistas[i]);
			System.out.println("-------------------------");
		}
	}
	
	private int buscarRevista(long codrevista) {
		for (int i = 0; i < posicion; i++) {
			if (this.gestionrevistas[i].getCodrevista()==codrevista) {
				return i;
			}
		}
		return -1;
	}
}
