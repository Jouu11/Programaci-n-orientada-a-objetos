/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controlescolar;

import java.util.List;

/**
 *
 * @author 52562
 */

class Profesor {
    private String nombre;
    private int numeroNomina;
    private double sueldoPorHora;
    private Materia materia;

    public Profesor() {}
    
    public Profesor(String nombre, int numeroNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre;
        this.numeroNomina = numeroNomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = materia;
    }
    
    public Profesor(Profesor otro) {
        this.nombre = otro.nombre;
        this.numeroNomina = otro.numeroNomina;
        this.sueldoPorHora = otro.sueldoPorHora;
        this.materia = otro.materia;
    }
    
    public double calcularSueldoSemanal(int horas) {
        return sueldoPorHora * horas;
    }
    
    public String getNombre() { return nombre; }
    public int getNumeroNomina() { return numeroNomina; }
    public double getSueldoPorHora() { return sueldoPorHora; }
    public Materia getMateria() { return materia; }
}

class Alumno {
    private String matricula;
    private String nombre;
    private int edad;    private Curso curso;
    
    public Alumno() {}
    
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }
    
    public Alumno(Alumno otro) {
        this.matricula = otro.matricula;
        this.nombre = otro.nombre;
        this.edad = otro.edad;
        this.curso = otro.curso;
    }

    public String getNombre() { return nombre; }
    public Curso getCurso() { return curso; }
}

class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;
    
    public Materia() {}
    
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }
    
    public Materia(Materia otra) {
        this.nombre = otra.nombre;
        this.clave = otra.clave;
        this.creditos = otra.creditos;
        this.horasSemanales = otra.horasSemanales;
    }
    
    public int getCreditos() { return creditos; }
}

class Curso {
    private String nombre;
    private List<Materia> materias;
    
    public Curso() {}
    
    public Curso(String nombre, List<Materia> materias) {
        if (materias == null || materias.size() != 3) {
            throw new IllegalArgumentException("Un curso debe tener exactamente 3 materias");
        }
        this.nombre = nombre;
        this.materias = materias;
    }
    
    public Curso(Curso otro) {
        this.nombre = otro.nombre;
        this.materias = otro.materias;
    }
    
    public int calcularTotalCreditos() {
        return materias.stream().mapToInt(Materia::getCreditos).sum();
    }
    
    public String getNombre() { return nombre; }
    public List<Materia> getMaterias() { return materias; }
}

public class ControlEscolar {
    public static void main(String[] args) {
        Materia m1 = new Materia("Matemáticas", "MAT101", 5, 4);
        Materia m2 = new Materia("Español", "FIS101", 4, 3);
        Materia m3 = new Materia("Química", "QUI101", 3, 2);
        Curso curso = new Curso("Deportes", List.of(m1, m2, m3));
        
        Alumno alumno = new Alumno("A001", "Juan Pérez", 20, curso);
        Profesor profesor = new Profesor("Dr. García", 12345, 200.0, m1);
        
        System.out.println("Información del Curso:");
        System.out.println("- Nombre: " + curso.getNombre());
        System.out.println("- Total Créditos: " + curso.calcularTotalCreditos());
        
        System.out.println("\nInformación del Alumno:");
        System.out.println("- Nombre: " + alumno.getNombre());
        System.out.println("- Curso: " + alumno.getCurso().getNombre());
        
        System.out.println("\nInformación del Profesor:");
        System.out.println("- Nombre: " + profesor.getNombre());
        System.out.println("- Sueldo Semanal (10 horas): " + profesor.calcularSueldoSemanal(10));
    }
}