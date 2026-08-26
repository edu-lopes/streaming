import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // 2 criações válidas de objetos;
        Usuario cleber = new Usuario(
                "Cleber",
                new Assinatura("Basico")
        );

        Usuario douglas = new Usuario(
                "Douglas",
                new Assinatura("Padrao")
        );

        // 2 operações válidas;

        // Adicionando uma série com com 1 ep
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

        // Adicionando um filme
        Filme duna = new Filme(
                "Duna",
                "Um jovem herdeiro embarca numa jornada num planeta desértico.",
                155,
                "Basico"
        );

        // 2 tentativas de alteração inválida e o comportamento adotado pelo programa
        Filme filme = new Filme(
                "Interestelar",
                "Um filme sobre viagem espacial.",
                0,
                "Premium"
        );

        Usuario guilherme = new Usuario(
                "",
                new Assinatura("Premium")
        );

        // 1 caso em que um metodo de negócio protege melhor o objeto do que um setter genérico.
        cleber.podeAssistir(breakingBad.getPlanoNecessario());
    }
}