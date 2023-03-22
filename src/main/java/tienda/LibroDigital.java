/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author alejandro
 */
public final class LibroDigital extends Libro implements SeDescarga {
    
    private int numKBytes;

    public LibroDigital(int numKBytes, String isbn, int codigo, double precio, double iva, String descripcion) {
        super(isbn, codigo, precio, iva, descripcion);
        this.numKBytes = numKBytes;
    }

    public int getNumKBytes() {
        return numKBytes;
    }

    public void setNumKBytes(int numKBytes) {
        this.numKBytes = numKBytes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LibroDigital{");
        sb.append("numKBytes=").append(numKBytes);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void descargar() {
        System.out.println("http://alejandro.daw/" + hashCode());
    }
}
