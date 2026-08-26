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

    public boolean cobrePlano(String planoNecessario) {
        int nivelAssinatura = obterNivel(plano);
        int nivelNecessario = obterNivel(planoNecessario);

        return nivelAssinatura >= nivelNecessario;
    }

    private int obterNivel(String plano) {
        if (plano.equals("Basico")) {
            return 1;
        }

        if (plano.equals("Padrao")) {
            return 2;
        }

        if (plano.equals("Premium")) {
            return 3;
        }

        throw new IllegalArgumentException("Plano inválido.");
    }
}
