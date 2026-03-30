package Dominio;

public class Produto {
    private String nomeProduto;
    private double precoProduto;
    private int quantidadeEstoque;

    public Produto(String nomeProduto, double precoProduto, int quantidadeEstoque) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void imprimirProduto() {
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Preço: R$" + precoProduto);
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("---------------------------");
    }

    public boolean vender(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            quantidadeEstoque -= quantidade;
            System.out.println("Quantidade disponível, compra liberada!!");
            return true;
        } else {
            System.out.println("Não possuímos estoque desse produto, compra negada!!");
            return false;
        }
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

}
