/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachine;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Orlan
 */
public class TuringMachine {
private Map<StateSymbolPair, Transition> reglas;// Reglas de transición
    private String estadoActual;  // Estado actual
    private String cinta;  // Cinta de entrada
    private int posicionInicial;  // Posición de la cabeza de lectura/escritura en la cinta
    
     /**
     * Constructor de la máquina de Turing.
     * @param rules Reglas de transición de la máquina.
     * @param initialState Estado inicial de la máquina.
     * @param input Entrada de la máquina.
     */

    public TuringMachine(Map<StateSymbolPair, Transition> rules, String initialState, String input) {
        this.reglas = rules;
        this.estadoActual = initialState;
        this.cinta = input;
        this.posicionInicial = 0;
    }
    
    /**
     * Realiza un paso de la máquina de Turing.
     */
    
    public void step() {
        char currentSymbol = cinta.charAt(posicionInicial);
        StateSymbolPair stateSymbolPair = new StateSymbolPair(estadoActual, currentSymbol);

        if (!reglas.containsKey(stateSymbolPair)) {
            estadoActual = "Estado rechazado";
            return;
        }

        Transition transition = reglas.get(stateSymbolPair);
        StringBuilder tapeBuilder = new StringBuilder(cinta);
        tapeBuilder.setCharAt(posicionInicial, transition.getWriteSymbol());
        cinta = tapeBuilder.toString();

        if (transition.getMoveDirection() == 'L') {
            posicionInicial--;
            if (posicionInicial < 0) {
                cinta = "B" + cinta;
                posicionInicial = 0;
            }
        } else if (transition.getMoveDirection() == 'R') {
            posicionInicial++;
            if (posicionInicial >= cinta.length()) {
                cinta += "B";
            }
        }

        estadoActual = transition.getNextState();
    }
    
    /**
     * Ejecuta la máquina de Turing hasta alcanzar un estado de aceptación o rechazo.
     */
    
    public void run() {
        while (!estadoActual.equals("Aceptando estado") && !estadoActual.equals("Estado rechazado")) {
            step();
        }

        if (estadoActual.equals("Estado aceptado")) {
            System.out.println("Rechazado");
        } else {
            System.out.println("Aceptado");
        }
    }

 public static void main(String[] args) {
    Map<StateSymbolPair, Transition> rules = new HashMap<>();
    rules.put(new StateSymbolPair("q0", '0'), new Transition('1', 'R', "q1"));
    rules.put(new StateSymbolPair("q0", '1'), new Transition('0', 'R', "q0"));
    rules.put(new StateSymbolPair("q1", '0'), new Transition('1', 'R', "q1"));
    rules.put(new StateSymbolPair("q1", '1'), new Transition('1', 'R', "q1"));
    rules.put(new StateSymbolPair("q1", 'B'), new Transition('B', 'L', "q2"));

    TuringMachine tm = new TuringMachine(rules, "q0", "010101");
    tm.run();
}


}   
