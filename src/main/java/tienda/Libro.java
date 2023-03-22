/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

import java.util.Objects;

/**
 *
 * @author alejandro
 */
public abstract class Libro extends Producto implements Comparable<Libro>{
    
    private String isbn;

    public Libro(String isbn, int codigo, double precio, double iva, String descripcion) {
        super(codigo, precio, iva, descripcion);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", isbn=").append(isbn);
        sb.append(", ");
        sb.append(super.toString());
        return sb.toString();
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        final Libro other = (Libro) obj;
        return this.isbn == other.isbn;
    }

    @Override
    public int compareTo(Libro o) {
        return this.isbn.compareToIgnoreCase(o.isbn);
    }
    
    public abstract void tipoLibro();
}
