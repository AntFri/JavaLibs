package com.antoniofrische.holaandroid.Libs;

public class BomboAutonumerico {
    private final int[] array;
    private int validos;
    private int indice;

    public BomboAutonumerico(int cantidadElementos, int valorMinimo) {
        indice = 0;
        array = new int[cantidadElementos];
        for(int i = 0; i < array.length; i++) {
            array[i] = valorMinimo;
            valorMinimo++;
        }
        validos = cantidadElementos - 1;
    }

    public int extraerNum() {
        if(validos >= 0) {
            indice++;
            int numero = array[indice];
            array[indice] = array[validos];
            array[validos] = numero;
            validos--;
            return numero;
        }
        return Integer.MIN_VALUE;
    }

    public void reset() {
        validos = array.length - 1;
    }
}
