import java.util.ArrayList;

public class Serie {
    private String titulo;
    private String sinopse;
    private String planoNecessario;
    private ArrayList<Episodio> episodios;

    public Serie(String titulo, String sinopse, String planoNecessario) {
        // Validações
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da série não pode ser vazio.");
        }

        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("A sinopse da série não pode ser vazia.");
        }

        if (planoNecessario == null || planoNecessario.isBlank()) {
            throw new IllegalArgumentException("O plano necessário não pode ser vazio.");
        }

        this.titulo = titulo;
        this.sinopse = sinopse;
        this.planoNecessario = planoNecessario;
        this.episodios = new ArrayList<>();
    }

    public void adicionarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    public void exibirInfo() {
        System.out.println("Série: " + titulo + ". Sinopse série: " + sinopse + ".");

        for (Episodio episodio : episodios) {
            System.out.println(episodio.exibirEpisodio());
        }
    }

    public String getPlanoNecessario() {
        return planoNecessario;
    }

    public String getTitulo() {
        return titulo;
    }
}