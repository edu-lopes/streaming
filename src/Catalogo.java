import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Catalogo {
    // List: o catálogo é exibido na ordem em que os conteúdos foram cadastrados.
    private List<Midia> conteudos;

    // Map<id, Midia>: localizar uma mídia rapidamente pelo seu id (chave única da mídia).
    private Map<Integer, Midia> porId;

    // Set<título>: não pode haver dois conteúdos com o mesmo título no catálogo.
    private Set<String> titulos;

    public Catalogo() {
        conteudos = new ArrayList<>();
        porId = new HashMap<>();
        titulos = new HashSet<>();
    }

    // Um único método serve para Filme e Serie, pois ambos são Midia.
    public void adicionar(Midia midia) {
        if (midia == null) {
            throw new IllegalArgumentException("A mídia não pode ser nula.");
        }

        if (porId.containsKey(midia.getId())) {
            throw new IllegalArgumentException("Já existe uma mídia com o id " + midia.getId() + ".");
        }

        // add() devolve false se o título já existir (ignorando maiúsculas/minúsculas)
        if (!titulos.add(chaveTitulo(midia.getTitulo()))) {
            throw new IllegalArgumentException("Já existe \"" + midia.getTitulo() + "\" no catálogo.");
        }

        conteudos.add(midia);
        porId.put(midia.getId(), midia);
    }

    // Consulta por chave no Map. Se não existir, o conteúdo está indisponível no catálogo.
    public Midia buscarPorId(int id) throws ConteudoIndisponivelException {
        Midia midia = porId.get(id);

        if (midia == null) {
            throw new ConteudoIndisponivelException("Nenhum conteúdo com id " + id + " no catálogo.");
        }

        return midia;
    }

    // Iterator: percorre o catálogo e remove os indisponíveis com segurança,
    // mantendo List, Map e Set sincronizados.
    public int removerIndisponiveis() {
        int removidos = 0;
        Iterator<Midia> it = conteudos.iterator();

        while (it.hasNext()) {
            Midia midia = it.next();

            if (!midia.isDisponivel()) {
                it.remove();                                   // remove da List
                porId.remove(midia.getId());                   // remove do Map
                titulos.remove(chaveTitulo(midia.getTitulo())); // libera o título no Set
                removidos++;
            }
        }

        return removidos;
    }

    public int quantidade() {
        return conteudos.size();
    }

    private String chaveTitulo(String titulo) {
        return titulo.trim().toLowerCase();
    }

    public void exibirCatalogo(List<Usuario> usuarios) {
        for (Midia conteudo : conteudos) {
            conteudo.exibirInfo();

            System.out.println("Usuários com acesso:");
            for (Usuario usuario : usuarios) {
                if (usuario.podeAssistir(conteudo.getPlanoNecessario())) {
                    System.out.println("- " + usuario.getNome());
                }
            }
            System.out.println();
        }

        for (Usuario usuario : usuarios) {
            usuario.exibirFavoritos();
        }
    }
}
