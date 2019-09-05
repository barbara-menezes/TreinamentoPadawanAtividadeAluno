package br.com.frw;

public enum StatusAluno {

    APROVADO("Aprovado"),
    RECUPERACAO_PROVA_1("Recuperação Prova I"),
    RECUPERACAO_PROVA_2("Recuperação Prova II"),
    REPROVADO("Reprovado");


    private String descricao;


    StatusAluno(String descricao) {
        this.descricao = descricao;
    }

    public static StatusAluno buscarPorNota(Long notaTotal) { //60
        if (notaTotal >= 60) {
            return APROVADO;
        }

        if (notaTotal >= 50) {
            return RECUPERACAO_PROVA_1;
        }

        if (notaTotal >= 40) {
            return RECUPERACAO_PROVA_2;
        }

        return REPROVADO;
    }

    public String getDescricao() {
        return descricao;
    }
}
