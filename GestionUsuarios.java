package biblioteca;

public class GestionUsuarios {
	private final int TAM=100;
	private int posicion=0;
	private Usuario[] gestionusuario=new Usuario[TAM];
	
	public void menu() {
		int opcion=0;
		do {
			System.out.println("GESTIÓN DE USUARIOS");
			System.out.println("-------------------");
			System.out.println("1. Añadir usuario.");
			System.out.println("2. Eliminar usuario.");
			System.out.println("3. Modificar usuario.");
			System.out.println("4. Mostrar usuarios.");
			System.out.println("0. Volver al menú principal.");
			opcion=PedirDatos.leerEntero("¿Qué desea hacer?");
			switch (opcion) {
			case 1:
				addUsuario();
				break;
			case 2:
				delUsuario();
				break;
			case 3:
				setUsuario();
				break;
			case 4:
				mostrarUsuarios();
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

	private void addUsuario() {
		if (posicion>=TAM) {
			System.out.println("No puede añadir más usuarios porque el espacio para usuarios está completo.");
			return;
		}
		long codusuario=PedirDatos.leerLong("Introduzca el código del usuario que desea añadir.");
		if (buscarUsuario(codusuario)!=-1) {
			System.out.println("No se puede añadir el usuario con el código "+codusuario+" porque ya existe.");
			return;
		}
		String nombre=PedirDatos.leerCadena("Introduzca el nombre del usuario.");
		String apellido1=PedirDatos.leerCadena("Introduzca el primer apellido del usuario.");
		String apellido2=PedirDatos.leerCadena("Introduzca el segundo apellido del usuario.");
		Usuario u=new Usuario(codusuario, nombre, apellido1, apellido2);
		this.gestionusuario[posicion]=u;
		posicion++;
		System.out.println("El usuario con el código "+codusuario+" ha sido añadido correctamente.");
	}

	private void delUsuario() {
		if (posicion<=0) {
			System.out.println("No puede eliminar usuarios porque no existe ninguno.");
			return;
		}
		long codusuario=PedirDatos.leerLong("Introduzca el código del usuario que desea eliminar.");
		int pos=buscarUsuario(codusuario);
		if (pos==-1) {
			System.out.println("No se puede eliminar el usuario con el código "+codusuario+" porque no existe.");
			return;
		}
		for (int i = pos; i < posicion-1; i++) {
			this.gestionusuario[i]=this.gestionusuario[i+1];
		}
		posicion--;
		this.gestionusuario[posicion]=null;
		System.out.println("El usuario con el código "+codusuario+" ha sido eliminado correctamente.");
	}

	private void setUsuario() {
		if (posicion<=0) {
			System.out.println("No puede modificar usuarios porque no existe ninguno.");
		}
		long codusuario=PedirDatos.leerLong("Introduzca el código del usuario que desea modificar.");
		int pos=buscarUsuario(codusuario);
		if (pos==-1) {
			System.out.println("No se puede modificar el usuario con el código "+codusuario+" porque no existe.");
			return;
		}
		System.out.println("Los datos del usuario con el código "+codusuario+" son:");
		System.out.println(this.gestionusuario[pos]);
		String nombre=PedirDatos.leerCadena("Introduzca el nuevo nombre del usuario.");
		String apellido1=PedirDatos.leerCadena("Introduzca el nuevo primer apellido del usuario.");
		String apellido2=PedirDatos.leerCadena("Introduzca el nuevo segundo apellido del usuario.");
		Usuario u=new Usuario(codusuario, nombre, apellido1, apellido2);
		this.gestionusuario[pos]=u;
		System.out.println("El usuario con el código "+codusuario+" ha sido modificado correctamente.");
	}

	private void mostrarUsuarios() {
		for (int i = 0; i < posicion; i++) {
			System.out.println(this.gestionusuario[i]);
			System.out.println("-------------------------");
		}
	}
	
	private int buscarUsuario(long codusuario) {
		for (int i = 0; i < posicion; i++) {
			if (this.gestionusuario[i].getCodusuario()==codusuario) {
				return i;
			}
		}
		return -1;
	}
}