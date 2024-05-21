package com.example;


import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TArbolTrieTest {

    TArbolTrie arbolTrie = new TArbolTrie();


    @Test
    void predecirTestPrefijoIgualPalabra() {
        arbolTrie.insertar("programa");
        arbolTrie.insertar("programar");
        arbolTrie.insertar("programacion");
        LinkedList<String> input = arbolTrie.predecir("programa");

        LinkedList<String> output = new LinkedList<String>();
        String programa = "programa";
        String programar = "programar";
        String programacion = "programacion";
        output.add(programa);
        output.add(programacion);
        output.add(programar);

        assertEquals (input, output);
    }

    @Test
    void predecirTestPrefijoVacio() {
        arbolTrie.insertar("programa");
        arbolTrie.insertar("programar");
        arbolTrie.insertar("programacion");
        LinkedList<String> input = arbolTrie.predecir("");

        LinkedList<String> output = new LinkedList<String>();

        assertEquals (input, output);
    }

    @Test
    void predecirTestPrefijo(){
        arbolTrie.insertar("programa");
        arbolTrie.insertar("programar");
        arbolTrie.insertar("programacion");
        LinkedList<String> input = arbolTrie.predecir("pro");

        LinkedList<String> output = new LinkedList<String>();
        String programa = "programa";
        String programar = "programar";
        String programacion = "programacion";
        output.add(programa);
        output.add(programacion);
        output.add(programar);

        assertEquals (input, output);

    }

}
