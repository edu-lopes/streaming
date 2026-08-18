public class Usuario {
    private String nome;
    private Assinatura assinatura;

    public Usuario(String nome, Assinatura assinatura) {
        this.nome = nome;
        this.assinatura = assinatura;
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }
}