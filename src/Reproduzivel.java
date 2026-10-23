/**
 * Contrato de tudo aquilo que o usuário pode "dar play".
 *
 * É uma interface (e não herança) porque "ser reproduzível" é uma CAPACIDADE,
 * não uma identidade: Filme e Serie reproduzem de formas diferentes e outras
 * classes futuras (Trailer, Documentario...) poderiam assumir o mesmo contrato.
 */
public interface Reproduzivel {

    /**
     * Reproduz o conteúdo para o usuário informado.
     *
     * @throws ConteudoIndisponivelException se o conteúdo estiver indisponível
     *         ou o plano do usuário não cobrir o conteúdo.
     */
    void reproduzir(Usuario usuario) throws ConteudoIndisponivelException;
}
