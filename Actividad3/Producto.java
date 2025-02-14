/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.producto;
import java.util.Scanner;

/**
 *
 * @author 52562
 */
public class Producto {
    private String descripcion;
    private String codigo;
    private String tipo;
    private double costo;
    private double impuesto;

    public Producto() {}

    public String getDescripcion() { return descripcion; }
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public double getCosto() { return costo; }
    public double getImpuesto() { return impuesto; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCosto(double costo) { this.costo = costo; }
    public void setImpuesto(double impuesto) { this.impuesto = impuesto; }

    public void muestraProducto() {
        System.out.println("Descripción: " + descripcion);
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Costo: $" + costo);
        System.out.println("Impuesto: " + impuesto + "%");
    }

    public double calcularPrecio(double utilidad) {
        double precioAntesDeImpuestos = costo + (costo * utilidad / 100);
        double precioFinal = precioAntesDeImpuestos + (precioAntesDeImpuestos * impuesto / 100);
        return precioFinal;
    }

    public static String compararProductos(Producto p1, Producto p2, double utilidad) {
        double precio1 = p1.calcularPrecio(utilidad);
        double precio2 = p2.calcularPrecio(utilidad);

        if (precio1 > precio2) {
            return "El producto con mayor precio es: " + p1.getDescripcion();
        } else if (precio2 > precio1) {
            return "El producto con mayor precio es: " + p2.getDescripcion();
        } else {
            return "Ambos productos tienen el mismo precio.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        
        try {
            System.out.println("Ingrese los datos del primer producto:");
            System.out.print("Descripción: ");
            producto1.setDescripcion(scanner.nextLine());
            System.out.print("Código: ");
            producto1.setCodigo(scanner.nextLine());
            System.out.print("Tipo: ");
            producto1.setTipo(scanner.nextLine());
            System.out.print("Costo: ");
            producto1.setCosto(Double.parseDouble(scanner.nextLine()));
            System.out.print("Impuesto (%): ");
            producto1.setImpuesto(Double.parseDouble(scanner.nextLine()));

            System.out.println("\nIngrese los datos del segundo producto:");
            System.out.print("Descripción: ");
            producto2.setDescripcion(scanner.nextLine());
            System.out.print("Código: ");
            producto2.setCodigo(scanner.nextLine());
            System.out.print("Tipo: ");
            producto2.setTipo(scanner.nextLine());
            System.out.print("Costo: ");
            producto2.setCosto(Double.parseDouble(scanner.nextLine()));
            System.out.print("Impuesto (%): ");
            producto2.setImpuesto(Double.parseDouble(scanner.nextLine()));

            System.out.println("\nDatos del primer producto:");
            producto1.muestraProducto();

            System.out.println("\nDatos del segundo producto:");
            producto2.muestraProducto();

            System.out.print("\nIngrese el porcentaje de utilidad para la comparación: ");
            double utilidad = Double.parseDouble(scanner.nextLine());

            String resultadoComparacion = Producto.compararProductos(producto1, producto2, utilidad);
            System.out.println("\n" + resultadoComparacion);

        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida. Asegúrese de ingresar valores numéricos donde corresponda.");
        } finally {
            scanner.close();
        }
    }
}


    
    
