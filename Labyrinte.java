import javax.print.DocFlavor;
        import java.lang.reflect.Array;

public class Labyrinte {

    private char[][] laby;
    private int h; private int l;
    private int[] start;
    private int[] arriver;

    public Labyrinte(int hauteur, int largeur) {
        this.h = hauteur; this.l = largeur;
        this.laby = new char[hauteur][largeur];
        generate();
    }

    private void generate() {
        if(h > 2 && l > 3){
            startPoint();
            endPoint();
            tracerLeChemin();
        }else{
            fillpaterne();
        }
    }

    private void startPoint(){
        start = new int[]{h/2,0};
    }

    private void endPoint(){
        arriver = new int[]{h/2,l};
    }

    private void tracerLeChemin(){

    }

    private void fillpaterne(){
        for (int i = 0; i < h ; i++) {
            for (int j = 0; j < l; j++) {
                laby[i][l] = 'X';
            }
        }
    }
}
