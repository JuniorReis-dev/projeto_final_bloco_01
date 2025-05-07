package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Produto {     
	    private int id;
	    private String nome;
	    private int tipo;
	    private String genero;
	    private float preco;

	    public Produto(int id, String nome, int tipo, float preco) {
	        this.id = id;
	        this.nome = nome;
	        this.tipo = tipo;
	        this.preco = preco;

	        setGenero(tipo);
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public int getTipo() {
	        return tipo;
	    }

	    public void setTipo(int tipo) {
	        this.tipo = tipo;
	        setGenero(tipo);
	    }

	    public String getGenero() {
	        return genero;
	    }

	    private void setGenero(int tipo) {
	        switch (tipo) {
	            case 1 -> this.genero = "Ficção";
	            case 2 -> this.genero = "Romance";
	            case 3 -> this.genero = "Fantasia";
	            case 4 -> this.genero = "Suspense";
	            default -> this.genero = "Inválido";
	        }
	    }

	    public float getPreco() {
	        return preco;
	    }

	    public void setPreco(float preco) {
	        this.preco = preco;
	    }

	    public void visualizar() {
	        NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

	        System.out.println("***************************************");
	        System.out.println("DADOS DO PRODUTO                        ");
	        System.out.println("***************************************");
	        System.out.println("ID do Produto: " + this.id);
	        System.out.println("Nome do Produto: " + this.nome);
	        System.out.println("Preço: " + nfMoeda.format(this.preco));
	    }
	
}
