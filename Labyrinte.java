public class Labyrinte {

    private Case[][] laby;
    private int hauteur;
    private int largeur;
    private int[] start;
    private int[] arriver;

    public Labyrinte(int hauteur, int largeur) {
        if (hauteur > 1 && largeur > 1 ) {
            this.hauteur = hauteur;
            this.largeur = largeur;
            this.laby = new Case[hauteur][largeur];
            generate();
        }else {
            System.err.println("Taille du labyrinte incorecte !");
        }
    }

    private void generate() {
        startPoint();
        endPoint();
        initLabyrinte();
    }

    private void startPoint() {
        start = new int[]{hauteur / 2, 0};
    }

    private void endPoint() {
        arriver = new int[]{hauteur / 2, largeur - 1};
    }

    private void initLabyrinte() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                laby[i][j] = new Case(typeDeCase.VIDE);
            }
        }
        for (int k = 0; k < largeur; k++) {
            laby[0][k] = new Case(typeDeCase.MURE);
            laby[hauteur - 1][k] = new Case(typeDeCase.MURE);
        }
        for (int g = 0; g < hauteur; g++) {
            laby[g][0] = new Case(typeDeCase.MURE);
            laby[g][largeur - 1] = new Case(typeDeCase.MURE);
        }
        laby[start[0]][start[1]] = new Case(typeDeCase.VIDE);
        laby[arriver[0]][arriver[1]] = new Case(typeDeCase.VIDE);
    }

    @Override
    public String toString() {
        String res = "";
        for (Case[] l : laby) {
            for (Case c : l) {
                res += "| " + c.toString() + " ";
            }
            res += "|\n";
        }
        return res;
    }
}
