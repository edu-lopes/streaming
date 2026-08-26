import java.time.LocalDate;

public class Episodio {
    private String nomeEpisodio;
    private int episodio;
    private int temporada;
    private String descricaoEpisodio;
    private LocalDate dataLancamento;

    public Episodio(String nomeEpisodio, int episodio, int temporada, String descricaoEpisodio, LocalDate dataLancamento) {
        // Validações
        if (nomeEpisodio == null || nomeEpisodio.isBlank()) {
            throw new IllegalArgumentException("O nome do episódio não pode ser vazio.");
        }

        if (episodio <= 0) {
            throw new IllegalArgumentException("O número do episódio deve ser maior que zero.");
        }

        if (temporada <= 0) {
            throw new IllegalArgumentException("O número da temporada deve ser maior que zero.");
        }

        if (descricaoEpisodio == null || descricaoEpisodio.isBlank()) {
            throw new IllegalArgumentException("A descrição do episódio não pode ser vazia.");
        }

        if (dataLancamento == null) {
            throw new IllegalArgumentException("A data de lançamento não pode ser nula.");
        }

        this.nomeEpisodio = nomeEpisodio;
        this.episodio = episodio;
        this.temporada = temporada;
        this.descricaoEpisodio = descricaoEpisodio;
        this.dataLancamento = dataLancamento;
    }

    public String exibirEpisodio() {
        return "Temporada " + temporada + " - Episódio " + episodio + ": " + nomeEpisodio + " - "
                + descricaoEpisodio + " Data de lançamento: " + dataLancamento;
    }
}