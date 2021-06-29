import java.util.Stack;

public class TrouveSonChemin {
    Labyrinte L;
    Boolean caseTrouver;
    Stack<int[]> atraiter;

    public TrouveSonChemin(Labyrinte l) {
        L = l;
        caseTrouver = false;
        atraiter = new Stack<>();
    }

    public void decouvre() {
        int[] end = L.getArriver();
        int nbCycle = 0;
        atraiter.push(L.getStart());
        while (!caseTrouver && !atraiter.empty()) {
            int[] temp = atraiter.pop();
            if (! L.getcase(temp[0], temp[1]).typeDeCase.equals(TypeDeCase.VUE)) {
                nbCycle++;
                ajouterLesVoisins(atraiter, temp);
                if (temp[0] == end[0] && temp[1] == end[1]) {
                    caseTrouver = true;
                    System.out.println("Fin Trouver !");
                }
                L.setcase(temp[0], temp[1], TypeDeCase.POS);
                System.out.println(L.toString());
                L.setcase(temp[0], temp[1], TypeDeCase.VUE);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (atraiter.empty()) {
            System.out.println("sortie inatégnable");
        }
        System.out.println("nombre de cycle : " + nbCycle);
    }

    private void ajouterLesVoisins(Stack<int[]> s, int[] v) {
        for (int[] voi : L.getVoisin(v[0], v[1])) {
            s.push(voi);
        }
    }

}
