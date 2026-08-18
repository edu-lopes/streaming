import java.time.LocalDate;

public class Episodio {
    private String nomeEpisodio;
    private int episodio;
    private int temporada;
    private String descricaoEpisodio;
    private LocalDate dataLancamento;

    public Episodio(String nomeEpisodio, int episodio, int temporada, String descricaoEpisodio, LocalDate dataLancamento) {
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