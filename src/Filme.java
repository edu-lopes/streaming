public class Filme {
    private String titulo;
    private String sinopse;
    private int duracaoMinutos;
    private String planoNecessario;


    public Filme(String titulo, String sinopse, int duracaoMinutos, String planoNecessario) {
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