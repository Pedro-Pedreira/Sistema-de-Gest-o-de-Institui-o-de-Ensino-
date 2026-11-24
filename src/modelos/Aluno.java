/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public abstract class Aluno {
    private int codigo;
    private String nome;
    private String email;
    private Curso curso; // Agregação, Curso existe independente do aluno 

    public Aluno() {
    }

    public Aluno(int codigo, String nome, String email, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    public abstract double calcularMensalidade(int totalCreditosAtivos);
    // metodo abstrato, garante que os filhos tenham sua propria regra

    @Override
    public String toString() {
        return "Aluno [Código: " + codigo + ", Nome: " + nome + ", E-mail: " + email + ", Curso: " + curso.getNome() + "]";
    }
}
