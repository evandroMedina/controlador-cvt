package sistema;

import java.util.ArrayList;

public class Trajeto {

    private String nome;
    private double rotacaoMotor;
    private double aberturaBorboleta;
    private double frenagem;
    private double velocidadeVeiculo;
    private double abertura_polia1;

    public Trajeto() {
    }

    public Trajeto(String nome, double rotacaoMotor, double aberturaBorboleta, double frenagem, double velocidadeVeiculo, double abertura_polia1) {
        this.nome = nome;
        this.rotacaoMotor = rotacaoMotor;
        this.aberturaBorboleta = aberturaBorboleta;
        this.frenagem = frenagem;
        this.velocidadeVeiculo = velocidadeVeiculo;
        this.abertura_polia1 = abertura_polia1;
    }

    public void imprimirTrajeto() {
        System.out.println("\n" + getNome() + "\nRotação do Motor: " + Double.toString(getRotacaoMotor())
                + "\nAbertura da Borboleta: " + getAberturaBorboleta() + "\nFrenagem: " + getFrenagem()
                + "\nVelocidade do veículo: " + getVelocidadeVeiculo() + "\nSaída Controle ===> " + getAbertura_polia1() + "\n");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRotacaoMotor() {
        return rotacaoMotor;
    }

    public void setRotacaoMotor(double rotacaoMotor) {
        this.rotacaoMotor = rotacaoMotor;
    }

    public double getAberturaBorboleta() {
        return aberturaBorboleta;
    }

    public void setAberturaBorboleta(double aberturaBorboleta) {
        this.aberturaBorboleta = aberturaBorboleta;
    }

    public double getFrenagem() {
        return frenagem;
    }

    public void setFrenagem(double frenagem) {
        this.frenagem = frenagem;
    }

    public double getVelocidadeVeiculo() {
        return velocidadeVeiculo;
    }

    public void setVelocidadeVeiculo(double velocidadeVeiculo) {
        this.velocidadeVeiculo = velocidadeVeiculo;
    }

    public double getAbertura_polia1() {
        return abertura_polia1;
    }

    public void setAbertura_polia1(double abertura_polia1) {
        this.abertura_polia1 = abertura_polia1;
    }

    @Override
    public String toString() {
        return "Trajeto{" + "rotacaoMotor=" + rotacaoMotor + ", aberturaBorboleta=" + aberturaBorboleta + ", frenagem=" + frenagem + ", velocidadeVeiculo=" + velocidadeVeiculo + ", abertura_polia1=" + abertura_polia1 + '}';
    }

}
