/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Pdrbe
 */
public class AlunoBolsista extends Aluno {
    private String tipoBolsa;
    private double percentualBolsa;

    public AlunoBolsista() {
        super();
    }

    public AlunoBolsista(int codigo, String nome, String email, Curso curso, String tipoBolsa, double percentualBolsa) {
        super(codigo, nome, email, curso);
        this.tipoBolsa = tipoBolsa;
        this.percentualBolsa = percentualBolsa;
    }

    public String getTipoBolsa() {
        return tipoBolsa;
    }

    public void setTipoBolsa(String tipoBolsa) {
        this.tipoBolsa = tipoBolsa;
    }

    public double getPercentualBolsa() {
        return percentualBolsa;
    }

    public void setPercentualBolsa(double percentualBolsa) {
        this.percentualBolsa = percentualBolsa;
    }

    @Override
    public double calcularMensalidade(int totalCreditosAtivos) {
        double valorBruto = totalCreditosAtivos * getCurso().getValorCredito();
        return valorBruto * (1.0 - (percentualBolsa / 100.0));
    }

    @Override
    public String toString() {
        return super.toString() + " (Tipo: Bolsista - " + tipoBolsa + " " + percentualBolsa + "%)";
    }
}
