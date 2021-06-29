import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinte {

    private Case[][] laby;
    private int hauteur;
    private int largeur;
    private int[] start;
    private int[] arriver;

    public Labyrinte(int hauteur, int largeur, int nbObstacle) {
        if (hauteur > 1 && largeur > 1) {
            this.hauteur = hauteur;
            this.largeur = largeur;
            this.laby = new Case[hauteur][largeur];
            generate(nbObstacle);
        } else {
            System.err.println("Taille du labyrinte incorecte !");
        }
    }

    private void generate(int nbObstacle) {
        startPoint();
        endPoint();
        initLabyrinte();
        obstacle(nbObstacle);
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
                laby[i][j] = new Case(TypeDeCase.VIDE);
            }
        }
        for (int k = 0; k < largeur; k++) {
            laby[0][k] = new Case(TypeDeCase.MURE);
            laby[hauteur - 1][k] = new Case(TypeDeCase.MURE);
        }
        for (int g = 0; g < hauteur; g++) {
            laby[g][0] = new Case(TypeDeCase.MURE);
            laby[g][largeur - 1] = new Case(TypeDeCase.MURE);
        }
        laby[start[0]][start[1]] = new Case(TypeDeCase.VIDE);
        laby[arriver[0]][arriver[1]] = new Case(TypeDeCase.VIDE);
    }

    private void obstacle(int nb) {
        Random pif = new Random();
        for (int n = 0; n < nb; n++) {
            int h = pif.nextInt(hauteur - 1);
            int l = pif.nextInt(largeur - 1);
            laby[h][l] = new Case(TypeDeCase.MURE);
        }
    }

    public List<int[]> getVoisin(int h, int l) {
        List<int[]> res = new ArrayList<>();
        if (h - 1 > -1 && laby[h - 1][l].typeDeCase.equals(TypeDeCase.VIDE)) {
            res.add(new int[]{h - 1, l});
        }
        if (h + 1 < hauteur && laby[h + 1][l].typeDeCase.equals(TypeDeCase.VIDE)) {
            res.add(new int[]{h + 1, l});
        }
        if (l - 1 > -1 && laby[h][l - 1].typeDeCase.equals(TypeDeCase.VIDE)) {
            res.add(new int[]{h, l - 1});
        }
        if (l + 1 < largeur && laby[h][l + 1].typeDeCase.equals(TypeDeCase.VIDE)) {
            res.add(new int[]{h, l + 1});
        }
        return res;
    }

    public int[] getStart() {
        return start;
    }

    public int[] getArriver() {
        return arriver;
    }

    public void setcase(int h, int l, TypeDeCase tdc) {
        laby[h][l] = new Case(tdc);
    }

    public Case getcase(int h, int l) {
        return laby[h][l];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Case[] l : laby) {
            for (Case c : l) {
                res.append("| ").append(c.toString()).append(" ");
            }
            res.append("|\n");
        }
        return res.toString();
    }
}
