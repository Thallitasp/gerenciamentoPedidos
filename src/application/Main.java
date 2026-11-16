package src.application;

import src.exception.DadosInvalidosException;
import src.exception.ProdutoNaoEncontradoException;
import src.model.Produto;
import src.service.CatalogoService;

public class Main {
    public static void main(String[] args) {

        CatalogoService service = new CatalogoService();

        service.exibirCategorias();

        System.out.println("\n=== 1. CADASTRO DE PRODUTOS (COLEÇÕES + EXCEÇÕES) ===");
        
        try {

            Produto p1 = new Produto("P01", "Teclado Mecânico", 350.00);
            Produto p2 = new Produto("P02", "Clean Code - Livro", 120.00);

            service.cadastrarProduto(p1);
            service.cadastrarProduto(p2);

            System.out.println("Produtos válidos cadastrados com sucesso!");

            Produto pInvalido = new Produto("P03", "Mouse sem fio", -50.00);
            
            service.cadastrarProduto(pInvalido);

        } catch (DadosInvalidosException e) {
            System.err.println("[Erro de Validação]: " + e.getMessage());
        } finally {
            System.out.println("Bloco finally executado: etapa de cadastro finalizada.");
        }

        System.out.println("\n=== 2. CONSULTA RÁPIDA NO MAPA ===");

        try {

            Produto encontrado = service.buscarPorCodigo("P01");
            System.out.println("Busca bem-sucedida: " + encontrado);

            service.buscarPorCodigo("P99");

        } catch (ProdutoNaoEncontradoException e) {
            System.err.println("[Erro de Consulta]: " + e.getMessage());
        }
    }
}
