/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class AlunoRegular extends Aluno {

    public AlunoRegular() {
        super();
    }

    public AlunoRegular(int codigo, String nome, String email, Curso curso) {
        super(codigo, nome, email, curso);
    }

    @Override
    public double calcularMensalidade(int totalCreditosAtivos) {
        return totalCreditosAtivos * getCurso().getValorCredito();
    }

    @Override
    public String toString() {
        return super.toString() + " (Tipo: Regular)";
    }
}
