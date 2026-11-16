# ☕ Gerenciamento de Catalogo em Java: POO, Arrays, Colecoes e Excecoes

Este repositorio contem uma aplicacao Java desenvolvida para demonstrar na pratica como **Programacao Orientada a Objetos (POO)**, **Arrays**, **Colecoes (`List`, `Map`, `Set`)** e **Tratamento de Excecoes Personalizadas** trabalham juntos para gerenciar dados em memoria e garantir a robustez e manutenibilidade de aplicacoes back-end.

---

## 🎯 Objetivos Tecnicos Demonstrados

- **Orientacao a Objetos (POO):** Encapsulamento de atributos, validacao de regras de negocio no construtor e arquitetura organizada em camadas (`model`, `service`, `exception` e `application`).
- **Arrays (`String[]`):** Uso eficiente para dominios estaticos e imutaveis (`categoriasPermitidas`), evitando alocacao dinamica desnecessaria.
- **Collections Framework (`java.util.*`):**
  - `ArrayList<Produto>`: Preservacao da ordem cronologica de cadastro.
  - `HashMap<String, Produto>`: Busca indexada por chave unica em tempo constante medio $O(1)$.
  - `HashSet<String>`: Garantia nativa de unicidade de codigos sem varreduras lineares.
- **Tratamento de Excecoes:** Criacao e captura de excecoes semanticas personalizadas (`DadosInvalidosException` como *Checked Exception* e `ProdutoNaoEncontradoException` como *Unchecked Exception*), separando o fluxo principal do tratamento de falhas.

---

## 📂 Estrutura do Projeto

```text
src/
├── exception/
│   ├── DadosInvalidosException.java        # Excecao verificada para validacao de regras de negocio
│   └── ProdutoNaoEncontradoException.java  # Excecao em tempo de execucao para falhas de consulta
│
├── model/
│   └── Produto.java                        # Entidade encapsulada com validacao no construtor
│
├── service/
│   └── CatalogoService.java                # Gerenciamento com Array, ArrayList, HashMap e HashSet
│
└── application/
    └── Main.java                           # Simulacao dos fluxos de sucesso e tratamento de erros
```

---

## ⚙️ O que a Simulacao (`Main.java`) Executa

1. **Exibicao de Dominio Estatico (`Array`):** Lista as categorias permitidas configuradas em um array de tamanho fixo.
2. **Cadastro e Validacao (`Collections` + `Checked Exception`):**
   - Registra produtos validos no `ArrayList`, `HashMap` e `HashSet`.
   - Tenta instanciar um produto com preco negativo, disparando e capturando `DadosInvalidosException` no bloco `try-catch-finally`.
3. **Consulta Performantica (`HashMap` + `Unchecked Exception`):**
   - Realiza busca instantanea ($O(1)$) por codigo existente (`P01`).
   - Simula consulta a um codigo inexistente (`P99`), interceptando `ProdutoNaoEncontradoException` de forma controlada.

---

## 🚀 Como Executar na Sua Maquina

### Pre-requisitos
- **JDK 17** (ou superior) instalado.
- **Visual Studio Code** (com *Extension Pack for Java*) ou qualquer terminal com `javac` configurado.

### Passo a passo pelo Terminal

1. **Clone este repositorio:**
   ```bash
   git clone https://github.com/Thallitasp/gerenciamento-pedidos-java.git
   ```

2. **Acesse a pasta do projeto:**
   ```bash
   cd gerenciamento-pedidos-java
   ```

3. **Compile os arquivos Java para a pasta `bin`:**
   ```bash
   javac -d bin src/exception/*.java src/model/*.java src/service/*.java src/application/*.java
   ```

4. **Execute a classe principal (`Main`):**
   ```bash
   java -cp bin application.Main
   ```

*(Pelo **VS Code**, basta abrir a pasta do projeto, acessar `src/application/Main.java` e clicar em **Run** ou pressionar `Ctrl + F5`.)*

---

## 🖥️ Saida Esperada no Console

```text
Categorias suportadas (Array): Eletronicos, Livros, Perifericos

=== 1. CADASTRO DE PRODUTOS (COLECOES + EXCECOES) ===
Produtos validos cadastrados com sucesso!
[Erro de Validacao]: O preco do produto deve ser maior que zero.
Bloco finally executado: etapa de cadastro finalizada.

=== 2. CONSULTA RAPIDA NO MAPA ===
Busca bem-sucedida: [P01] Teclado Mecanico - R$ 350,00
[Erro de Consulta]: Produto nao encontrado para o codigo: P99
```

---

## 👩‍💻 Autora

**Thallita da Silva Pedreira**  
GitHub: [@Thallitasp](https://github.com/Thallitasp)
