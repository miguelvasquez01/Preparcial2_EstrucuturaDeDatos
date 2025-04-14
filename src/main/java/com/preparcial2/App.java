package com.preparcial2;

import com.preparcial2.ListaEnlazadaSimple.ListaSimple;
import com.preparcial2.ListaEnlazadaSimple.Nodo;
import com.preparcial2.Pila.Pila;

public class App 
{
    public static void main( String[] args )
    {
        //Punto 1:
        System.out.println("Punto 1:");
        ListaSimple<Long> listaS = new ListaSimple<>();
        listaS.agregarFinal((long)1);
        listaS.agregarFinal((long)2);
        listaS.agregarFinal((long)3);
        listaS.agregarFinal((long)4);
        listaS.mostrarLista();

        System.out.println("\nLista invertida:");
        ListaSimple<Long> listaInvert = Pila.invertirListaSimple(listaS);
        listaInvert.mostrarLista();

        //Punto 2:
        Pila<Long> pila = new Pila<>();
        pila.push((long) 2); pila.push((long) 4); pila.push((long) 7); pila.push((long) 1);
        pila.push((long) 3); pila.push((long) 15); pila.push((long) 17); pila.push((long) 11);

        System.out.println("\nPunto 2:");
        pila.pilaPrimos().imprimir();

        //Punto 3:
        Pila<Persona> pilaP = new Pila<>();
        Persona p1 = new Persona(null, (long)30, null);
        Persona p2 = new Persona(null, (long)23, null);
        Persona p3 = new Persona(null, (long)45, null);
        Persona p4 = new Persona(null, (long)34, null);
        Persona p5 = new Persona(null, (long)57, null);
        pilaP.push(p1); pilaP.push(p2); pilaP.push(p3); pilaP.push(p4); pilaP.push(p5);

        System.out.println("Punto 3:");
        pilaP.filtrarPersonas().imprimir();

        //Punto 4:
        System.out.println("Punto 4:");
        System.out.println(Pila.enteroABinario((long)61, new Pila<Long>()));

        //Punto 5:
        System.out.println("Punto 5:");
        System.out.println(Pila.esBalanceada("[(1+2)*4]+5"));

        //Último Punto:
        System.out.println("Último punto:");
        ListaSimple<Long> listaSimple = new ListaSimple<>();
        listaSimple.agregarFinal((long)1);
        listaSimple.agregarFinal((long)2);
        listaSimple.agregarFinal((long)3);
        listaSimple.agregarFinal((long)8);

        listaSimple.mostrarLista();
        insertarDos(listaSimple);
        System.out.println("\nDespues de la evalucación:");
        //Para este ejemplo añade dos veces dos a la lista
        //1+2 = 3
        //1+2+3+2 = 8
        listaSimple.mostrarLista();
    }

    //Último punto: Insertar el valor 2 despues de cierta suma
    public static void insertarDos(ListaSimple<Long> lista) {

        Long acum = (long)0;
        Nodo<Long> nodoRecorrer = lista.getInicial();
        while (nodoRecorrer != null) {
            
            if (nodoRecorrer.getValor() == acum) {

                Nodo<Long> dos = new Nodo<Long>((long)2);
                if (nodoRecorrer.getSiguiente() != null) dos.setSiguiente(nodoRecorrer.getSiguiente());
                nodoRecorrer.setSiguiente(dos);
            }
            acum += nodoRecorrer.getValor();
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }
    }
}
