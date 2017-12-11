package esof322.pa1;
import org.junit.*;
import static org.junit.Assert.*;

public class Vector3DTest {
    private Vector3D vec = new Vector3D(1.0, 1.0, 1.0);

    @Test
    public void testScale() throws Exception {
        Vector3D scale_vec = new Vector3D(2.0, 2.0, 2.0);
        assertTrue(vec.equals(scale_vec, vec.scale(2)));
    }

    @Test
    public void testAdd() throws Exception {
        Vector3D add_vec = new Vector3D(2.0, 2.0, 2.0);
        assertTrue(vec.equals(add_vec, vec.add(vec)));
    }

    @Test
    public void testSubtract() throws Exception {
        Vector3D subtract_vec = new Vector3D(0, 0, 0);
        assertTrue(vec.equals(subtract_vec, vec.subtract(vec)));
    }

    @Test
    public void testMagnitude() throws Exception {
        Vector3D v = new Vector3D(3.0, 4.0, 5.0);
        assertEquals(7.071, v.magnitude(), .1);
    }

    @Test
    public void testNegate() throws Exception {
        Vector3D a = new Vector3D(2.0, 2.0, 2.0);
        Vector3D control = new Vector3D(-2.0, -2.0, -2.0);
        assertTrue(vec.equals(control, a.negate()));
    }

    @Test
    public void testDot() throws Exception {
        Vector3D v = new Vector3D(2.0, 3.0, 4.0);
        Vector3D w = new Vector3D(4.0, 3.0, 3.0);
        assertEquals(8.0 + 9.0 + 12.0, v.dot(w), .1);
    }

    @Test
    public void testEquals() throws Exception {
        Vector3D v = new Vector3D(2.0 - 1.1, 2.0, 3.0);
        Vector3D w = new Vector3D(2.0 - 1.1, 2.0, 3.0);
        assertTrue(w.equals(v, w));
        Vector3D x = new Vector3D(2.01 - 1.1, 2.0, 3.0);
        Vector3D y = new Vector3D(2.0 - 1.1, 2.0, 3.0);
        assertFalse(w.equals(x, y));
        assertTrue(v.equals(v, v));
    }

    @Test
    public void testToString() throws Exception {
        String test = "[1.0, 1.0, 1.0]";
        Vector3D stringTest = new Vector3D(1.0, 1.0, 1.0);
        assertEquals(test, stringTest.toString(stringTest));
    }
}