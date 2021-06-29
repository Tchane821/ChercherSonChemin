public enum TypeDeCase {
    MURE("X"),VIDE("O"),VUE("."),POS("/");

    private String strValue;

    TypeDeCase(String strValue) {
        this.strValue = strValue;
    }

    public String getStrValue() {
        return strValue;
    }
}
