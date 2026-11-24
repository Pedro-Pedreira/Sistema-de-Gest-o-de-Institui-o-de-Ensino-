/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
import java.util.ArrayList;
import java.util.List;
import modelos.Aluno;
import modelos.AlunoBolsista;
import modelos.AlunoRegular;
import modelos.Curso;
import modelos.Disciplina;
import modelos.InstituicaoGerenciavel;
import modelos.Professor;
import modelos.Turma;

public class GerenciadorDeInstituicao implements InstituicaoGerenciavel {

private ArrayList<Curso> cursos = new ArrayList<>();
private ArrayList<Disciplina> disciplinas = new ArrayList<>();
private ArrayList<Professor> professores = new ArrayList<>();
private ArrayList<Aluno> alunos = new ArrayList<>();
private ArrayList<Turma> turmas = new ArrayList<>();
    // Polimorfismo de inclusão na lista de ALUNOS porque aceita dois tipos de objetos que herdam de si mesmo
private ArrayList<Matricula> matriculas = new ArrayList<>();
    // --- BUSCAS POR CÓDIGO (Devolvem o objeto ou null) ---

    @Override
    public Curso buscarCurso(int codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Disciplina buscarDisciplina(int codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigo) {
                return d;
            }
        }
        return null;
    }

    @Override
    public Professor buscarProfessor(int codigo) {
        for (Professor p : professores) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Aluno buscarAluno(int codigo) {
        for (Aluno a : alunos) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Turma buscarTurma(int codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo() == codigo) {
                return t;
            }
        }
        return null;
    }

    // --- CADASTROS COM VALIDAÇÕES (Retornam mensagens de erro ou sucesso) ---

    @Override
    public String cadastrarCurso(int codigo, String nome, double valorCredito) {
        if (buscarCurso(codigo) != null) {
            return "Erro: Código de curso já cadastrado.";
        }
        Curso novoCurso = new Curso(codigo, nome, valorCredito);
        cursos.add(novoCurso);
        return "Curso cadastrado com sucesso!";
    }

    @Override
    public String cadastrarDisciplina(int codigo, String nome, int creditos, int codigoCurso) {
        if (buscarDisciplina(codigo) != null) {
            return "Erro: Código de disciplina já cadastrado.";
        }
        Curso cursoEncontrado = buscarCurso(codigoCurso);
        if (cursoEncontrado == null) {
            return "Erro: Curso informado não foi encontrado.";
        }
        Disciplina novaDisciplina = new Disciplina(codigo, nome, creditos, cursoEncontrado);
        disciplinas.add(novaDisciplina);
        return "Disciplina cadastrada com sucesso!";
    }

    @Override
    public String cadastrarProfessor(int codigo, String nome, String titulacao, String email) {
        if (buscarProfessor(codigo) != null) {
            return "Erro: Código de professor já cadastrado.";
        }
        Professor novoProfessor = new Professor(codigo, nome, titulacao, email);
        professores.add(novoProfessor);
        return "Professor cadastrado com sucesso!";
    }

    @Override
    public String cadastrarAlunoRegular(int codigo, String nome, String email, int codigoCurso) {
        if (buscarAluno(codigo) != null) {
            return "Erro: Código de aluno já cadastrado.";
        }
        Curso cursoEncontrado = buscarCurso(codigoCurso);
        if (cursoEncontrado == null) {
            return "Erro: Curso informado não foi encontrado.";
        }
        AlunoRegular novoAluno = new AlunoRegular(codigo, nome, email, cursoEncontrado);
        alunos.add(novoAluno);
        return "Aluno regular cadastrado com sucesso!";
    }

    @Override
    public String cadastrarAlunoBolsista(int codigo, String nome, String email, int codigoCurso, String tipoBolsa, double percentualBolsa) {
        if (buscarAluno(codigo) != null) {
            return "Erro: Código de aluno já cadastrado.";
        }
        Curso cursoEncontrado = buscarCurso(codigoCurso);
        if (cursoEncontrado == null) {
            return "Erro: Curso informado não foi encontrado.";
        }
        AlunoBolsista novoAluno = new AlunoBolsista(codigo, nome, email, cursoEncontrado, tipoBolsa, percentualBolsa);
        alunos.add(novoAluno);
        return "Aluno bolsista cadastrado com sucesso!";
    }

    @Override
    public String cadastrarTurma(int codigo, String semestre, int codigoDisciplina, int codigoProfessor, int vagas) {
        if (buscarTurma(codigo) != null) {
            return "Erro: Código de turma já cadastrado.";
        }
        Disciplina disciplinaEncontrada = buscarDisciplina(codigoDisciplina);
        if (disciplinaEncontrada == null) {
            return "Erro: Disciplina informada não foi encontrada.";
        }
        Professor professorEncontrado = buscarProfessor(codigoProfessor);
        if (professorEncontrado == null) {
            return "Erro: Professor informado não foi encontrado.";
        }
        Turma novaTurma = new Turma(codigo, semestre, disciplinaEncontrada, professorEncontrado, vagas);
        turmas.add(novaTurma);
        return "Turma cadastrada com sucesso!";
    }

    // --- MÉTODOS RESERVADOS PARA A SEGUNDA ENTREGA (18/11) ---

    @Override
    public Matricula buscarMatricula(Aluno aluno, Turma turma) {
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(aluno) && m.getTurma().equals(turma)) {
                return m; // Achou o vínculo entre eles
            }
        }
        return null;
    }

    @Override
    public String matricular(Aluno aluno, Turma turma, String dataMatricula) {
        if (aluno == null || turma == null) {
            return "Erro: Aluno ou Turma não encontrados.";
        }
        
        // 1. Validar se o aluno já tem matrícula nessa turma (qualquer status)
        if (buscarMatricula(aluno, turma) != null) {
            return "Erro: Aluno já possui registro nesta turma.";
        }
        
        // 2. Validar vagas disponíveis (somente ativas consomem vaga)
        if (calcularVagasDisponiveis(turma) <= 0) {
            return "Erro: Não há vagas disponíveis nesta turma.";
        }

        // 3. Efetivar matrícula
        Matricula novaMatricula = new Matricula(aluno, turma, dataMatricula);
        matriculas.add(novaMatricula);
        return "Matrícula realizada com sucesso!";
    }

    @Override
    public int calcularVagasDisponiveis(Turma turma) {
        int ativas = 0;
        for (Matricula m : matriculas) {
            if (m.getTurma().equals(turma) && m.getSituacao().equals("ATIVA")) {
                ativas++;
            }
        }
        return turma.getVagas() - ativas;
    }

    
    @Override
    public double calcularMensalidade(Aluno aluno) {
        int totalCreditosAtivos = 0;
        
        // Somar os créditos de todas as disciplinas em que o aluno tem matrícula ATIVA
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(aluno) && m.getSituacao().equals("ATIVA")) {
                totalCreditosAtivos += m.getTurma().getDisciplina().getCreditos();
            }
        }
        
        // Polimorfismo perfeito: O Gerenciador só manda a quantidade de créditos.
        // O próprio aluno vai buscar o valor do curso dele e fazer a conta!
        return aluno.calcularMensalidade(totalCreditosAtivos);
    }

    @Override
    public String retornarListaDeFrequencia(Turma turma) {
        if (turma == null) {
            return "Erro: Turma não encontrada.";
        }

        String relatorio = "=== Lista de Frequência - Turma " + turma.getCodigo() + " ===\n";
        boolean encontrou = false;

        for (Matricula m : matriculas) {
            if (m.getTurma().getCodigo() == turma.getCodigo()) {
                relatorio += "Aluno: " + m.getAluno().getNome()
                           + " (Cód: " + m.getAluno().getCodigo() + ")"
                           + " | Faltas: " + m.getFaltas()
                           + " | Status: " + m.getSituacao() + "\n";
                encontrou = true;
            }
        }

        if (!encontrou) {
            return "Nenhum aluno matriculado nesta turma.";
        }

        return relatorio;
    }

    @Override
    public String retornarMatriculasDoAluno(Aluno aluno) {
        if (aluno == null) {
            return "Erro: Aluno não encontrado.";
        }

        String relatorio = "=== Histórico do Aluno: " + aluno.getNome() + " ===\n";
        boolean encontrou = false;

        for (Matricula m : matriculas) {
            if (m.getAluno().getCodigo() == aluno.getCodigo()) {
                relatorio += "Turma: " + m.getTurma().getCodigo()
                           + " | Disciplina: " + m.getTurma().getDisciplina().getNome()
                           + " | Notas: " + m.getNota1() + " e " + m.getNota2()
                           + " | Faltas: " + m.getFaltas()
                           + " | Status: " + m.getSituacao() + "\n";
                encontrou = true;
            }
        }

        if (!encontrou) {
            return "Nenhuma matrícula encontrada para este aluno.";
        }

        return relatorio;
    }
}
