public class Produto {
    private final String nome;
    private final double preco;
    private final int quantidadeEstoque;

    public Produto(String nome) {
        this(nome, 0.0, 0);
    }

    public Produto(String nome, double preco) {
        this(nome, preco, 0);
    }

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirInformacoes() {
        System.out.printf(java.util.Locale.forLanguageTag("pt-BR"),
                "Produto: %s | Preço: R$ %.2f | Estoque: %d%n",
                nome, preco, quantidadeEstoque);
    }
}
