package com.preparcial2.ListaEnlazadaSimple;

public class ListaSimple <T> {
    
    private Nodo<T> inicial;
    private int tamano = 0;

    public void eliminar(T value) {
        
        if (inicial == null) {
            System.out.println("Lista vacía");
            return;
        }

        //if si voy a eliminar el primer elemento
        if (inicial.getValor().equals(value)) {
            inicial = inicial.getSiguiente();
            return;
        }

        Nodo<T> nodoRecorrer = inicial;
        while (nodoRecorrer.getSiguiente() != null) {

            if (nodoRecorrer.getSiguiente().getValor().equals(value)) {
                nodoRecorrer.setSiguiente(nodoRecorrer.getSiguiente().getSiguiente());
                return;
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();//Establezco el último como null
        }
    }

    public void agregarFinal(T valor) {

        Nodo<T> nodo = new Nodo<T>(valor);

        if (inicial == null) {  
            inicial = nodo;
        } else {

            Nodo<T> nodoRecorrer = inicial;
            while (nodoRecorrer.getSiguiente() != null) {

                nodoRecorrer = nodoRecorrer.getSiguiente();
            }
            nodoRecorrer.setSiguiente(nodo);
        }
        tamano +=1;
    }

    public void agregarInicio(T valor) {

        Nodo<T> nodo = new Nodo<T>(valor);

        if (inicial == null) {
            inicial = nodo;
        } else {

            nodo.setSiguiente(inicial);
            inicial = nodo;
        }
        tamano += 1;
    }

    public void mostrarLista() {

        if (inicial == null) {
            System.out.println("Lista vacía");
        }

        Nodo<T> nodoRecorrer = inicial;
        do {

            System.out.print(nodoRecorrer.getValor() + ", ");
            nodoRecorrer = nodoRecorrer.getSiguiente();

        } while (nodoRecorrer != null);
    }

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
