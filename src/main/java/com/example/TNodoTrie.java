package com.example;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    public boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (indice>=0 && indice<=26){
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new TNodoTrie();
                }
                nodo = nodo.hijos[indice];
            }
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    public TNodoTrie buscarNodoTrie(String s) {
        //devuelve el nodo que busco, mismo que sea o no palabra.
        boolean hayUno = false;
        TNodoTrie nodoActual = this;
        TNodoTrie unHijo = null;

        for (char car : s.toCharArray()) {
            int indice = this.obtenerHijos(car);
            if (indice>=0 && indice<=26){
                unHijo = nodoActual.hijos[indice];

                if (unHijo == null) {
                    //devolver nulo porque no existe el caracter como hijo del nodo actual
                    return null;

                } else {
                    nodoActual = unHijo;
                }
                hayUno = true;
            }
        }

        //que devuelve hasta donde encontro
        if (hayUno) {
            return nodoActual;
        }

        return null;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        // implementar

        //buscar el prefijo y si tiene hijos, y el arreglo no es vacio, entonces seguir buscando
        //TNodoTrie nodo2 = this.buscarNodoTrie(prefijo);
        if (nodo != null) {
            //visitar todos los hijos y imprimir los que sean palabras, y los que sean
            for (int c = 0; c < nodo.hijos.length; c++) {

                if (nodo.hijos[c] != null) {
                    s = prefijo + (char) (c + 'a');
                    if (nodo.hijos[c].esPalabra) {
                        //palabras.add(prefijo + (char) (c + 'a'));
                        palabras.add(s);
                    }
                    //System.out.println(s);
                    //hijos[c].imprimir();
                    predecir(s, s, palabras, nodo.hijos[c]);

                }

            }

        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        if (this != null) {
            TNodoTrie nodo2 = this.buscarNodoTrie(prefijo);
            predecir("", prefijo, palabras, nodo2);
        }
    }

    @Override
    public int buscar(String s) {
        int comparaciones = 0;
        TNodoTrie nodoActual = this;
        TNodoTrie unHijo = null;

        for (char car : s.toCharArray()) {

            unHijo = nodoActual.hijos[this.obtenerHijos(car)];

            if (unHijo == null) {
                //salir del for
                return 0;

            } else {
                nodoActual = unHijo;
            }
            comparaciones++;
        }

        if (nodoActual.esPalabra) {
            return comparaciones;
        }

        return 0;
    }

    private int obtenerHijos(char car) {
        int indice = car - 'a';
        return indice;
    }

}
