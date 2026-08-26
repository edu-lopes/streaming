public class Assinatura {
    private String plano;

    public Assinatura(String plano) {
        // Validações
        if (plano == null || plano.isBlank()) {
            throw new IllegalArgumentException("O plano não pode ser vazio.");
        }

        if (!plano.equals("Basico") && !plano.equals("Padrao") && !plano.equals("Premium")) {
            throw new IllegalArgumentException("Plano inválido. Escolha Basico, Padrao ou Premium.");
        }

        this.plano = plano;
    }

    public String getPlano() {
        return plano;
    }
}
