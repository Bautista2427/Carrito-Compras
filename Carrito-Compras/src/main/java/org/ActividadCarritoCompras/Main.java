package org.ActividadCarritoCompras;

public class Main {
    public static void main(String[] args) {
        Carrito<Producto> carrito = new Carrito<>("Carrito NOLEN");

        Producto producto1 = new Tecnologia("Teclado Ajazz", 120000);
        Producto producto2 = new Tecnologia("JBL Boombox 4", 1900000);
        Producto producto3 = new Gafas("Viola Mag", 50000);
        Producto producto4 = new Moto("Espejos aleron", 60000);
        Producto producto5 = new Perfumeria("Creed Silver", 85000);

        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);
        carrito.agregarProducto(producto4);
        carrito.agregarProducto(producto5);


        System.out.println("=== PRODUCTOS DEL CARRITO ===");
        carrito.mostrarProductos();

        Producto mayor = carrito.obtenerProductoMayorPrecio();

        System.out.println("\n=== PRODUCTO MÁS CARO ===");
        System.out.println(mayor);

        System.out.println("\n=== PRECIO TOTAL ===");
        System.out.println("$" + carrito.calcularTotal());

        CarritoIterator<Producto> carritoIterator = carrito.iterator();

        while(carritoIterator.hasNext()){
            Producto producto = carritoIterator.next();
            System.out.println(producto);
        }

        System.out.println("\n=== RECORRIDO POR PRECIO ===");

        carritoIterator.recorrerPorPrecio(100000);
    }
}
