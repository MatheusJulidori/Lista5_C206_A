package br.inatel.cdg.funcionario;

public class Funcionario {

    private int id;
    private double salario;
    private int numFilhos;

    public Funcionario(int id, double salario, int numFilhos) {
        this.id = id;
        this.salario = salario;
        this.numFilhos = numFilhos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getNumFilhos() {
        return numFilhos;
    }

    public void setNumFilhos(int numFilhos) {
        this.numFilhos = numFilhos;
    }
}
