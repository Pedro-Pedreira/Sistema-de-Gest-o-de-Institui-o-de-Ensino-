/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class Disciplina {
    private int codigo;
    private String nome;
    private int creditos;
    private Curso curso; // Agregação, curso existe mesmo sem a disciplina

    public Disciplina() {
    }

    public Disciplina(int codigo, String nome, int creditos, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.creditos = creditos;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }
    
    // OBS: Não coloquei setCodigo() porque assim eu garanto que o usuario não irá mexer (alterar) nos meus dados diretamente


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Disciplina [Código: " + codigo + ", Nome: " + nome + ", Créditos: " + creditos + ", Curso: " + curso.getNome() + "]";
    }
}
