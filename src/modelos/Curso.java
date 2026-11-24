/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class Curso {
    private int codigo;
    private String nome;
    private double valorCredito;

    public Curso() {
    }

    public Curso(int codigo, String nome, double valorCredito) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorCredito = valorCredito;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    @Override
    public String toString() {
        return "Curso [Código: " + codigo + ", Nome: " + nome + ", Valor Crédito: R$ " + valorCredito + "]";
    }
}
