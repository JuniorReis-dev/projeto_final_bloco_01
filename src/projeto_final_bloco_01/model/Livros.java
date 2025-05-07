package projeto_final_bloco_01.model;


public class Livros extends Produto {
	private String livros;

	public Livros(int id, String nome, int tipo, float preco, String livros) {
		super(id, nome, tipo, preco);
		this.livros = livros;
	}

	public String getLivros() {
		return livros;
	}

	public void setLivros(String livros) {
		this.livros = livros;
	}

	@Override
	 public void visualizar() {
		 super.visualizar();
		 System.out.println("Gênero: " + this.livros);
	    }
}
