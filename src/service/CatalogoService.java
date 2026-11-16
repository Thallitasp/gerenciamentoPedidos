package src.service;

import src.exception.ProdutoNaoEncontradoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import src.model.Produto;

public class CatalogoService {

    private final String[] categoriasPermitidas = {"Eletronicos", "Livros", "Perifericos"};

    private List<Produto> historicoAdicoes = new ArrayList<>();
    private Map<String, Produto> catalogoPorCodigo = new HashMap<>();
    private Set<String> codigosRegistrados = new HashSet<>();

    public void exibirCategorias() {

        System.out.print("Categorias suportadas (Array): ");
        
        for (int i = 0; i < categoriasPermitidas.length; i++) {
            System.out.print(categoriasPermitidas[i] + (i < categoriasPermitidas.length - 1 ? ", " : "\n"));
        }
    }

    public void cadastrarProduto(Produto produto) {

        if (!codigosRegistrados.add(produto.getCodigo())) {
            System.out.println("Aviso: Produto com codigo " + produto.getCodigo() + " ja existe e sera atualizado.");
        }

        historicoAdicoes.add(produto);
        catalogoPorCodigo.put(produto.getCodigo(), produto);
    }

    public Produto buscarPorCodigo(String codigo) {

        Produto produto = catalogoPorCodigo.get(codigo);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException("Produto nao encontrado para o codigo: " + codigo);
        }
        return produto;
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(historicoAdicoes);
    }
}