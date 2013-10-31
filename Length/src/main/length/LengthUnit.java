package length;

public enum LengthUnit {

    MM(1), CM(10), M(1000);

    private final int base;

    LengthUnit(int base) {
        this.base = base;
    }

    public static int convert(LengthUnit unit, LengthUnit lengthUnit) {
        return unit.base/lengthUnit.base;
    }
}
