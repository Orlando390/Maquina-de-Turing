/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turingmachine;

/**
 *
 * @author Orlan
 */
public class Transition {
    private char escrituraSimbolo;
    private char mover;
    private String siguienteEstado;

    public Transition(char writeSymbol, char moveDirection, String nextState) {
        this.escrituraSimbolo = writeSymbol;
        this.mover = moveDirection;
        this.siguienteEstado = nextState;
    }

    public char getWriteSymbol() {
        return escrituraSimbolo;
    }

    public char getMoveDirection() {
        return mover;
    }

    public String getNextState() {
        return siguienteEstado;
    }
}