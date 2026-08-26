# Etapa 2 — o que está feito e o que falta

Branch: `GuilhermeLima`.

Cada atividade tem duas metades, o código e o registro no documento. Uma pode
estar pronta sem a outra.

| Atividade | Código | Documento |
|---|---|---|
| 1 — Radiografia das classes | não tem código | feita |
| 2 — O que SABE x o que FAZ | não tem código | feita (classe `Usuario`) |
| 3 — Construtores e criação na Main | feita — `e3b418e` | feita |
| 4 — Desafio do cliente | feita — `7cff221` | feita |
| 5 — Hackear o próprio objeto | **falta** | **falta** |
| 6 — Encapsulamento | feita — `e1409bf`, `2585f3d` | **falta** |
| 7 — IA revisora | **falta** | **falta** |
| 8 — Testes de estado válido e inválido | **falta** | **falta** |
| 9 — Defesa e entrega | — | **falta** |

## O que o código ganhou

Validação no construtor das cinco classes de domínio: `Filme` recusa duração
`<= 0`, título e sinopse vazios; `Assinatura` recusa plano fora de Basico,
Padrao e Premium; `Serie`, `Episodio` e `Usuario` recusam campos vazios, nulos
ou números não positivos.

`Assinatura.cobrePlano()` compara planos por nível (Basico 1, Padrao 2,
Premium 3) com `>=`. `Usuario.podeAssistir()` delega para ela.
`Usuario.adicionarFavorito()` recusa `null` e duplicata.

`Catalogo` passou a guardar só o acervo: o construtor cria as listas vazias, os
objetos são criados na `Main` e entregues por `adicionarSerie()` e
`adicionarFilme()`, e `exibirCatalogo()` recebe a lista de usuários por
parâmetro.

## Atividade 5 — o que testar

Os atributos já são `private`, então `filme.duracaoMinutos = -1` nem compila.
Registrar isso como resultado.

Passa hoje e não deveria:

- `new Filme("X", "Y", 100, "banana")` — `Filme` e `Serie` checam que o plano não
  está vazio, mas não que ele existe, enquanto `Assinatura` recusa
- `serie.adicionarEpisodio(null)` — o `null` entra na lista e só estoura depois,
  dentro de `exibirInfo`

Já é recusado: duração `<= 0`, campos vazios, plano inválido na `Assinatura`,
`adicionarFavorito(null)` e favorito duplicado.

## Atividade 7 — IA revisora

A refatoração da Atividade 6 já está pronta, que é o pré-requisito do enunciado.
Passar `Usuario` ou `Assinatura` para a IA revisar encapsulamento, pedindo
análise e não reescrita. Registrar uma sugestão aceita e uma rejeitada, com
justificativa.

## Atividade 8 — o que falta no console

Já existem as criações e operações válidas. Faltam:

- 2 tentativas de alteração inválida, com `try/catch` imprimindo a mensagem.
  Sem `try/catch` a exceção encerra o programa e as linhas seguintes não rodam,
  e o enunciado pede "o comportamento adotado pelo programa"
- 1 caso de método de negócio protegendo melhor que um setter genérico

Para o último item dá para usar o que já existe: `adicionarFavorito` recusa
duplicata, coisa que um setter genérico de lista não pegaria. Basta favoritar o
mesmo conteúdo duas vezes e mostrar a recusa no console.
