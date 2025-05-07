
package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int ultimoId;

    // Busca um produto pelo ID
    private Optional<Produto> buscarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return Optional.of(produto);
            }
        }
        return Optional.empty();
    }

    // Gera um novo ID incrementando o último usado
    public int gerarId() {
        return ++ultimoId;
    }

    @Override
    public Optional<Produto> procuraPorId(int id) {
        return buscarProduto(id);
    }

    @Override
    public void listarTodos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto produto : produtos) {
            produto.visualizar();
        }
    }

    @Override
    public void listarPorNome(String nome) {
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produto.visualizar();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum produto com o nome '" + nome + "' foi encontrado.");
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto '" + produto.getNome() + "' (ID " + produto.getId() + ") cadastrado com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                System.out.println("Produto ID " + produto.getId() + " atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto ID " + produto.getId() + " não encontrado.");
    }

    @Override
    public void deletar(int id) {
        Optional<Produto> produto = buscarProduto(id);
        if (produto.isPresent()) {
            produtos.remove(produto.get());
            System.out.println("Produto ID " + id + " excluído com sucesso!");
        } else {
            System.out.println("Produto ID " + id + " não encontrado.");
        }
    }
}