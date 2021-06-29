public class Main {

    public static void main(String[] args) {
        Labyrinte L = new Labyrinte(11, 11,30);
        System.out.println(L.toString());
        TrouveSonChemin tsc = new TrouveSonChemin(L);
        tsc.decouvre();
    }
}
