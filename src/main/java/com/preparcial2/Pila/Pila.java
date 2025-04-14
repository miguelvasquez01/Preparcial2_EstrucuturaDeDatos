package com.preparcial2.Pila;

import com.preparcial2.Persona;
import com.preparcial2.ListaEnlazadaSimple.ListaSimple;

public class Pila <T> {

    private Nodo<T> cima;
    private int tamano;

    //Último punto en la clase App

    //5. Método para retornar si una expresión esta balanceada
    public static boolean esBalanceada(String exp) {

        Pila<Character> pila = new Pila<>();

        StringBuilder sb = new StringBuilder(exp);//Primero convierto la exp en pila
        for (int i = 0; i < sb.length(); i++) {

            pila.push(sb.charAt(i));
        }

        int expCont = 0;
        while (!pila.esVacia()) {
            
            Character expActual = pila.pop();
            if (expActual == '(' || expActual == '{' || expActual == '[') {

                expCont += 1;
            } else if (expActual == ')' || expActual == '}' || expActual == ']') {

                expCont -= 1;
            }
        }
        return expCont == 0;
    }

    //4. Método para convertir de entero a binario (no tiene que ver directamente con esta clase)
    public static Long enteroABinario(Long num, Pila<Long> pila) {
        
        if (num == 0) return pilaAEntero(pila);

        if (num % 2 == 0) {

            pila.push((long)0);
            return enteroABinario(num/2, pila);
        } else {
            pila.push((long)1);
            return enteroABinario(num/2, pila);
        }
    }
    public static Long pilaAEntero(Pila<Long> pila) {

        StringBuilder sb = new StringBuilder();

        while (!pila.esVacia()) {
            
            sb.append(pila.pop());
        }
        return Long.parseLong(sb.toString());
    }

    //3. Método para filtrar personas entre 30 y 50 años, devuelve el orden original
    public Pila<Persona> filtrarPersonas() {

        Pila<Persona> pilaFinal = new Pila<>();

        @SuppressWarnings("unchecked")
        Nodo<Persona> nodoRecorrer = (Nodo<Persona>) cima;
        while (nodoRecorrer != null) {
            
            Persona p = nodoRecorrer.getValor();
            if (p.getEdad() >= 30 && p.getEdad() <= 50) {

                pilaFinal.push(p);
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }
        return pilaFinal.invertirPila(); //Devuelve el orden original
    }

    //2. Método para retornas los números primos de una pila
    public Pila<Long> pilaPrimos() {

        Pila<Long> pilaFinal = new Pila<>();
        
        @SuppressWarnings("unchecked")
        Nodo<Long> nodoRecorrer = (Nodo<Long>) cima;
        while (nodoRecorrer != null) {
            
            Long num = nodoRecorrer.getValor();
            nodoRecorrer = nodoRecorrer.getSiguiente();
            if (num == 1) continue;
            if (num == 2) {
                pilaFinal.push(num);
                continue;
            }
                if (num % 2 == 0) continue;

            boolean esPrimo = true;
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if(esPrimo) pilaFinal.push(num);
        }
        return pilaFinal;
    }

    //1. Retornar una lista simple invertida
    public static ListaSimple<Long> invertirListaSimple(ListaSimple<Long> lista) {

        Pila<Long> pila = new Pila<>();
        ListaSimple<Long> listaInvertida = new ListaSimple<>();

        //Para evitar confusiones entre los dos tipos de nodos (Pila y ListaSimple)
        com.preparcial2.ListaEnlazadaSimple.Nodo<Long> nodoRecorrer = lista.getInicial();

        while (nodoRecorrer != null) { //Primero pasamos la lista a una pila
            
            pila.push(nodoRecorrer.getValor());
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }

        while(!pila.esVacia()) { //Luego se invierte gracias a la pila
            listaInvertida.agregarFinal(pila.pop());
        }
        return listaInvertida;
    }

    public Pila<T> invertirPila() {

        Pila<T> pilaInvert = new Pila<>();
        while (!esVacia()) {
            pilaInvert.push(this.pop()); //Vacía la pila original
        }
        return pilaInvert;
    }

    public void push(T value) {

        Nodo<T> nodo = new Nodo<T>(value);

        nodo.setSiguiente(cima);
        cima = nodo;
        tamano ++;
    }

    public T pop() {

        if (esVacia()) return null;

        T value = cima.getValor();
        cima = cima.getSiguiente();
        tamano --;
        return value;
    }

    public void imprimir() {
        Nodo<T> aux = cima;
        while(aux!=null) {
            System.out.print(aux.getValor()+"\t");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    public boolean esVacia() {
        return cima == null;
    }
}
