import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 3. Sobrecarga de construtores ===");
        Produto produto1 = new Produto("Caderno");
        Produto produto2 = new Produto("Caneta", 2.50);
        Produto produto3 = new Produto("Mochila", 120.00, 10);
        produto1.exibirInformacoes();
        produto2.exibirInformacoes();
        produto3.exibirInformacoes();

        System.out.println("\n=== 4. Sobrescrita em pagamentos ===");
        // A mesma referência base chama a implementação do objeto real.
        Pagamento[] pagamentos = {
                new Pagamento(), new PagamentoCartao(), new PagamentoBoleto()
        };
        for (Pagamento pagamento : pagamentos) {
            pagamento.processarPagamento();
        }

        System.out.println("\n=== 5. Sobrecarga em conversões ===");
        Conversor conversor = new Conversor();
        System.out.printf(Locale.forLanguageTag("pt-BR"),
                "25 °C = %.2f °F%n", conversor.converter(25.0));
        System.out.printf(Locale.forLanguageTag("pt-BR"),
                "0 °C = %.2f °F%n", conversor.converter(0.0));
        System.out.printf(Locale.forLanguageTag("pt-BR"),
                "10 km = %.6f milhas%n", conversor.converter(10.0, "km"));
        System.out.printf(Locale.forLanguageTag("pt-BR"),
                "1,609344 km = %.6f milhas%n", conversor.converter(1.609344, "km"));
        System.out.println("Texto convertido: " + conversor.converter("Polimorfismo em Java"));
        System.out.println("Texto convertido: " + conversor.converter("ação e conversão"));
    }
}
