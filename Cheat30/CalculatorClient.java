import org.me.calculator.CalculatorWS;
import org.me.calculator.CalculatorWS_Service;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorWS_Service service = new CalculatorWS_Service();
            CalculatorWS port = service.getCalculatorWSPort();
            int result = port.add(10, 20);
            System.out.println("Web Service Response: 10 + 20 = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}