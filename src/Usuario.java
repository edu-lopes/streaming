import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Usuario {
    private String nome;
    private Assinatura assinatura;
    // Set: um usuário não pode favoritar a mesma mídia duas vezes.
    // LinkedHashSet mantém a ordem em que os favoritos foram adicionados.
    private Set<Midia> favoritos;

    public Usuario(String nome, Assinatura assinatura) {
        // Validações
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio.");
        }

        if (assinatura == null) {
            throw new IllegalArgumentException("O usuário deve possuir uma assinatura.");
        }

        this.nome = nome;
        this.assinatura = assinatura;
        this.favoritos = new LinkedHashSet<>();
    }

    // Aceita qualquer Midia (Filme ou Serie): polimorfismo no lugar de duas sobrecargas.
    public void adicionarFavorito(Midia midia) {
        if (midia == null) {
            throw new IllegalArgumentException("A mídia não pode ser nula.");
        }

        // add() devolve false quando o elemento já existe no Set
        if (!favoritos.add(midia)) {
            throw new IllegalArgumentException("\"" + midia.getTitulo() + "\" já está nos favoritos.");
        }
    }

    // Iterator: percorre os favoritos e remove com segurança os que ficaram indisponíveis.
    // Remover dentro de um for-each lançaria ConcurrentModificationException.
    public int removerFavoritosIndisponiveis() {
        int removidos = 0;
        Iterator<Midia> it = favoritos.iterator();

        while (it.hasNext()) {
            Midia midia = it.next();
            if (!midia.isDisponivel()) {
                it.remove();
                removidos++;
            }
        }

        return removidos;
    }

    public boolean podeAssistir(String planoNecessario) {
        return assinatura.cobrePlano(planoNecessario);
    }

    public void exibirFavoritos() {
        System.out.println("Favoritos de " + nome + ":");

        for (Midia midia : favoritos) {
            System.out.println("- " + midia.getTitulo());
        }
    }

    public String getNome() {
        return nome;
    }
}
