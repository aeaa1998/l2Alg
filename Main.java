import javax.script.ScriptException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        View v = new View();
        StacksFactory<Integer> factory = new StacksFactory<>(v);
        iCalculator calc = new Calculator(factory);
        calc.init();
    }
}
