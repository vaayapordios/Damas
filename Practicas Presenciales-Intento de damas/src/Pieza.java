public class Pieza {
    private String id;
    private boolean esRey;

    public Pieza(String id) {
        this.id = id;
        this.esRey = false;
    }

    public String getId() {
        return id;
    }

    public boolean esRey() {
        return esRey;
    }

    public void coronar() {
        this.esRey = true; // marca la pieza como rey
    }
}
