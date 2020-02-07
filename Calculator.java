

public class Calculator implements iCalculator {
    /**
     * @author Augusto Alonso 181085 y David Cuellar 18382

     */
    /**
     * @param a primer numero a operar
     * @param b segundo numero a operar
     * @return los numeros sumados
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    /**
     * @param a primer numero a operar
     * @param b segundo numero a operar
     * @return los numeros restados
     */

    public int restar(int a, int b) {
        return a - b;
    }
    /**
     * @param a primer numero a operar
     * @param b segundo numero a operar
     * @return los numeros divididos
     */

    public int dividir(int a, int b) {
        return a/b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

}
