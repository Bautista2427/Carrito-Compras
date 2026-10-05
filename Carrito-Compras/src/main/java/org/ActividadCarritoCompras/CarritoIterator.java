package org.ActividadCarritoCompras;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CarritoIterator<T extends Producto> implements Iterator<T> {

    int indice = 0;
    List<T> lista;

    public CarritoIterator(List<T> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return indice < lista.size();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException("NO hay elementos");
        }
        T t = lista.get(indice);
        indice++;
        return t;
    }

    public void recorrerPorPrecio(double precioMinimo) {
        for(T producto : lista) {
            if(producto.getPrecio() >= precioMinimo) {
                System.out.println(producto);
            }
        }
    }
}