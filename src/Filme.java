public class Filme extends Midia implements Reproduzivel {
    private int duracaoMinutos;

    public Filme(int id, String titulo, String sinopse, int duracaoMinutos, String planoNecessario) {
        super(id, titulo, sinopse, planoNecessario);

        // Validações
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("A duração do filme deve ser maior que zero.");
        }

        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String getTipo() {
        return "Filme";
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Duração: " + duracaoMinutos + " minutos.");
    }

    @Override
    public void reproduzir(Usuario usuario) throws ConteudoIndisponivelException {
        validarAcesso(usuario); // lança a exceção se a regra for violada
        System.out.println("Reproduzindo o filme \"" + getTitulo() + "\" (" + duracaoMinutos
                + " min) para " + usuario.getNome() + ".");
    }
}
