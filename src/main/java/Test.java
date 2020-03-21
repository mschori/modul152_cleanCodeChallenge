import Exceptions.NoValidCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    private CommandEvaluator commandEvaluator;
    private Canvas canvas;

    public static void main(String[] args) throws IOException {

        Test drawingMachine = new Test();
        drawingMachine.commandEvaluator = new CommandEvaluator();

        System.out.println("Welcome to little-canvas.");
        System.out.println("What do you want to do?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("Type command: ");
            String line = reader.readLine();

            try {
                Integer command = drawingMachine.commandEvaluator.readCommand(line);
                if (command == 5){
                    break;
                }
            } catch (NoValidCommand e) {
                System.out.println("Failed!");
            }
        }

        System.out.println("Tschüss!");
    }

}
