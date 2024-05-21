package com.example;

import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
        }
        trie.imprimir();

        System.out.println("--------------");
        LinkedList<String> lista = trie.predecir("programa");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

    }
}
