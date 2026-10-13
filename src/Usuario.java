public class Usuario {
    private String nome;
    private String cpf;
    private String telefone;

    public Usuario (String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return nome+ " - " +cpf+ " - " +telefone;
    }
}
