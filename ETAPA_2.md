# Etapa 2 — estado do projeto e o que falta

Branch: `GuilhermeLima`. Tudo abaixo já está pushado.

Quem pegar daqui: leia a seção **O que falta** e siga a ordem das atividades.

---

## Como rodar

```bash
javac -encoding UTF-8 -d out src/*.java
java -Dfile.encoding=UTF-8 -cp out Main
```

---

## O que já foi feito

### Atividade 1 — Radiografia das classes

Respondida no documento do grupo, para as 6 classes. Os dois achados que
importam:

- a regra que decide acesso morava no `Catalogo`, usando dados que não são dele;
- a criação de todos os objetos morava no construtor do `Catalogo`, e montar o
  cenário é papel da `Main`.

Os dois foram corrigidos nas Atividades 3 e 6.

### Atividade 2 — o que SABE x o que FAZ

Feita sobre a classe `Usuario`. Getters ficaram de fora da coluna FAZ: não
decidem nem alteram nada.

### Atividade 3 — construtores e criação na Main

Commit `e3b418e`.

- `Catalogo`: o construtor passou a criar só as listas vazias
- `Catalogo`: ganhou `adicionarSerie()` e `adicionarFilme()`, ambos recusando `null`
- `Catalogo`: perdeu o campo `usuarios`; `exibirCatalogo()` recebe a lista por
  parâmetro, porque usuário não é conteúdo do acervo
- `Main`: cria os 6 usuários, as 3 séries com episódios e o filme, define os
  favoritos e chama o catálogo

Foi mudança de lugar, não de comportamento: a saída no console ficou idêntica.

### Atividade 4 — desafio do cliente

Registro exigido pelo enunciado, feito antes de programar:

**O que muda.** Filme não pode existir com duração menor ou igual a zero. O
catálogo precisa ser ajustado. Validações gerais nas demais classes.

**Onde muda.** Construtor de `Filme` (duração e título). Construtores de
`Assinatura`, `Serie`, `Episodio` e `Usuario`. `Catalogo` (construtor e
`exibirCatalogo`) e `Main`.

**Por que muda.** Duração zero ou negativa não representa filme nenhum, e o
objeto não pode nascer nesse estado. O construtor é o único ponto capaz de
garantir isso: ele não tem `return`, então ou cria um objeto válido ou lança
exceção — não existe objeto pela metade. E o catálogo precisou de ajuste porque
acumulava duas coisas que não são dele: criar os objetos do cenário e decidir
quem tem acesso ao conteúdo.

### Atividade 6 — encapsulamento

Commits `7cff221`, `e1409bf`, `2585f3d`.

Validação nos cinco construtores:

| Classe | O que o construtor recusa |
|---|---|
| `Assinatura` | plano vazio; plano fora de Basico / Padrao / Premium |
| `Filme` | título vazio, sinopse vazia, duração `<= 0`, plano vazio |
| `Serie` | título vazio, sinopse vazia, plano vazio |
| `Episodio` | nome vazio, descrição vazia, data nula, episódio `<= 0`, temporada `<= 0` |
| `Usuario` | nome vazio, assinatura nula |

Comportamento de negócio:

- `Assinatura.cobrePlano()` — hierarquia Basico(1) < Padrao(2) < Premium(3),
  comparada com `>=`. O auxiliar `obterNivel()` é `private`: é cálculo interno.
- `Usuario.podeAssistir()` — delega para a assinatura.
- `Usuario.adicionarFavorito()` — recusa `null` e recusa duplicata.
- `Usuario.getAssinatura()` foi **removido**. Ele só existia para o `Catalogo`
  puxar o plano de dentro da assinatura e decidir por fora. Agora o próprio
  usuário responde.

---

## O que mudou da Etapa 1 (para a apresentação)

O enunciado pede uma classe antes e depois. `Usuario` é a melhor.

