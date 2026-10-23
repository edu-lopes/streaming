/**
 * Exceção personalizada (checked) do domínio de streaming.
 *
 * Regra de negócio: um conteúdo NÃO pode ser reproduzido/consultado quando
 *  - ele foi marcado como indisponível (ex.: licença expirada);
 *  - o plano do usuário não cobre o plano exigido pelo conteúdo;
 *  - ele não existe no catálogo (ou a série ainda não tem episódios).
 *
 * É "checked" (extends Exception) de propósito: quem chama é OBRIGADO a tratar
 * ou declarar, porque é uma situação de negócio esperada, não um bug.
 */
public class ConteudoIndisponivelException extends Exception {
    public ConteudoIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
