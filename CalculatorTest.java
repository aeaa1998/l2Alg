

import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest implements iCalculator {
    private ScriptEngineManager manager = new ScriptEngineManager();
    private StacksFactory<Integer> factory;
    private ScriptEngine engine = manager.getEngineByName("js");
    private boolean broke = false;
    private iStack<Integer> temporalStack;
    private ArrayList<String> validOperators = new ArrayList<>();
    private ArrayList<String> values = new ArrayList<>();

    @Override
    public void init() {

    }
    @Test
    private void fillStack(String text){
        try {
            var c =Calculator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            c.length();
            var mainPath = Calculator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            if (getOsName().startsWith("Windows")){
                if(String.valueOf(mainPath.charAt(0)).equals("/")) { mainPath = mainPath.substring(1, mainPath.length());}
            }
            List<String> strings = Files.readAllLines(Path.of(mainPath + text));
            for (String line:
                    strings) {
                values.addAll(Arrays.asList(line.split(" ")));
            }
        } catch(URISyntaxException | IOException e){
            broke = true;
            System.out.print(e);
            System.out.println("Revise bien que su archivo txt  exista");
        }
    }
    @Test
    private void doOperation() throws ScriptException {
        for (int i = 0; i < values.size(); i++) {
            if (!isInt(values.get(i))){
                manageOperator(values.get(i));
            }
            if (broke){
                return;
            }
        }
    }
    @Test
    private boolean isInt(String value){
        try {
            int element = Integer.parseInt(value);
            temporalStack.push(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Test
    private void manageOperator(String operator) throws ScriptException {
        if (validOperators.contains(operator)){
            if (temporalStack.size() >= 2) {
                int b = temporalStack.pop();
                int a = temporalStack.pop();
                if (b == 0 && operator.equalsIgnoreCase("/")) {
                    System.out.println("Syntax Error");
                    broke = true;
                }else{
                    int result = (Integer) engine.eval(a + " " + operator + " " + b);
                    temporalStack.push(result);
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

    private  String getOsName()
    {
        return System.getProperty("os.name");
    }


}