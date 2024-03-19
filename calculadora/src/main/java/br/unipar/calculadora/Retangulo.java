/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.calculadora;

/**
 *
 * @author andersonbosing
 */
public class Retangulo {
    
    private double comprimento;
    private double largura;
    private double area;
    private double perimetro;
    
    public void setComprimento(double nrComprimento) {
        comprimento = nrComprimento;
    }
    
    public double getComprimento(){
        return comprimento;
    }
    
    public void setLargura(double nrLargura){
        largura = nrLargura;
    }
    
    public double getLargura(){
        return largura;
    }
    
    public double getArea(){
        return area;
    }
    
    public double getPerimetro(){
        return perimetro;
    }
    
    public void calcularArea(){
       area = comprimento * largura; 
    }
    
    public void calcularPerimetro(){
        perimetro = 2 * (comprimento + largura);
    }
    
    public void imprimir(){
        System.out.println("Area = "+area+" Perimetro = "+perimetro+
                " Largura = "+largura+" Comprimento = "+comprimento);
    }
    
}
