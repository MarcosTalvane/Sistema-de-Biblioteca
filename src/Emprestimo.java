public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private String dataPedido;
    private String dataDevolucao;
    private boolean ativo;

    public Emprestimo (Livro livro, Usuario usuario, String dataPedido, String dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataPedido = dataPedido;
        this.dataDevolucao = dataDevolucao;
        this.ativo = true;
    }

    public void devolverLivro () {
        this.ativo = false;
        this.livro.setDisponivel(true);
    }
    public boolean isAtivo() {
        return this.ativo;
    }
    public Livro getLivro() {
        return this.livro;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }

    @Override
    public String toString() {
        return "Empréstimo do livro: " +livro+ " para " +usuario.getNome()+ " no dia " +dataPedido+
                ". Devolução no dia " +dataDevolucao;
    }
}
