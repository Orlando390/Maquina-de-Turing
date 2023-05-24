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
public class StateSymbolPair {
   private String estado;
    private char simbolo;

    public StateSymbolPair(String state, char symbol) {
        this.estado = state;
        this.simbolo = symbol;
    }

    @Override
    public int hashCode() {
        int result = estado != null ? estado.hashCode() : 0;
        result = 31 * result + simbolo;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateSymbolPair that = (StateSymbolPair) o;

        if (simbolo != that.simbolo) return false;
        return estado != null ? estado.equals(that.estado) : that.estado == null;
    }
}

