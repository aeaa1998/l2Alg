
/**
 * @author Augusto Alonso 181085 y David Cuellar 18382

 */
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private Calculator calc = new Calculator();
    @org.junit.jupiter.api.Test
    void sumar() {
        assertEquals(1, calc.sumar(1,0));
    }

    @org.junit.jupiter.api.Test
    void restar() {
        assertEquals(1, calc.restar(1,0));
    }

    @org.junit.jupiter.api.Test
    void dividir() {
        assertEquals(1, calc.dividir(1,1));
    }

    @org.junit.jupiter.api.Test
    void multiplicar() {
        assertEquals(2, calc.multiplicar(1,2));
    }
    @org.junit.jupiter.api.Test
    void sumarFail() {
        assertEquals(2, calc.sumar(1,0));
    }

    @org.junit.jupiter.api.Test
    void restarFail() {
        assertEquals(2, calc.restar(1,0));
    }

    @org.junit.jupiter.api.Test
    void dividirFail() {
        assertEquals(2, calc.dividir(1,1));
    }

    @org.junit.jupiter.api.Test
    void multiplicarFail() {
        assertEquals(3, calc.multiplicar(1,2));
    }
}