/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class Professor {
    private int codigo;
    private String nome;
    private String titulacao;
    private String email;

    public Professor() {
    }

    public Professor(int codigo, String nome, String titulacao, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.titulacao = titulacao;
        this.email = email;
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

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professor [Código: " + codigo + ", Nome: " + nome + ", Titulação: " + titulacao + ", E-mail: " + email + "]";
    }
}
