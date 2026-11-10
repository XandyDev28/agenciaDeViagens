package model;

public class Passeio {
    private final int cod;
    private String descricao;
    private double precoPorPessoa;
    private int qtdPessoa;
    private double descontPercent;

    public int getCod(){
        return cod;
    }

/*     metodos descricao */
    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        if(descricao == null || descricao.isBlank()){
            throw new IllegalArgumentException("A descrição deve ser preenchida!");
        }
        this.descricao = descricao.trim();
    }

/*     metodos precoPorPessoa */
    public double getPrecoPorPessoa(){
        return precoPorPessoa;
    }

    public void setPrecoPorPessoa(double precoPorPessoa){
        if(!Double.isFinite(precoPorPessoa) || precoPorPessoa <= 0){
            throw new IllegalArgumentException("Preço por pessoa deve ser maior que zero!");
        }
        this.precoPorPessoa = precoPorPessoa;
    }

/*     metodos qtdPessoa */
    public int getQtdPessoa(){
        return qtdPessoa;
    }

    public void setQtdPessoa(int qtdPessoa){
        if(qtdPessoa <= 0) {
            throw new IllegalArgumentException("A quantidade de pessoas deve ser maior que zero!");
        }
        this.qtdPessoa = qtdPessoa;
    }

/*     metodos descontPercent */
    public double getDescontPercent(){
        return descontPercent;
    }

    public void setDescontPercent(double descontPercent){
        if(!Double.isFinite(descontPercent) || (descontPercent < 0  || descontPercent > 50)){
            throw new IllegalArgumentException("A porcentagem de desconto deve estar entre 0 e 50!");
        }
        this.descontPercent = descontPercent;
    }

/*     metodos calculo */
    public double calcularValorPasseio(){
        double subtotal = precoPorPessoa * qtdPessoa;
        return subtotal - subtotal * descontPercent / 100;
    }

/* metodo derivado */
    public String getCategoriaGrupo(){
        if (qtdPessoa == 1){
            return "INDIVIDUAL";
        } else if (qtdPessoa <= 5) {
            return "PEQUENO";
        } else {
            return "GRANDE";
        }

    }

/*     construtores */
    public Passeio(int cod, String descricao, double precoPorPessoa, int qtdPessoa, double descontPercent){
        if (cod <= 0){
            throw new IllegalArgumentException("O codigo precisa ser maior que zero!");
        }
        this.cod = cod;
        setDescontPercent(descontPercent);
        setDescricao(descricao);
        setPrecoPorPessoa(precoPorPessoa);
        setQtdPessoa(qtdPessoa);
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
        Passeio other = (Passeio) obj;
        if (cod != other.cod)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Passeio {cod=" + cod + 
                ", descricao=" + descricao + 
                ", precoPorPessoa=" + String.format("%.2f",precoPorPessoa) + 
                ", qtdPessoa=" + qtdPessoa + 
                ", descontPercent=" + descontPercent + 
                ", valor passeio=" + String.format("%.2f",calcularValorPasseio()) +  
                ", categoria do grupo=" + getCategoriaGrupo() + 
                "}";
    }

}
