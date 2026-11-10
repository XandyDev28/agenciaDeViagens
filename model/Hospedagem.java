package model;

public class Hospedagem {
    private final int codigo;
    private String hospede;
    private double valorDiaria;
    private int qtdDiarias;
    private double taxaServicoPercentual;

    public int getCodigo(){
        return codigo;
    }
    
/*     metodos hospede */
    public String getHospede(){
        return hospede;
    }

    public void setHospede(String hospede){
        if (hospede == null || hospede.isBlank()){
            throw new IllegalArgumentException("Hospede deve ser preenchido!");
        } 
        this.hospede = hospede.trim();
    }

/*     metodos valorDiaria */
    public double getValorDiaria(){
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria){
        if (!Double.isFinite(valorDiaria) || valorDiaria <= 0){
            throw new IllegalArgumentException("O valor da diaria deve ser finito e maior que zero!");
        }
        this.valorDiaria = valorDiaria;
    }

/*     metodos qtdDiarias */
    public int getQtdDiarias(){
        return qtdDiarias;
    }

    public void setQtdDiarias(int qtdDiarias){
        if (qtdDiarias <= 0) {
            throw new IllegalArgumentException("A quantidade de diarias deve ser maior que zero!");
        }
        this.qtdDiarias = qtdDiarias;
    }

/*     metodos taxa percentual de servico */
    public double getTaxaServicoPercent(){
        return taxaServicoPercentual;
    }

    public void setTaxaServicoPercent(double taxaServicoPercentual){
        if(!Double.isFinite(taxaServicoPercentual) || (taxaServicoPercentual < 0 || taxaServicoPercentual > 20) ){
            throw new IllegalArgumentException("A taxa percentual de serviço deve ser entre 0 e 20!");
        }
        this.taxaServicoPercentual = taxaServicoPercentual;
    }


/*     metodo de calculo */
    public double calcularValorEstadia(){
        double subtotal = valorDiaria * qtdDiarias;
        return subtotal + ((subtotal * taxaServicoPercentual ) / 100 );
    }

/*     construtores */
    public Hospedagem(int codigo, String hospede, double valorDiaria, int qtdDiarias, double taxaServicoPercentual){
        if (codigo <= 0) {
            throw new IllegalArgumentException("O codigo deve ser maior que zero!");
        }
        this.codigo = codigo;
        setHospede(hospede);
        setValorDiaria(valorDiaria);
        setQtdDiarias(qtdDiarias);
        setTaxaServicoPercent(taxaServicoPercentual);
    }



    @Override 
    public int hashCode(){
        int hash = 7;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    
    @Override 
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        } if (obj == null){
            return false;
        } if (getClass() != obj.getClass()){
            return false;
        }
        final Hospedagem other = (Hospedagem) obj;
        return this.codigo == other.codigo;
    }


    @Override 
    public String toString() {
        return "Hospedagem{" +
                "Codigo = " + codigo +
                ", Hospede = " + hospede +
                ", Valor da Diaria = " + String.format("%.2f",valorDiaria) + 
                ", Quantidade de Diarias = " + qtdDiarias +
                ", Taxa Percentual de Serviço = " +taxaServicoPercentual+"%" +
                ", Valor da Estadia = " + calcularValorEstadia() +
                '}';
    }
}