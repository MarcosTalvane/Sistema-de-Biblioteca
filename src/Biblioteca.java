import java.util.ArrayList;

public class Biblioteca {


    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivros (Livro livro) {
        livros.add(livro);
    }
    public void cadastrarUsuarios (Usuario usuario) {
        usuarios.add(usuario);
    }
    public void listarLivrosDisponiveis() {
        boolean encontrou = false;

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }
    public void listarUsuariosCadastrados () {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado");
        }
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }
    public Usuario buscarUsuarioPorCpf (String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }
    public void realizarEmprestimo (int idLivro, String cpfUsuario, String dataPedido, String dataDevolucao) {
        Livro livro = buscarLivroPorId(idLivro);
        Usuario usuario = buscarUsuarioPorCpf(cpfUsuario);

        if (livro == null) {
            System.out.println("Livro não encontrado\n");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuário não encontrado\n");
            return;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível\n");
            return;
        }

        livro.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(livro, usuario, dataPedido, dataDevolucao);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado com sucesso!\n");
    }

    public void listarEmprestimosAtivos() {
        boolean encontrou = false;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()) {
                System.out.println(emprestimo);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum empréstimo ativo no momento");
        }
    }
    public void devolverLivro (int idLivro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getId() == idLivro && emprestimo.isAtivo()) {
                emprestimo.devolverLivro();
                System.out.println("Livro devolvido com sucesso!\n");
                return;
            }
        }
        System.out.println("Nenhum emprestimo ativo encontrado para este livro\n");
    }

    public void removerLivro (int id) {
        Livro livro = buscarLivroPorId(id);
        if (livro == null) {
            System.out.println("Livro não encontrado");
            return;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível");
            return;
        }
        livros.remove(livro);
        System.out.println("Livro removido com sucesso!");
    }
    public void removerUsuario (String cpf) {
        Usuario usuario = buscarUsuarioPorCpf(cpf);

        if (usuario == null) {
            System.out.println("Usuário não encontrado");
            return;
        }
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getCpf().equals(cpf) && emprestimo.isAtivo()) {
                System.out.println("Esse usuário possui empréstimo(s) ativo(s) e não pode ser removido");
                return;
            }
        }
        usuarios.remove(usuario);
        System.out.println("Usuário removido com sucesso!");
    }
}
