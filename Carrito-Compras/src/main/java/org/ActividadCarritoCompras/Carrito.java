package org.ActividadCarritoCompras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Carrito<T extends Producto> implements Iterable<T>{

    private final   String nombre;
    private final List<T> listaProductos;

    public Carrito(String nombre) {
        this.nombre = nombre;
        listaProductos = new ArrayList<>();
    }

    public Collection<T> getListaProductos() {
        return Collections.unmodifiableCollection(listaProductos);
    }

    public void agregarProducto(T producto) {
        listaProductos.add(producto);
    }

    public T obtenerProductoMayorPrecio() {

        if (listaProductos.isEmpty()) {
            return null;
        }

        T mayor = listaProductos.get(0);

        for (T producto : listaProductos) {
            if (producto.getPrecio() > mayor.getPrecio()) {
                mayor = producto;
            }
        }

        return mayor;
    }

    public double calcularTotal() {
        double total = 0;

        for (T producto : listaProductos) {
            total += producto.getPrecio();
        }

        return total;
    }

    public void mostrarProductos() {

        for (T producto : listaProductos) {
            System.out.println(producto);
        }
    }

    @Override
    public CarritoIterator<T> iterator() {
        return new CarritoIterator<>(listaProductos);
    }
}