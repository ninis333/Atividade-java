public class Turma {
    private String curso;
    private String sigla;
    private Periodo periodo;

    public Turma(String , String sigla, Periodo periodo) {
        this.curso = curso;
        this.sigla = sigla;
        this.periodo = periodo;
    }
    public Turma() {
        this.curso = "";
        this.sigla = "";
        this.periodo = Periodo.INTEGRAL;
    }

    public String getCurso() {
        return curso;
    }

    public String getSigla() {
        return sigla;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "curso='" + curso + '\'' +
                ", sigla='" + sigla + '\'' +
                ", periodo=" + periodo +
                '}';
    }
}
