import java.util.ArrayList;

public class Usuario {
    private String nome;
    private Assinatura assinatura;
    private ArrayList<Filme> listaFavoritosFilmes;
    private ArrayList<Serie> listaFavoritosSeries;

    public Usuario(String nome, Assinatura assinatura) {
        // Validações
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio.");
        }

        if (assinatura == null) {
            throw new IllegalArgumentException("O usuário deve possuir uma assinatura.");
        }

        this.nome = nome;
        this.assinatura = assinatura;
        this.listaFavoritosFilmes = new ArrayList<>();
        this.listaFavoritosSeries = new ArrayList<>();
    }

    public void adicionarFavorito(Filme filme) {
        if (listaFavoritosFilmes.contains(filme)) {
            throw new IllegalArgumentException("Esse filme já está nos favoritos.");
        }

        listaFavoritosFilmes.add(filme);
    }

    public void adicionarFavorito(Serie serie) {
        if (listaFavoritosSeries.contains(serie)) {
            throw new IllegalArgumentException("Essa série já está nos favoritos.");
        }

        listaFavoritosSeries.add(serie);
    }

    public boolean podeAssistir(String planoNecessario) {
        return assinatura.cobrePlano(planoNecessario);
    }

    public void exibirFavoritos() {
        System.out.println("Favoritos de " + nome + ":");

        for (Filme filme : listaFavoritosFilmes) {
            System.out.println("- " + filme.getTitulo());
        }

        for (Serie serie : listaFavoritosSeries) {
            System.out.println("- " + serie.getTitulo());
        }
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }
}