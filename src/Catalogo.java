import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Serie> series;
    private ArrayList<Filme> filmes;

    public Catalogo() {
        series = new ArrayList<>();
        filmes = new ArrayList<>();
    }

    public void adicionarSerie(Serie serie) {
        if (serie == null) {
            throw new IllegalArgumentException("A serie nao pode ser nula.");
        }

        series.add(serie);
    }

    public void adicionarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("O filme nao pode ser nulo.");
        }

        filmes.add(filme);
    }

    public void exibirCatalogo(ArrayList<Usuario> usuarios) {
        for (Serie serie : series) {
            serie.exibirInfo();

            System.out.println("Usuários com acesso:");
            for (Usuario usuario : usuarios) {
                if (usuario.podeAssistir(serie.getPlanoNecessario())) {
                    System.out.println("- " + usuario.getNome());
                }
            }
            System.out.println();
        }

        for (Filme filme : filmes) {
            filme.exibirInfo();

            System.out.println("Usuários com acesso:");

            for (Usuario usuario : usuarios) {
                if (usuario.podeAssistir(filme.getPlanoNecessario())) {
                    System.out.println("- " + usuario.getNome());
                }
            }
            System.out.println();
        }

        for (Usuario usuario : usuarios) {
            usuario.exibirFavoritos();
        }
    }
}
