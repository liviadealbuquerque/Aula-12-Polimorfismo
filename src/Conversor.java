import java.util.Locale;

public class Conversor {
    // Celsius para Fahrenheit.
    public double converter(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    // O parâmetro de unidade distingue esta assinatura da conversão de temperatura.
    public double converter(double quilometros, String unidadeOrigem) {
        if (!"km".equalsIgnoreCase(unidadeOrigem)) {
            throw new IllegalArgumentException("A unidade de origem deve ser km.");
        }
        return quilometros / 1.609344;
    }

    public String converter(String texto) {
        return texto.toUpperCase(Locale.ROOT);
    }
}
