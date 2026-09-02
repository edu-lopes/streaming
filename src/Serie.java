import java.util.ArrayList;

public class Serie extends Midia{
    private ArrayList<Episodio> episodios;

    public Serie(String titulo, String sinopse, String planoNecessario) {
        super(titulo, sinopse, planoNecessario);

        this.episodios = new ArrayList<>();
    }

    public void adicionarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Episódios: " + episodios.size());
    }
}