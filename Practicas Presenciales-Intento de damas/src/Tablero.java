public class Tablero {
    private String[][] tablero;

    public Tablero() {
        this.tablero = new String[8][8];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ((i + j) % 2 == 0) ? " " : "L";
            }
        }
        colocarPiezasIniciales();
    }

    private void colocarPiezasIniciales() {
        int contadorBlancas = 1, contadorNegras = 1;
        for (int i = 0; i < 3; i++) { // Piezas blancas
            for (int j = (i % 2 != 0) ? 0 : 1; j < 8; j += 2) {
                tablero[i][j] = "B" + contadorBlancas++;
            }
        }
        for (int i = 5; i < 8; i++) { // Piezas negras
            for (int j = (i % 2 != 0) ? 0 : 1; j < 8; j += 2) {
                tablero[i][j] = "N" + contadorNegras++;
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("+----+----+----+----+----+----+----+----+");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String casilla = tablero[i][j];
                casilla = casilla.length() == 1 ? "  " + casilla + " " :
                        casilla.length() == 2 ? " " + casilla + " " :
                                casilla.length() == 3 ? " " + casilla :
                                        casilla;
                if(casilla.charAt(1)=='N'){
                    System.out.print("|" +  "\u001B[31m" + casilla + "\u001B[0m");

                } else {

                    System.out.print("|" + casilla);

                }
            }
            System.out.println("|");
            System.out.println("+----+----+----+----+----+----+----+----+");
        }
    }



    public int[] encontrarPieza(String piezaId) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].equals(piezaId)) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // pieza no encontrada
    }

    public boolean moverPieza(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino, String piezaId) {
        if (!esMovimientoValido(filaOrigen, columnaOrigen, filaDestino, columnaDestino, piezaId)) {
            return false;
        }
        tablero[filaDestino][columnaDestino] = piezaId;
        tablero[filaOrigen][columnaOrigen] = "L";
        return true;
    }
    public boolean esMovimientoValido(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino, String piezaId) {
        // Verificación básica de movimiento válido aquí
        return true; // Placeholder, ajusta según tu lógica de juego
    }
}
