package projeto_final_bloco_01.model;

public class Livros extends Produto {

    public Livros(int id, String nome, int tipo, float preco, String genero) {
        super(id, nome, tipo, preco);
        setGenero(genero);
    }

    @Override
    public void visualizar() {
        super.visualizar();
    }
}