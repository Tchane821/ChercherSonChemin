public class Labyrinte {

    private char[][] laby;
    private int hauteur;
    private int largeur;
    private int[] start;
    private int[] arriver;
    private final char mure = 'X';
    private final char vide = 'o';

    public Labyrinte(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.laby = new char[hauteur][largeur];
        generate();
    }

    private void generate() {
        if (hauteur > 2 && largeur > 3) {
            startPoint();
            endPoint();
            tracerLeChemin();
        } else {
            fillpaterne();
        }
    }

    private void startPoint() {
        start = new int[]{hauteur / 2, 0};
    }

    private void endPoint() {
        arriver = new int[]{hauteur / 2, largeur-1};
    }

    private void tracerLeChemin() {
        initLabyrinte();
    }

    private void initLabyrinte() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                laby[i][j] = vide;
            }
        }
        for (int k = 0; k < largeur; k++) {
            laby[0][k] = 'X';
            laby[hauteur - 1][k] = mure;
        }
        for (int g = 0; g < hauteur; g++) {
            laby[g][0] = mure;
            laby[g][largeur - 1] = mure;
        }
        laby[start[0]][start[1]] = vide;
        laby[arriver[0]][arriver[1]] = vide;
    }

    private void fillpaterne() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                laby[i][j] = mure;
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (char[] l : laby) {
            for (char c : l) {
                res += "| " + c + " ";
            }
            res += "|\n";
        }
        return res;
    }
}
