package com.example;

import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {

        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {

        LinkedList<String> lista = new LinkedList<String>();
        if (raiz != null) {
            TNodoTrie unPrefijo = raiz.buscarNodoTrie(prefijo);
            if (unPrefijo != null && unPrefijo.esPalabra){
                lista.add(prefijo);
            }
            raiz.predecir(prefijo, lista);
        }
        return lista;
    }

}
