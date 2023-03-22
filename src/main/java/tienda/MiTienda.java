/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author alejandro
 */
public class MiTienda {
    private List<Producto> listaProductos;

    public MiTienda(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }    

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    
    public static void main(String[] args) {
        //Crea una lista de productos y añade dos objetos de 
        //cada tipo de producto distinto (de los posibles) a la misma.
        //Música
        Producto musica1 = new Musica("Beatles", 11, 20.99, 0.21, 
                "Disco del mítico grupo Beatles");
        Producto musica2 = new Musica("Kiss", 12, 10.20, 0.1, 
                "Disco del famoso grupo Kiss");
        //Libros de papel
        Producto libPap1 = new LibroPapel(365, "754p",211, 15.5, 0.15, 
        "Libro del famoso autor Cervantes");
        Producto libPap2 = new LibroPapel(251, "953p", 212, 10.5, 0.15, 
                "Libro de autoayuda");
        //Libros digitales
        Producto libDig1 = new LibroDigital(200, "256d", 221, 5.99, 0.17, 
                "Libro para aprender a programar");
        Producto libDig2 = new LibroDigital(345, "635d", 222, 6.75, 0.14, 
                "Libro de fantasía");
        //Pantalones
        Producto pan1 = new Pantalon("M", "Adidas", 31, 25.99, 0.21, 
        "Pantalón deportivo");
        Producto pan2 = new Pantalon("XL", "Springfield", 32, 33.5, 0.21, 
        "Pantalón vaquero de la marca Springfield");
        
        //Al introducir los datos en la lista se realiza conversiones implícitas
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(musica1);
        listaProductos.add(musica2);
        listaProductos.add(libPap1);
        listaProductos.add(libPap2);
        listaProductos.add(libDig1);
        listaProductos.add(libDig2);
        listaProductos.add(pan1);
        listaProductos.add(pan2);
        
        //Muestra los datos de los productos usando un foreach.
        System.out.println("Muestro los productos de la lista---------------------------------------------------------------");
        listaProductos.forEach(System.out::println);
        
        //Ordena la lista de productos según el precio, haciendo uso de <<Comparator>> 
        //y una expresión lambda. Muestra la lista de productos ordenados por precio.
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Muestro los productos de la lista ordenados por precio---------------------------------");
        Comparator<Producto> porPrecio = (p1, p2)->Double.compare(p1.getPrecio(), p2.getPrecio());
        Collections.sort(listaProductos, porPrecio);
        listaProductos.forEach(System.out::println);
        
        //Ordena la lista de productos según el código, haciendo uso de <<Comparator>> 
        //y una expresión lambda. Muestra la lista de productos ordenados por código.
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Muestro los productos de la lista ordenados por el código-----------------------------");
        Comparator<Producto> porCodigo = (p1,p2)->Integer.compare(p1.getCodigo(), p2.getCodigo());
        Collections.sort(listaProductos, porCodigo);
        listaProductos.forEach(System.out::println);
        
        //Realiza la búsqueda binaria, según su código, de algún producto que exista dentro 
        //de la lista y otro que no exista, mostrando la posición que ocupa en la lista.
        int posicion = Collections.binarySearch(listaProductos, pan1, porCodigo);
        System.out.println("El producto pan1 está en la posición: " + posicion);
        Producto aux = new Musica("Noseque", 13, 5.99, 0.15, "no se cuantos");
        posicion = Collections.binarySearch(listaProductos, aux, porCodigo);
        System.out.println("El producto aux (que no está en la lista) está en la posición: " + posicion);
        
        //Recorre la lista de productos y guarda todos los libros en una lista de libros.
        List<Libro> listaLibros = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto instanceof Libro) {
                listaLibros.add((Libro) producto); //Conversión explícita
            }
        }
        
        //Muestra los datos de la lista de libros usando un objeto Iterator.
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Muestro los libros almacenados en la lista de libros con un iterador-----------------");
        Iterator<Libro> it = listaLibros.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        
        //Ordena los libros según ISBN, haciendo uso de <<Comparable>>. Muestra la lista 
        //de libros ordenada. 
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Muestro los libros ordenados por el isbn-----------------------------------------------------");
        Collections.sort(listaLibros);
        listaLibros.forEach(System.out::println);
        
        //Recorre de nuevo la lista de libros y en cada iteración, ejecuta enviar() o descargar() 
        //en función del tipo de libro.
         System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Ejecuto los métodos enviar() o descargar()-------------------------------------------------");
        String direccion = "Calle nosecuantos nº5";
        for (Libro libro : listaLibros) {
            if (libro instanceof LibroPapel) {
                ((LibroPapel) libro).enviar(direccion); //Conversión explícita
            } else if (libro instanceof LibroDigital){
                ((LibroDigital) libro).descargar(); //Conversión explícita
            }
        }
        
        //Utiliza el método contains(Object) sobre la lista de libros para comprobar si existe un 
        //libro o no existe.
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("¿El libro dígtal libDig2 existe en la lista?: " + listaLibros.contains(libDig2));
        
        //Usando la lista de productos inicial, crea una nueva lista con todos los 
        //objetos que SeEnvian.
        List<SeEnvia> listaSeEnvian = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto instanceof SeEnvia) {
                listaSeEnvian.add((SeEnvia) producto);
            }
        }
        //listaSeEnvian.forEach(System.out::println);
        
        //Recorre la lista de objetos que Se Envian y llama al método de la interfaz.
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Recorrer la lista SeEnvian mientras se llama al método----------------------------------");
        for (SeEnvia seEnvia : listaSeEnvian) {
            seEnvia.enviar(direccion);
        }
        
        //Inventa un método abstracto en Libro que tenga comportamientos diferentes en 
        //las subclases. Implementa los métodos en las clases hijas.
        System.out.println("\n-----------------------------------------------------------------------------\n");
        System.out.println("Recorrer la lista de libros mientras se llama al método abstracto de Libro-------------");
        for (Libro libro : listaLibros) {
            libro.tipoLibro();
        }
    }
}
