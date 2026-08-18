import java.util.ArrayList;

public class Serie {
    private String titulo;
    private String sinopse;
    private String planoNecessario;
    private ArrayList<Episodio> episodios;

    public Serie(String titulo, String sinopse, String planoNecessario) {
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
}