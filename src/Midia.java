/**
 * Classe ABSTRATA: representa "uma mídia do catálogo" de forma genérica.
 * Não existe uma mídia que não seja filme nem série, por isso ela não pode
 * ser instanciada (new Midia(...) não compila). Guarda o que é comum a todas
 * as mídias e obriga as subclasses a implementarem o que muda de uma para outra.
 */
public abstract class Midia {
    private int id;
    private String titulo;
    private String sinopse;
    private String planoNecessario;
    private boolean disponivel;

    public Midia(int id, String titulo, String sinopse, String planoNecessario) {
        // Validações
        if (id <= 0) {
            throw new IllegalArgumentException("O id da mídia deve ser maior que zero.");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }

        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("A sinopse não pode ser vazia.");
        }

        if (planoNecessario == null || planoNecessario.isBlank()) {
            throw new IllegalArgumentException("O plano necessário não pode ser vazio.");
        }

        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.planoNecessario = planoNecessario;
        this.disponivel = true; // toda mídia nasce disponível
    }

    // MÉTODO ABSTRATO: só a subclasse sabe dizer o que ela é.
    public abstract String getTipo();

    public void exibirInfo() {
        System.out.println("[" + getTipo() + " #" + id + "] " + titulo + ". Sinopse: " + sinopse);
        if (!disponivel) {
            System.out.println("Situação: INDISPONÍVEL.");
        }
    }

    // Regra de acesso centralizada: Filme e Serie reutilizam, sem duplicar código.
    // Fica aqui porque é a Midia quem conhece sua disponibilidade e o plano exigido.
    protected void validarAcesso(Usuario usuario) throws ConteudoIndisponivelException {
        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }

        if (!disponivel) {
            throw new ConteudoIndisponivelException(
                    "\"" + titulo + "\" está indisponível no momento.");
        }

        if (!usuario.podeAssistir(planoNecessario)) {
            throw new ConteudoIndisponivelException(
                    "O plano de " + usuario.getNome() + " não cobre \"" + titulo
                            + "\" (exige plano " + planoNecessario + ").");
        }
    }

    // Comportamentos de domínio (em vez de um setDisponivel solto)
    public void marcarIndisponivel() {
        this.disponivel = false;
    }

    public void marcarDisponivel() {
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlanoNecessario() {
        return planoNecessario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Duas mídias são a mesma se tiverem o mesmo id (usado pelo Set de favoritos).
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Midia)) {
            return false;
        }
        return id == ((Midia) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
