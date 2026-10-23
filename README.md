# Aula 12 — Polimorfismo

Exercícios 3, 4 e 5, com exemplos executáveis e respostas às perguntas.

## 3. Sobrecarga de construtores — Produto

`Produto` possui três construtores: `Produto(String nome)`, `Produto(String nome, double preco)` e `Produto(String nome, double preco, int quantidadeEstoque)`.

### Resposta à pergunta

A sobrecarga de construtores facilita a criação de objetos com diferentes conjuntos de informações. Quem conhece apenas o nome pode usar o primeiro construtor; quem também conhece o preço usa o segundo; e quem possui todas as informações usa o terceiro. Assim, não é necessário fornecer todos os dados em cada instanciação.

Neste exemplo, os valores não informados recebem padrões: preço `0.0` e estoque `0`. Os construtores mais simples usam `this(...)` para chamar o construtor completo, centralizando a inicialização e evitando repetição de código. O compilador escolhe o construtor pela quantidade e pelos tipos dos argumentos. Construtores não são herdados nem sobrescritos.

### Exemplos

```java
new Produto("Caderno");
new Produto("Caneta", 2.50);
new Produto("Mochila", 120.00, 10);
```

## 4. Sobrescrita de métodos — Pagamento

`Pagamento` define `processarPagamento()`. `PagamentoCartao` e `PagamentoBoleto` sobrescrevem esse método com as mensagens específicas solicitadas, usando `@Override`.

### Resposta à pergunta

O polimorfismo por sobrescrita permite tratar diferentes formas de pagamento por meio do mesmo tipo base, `Pagamento`. Ao chamar `processarPagamento()` em uma referência desse tipo, Java executa o método correspondente ao tipo real do objeto em tempo de execução: cartão ou boleto.

Para adicionar outra forma de pagamento, como Pix, podemos criar uma nova subclasse e sobrescrever o método. Não é necessário alterar a classe base ou o laço que processa os pagamentos; basta fornecer uma instância da nova subclasse. Cada classe concentra o comportamento da sua forma de pagamento, facilitando a manutenção e a extensão do sistema.

## 5. Sobrecarga de métodos — Conversor

As três versões são:

- `converter(double celsius)`: converte Celsius para Fahrenheit com `celsius * 9.0 / 5.0 + 32.0`.
- `converter(double quilometros, String unidadeOrigem)`: recebe a unidade `"km"` e converte quilômetros para milhas dividindo por `1.609344`.
- `converter(String texto)`: retorna o texto em letras maiúsculas.

### Resposta à pergunta

A sobrecarga permite declarar métodos com o mesmo nome e assinaturas diferentes, alterando a quantidade, os tipos ou a ordem dos parâmetros. O compilador escolhe a versão aplicável a partir dos argumentos de cada chamada. Assim, `converter(25.0)`, `converter(10.0, "km")` e `converter("Java")` executam funcionalidades diferentes usando o mesmo nome de método.

As duas conversões numéricas recebem valores do tipo `double`. Por isso, não seria válido declarar ambas apenas como `converter(double)`: trocar o nome do parâmetro ou apenas o tipo de retorno não muda a assinatura. O segundo parâmetro `String unidadeOrigem` distingue a conversão de distância e informa explicitamente sua unidade. A implementação aceita `"km"` sem diferenciar maiúsculas e minúsculas e rejeita outras unidades com `IllegalArgumentException`.

A sobrecarga é resolvida em tempo de compilação e não exige herança. A sobrescrita mantém a assinatura de um método herdado e seleciona sua implementação em tempo de execução pelo tipo real do objeto.

## Executar no IntelliJ IDEA

Abra o projeto e execute o método `main` de `src/Main.java` pelo botão verde. Não são necessárias bibliotecas externas.

## Saída esperada

```text
=== 3. Sobrecarga de construtores ===
Produto: Caderno | Preço: R$ 0,00 | Estoque: 0
Produto: Caneta | Preço: R$ 2,50 | Estoque: 0
Produto: Mochila | Preço: R$ 120,00 | Estoque: 10

=== 4. Sobrescrita em pagamentos ===
Processando pagamento genérico
Processando pagamento via cartão de crédito
Processando pagamento via boleto bancário

=== 5. Sobrecarga em conversões ===
25 °C = 77,00 °F
0 °C = 32,00 °F
10 km = 6,213712 milhas
1,609344 km = 1,000000 milhas
Texto convertido: POLIMORFISMO EM JAVA
Texto convertido: AÇÃO E CONVERSÃO
```
