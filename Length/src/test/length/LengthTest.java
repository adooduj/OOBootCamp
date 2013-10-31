package length;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LengthTest {

    @Test
    public void should_add_by_self() throws Exception {

        Length length = new Length(0, LengthUnit.M);

        Length calculatedLength = length.add(length).minus(length);

        assertThat(calculatedLength.getValue(), is(length.getValue()));

    }

    @Test
    public void should_1m_equals_1m() throws Exception {
        Length length = new Length(1, LengthUnit.M);
        Length length2 = new Length(1, LengthUnit.M);

        assertTrue(length.equalsTo(length2));
    }

    @Test
    public void should_100cm_equals_100cm() throws Exception {
        Length length = new Length(100, LengthUnit.CM);
        Length length2 = new Length(100, LengthUnit.CM);

        assertTrue(length.equalsTo(length2));
    }

    @Test
    public void should_10mm_equals_10mm() throws Exception {
        Length length = new Length(10, LengthUnit.MM);
        Length length2 = new Length(10, LengthUnit.MM);

        assertTrue(length.equalsTo(length2));
    }

    @Test
    public void should_convert_1m_to_100cm1() throws Exception {
        Length lengthM = new Length(1, LengthUnit.M);
        Length lengthCM = lengthM.convertTo(LengthUnit.CM);

        Length length2 = new Length(100, LengthUnit.CM);
        assertTrue(lengthCM.equalsTo(length2));
    }

    @Test
    public void should_convert_1m_to_100cm() throws Exception {
        Length lengthM = new Length(1, LengthUnit.M);
        Length lengthCM = new Length(100, LengthUnit.CM);

        assertTrue(lengthM.equalsTo(lengthCM));
    }


}
