import java.util.Scanner;
public class Principal {

    public static Bicho[][] bichos = new Bicho[3][3];
    public static String[] frasesAbuela = {"'Matar bichos te hace más fuerte'", "'Mis bichos favoritos eran los espaciales'", "'Extraño aplastar bichos'", "'Los bichos son plagas muy malas'", "'Los bichos aliens eran de otro planeta...'"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Principal.mostrarMenuInicial();
        Bicho.iniciarJuego(bichos);
        Bicho.mostrarMenuJuego(bichos);

    }

    public static void mostrarMenuInicial() {

        Scanner scan = new Scanner(System.in);
        boolean condicion = true;
        while(condicion) {
            System.out.println("-------Bienvenido------");
            System.out.println("Ingresa 1 para iniciar el juego");

            int inicio = scan.nextInt();
            if (inicio == 1) {
                Bicho.iniciarJuego(bichos);
                condicion = false;
            } else {
                System.out.println("Opción inválida");
            }

        }
    }
}
