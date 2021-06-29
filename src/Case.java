public class Case {

    public TypeDeCase typeDeCase;

    public Case(TypeDeCase typeDeCase) {
        this.typeDeCase = typeDeCase;
    }

    @Override
    public String toString() {
        return this.typeDeCase.getStrValue();
    }
}
