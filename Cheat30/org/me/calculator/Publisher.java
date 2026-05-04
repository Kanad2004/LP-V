package org.me.calculator;
import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        String url = "http://localhost:8080/ws/calculator";
        System.out.println("Starting Web Service at: " + url);
        Endpoint.publish(url, new CalculatorWS());
        System.out.println("Server is running! Do not close this terminal.");
    }
}