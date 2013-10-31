package length;

public class Length {

    private int value = 0;
    private LengthUnit unit;


    public Length(int value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length add(Length length) {
        return this;

    }

    public Length minus(Length length) {
        return this;
    }

    public int getValue() {
        return value;
    }

    public boolean equalsTo(Length anotherLength) {
        final Length length = convertTo(anotherLength.unit);
        return anotherLength.getValue() == length.getValue() && anotherLength.unit == length.getUnit();
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public Length convertTo(LengthUnit lengthUnit) {
        final int rate = LengthUnit.convert(unit, lengthUnit);

        return new Length(value * rate, lengthUnit);
    }

}
