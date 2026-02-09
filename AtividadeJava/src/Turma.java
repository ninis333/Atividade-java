public class Turma {
    private String cuso;
    private String sigla;
    private Periodo periodo;

    public Turma(String cuso, String sigla, Periodo periodo) {
        this.cuso = cuso;
        this.sigla = sigla;
        this.periodo = periodo;
    }
    public Turma() {
        this.cuso = "";
        this.sigla = "";
        this.periodo = Periodo.INTEGRAL;
    }

    public String getCuso() {
        return cuso;
    }

    public String getSigla() {
        return sigla;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setCuso(String cuso) {
        this.cuso = cuso;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
