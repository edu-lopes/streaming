import java.util.ArrayList;
import java.util.List;

public class Serie extends Midia implements Reproduzivel {
    // List: a ORDEM dos episódios importa (episódio 1 vem antes do 2).
    private List<Episodio> episodios;

    public Serie(int id, String titulo, String sinopse, String planoNecessario) {
        super(id, titulo, sinopse, planoNecessario);

        this.episodios = new ArrayList<>();
    }

    public void adicionarEpisodio(Episodio episodio) {
        if (episodio == null) {
            throw new IllegalArgumentException("O episódio não pode ser nulo.");
        }

        episodios.add(episodio);
    }

    @Override
    public String getTipo() {
        return "Série";
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Episódios: " + episodios.size());
    }

    @Override
    public void reproduzir(Usuario usuario) throws ConteudoIndisponivelException {
        validarAcesso(usuario);

        if (episodios.isEmpty()) {
            throw new ConteudoIndisponivelException(
                    "A série \"" + getTitulo() + "\" ainda não possui episódios.");
        }

        System.out.println("Reproduzindo a série \"" + getTitulo() + "\" para " + usuario.getNome() + ":");
        for (Episodio episodio : episodios) {
            System.out.println("  > " + episodio.exibirEpisodio());
        }
    }
}
