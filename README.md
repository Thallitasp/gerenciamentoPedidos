# ☕ Gerenciamento de Catálogo em Java: POO, Arrays, Coleções e Exceções

Este repositório contém uma aplicação Java desenvolvida para demonstrar na prática como **Programação Orientada a Objetos (POO)**, **Arrays**, **Coleções (`List`, `Map`, `Set`)** e **Tratamento de Exceções Personalizadas** trabalham juntos para gerenciar dados em memória e garantir a robustez e manutenibilidade de aplicações back-end.

---

## 🎯 Objetivos Técnicos Demonstrados

- **Orientação a Objetos (POO):** Encapsulamento de atributos, validação de regras de negócio no construtor e arquitetura organizada em camadas (`model`, `service`, `exception` e `application`).
- **Arrays (`String[]`):** Uso eficiente para domínios estáticos e imutáveis (`categoriasPermitidas`), evitando alocação dinâmica desnecessária.
- **Collections Framework (`java.util.*`):**
  - `ArrayList<Produto>`: Preservação da ordem cronológica de cadastro.
  - `HashMap<String, Produto>`: Busca indexada por chave única em tempo constante médio $O(1)$.
  - `HashSet<String>`: Garantia nativa de unicidade de códigos sem varreduras lineares.
- **Tratamento de Exceções:** Criação e captura de exceções semânticas personalizadas (`DadosInvalidosException` como *Checked Exception* e `ProdutoNaoEncontradoException` como *Unchecked Exception*), separando o fluxo principal do tratamento de falhas.

---

## 📂 Estrutura do Projeto

```text
src/
├── exception/
│   ├── DadosInvalidosException.java        # Exceção verificada para validação de regras de negócio
│   └── ProdutoNaoEncontradoException.java  # Exceção em tempo de execução para falhas de consulta
│
├── model/
│   └── Produto.java                        # Entidade encapsulada com validação no construtor
│
├── service/
│   └── CatalogoService.java                # Gerenciamento com Array, ArrayList, HashMap e HashSet
│
└── application/
    └── Main.java                           # Simulação dos fluxos de sucesso e tratamento de erros
```

---

## ⚙️ O que a Simulação (`Main.java`) Executa

1. **Exibição de Domínio Estático (`Array`):** Lista as categorias permitidas configuradas em um array de tamanho fixo.
2. **Cadastro e Validação (`Collections` + `Checked Exception`):**
   - Registra produtos válidos no `ArrayList`, `HashMap` e `HashSet`.
   - Tenta instanciar um produto com preço negativo, disparando e capturando `DadosInvalidosException` no bloco `try-catch-finally`.
3. **Consulta Performática (`HashMap` + `Unchecked Exception`):**
   - Realiza busca instantânea ($O(1)$) por código existente (`P01`).
   - Simula consulta a um código inexistente (`P99`), interceptando `ProdutoNaoEncontradoException` de forma controlada.

---

## 🚀 Como Executar na Sua Máquina

### Pré-requisitos
- **JDK 17** (ou superior) instalado.
- **Visual Studio Code** (com *Extension Pack for Java*) ou qualquer terminal com `javac` configurado.

### Passo a passo pelo Terminal

1. **Clone este repositório:**
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

## 🖥️ Saída Esperada no Console

```text
Categorias suportadas (Array): Eletrônicos, Livros, Periféricos

=== 1. CADASTRO DE PRODUTOS (COLEÇÕES + EXCEÇÕES) ===
Produtos válidos cadastrados com sucesso!
[Erro de Validação]: O preço do produto deve ser maior que zero.
Bloco finally executado: etapa de cadastro finalizada.

=== 2. CONSULTA RÁPIDA NO MAPA ===
Busca bem-sucedida: [P01] Teclado Mecânico - R$ 350,00
[Erro de Consulta]: Produto não encontrado para o código: P99
```

---

## 👩‍💻 Autora

**Thallita da Silva Pedreira**  
GitHub: [@Thallitasp](https://github.com/Thallitasp)
