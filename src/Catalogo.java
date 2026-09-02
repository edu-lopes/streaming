    import java.util.ArrayList;

    public class Catalogo {
    private ArrayList<Midia> conteudos;

    public Catalogo() {
        conteudos = new ArrayList<>();
    }

    public void adicionar(Serie serie) {
    if (serie == null) {
        throw new IllegalArgumentException("A serie nao pode ser nula.");
    }

    conteudos.add(serie);
}

    public void adicionar(Filme filme) {
    if (filme == null) {
        throw new IllegalArgumentException("O filme nao pode ser nulo.");
    }

    conteudos.add(filme);
}

    public void exibirCatalogo(ArrayList<Usuario> usuarios) {
        for (Midia conteudo : conteudos) {
            conteudo.exibirInfo();

            System.out.println("Usuários com acesso:");
            for (Usuario usuario : usuarios) {
                if (usuario.podeAssistir(conteudo.getPlanoNecessario())) {
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
