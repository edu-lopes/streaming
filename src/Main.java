import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Usuario cleber = new Usuario(
                "Cleber",
                new Assinatura("Basico")
        );

        Usuario eduardo = new Usuario(
                "Eduardo",
                new Assinatura("Padrao")
        );

        Usuario guilherme = new Usuario(
                "Guilherme",
                new Assinatura("Premium")
        );

        Usuario douglas = new Usuario(
                "Douglas",
                new Assinatura("Padrao")
        );

        Usuario victor = new Usuario(
                "Victor",
                new Assinatura("Premium")
        );

        Usuario gabriel = new Usuario(
                "Gabriel",
                new Assinatura("Basico")
        );

        usuarios.add(cleber);
        usuarios.add(eduardo);
        usuarios.add(guilherme);
        usuarios.add(douglas);
        usuarios.add(victor);
        usuarios.add(gabriel);


        Serie strangerThings = new Serie(
                "Stranger Things",
                "Um grupo de amigos enfrenta acontecimentos misteriosos em sua cidade.",
                "Basico"
        );

        strangerThings.adicionarEpisodio(new Episodio(
                "O desaparecimento de Will Byers",
                1,
                1,
                "Os amigos começam a investigar acontecimentos estranhos na cidade.",
                LocalDate.parse("2026-02-28")
        ));

        catalogo.adicionar(strangerThings);


        Serie theLastOfUs = new Serie(
                "The Last of Us",
                "Após uma pandemia devastadora, dois sobreviventes atravessam os Estados Unidos.",
                "Padrao"
        );

        theLastOfUs.adicionarEpisodio(new Episodio(
                "Quando estamos precisando",
                1,
                2,
                "Joel e Ellie iniciam uma jornada perigosa pelos Estados Unidos.",
                LocalDate.parse("2026-03-15")
        ));

        catalogo.adicionar(theLastOfUs);


        Serie breakingBad = new Serie(
                "Breaking Bad",
                "Um professor de química começa a produzir drogas para sustentar sua família.",
                "Premium"
        );

        breakingBad.adicionarEpisodio(new Episodio(
                "Piloto",
                1,
                1,
                "Walter White começa a produzir metanfetamina para conseguir dinheiro.",
                LocalDate.parse("2026-04-10")
        ));

        catalogo.adicionar(breakingBad);


        Filme duna = new Filme(
                "Duna",
                "Um jovem herdeiro embarca numa jornada num planeta desértico.",
                155,
                "Premium"
        );

        catalogo.adicionar(duna);


        douglas.adicionarFavorito(duna);
        douglas.adicionarFavorito(breakingBad);
        cleber.adicionarFavorito(strangerThings);

        // Polimorfismo: a referência é do tipo Midia, mas o objeto real é Filme ou Serie.
        // A mesma chamada exibirInfo() executa a versão sobrescrita de cada subclasse.
        System.out.println("=== POLIMORFISMO ===");
        System.out.println();

        Midia a = duna;
        Midia b = strangerThings;

        a.exibirInfo();
        System.out.println();
        b.exibirInfo();
        System.out.println();

        System.out.println("=== CATALOGO ===");
        System.out.println();

        catalogo.exibirCatalogo(usuarios);
    }
}
