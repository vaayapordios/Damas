import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();

        // Crea los jugadores
        Jugador jugador1 = new Jugador("B");
        Jugador jugador2 = new Jugador("N");

        boolean juegoTerminado = false;
        boolean turnoJugador1 = true;

        while (!juegoTerminado) {
            tablero.mostrarTablero();

            System.out.println("Turno de " + (turnoJugador1 ? "jugador 1 (Blancas)" : "jugador 2 (Negras)"));
            System.out.print("Ingrese el identificador de la pieza y la dirección (D/I)");
            System.out.print("o 'rendirse' para terminar el juego: ");
            String lineaCompleta = scanner.nextLine().trim();

            if (lineaCompleta.equalsIgnoreCase("rendirse")) {
                System.out.println("El " + (turnoJugador1 ? "jugador 1" : "jugador 2") + " se ha rendido. ¡Juego terminado!");
                juegoTerminado = true;
                break;
            }

            if (lineaCompleta.contains(" ")) {
                String[] partes = lineaCompleta.split(" ");
                if (partes.length == 2) {
                    String piezaId = partes[0];
                    char direccion = partes[1].charAt(0);

                    boolean movimientoValido = turnoJugador1 ?
                            jugador1.moverPieza(tablero, piezaId, direccion) :
                            jugador2.moverPieza(tablero, piezaId, direccion);

                    if (!movimientoValido) {
                        System.out.println("Movimiento no válido, intente nuevamente.");
                    } else {
                        turnoJugador1 = !turnoJugador1;
                    }
                } else {
                    System.out.println("Formato de entrada no reconocido. Por favor, intente de nuevo.");
                }
            } else {
                System.out.println("Formato de entrada no reconocido. Por favor, siga el formato '[PiezaID] [D/I]'.");
            }
        }

        scanner.close();
    }
}
