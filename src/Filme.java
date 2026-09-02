public class Filme extends Midia {
    private int duracaoMinutos;

    public Filme(String titulo, String sinopse, int duracaoMinutos, String planoNecessario) {
        super(titulo, sinopse, planoNecessario);

        // Validações
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("A duração do filme deve ser maior que zero.");
        }

        this.duracaoMinutos = duracaoMinutos;
    }

    // fazer a atividade 08 aq utilizando como override o exibirInfo()
}