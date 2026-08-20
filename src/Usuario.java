import java.util.ArrayList;

public class Usuario {
    private String nome;
    private Assinatura assinatura;
    private ArrayList<Filme> listaFavoritosFilmes;
    private ArrayList<Serie> listaFavoritosSeries;

    public Usuario(String nome, Assinatura assinatura) {
        this.nome = nome;
        this.assinatura = assinatura;
        this.listaFavoritosFilmes = new ArrayList<>();
        this.listaFavoritosSeries = new ArrayList<>();
    }

    public void adicionarFavorito(Filme filme){
        listaFavoritosFilmes.add(filme);
    }

    public void adicionarFavorito(Serie serie) {
        listaFavoritosSeries.add(serie);
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