/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class Turma {
    private int codigo;
    private String semestre;
    private Disciplina disciplina; // Disciplina existe independente de turma
    private Professor professor; // Professor existe independente de turma
    private int vagas;

    public Turma() {
    }

    public Turma(int codigo, String semestre, Disciplina disciplina, Professor professor, int vagas) {
        this.codigo = codigo;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.professor = professor;
        this.vagas = vagas;
    }

    public int getCodigo() {
        return codigo;
    }
    
    //Não tem porque ter setCodigo(...)

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Turma [Código: " + codigo + ", Semestre: " + semestre + ", Disciplina: " + disciplina.getNome() + ", Professor: " + professor.getNome() + ", Vagas: " + vagas + "]";
    }
}
