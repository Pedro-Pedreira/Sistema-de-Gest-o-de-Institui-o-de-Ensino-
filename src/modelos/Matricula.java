/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class Matricula implements MatriculaGerenciavel {
    private Aluno aluno;
    private Turma turma;
    private String dataMatricula; // formato "dd/mm/aaaa"
    private double nota1;
    private double nota2;
    private int faltas;
    private String situacao; // "ATIVA", "TRANCADA", "CANCELADA"
    private boolean notasLancadas;

    public Matricula(Aluno aluno, Turma turma, String dataMatricula) {
        this.aluno = aluno;
        this.turma = turma;
        this.dataMatricula = dataMatricula;
        this.situacao = "ATIVA"; // Toda matrícula começa ATIVA
        this.faltas = 0; // Começa com 0 faltas
        this.notasLancadas = false; // Começa sem notas
    }
    
    public double getNota1() {
        return this.nota1;
    }

    public double getNota2() {
        return this.nota2;
    }

    public int getFaltas() {
        return this.faltas;
    }

    @Override
    public String lancarNotas(double nota1, double nota2) {
        if (!situacao.equals("ATIVA")) {
            return "Erro: Notas só podem ser lançadas em matrículas ATIVAS.";
        }
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            return "Erro: Notas devem estar entre 0 e 10.";
        }
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notasLancadas = true;
        return "Notas lançadas com sucesso!";
    }

    @Override
    public String registrarFaltas(int quantidade) {
        if (!situacao.equals("ATIVA")) {
            return "Erro: Faltas só podem ser registradas em matrículas ATIVAS.";
        }
        if (quantidade < 0) {
            return "Erro: A quantidade de faltas não pode ser negativa.";
        }
        this.faltas += quantidade; // Soma as faltas recebidas
        return "Faltas registradas com sucesso! Total atual: " + this.faltas;
    }

    @Override
    public String trancar() {
        if (!situacao.equals("ATIVA")) {
            return "Erro: Apenas matrículas ATIVAS podem ser trancadas.";
        }
        this.situacao = "TRANCADA";
        return "Matrícula trancada com sucesso.";
    }

    @Override
    public String cancelar() {
        if (situacao.equals("CANCELADA")) {
            return "Erro: A matrícula já está cancelada (ação definitiva).";
        }
        this.situacao = "CANCELADA";
        return "Matrícula cancelada com sucesso.";
    }

    @Override
    public double calcularMedia() {
        if (!notasLancadas) return 0.0;
        return (this.nota1 + (2 * this.nota2)) / 3.0; // Ponderada, nota 2 tem peso 2
    }

    @Override
    public String retornarResultado() {
        if (!notasLancadas) {
            return "SEM NOTAS LANÇADAS";
        }
        if (this.faltas > 15) {
            return "REPROVADO POR FALTA"; // Faltas reprovam mesmo com média alta
        }
        if (calcularMedia() < 6.0) {
            return "REPROVADO POR NOTA";
        }
        return "APROVADO";
    }

    // Getters necessários para o Gerenciador
    public Aluno getAluno() { return aluno; }
    public Turma getTurma() { return turma; }
    public String getSituacao() { return situacao; }
    public String getDataMatricula() { return dataMatricula; }
}