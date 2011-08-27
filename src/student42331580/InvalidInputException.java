package student42331580;
import java.lang.Exception;

public class InvalidInputException extends Exception{

    public InvalidInputException(int LineNumber) {
        System.err.println("Command on line "+LineNumber+" is not well formed.");
    }

}
