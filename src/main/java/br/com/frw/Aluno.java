package br.com.frw;

public class Aluno {

    private String matricula;
    private String nome;
    private String turma;

    private Long notaProva1;
    private Long notaProva2;
    private Long notaProva3;
    private Long notaExercicios;

    private Long notaTotal;

    private StatusAluno status;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Long getNotaProva1() {
        return notaProva1;
    }

    public void setNotaProva1(Long notaProva1) {
        this.notaProva1 = notaProva1;
    }

    public Long getNotaProva2() {
        return notaProva2;
    }

    public void setNotaProva2(Long notaProva2) {
        this.notaProva2 = notaProva2;
    }

    public Long getNotaProva3() {
        return notaProva3;
    }

    public void setNotaProva3(Long notaProva3) {
        this.notaProva3 = notaProva3;
    }

    public Long getNotaExercicios() {
        return notaExercicios;
    }

    public void setNotaExercicios(Long notaExercicios) {
        this.notaExercicios = notaExercicios;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public void setStatus(StatusAluno status) {
        this.status = status;
    }

    public Long getNotaTotal() {
        return notaTotal;
    }

    public void calculaNotaTotal() {
        this.notaTotal = this.notaProva1 + this.notaProva2 + this.notaProva3 + this.notaExercicios;

        if (this.notaTotal > 100) {
            this.notaTotal = 100L;
        }

        this.calculaStatusAprovacao();
    }

    private void calculaStatusAprovacao() {
        this.status = StatusAluno.buscarPorNota(this.notaTotal);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", turma='" + turma + '\'' +
                ", notaTotal=" + notaTotal +
                ", status=" + status +
                '}';
    }
}
