import java.util.Random;
import java.util.Scanner;
public class Bicho {
    public static Scanner scan = new Scanner(System.in);
    private String tipoBicho;
    private int salud;

    public Bicho() {

    }

    public Bicho(String tipoBicho, int salud) {
        this.tipoBicho = tipoBicho;
        this.salud = salud;
    }
    public void setTipoBicho(String tipoBicho) {

        this.tipoBicho = tipoBicho;
    }
    public String getTipoBicho() {

        return this.tipoBicho;
    }
    public void setSalud(int salud) {

        this.salud = salud;
    }
    public int getSalud() {

        return this.salud;
    }
    public static int obtenerNumeroRandom() {
        int min = 1;
        int max = 10;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static int obtenerNumeroRandom2() {
        int min = 1;
        int max = 4;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static int obtenerNumeroRandom3() {
        int min = 0;
        int max = 3;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static int obtenerNumeroRandom4() {
        int min = 0;
        int max = 5;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    @Override
    public String toString() {
        String text = this.tipoBicho + "-" + this.salud;
        return text;

    }
    public static void iniciarJuego(Bicho[][] bichos) {
        int cantidadBichos = Bicho.obtenerNumeroRandom();
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < cantidadBichos; i++) {

            int numero = Bicho.obtenerNumeroRandom2();
            if (numero == 1) { //crear bicho normal
                BichoNormal b3 = new BichoNormal();
                bichos[fila][columna] = b3;

            } else if (numero == 2) { //crear bicho alien
                BichoAlien b2 = new BichoAlien();
                bichos[fila][columna] = b2;

            } else if (numero == 3) { //crear bicho Espacial
                BichoEspacial b3 = new BichoEspacial();
                bichos[fila][columna] = b3;
            }
            if (columna == 2) {
                columna = 0;
                fila = fila + 1;

            } else {
                columna = columna + 1;

            }
        }
    }
    public static void mostrarTablero(Bicho[][] bichos) {
        for (int r = 0; r < bichos.length; r++) {
            System.out.print("-----------------------\n");
            for (int c = 0; c < bichos[r].length; c++) {
                if (bichos[r][c] != null) {
                    System.out.print(bichos[r][c] + " | ");

                } else {
                    System.out.print("    - | ");
                }
            }
            System.out.println();
        }
        System.out.print("-----------------------\n");
    }
    public static void mostrarMenuJuego(Bicho[][] bichos) {
        while(Bicho.contarBichos(bichos) != 0) {

            System.out.println("----------TABLERO--------");
            Bicho.mostrarTablero(bichos);
            System.out.println("-------¿QUÉ QUIERES HACER?--------");
            System.out.println("| 1 | Disparar a un bicho");
            System.out.println("| 2 | Activar Bomba Atómica");
            System.out.println("| 3 | Activar Bicho Mutante");
            System.out.println("| 4 | Intercambiar posiciones de bichos");
            System.out.println("| 5 | Convertir sangre");
            System.out.println("| 6 | Lanzar Bomba de Fila");
            System.out.println("| 7 | Ver promedio tenebroso");
            System.out.println("| 8 | ¿Qué diría la abuela?");
            System.out.println("| 0 | Rendirse");
            int opcion = scan.nextInt();
            if (opcion == 0) {
                System.out.println("Te has rendido...");
                System.exit(1);
            }
            switch (opcion) {
                case 1:
                    Bicho.dispararBicho(bichos);
                    break;
                case 2:
                    Bicho.activarBombaAtomica(bichos);
                    break;
                case 3:
                    Bicho.activarBichoMutante(bichos);
                    break;
                case 4:
                    Bicho.intercambiarPosicionesBichos(bichos);
                    break;
                case 5:
                    Bicho.convertirSangre(bichos);
                    break;
                case 6:
                    Bicho.bombaDeFila(bichos);
                    break;
                case 7:
                    Bicho.mostrarPromedioTenebroso(bichos);
                    break;
                case 8:
                    Bicho.mostrarFraseDeLaAbuela(Principal.frasesAbuela);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        }
        public static int contarBichos(Bicho[][] bichos){
            int cantidadBichos = 0;
            for (int i = 0; i < bichos.length; i++) {
                for (int j = 0; j < bichos[i].length; j++) {
                    if (bichos[i][j] != null) {
                        cantidadBichos = cantidadBichos + 1;
                    }
                }
            }
            return cantidadBichos;
        }
    public static void dispararBicho(Bicho[][] bichos) { //case 1
        System.out.println("----Selección de fila-----");
        System.out.println("Ingresa un número entre 0 y 2");
        int fila = scan.nextInt();
        if (fila == 0 || fila == 1 || fila == 2) {
            while (true) {
                System.out.println("----Selección de columna----");
                System.out.println("Ingresa un número entre 0 y 2");
                int columna = scan.nextInt();
                if (columna == 0 || columna == 1 || columna == 2) {
                    System.out.println("Has seleccionado la posición: | " + fila + "." + columna + " |\n");
                    if (bichos[fila][columna] != null) {
                        Principal.bichos[fila][columna].setSalud(Principal.bichos[fila][columna].getSalud() - 5);
                    }
                    break;
                }
            }
        } else {
            System.out.println("Opción inválida \n");
            Bicho.dispararBicho(bichos);
        }
    }
    public static void activarBombaAtomica(Bicho[][] bichos) { //case 2
        int filaAleatoria = Bicho.obtenerNumeroRandom3();
        int columnaAleatoria = Bicho.obtenerNumeroRandom3();
        Bicho posicionAleatoria = bichos[filaAleatoria][columnaAleatoria];
        if (posicionAleatoria != null) {
            System.out.println("Posición aleatoria: | " + filaAleatoria + "." + columnaAleatoria + " |");
            bichos[filaAleatoria][columnaAleatoria] = null;

        } else {
            Bicho.activarBombaAtomica(bichos);
        }
    }
    public static Bicho bichoConMenorSalud(Bicho[][] bichos) {
        Bicho posMenor = null;
        int saludBichomenor = 0;
        for (int filas = 0; filas < bichos.length; filas++) {
            for (int columnas = 0; columnas < bichos[filas].length; columnas++) {
                if (bichos[filas][columnas] != null) {
                    saludBichomenor = bichos[filas][columnas].salud;
                    posMenor = bichos[filas][columnas];
                    break;
                }
            }
        }
        for (int fila = 0; fila < bichos.length; fila++) {
            for (int columna = 0; columna < bichos[fila].length; columna++) {
                if (bichos[fila][columna] != null) {
                    if (saludBichomenor > bichos[fila][columna].salud) {
                        saludBichomenor = bichos[fila][columna].salud;
                        posMenor = bichos[fila][columna];
                    }
                }
            }
        }
        return posMenor;
    }
    public static void activarBichoMutante(Bicho[][] bichos){ //case 3
        Bicho posMenor = Bicho.bichoConMenorSalud(bichos);
        System.out.println("Se ha duplicado la salud de: "+ posMenor);
        posMenor.setSalud(posMenor.getSalud() * 2);
    }
    public static void intercambiarPosicionesBichos(Bicho[][] bichos) { //case 4
        int filaPrimerPosicion = Bicho.obtenerNumeroRandom3();
        int columnaPrimerPosicion = Bicho.obtenerNumeroRandom3();
        int filaSegundaPosicion = Bicho.obtenerNumeroRandom3();
        int columnaSegundaPosicion = Bicho.obtenerNumeroRandom3();
        Bicho.mostrarTablero(bichos);
        Bicho temp;
        temp = bichos[filaPrimerPosicion][columnaPrimerPosicion];
        bichos[filaPrimerPosicion][columnaPrimerPosicion] = bichos[filaSegundaPosicion][columnaSegundaPosicion];
        bichos[filaSegundaPosicion][columnaSegundaPosicion] = temp;
        System.out.println("Se han intercambiado las posiciones: " + " | " + filaPrimerPosicion + "." +
                columnaPrimerPosicion + " |" + " | " + filaSegundaPosicion + "." + columnaSegundaPosicion + " |");
    }
    public static void convertirSangre(Bicho[][] bichos){ //case 5
        Bicho posMenor = Bicho.bichoConMenorSalud(bichos);
        System.out.println(posMenor+" se ha convertido en un Bicho Espacial.\n");
        posMenor.setTipoBicho("BE");
    }
    public static void bombaDeFila(Bicho[][] bichos) { //case 6
        int filaAleatoria = Bicho.obtenerNumeroRandom3();
        System.out.println("Fila: " + filaAleatoria);
                for (int i = 0; i < 3; i++) {
                    bichos[filaAleatoria][i] = null;
                }
    }
    public static void mostrarPromedioTenebroso(Bicho[][] bichos) { //case 7
        int sumaTotal = 0;
        for (int i = 0; i < bichos.length; i++) {
            for (int j = 0; j < bichos[i].length; j++) {
                if (bichos[i][j] != null) {
                    sumaTotal = sumaTotal + bichos[i][j].getSalud();
                }
            }
        }
        int cantidadBichos = Bicho.contarBichos(bichos);
        int promedio = sumaTotal/cantidadBichos;
        System.out.println("El promedio de salud de los bichos vivos es de | " + promedio + " |");
    }
    public static void mostrarFraseDeLaAbuela(String[] frasesAbuela){
        int numeroAleatorio = Bicho.obtenerNumeroRandom4();
        System.out.println(frasesAbuela[numeroAleatorio]);
    }
}