
/**
 * @author Augusto Alonso 181085 y David Cuellar 18382

 */
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    private static  boolean broke = false;
    //Se un arraylist para agregar los operadores que son validos
    private static ArrayList<String> validOperators = new ArrayList<>();
    //Se crea el stack donde se haran todas las operaciones
    private static  Stack<Integer> temporalStack = new Stack<>();
    public static void main(String[] args) throws IOException, URISyntaxException {
        Calculator calc = new Calculator();
        validOperators.add("+");
        validOperators.add("-");
        validOperators.add("/");
        validOperators.add("*");
        //Se lee el archivo encontrado el path del codigo
        List<String> strings = Files.readAllLines(Path.of(Calculator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "datos.txt"));
        //Se crea arraylist donde se anade el contenido del documento
        ArrayList<String> values = new ArrayList<>();
        //Se recorre todo el documento y se agrega al arraylist
        for (String line:
                strings) {
            values.addAll(Arrays.asList(line.split(" ")));
        }
        //Se ejecutan todas las operaciones del stack recorriendo el arraylist utilizando
        //los metodos debajo  definidos
        for (int i = 0; i < values.size(); i++) {
            if (!isInt(values.get(i))){
                manageOperator(values.get(i), calc);
            }
            if (broke){
                return;
            }
        }
        if (!broke && temporalStack.size() == 1){
            System.out.println("El resultado final es: " + temporalStack.pop());
        }else if(!broke){
            System.out.println("No hubo suficientes operadores para realizar la operaciones");
        }

    }

    /**
     *
     * @param value recibe un string para ver si es un operador o numero
     * @return se retorna true si es elemento y se mete al stack
     */
    public static boolean isInt(String value){
        try {
            int element = Integer.parseInt(value);
            temporalStack.push(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *
     * @param operator se recibe un string para saber que operacion realizar
     * @param calc se usa para invocar los metodos de la clase calculadora
     */
    public static  void manageOperator(String operator, Calculator calc) {
        if (validOperators.contains(operator)){
            if (temporalStack.size() >= 2) {
                int b = temporalStack.pop();
                int a = temporalStack.pop();
                if (operator.equalsIgnoreCase("+")){
                    int sum = calc.sumar(b, a);
                    temporalStack.push(sum);
                }else if(operator.equalsIgnoreCase("-")){
                    temporalStack.push(calc.restar(a, b));
                }else if (operator.equalsIgnoreCase("/")){
                    temporalStack.push(calc.dividir(a, b));
                }else {
                    temporalStack.push(calc.multiplicar(a, b));
                }
            }else{
                System.out.println("Ha ingresado un mas operadores de los validos ");
                broke = true;
            }
        }else{
            System.out.println("Ha ingresado un valor invalido " + operator);
            broke = true;
        }
    }
}
