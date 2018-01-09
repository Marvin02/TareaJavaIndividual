package biblioteca;

public class GestionLibros {
	private final int TAM=100;
	private int posicion=0;
	private Libro[] gestionlibros=new Libro[TAM];
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("GESTIÓN DE LIBROS");
			System.out.println("-----------------");
			System.out.println("1. Añadir libro.");
			System.out.println("2. Eliminar libro.");
			System.out.println("3. Modificar libro.");
			System.out.println("4. Mostrar libros.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				addLibro();
				break;
			case 2:
				delLibro();
				break;
			case 3:
				setLibro();
				break;
			case 4:
				mostrarLibros();
				break;
			case 0:
				System.out.println("Volviendo al menú principal...");
				System.out.println();
				GestionBiblioteca.menu();
				break;
			default:
				System.out.println("Debe introducir una opción entre 0 y 4.");
				break;
			}			
		} while (opcion!=0);
	}

	private void addLibro() {
		if (posicion==TAM) {
			System.out.println("No puede añadir más libros porque el espacio para libros está completo.");
			return;
		}
		long isbn=PedirDatos.leerLong("Introduzca el ISBN del libro que desea añadir.");
		if (buscarLibro(isbn)!=-1) {
			System.out.println("No se puede añadir el libro con el ISBN "+isbn+" porque ya existe.");
			return;
		}
		//String signatura=PedirDatos.leerCadena("¿Desea modificar la signatura?");
		
		String signatura=PedirDatos.leerCadena("Introduzca la signatura.");
		String titulo=PedirDatos.leerCadena("Introduzca el título.");
		String autor=PedirDatos.leerCadena("Introduzca el autor.");
		String materia=PedirDatos.leerCadena("Introduzca la materia.");
		String editorial=PedirDatos.leerCadena("Introduzca la editorial.");
		Libro l=new Libro(isbn, signatura, titulo, autor, materia, editorial);
		this.gestionlibros[posicion]=l;
		posicion++;
		System.out.println("El libro con el ISBN "+isbn+" se ha creado correctamente.");
	}

	private void delLibro() {
		if (posicion==0) {
			System.out.println("No puede eliminar libros porque no existe ninguno.");
			return;
		}
		long isbn=PedirDatos.leerLong("Introduzca el ISBN del libro que desea eliminar.");
		int pos=buscarLibro(isbn);
		if (pos==-1) {
			System.out.println("No se puede eliminar el libro con el ISBN "+pos+" porque no existe.");
			return;
		}
		for (int i = pos; i < posicion-1; i++) {
			this.gestionlibros[i]=this.gestionlibros[i+1];
		}
		posicion--;
		this.gestionlibros[posicion]=null;
		System.out.println("El libro con el ISBN "+isbn+" ha sido eliminado correctamente.");
	}

	private void setLibro() {
		if (posicion<=0) {
			System.out.println("No puede modificar libros porque no existe ninguno.");
			return;
		}
		long isbn=PedirDatos.leerLong("Introduzca el ISBN del libro que desea modificar.");
		int pos=buscarLibro(isbn);
		if (pos==-1) {
			System.out.println("No se puede modificar el libro con el ISBN "+isbn+" porque no existe.");
			return;
		}
		System.out.println("Los datos del libro con el ISBN "+isbn+" son:");
		System.out.println(this.gestionlibros[pos]);
		String signatura=PedirDatos.leerCadena("Introduzca la nueva signatura.");
		String titulo=PedirDatos.leerCadena("Introduzca el nuevo título.");
		String autor=PedirDatos.leerCadena("Introduzca el nuevo autor.");
		String materia=PedirDatos.leerCadena("Introduzca la nueva materia.");
		String editorial=PedirDatos.leerCadena("Introduzca la nueva editorial.");
		Libro l=new Libro(isbn, signatura, titulo, autor, materia, editorial);
		this.gestionlibros[pos]=l;
		System.out.println("El libro con el ISBN "+isbn+" ha sido modificado correctamente.");
	}

	private void mostrarLibros() {
		for (int i = 0; i < posicion; i++) {
			System.out.println(this.gestionlibros[i]);
			System.out.println("-------------------------");
		}
	}
	
	private int buscarLibro(long isbn) {
		for (int i = 0; i < posicion; i++) {
			if (this.gestionlibros[i].getISBN()==isbn) {
				return i;
			}
		}
		return -1;
	}
}