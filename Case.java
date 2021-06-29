public class Case {

    public typeDeCase typeDeCase;

    public Case(typeDeCase typeDeCase) {
        this.typeDeCase = typeDeCase;
    }

    @Override
    public String toString() {
        return this.typeDeCase.getStrValue();
    }
}
