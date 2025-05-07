package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;
import java.util.Optional;

public interface ProdutoRepository {
    Optional<Produto> procuraPorId(int id);
    void listarTodos();
    void listarPorNome(String nome);
    void cadastrar(Produto produto);
    void atualizar(Produto produto);
    void deletar(int id);
}