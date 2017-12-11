import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;

public class ManagePropBoxTest {
    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    @Test
    public void display() throws Exception {
        ManagePropBox test = new ManagePropBox();
        int[] value = {};
        Railroad prop1 = new Railroad(3,value);
        BasicProp prop2 = new BasicProp(value,"blue",3,3,value);
        assertEquals(value.getClass(),test.display("Yoghurt",prop1).getClass());
        assertEquals(value.getClass(),test.display("Yoghurt",prop2).getClass());
    }

}