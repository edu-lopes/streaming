import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();
        List<Usuario> usuarios = new ArrayList<>();

        Usuario cleber = new Usuario("Cleber", new Assinatura("Basico"));
        Usuario eduardo = new Usuario("Eduardo", new Assinatura("Padrao"));
        Usuario guilherme = new Usuario("Guilherme", new Assinatura("Premium"));
        Usuario douglas = new Usuario("Douglas", new Assinatura("Padrao"));
        Usuario victor = new Usuario("Victor", new Assinatura("Premium"));
        Usuario gabriel = new Usuario("Gabriel", new Assinatura("Basico"));

        usuarios.add(cleber);
        usuarios.add(eduardo);
        usuarios.add(guilherme);
        usuarios.add(douglas);
        usuarios.add(victor);
        usuarios.add(gabriel);

        Serie strangerThings = new Serie(
                1,
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
                2,
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
                3,
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
                4,
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

        // Midia é abstrata: a linha abaixo NÃO compila.
        // Midia m = new Midia(5, "Teste", "Teste", "Basico");

        System.out.println("=== CATALOGO ===");
        System.out.println();

        catalogo.exibirCatalogo(usuarios);

        // ------------------------------------------------------------------
        // ETAPA 4 - EXCEÇÕES (cenário válido x cenário inválido)
        // ------------------------------------------------------------------
        System.out.println();
        System.out.println("=== EXCECOES: REPRODUZIR CONTEUDO ===");
        System.out.println();

        // Reproduzivel é a interface: Filme e Serie são tratados pelo mesmo contrato.
        Reproduzivel filmeParaAssistir = duna;
        Reproduzivel serieParaAssistir = breakingBad;

        // Cenário VÁLIDO: Guilherme (Premium) assiste a um filme Premium.
        try {
            filmeParaAssistir.reproduzir(guilherme);
        } catch (ConteudoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Cenário VÁLIDO: série.
        try {
            serieParaAssistir.reproduzir(victor);
        } catch (ConteudoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Cenário INVÁLIDO: Gabriel (Basico) tenta assistir a um filme Premium.
        try {
            filmeParaAssistir.reproduzir(gabriel);
        } catch (ConteudoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Cenário INVÁLIDO: série sem episódios.
        Serie serieVazia = new Serie(
                5,
                "Serie em Producao",
                "Uma série que ainda não tem episódios cadastrados.",
                "Basico"
        );
        try {
            serieVazia.reproduzir(gabriel);
        } catch (ConteudoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Outra regra rejeitada (IllegalArgumentException): favorito duplicado.
        try {
            douglas.adicionarFavorito(duna);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // ------------------------------------------------------------------
        // ETAPA 4 - COLEÇÕES: List, Set, Map e Iterator
        // ------------------------------------------------------------------
        System.out.println();
        System.out.println("=== COLECOES: INCLUSAO ===");
        System.out.println();

        // Inclusão (List + Map + Set atualizados juntos pelo Catalogo)
        Filme interestelar = new Filme(
                6,
                "Interestelar",
                "Exploradores viajam por um buraco de minhoca em busca de um novo lar.",
                169,
                "Padrao"
        );
        catalogo.adicionar(interestelar);
        System.out.println("Interestelar adicionado. Total no catálogo: " + catalogo.quantidade());

        // Set de títulos: rejeita título repetido (ignora maiúsculas/minúsculas).
        try {
            catalogo.adicionar(new Filme(7, "DUNA", "Outra sinopse qualquer.", 120, "Basico"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Map de ids: rejeita id repetido.
        try {
            catalogo.adicionar(new Filme(4, "Matrix", "Um hacker descobre a verdade sobre a realidade.", 136, "Padrao"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== COLECOES: CONSULTA POR ID (Map) ===");
        System.out.println();

        try {
            Midia encontrada = catalogo.buscarPorId(6);
            encontrada.exibirInfo();
        } catch (ConteudoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Favorito novo (Set aceita) para Eduardo
        eduardo.adicionarFavorito(interestelar);

        System.out.println();
        System.out.println("=== COLECOES: REMOCAO COM ITERATOR ===");
        System.out.println();

        // Alteração de estado: a licença de Breaking Bad expirou.
        breakingBad.marcarIndisponivel();
        System.out.println("Breaking Bad foi marcada como indisponível.");

        int removidosDoCatalogo = catalogo.removerIndisponiveis();   // Iterator no Catalogo
        int removidosDosFavoritos = douglas.removerFavoritosIndisponiveis(); // Iterator no Usuario
        System.out.println("Removidos do catálogo: " + removidosDoCatalogo);
        System.out.println("Removidos dos favoritos de Douglas: " + removidosDosFavoritos);

        // Depois da remoção, a consulta pelo id 3 falha (exceção personalizada).
        try {
            catalogo.buscarPorId(3);
        } catch (ConteudoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // O título foi liberado no Set: dá para cadastrar de novo com outro id.
        catalogo.adicionar(new Serie(8, "Breaking Bad", "Nova temporada licenciada.", "Premium"));
        System.out.println("Breaking Bad recadastrada. Total no catálogo: " + catalogo.quantidade());

        System.out.println();
        System.out.println("=== CATALOGO FINAL ===");
        System.out.println();

        catalogo.exibirCatalogo(usuarios);
    }
}