| | Etapa 1 | Etapa 2 |
|---|---|---|
| Construtor | aceitava qualquer coisa | recusa nome vazio e assinatura nula |
| `adicionarFavorito` | aceitava `null` e duplicata | recusa os dois |
| `podeAssistir` | não existia | responde sobre o próprio acesso |
| `getAssinatura` | existia, entregava o objeto interno | removido |

Evidência no console, mesma execução:

```
Etapa 1                              Etapa 2
Stranger Things (Basico)             Stranger Things (Basico)
  - Cleber                             - Cleber, Eduardo, Guilherme,
  - Gabriel                              Douglas, Victor, Gabriel
```

O `Catalogo` comparava plano com `equals`, exigindo plano idêntico, então um
usuário Premium não aparecia como tendo acesso a um conteúdo Basico. Depois da
correção só entrou gente na lista, ninguém saiu — a hierarquia amplia acesso,
nunca tira. Premium continua com 2 porque nada está acima de Premium.

---

## O que falta

Na ordem. Não dá para pular: a 5 vem antes do resto por causa do enunciado, e a
7 exige que a refatoração da 6 já esteja pronta (está).

### Atividade 5 — hackear o próprio objeto

Não feita. Os atributos já eram `private` desde a Etapa 1, então tentar
`filme.duracaoMinutos = -1` nem compila — isso já é um resultado para registrar.

Testar e anotar o que acontece hoje:

- `new Filme("X", "Y", -1, "Basico")` — recusado pelo construtor
- `new Filme("X", "Y", 100, "banana")` — **passa**, ver pendência abaixo
- `usuario.adicionarFavorito(null)` — recusado
- `serie.adicionarEpisodio(null)` — **passa**, ver pendência abaixo

### Atividade 7 — IA revisora

Liberada. Passar `Usuario` ou `Assinatura` para a IA revisar encapsulamento,
usando os prompts do enunciado (pedir análise, não reescrita). Registrar no
documento do grupo uma sugestão aceita e uma rejeitada com justificativa.

### Atividade 8 — testes de estado válido e inválido

O rascunho do Guilherme foi substituído quando a `Main` foi reescrita, mas está
preservado no histórico:

```bash
git show 202b516:src/Main.java
```

Ele não roda até o fim: a criação de `Filme` com duração `0` lança exceção sem
`try/catch` e mata o programa antes das linhas seguintes. Refazer com `try/catch`
imprimindo a mensagem, porque o enunciado pede "o comportamento adotado pelo
programa" — crashar não é comportamento adotado.

Faltam no console: 2 tentativas inválidas sendo recusadas, e 1 caso de método de
negócio protegendo melhor que um setter genérico.

### Atividade 9 — defesa e entrega

Documento do grupo, documento individual de cada um, e o ZIP com `src/`,
`modelagem/`, `execucao/` e o documento.

---

## Pendências técnicas conhecidas

**`Serie.adicionarEpisodio` aceita `null`.** O `null` entra na lista e só explode
depois, dentro de `exibirInfo`, quando alguém chama `episodio.exibirEpisodio()`.
O erro aparece longe de onde foi causado. Mesmo padrão que já foi corrigido em
`adicionarFavorito`.

**`Filme` e `Serie` não validam se o plano existe.** Os dois só checam que
`planoNecessario` não está vazio, então `new Filme("X", "Y", 100, "banana")`
passa. A `Assinatura` recusa qualquer plano fora dos três. É a mesma regra do
domínio aplicada com dois critérios diferentes em lugares diferentes.

**`adicionarFavorito` aceita conteúdo fora do plano.** Douglas é Padrao e
favorita Duna, que é Premium. Essa regra é o melhor candidato para o item
"método de negócio protege melhor que setter" da Atividade 8, mas colocá-la
**quebra o cenário atual** — Douglas passaria a receber exceção. Antes de
implementar, decidir: muda o plano do Douglas, muda o plano do Duna, ou usa
outro par no exemplo.

**`podeAssistir` recebe `String`.** Quem chama ainda faz
`filme.getPlanoNecessario()`. Sobrecarregar para `podeAssistir(Filme)` e
`podeAssistir(Serie)` encurtaria a cadeia. Não é urgente.
