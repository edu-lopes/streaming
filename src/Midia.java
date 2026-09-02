public class Midia {
    private String titulo;
    private String sinopse;
    private String planoNecessario;

    public Midia(String titulo, String sinopse, String planoNecessario) {
        // Validações
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }

        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("A sinopse não pode ser vazia.");
        }

        if (planoNecessario == null || planoNecessario.isBlank()) {
            throw new IllegalArgumentException("O plano necessário não pode ser vazio.");
        }

        this.titulo = titulo;
        this.sinopse = sinopse;
        this.planoNecessario = planoNecessario;
    }

    public void exibirInfo() {
        System.out.println(titulo + ". Sinopse: " + sinopse + ".");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlanoNecessario() {
        return planoNecessario;
    }
}