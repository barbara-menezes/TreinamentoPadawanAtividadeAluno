package br.com.frw;

public enum ItemMenu {

    CADASTRAR(1, "Cadastrar novo aluno:"),
    CONSULTAR(2, "Consultar aluno por matricula:"),
    LISTAR_APROVADOS(3, "Listar alunos aprovados:"),
    LISTAR_REPROVADOS(4, "Listar alunos reprovados:"),
    LISTAR_RECUPERACAO(5, "Listar alunos de recuperação:"),
    SAIR(6, "Sair:");

    private int opcao;
    private String descricao;

    ItemMenu(int opcao, String descricao) {
        this.opcao = opcao;
        this.descricao = descricao;
    }

    public int getOpcao() {
        return opcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ItemMenu buscarPorOpcao(int opcao) {

        for (ItemMenu item: values()) {
            if (item.getOpcao() == opcao) {
                return item;
            }
        }
        return SAIR;
    }


}
