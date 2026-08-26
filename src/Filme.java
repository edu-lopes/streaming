public class Filme {
    private String titulo;
    private String sinopse;
    private int duracaoMinutos;
    private String planoNecessario;


    public Filme(String titulo, String sinopse, int duracaoMinutos, String planoNecessario) {
        // Validações
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }

        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("A sinopse não pode ser vazia.");
        }

        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("A duração do filme deve ser maior que zero.");
        }

        if (planoNecessario == null || planoNecessario.isBlank()) {
            throw new IllegalArgumentException("O plano necessário não pode ser vazio.");
        }

        this.titulo = titulo;
        this.sinopse = sinopse;
        this.duracaoMinutos = duracaoMinutos;
        this.planoNecessario = planoNecessario;
    }


    public void exibirInfo() {
        System.out.println("Filme: " + titulo + ". Sinopse filme: " + sinopse +
                ". Duração: " + duracaoMinutos + " min.");
    }
    public String getPlanoNecessario() {
        return planoNecessario;
    }

    public String getTitulo() {
        return titulo;
    }
}