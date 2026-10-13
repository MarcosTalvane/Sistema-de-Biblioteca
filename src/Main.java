void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    Scanner sc = new Scanner(System.in);

    int opcao = -1;

    while (opcao != 0) {
        System.out.println("------------ Biblioteca ------------\n");
        System.out.println("1) Gerenciar livros");
        System.out.println("2) Gerenciar usuários");
        System.out.println("3) Gerenciar Empréstimos");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: ");
        opcao = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (opcao) {
            case 1:
                System.out.println("========== GERENCIAMENTO DE LIVROS ==========\n");
                System.out.println("1) Cadastrar livro");
                System.out.println("2) Remover livro");
                System.out.println("3) Listar livros");
                System.out.println("0) Sair");
                System.out.print("Escolha uma opção: ");
                int opcaoLivro = sc.nextInt();
                sc.nextLine();

                switch (opcaoLivro) {
                    case 1:
                        System.out.println("========== CADASTRAR LIVRO ==========\n");
                        System.out.print("Digite o ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Digite o título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Digite o Autor: ");
                        String autor = sc.nextLine();

                        System.out.print("Digite o gênero: ");
                        String genero = sc.nextLine();

                        System.out.print("Digite as páginas: ");
                        int pagina = sc.nextInt();
                        sc.nextLine();
                        Livro novoLivro = new Livro(id, titulo, autor, genero, pagina);
                        biblioteca.cadastrarLivros(novoLivro);
                        System.out.println("Livro cadastrado com sucesso!\n");
                        break;
                    case 2:
                        System.out.println("========== REMOVER LIVRO ==========\n");
                        System.out.print("Digite o ID do livro: ");
                        int idRemover = sc.nextInt();
                        sc.nextLine();
                        biblioteca.removerLivro(idRemover);
                        break;
                    case 3:
                        System.out.println("========== LIVROS DISPONÍVEIS ==========\n");
                        biblioteca.listarLivrosDisponiveis();
                        System.out.println();
                        break;
                    case 0:
                        break;
                }
                break;
            case 2:
                System.out.println("========== GERENCIAMENTO DE USUÁRIOS ==========\n");
                System.out.println("1) Cadastrar usuários");
                System.out.println("2) Remover usuários");
                System.out.println("3) Listar usuários");
                System.out.println("0) Sair");
                System.out.print("Escolha uma opção: ");
                int opcaoUsuario = sc.nextInt();
                sc.nextLine();

                switch (opcaoUsuario) {
                    case 1:
                        System.out.println("========== CADASTRAR USUÁRIO ==========\n");
                        System.out.print("Digite o nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Digite o CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Digite o número de telefone: ");
                        String telefone = sc.nextLine();

                        Usuario novoUsuario = new Usuario(nome, cpf, telefone);
                        biblioteca.cadastrarUsuarios(novoUsuario);
                        System.out.println("Usuário cadastrado com sucesso!\n");
                        break;
                    case 2:
                        System.out.println("========== REMOVER USUÁRIO ==========\n");
                        System.out.print("Digite o CPF do usuário: ");
                        String cpfRemover = sc.nextLine();
                        biblioteca.removerUsuario(cpfRemover);
                        break;
                    case 3:
                        System.out.println("========== Usuários Cadastrados ==========\n");
                        biblioteca.listarUsuariosCadastrados();
                        System.out.println();
                        break;
                    case 0:
                        break;
                }
                break;
            case 3:
                System.out.println("========== GERENCIAR EMPRÉSTIMOS ==========\n");
                System.out.println("1) Realizar empréstimos");
                System.out.println("2) Empréstimos ativos");
                System.out.println("3) Devolver livro");
                System.out.println("0) Sair");
                System.out.print("Escolha uma opção: ");
                int opcaoEmprestimo = sc.nextInt();
                sc.nextLine();

                switch (opcaoEmprestimo) {
                    case 1:
                        System.out.println("========== Realizar Empréstimo ==========\n");
                        System.out.print("Digite o ID do livro: ");
                        int idLivro = sc.nextInt();
                        sc.nextLine();

                        Livro livro = biblioteca.buscarLivroPorId(idLivro);
                        if (livro == null) {
                            System.out.println("Livro não encontrado!\n");
                            break;
                        }

                        if (!livro.isDisponivel()) {
                            System.out.println("Este livro já está emprestado!\n");
                            break;
                        }

                        System.out.print("Digite o CPF do usuário: ");
                        String cpfUsuario = sc.nextLine();

                        Usuario usuario = biblioteca.buscarUsuarioPorCpf(cpfUsuario);
                        if (usuario == null) {
                            System.out.println("Usuário não encontrado!\n");
                            break;
                        }

                        System.out.print("Data do pedido: ");
                        String dataPedido = sc.nextLine();

                        System.out.print("Data de entrega: ");
                        String dataDevolucao = sc.nextLine();

                        biblioteca.realizarEmprestimo(idLivro, cpfUsuario, dataPedido, dataDevolucao);
                        break;
                    case 2:
                        System.out.println("========== EMPRÉSTIMOS ATIVOS ==========\n");
                        biblioteca.listarEmprestimosAtivos();
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("========== Devolução Do Livro ==========\n");
                        System.out.print("Digite o ID do livro: ");
                        int idDevolucao = sc.nextInt();
                        sc.nextLine();

                        biblioteca.devolverLivro(idDevolucao);
                        break;
                    case 0:
                        break;
                }
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
        }
    }
}