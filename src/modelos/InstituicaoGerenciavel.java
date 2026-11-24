/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public interface InstituicaoGerenciavel {

    // Métodos de Cadastro
    String cadastrarCurso(int codigo, String nome, double valorCredito);
    String cadastrarDisciplina(int codigo, String nome, int creditos, int codigoCurso);
    String cadastrarProfessor(int codigo, String nome, String titulacao, String email);
    String cadastrarAlunoRegular(int codigo, String nome, String email, int codigoCurso);
    String cadastrarAlunoBolsista(int codigo, String nome, String email, int codigoCurso, String tipoBolsa, double percentualBolsa);
    String cadastrarTurma(int codigo, String semestre, int codigoDisciplina, int codigoProfessor, int vagas);

    // Métodos de Busca
    Curso buscarCurso(int codigo);
    Disciplina buscarDisciplina(int codigo);
    Professor buscarProfessor(int codigo);
    Aluno buscarAluno(int codigo);
    Turma buscarTurma(int codigo);
    Object buscarMatricula(Aluno aluno, Turma turma);

    // Métodos de Operação e Consulta
    String matricular(Aluno aluno, Turma turma, String dataMatricula);
    int calcularVagasDisponiveis(Turma turma);
    double calcularMensalidade(Aluno aluno);

    // Métodos de Relatórios
    String retornarListaDeFrequencia(Turma turma);
    String retornarMatriculasDoAluno(Aluno aluno);
}
