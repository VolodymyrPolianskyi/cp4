package pl.vpolianskyi.hello;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HelloTest {
    @Test
    void myFirstTest(){
        int a = 2 ;
        int b = 4 ;
        int result = a + b;

        assert 6 == result;
    }

    @Test
    void assertions(){
        assertTrue(false ,"Bruh");
    }
}
