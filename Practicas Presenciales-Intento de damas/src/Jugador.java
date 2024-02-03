public class Jugador {
    private String color;

    public Jugador(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean moverPieza(Tablero tablero, String piezaId, char direccion) {
        if (!piezaId.startsWith(color)) {
            System.out.println("Movimiento no permitido: no puedes mover piezas del oponente.");
            return false;
        }

        int[] posicion = tablero.encontrarPieza(piezaId);
        if (posicion == null) {
            System.out.println("Pieza no encontrada.");
            return false;
        }

        int filaDestino = posicion[0] + (color.equals("B") ? 1 : -1);
        int columnaDestino = posicion[1] + (direccion == 'D' ? 1 : -1);

        if (tablero.esMovimientoValido(posicion[0], posicion[1], filaDestino, columnaDestino, piezaId)) {
            return tablero.moverPieza(posicion[0], posicion[1], filaDestino, columnaDestino, piezaId);
        } else {
            System.out.println("Movimiento no válido.");
            return false;
        }
    }
}


