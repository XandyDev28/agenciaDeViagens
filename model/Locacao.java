package model;

public class Locacao {
    private final int cod;
    private String modeloVeiculo;
    private double valorDiaria;
    private int qtdDias;
    private double kmRodado;
    private final static int KM_INCLUSO_POR_DIA = 100;
    private final static double VALOR_KM_EXCEDENTE = 0.80;

    public int getCod(){
        return cod;
    }

/*     metodos modeloVeiculo */
    public String getModeloVeiculo(){
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo){
        if (modeloVeiculo == null || modeloVeiculo.isBlank()){
            throw new IllegalArgumentException("Modelo do veiculo deve ser preenchido!");
        }
        this.modeloVeiculo = modeloVeiculo.trim();
    }


/*     metodos valorDiaria */
    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if(!Double.isFinite(valorDiaria) || valorDiaria <= 0){
            throw new IllegalArgumentException("Valor da diaria deve ser maior que zero!");
        }
        this.valorDiaria = valorDiaria;
    }

/*     metodos qtdDias */
    public int getQtdDias(){
        return qtdDias;
    }

    public void setQtdDias(int qtdDias){
        if(qtdDias <= 0){
            throw new IllegalArgumentException("Quantidades de dias deve ser maior que Zero!");
        }
        this.qtdDias = qtdDias;
    }

/*     metodos km rodado */
    public double getKmRodado(){
        return kmRodado;
    }

    public void setKmRodado(double kmRodado){
        if(!Double.isFinite(kmRodado) || kmRodado < 0){
            throw new IllegalArgumentException("Quilometros rodados não podem ser negativos!");
        }
        this.kmRodado = kmRodado;
    }

/*     metodos de calculo */
    public double calcularKmExcedentes(){
        double kmInclusos = qtdDias * KM_INCLUSO_POR_DIA;
        return Math.max(0, kmRodado - kmInclusos);
    }

    public double calcularValorLocacao(){
        return valorDiaria * qtdDias + calcularKmExcedentes() * VALOR_KM_EXCEDENTE;
    }


/*     construtores */
    public Locacao(int cod, String modeloVeiculo, double valorDiaria, int qtdDias, double kmRodado) {
        if (cod <= 0){
            throw new IllegalArgumentException("O codigo deve ser maior que zero!");
        }
        this.cod = cod;
        setModeloVeiculo(modeloVeiculo);
        setValorDiaria(valorDiaria);
        setQtdDias(qtdDias);
        setKmRodado(kmRodado);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cod;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Locacao other = (Locacao) obj;
        if (cod != other.cod)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Locacao [cod=" + cod + 
        ", modeloVeiculo=" + modeloVeiculo + 
        ", valorDiaria=" + String.format("%.2f", valorDiaria) + 
        ", qtdDias=" + qtdDias + 
        ", kmRodado=" + kmRodado + 
        ", KmExcedentes=" + calcularKmExcedentes() + 
        ", ValorLocacao=" + String.format("%.2f",calcularValorLocacao()) + "]";
    }

}
