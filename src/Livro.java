public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int paginas;
    private boolean disponivel;

    public Livro (int id, String titulo, String autor, String genero, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
        this.disponivel = true;
    }

    public int getId() {
        return this.id;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public boolean isDisponivel() {
        return this.disponivel;
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Emprestado";
        return "[" +id+ "]" + " - " +titulo+ " | " +autor+ " | " +genero+ " | " +paginas+
                " | " +status;
    }
}
