import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();
    public static void main(String[] args) {
        menuPrincipal();
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }

    public static void menuPrincipal(){
        System.out.println("--- Secretaria ---");
        System.out.println("1 - Alunos");
        System.out.println("2 - Turmas");
        String opcao = Leitura.dados("Digite a opção desejada: ");

        switch (opcao) {

            case "1":
                menuAlunos();
                break;

            case "2":
                menuTumas();
                break;

            case "3":
                System.out.println("tchau");
                System.exit(0);

    }
}

    private static void menuAlunos() {
        System.out.println("--- Alunos ---");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Cadastrar Alunos");
        System.out.println("3 - Atualizar Alunos");
        System.out.println("4 - Excluir Alunos");
        System.out.println("5 - Voltar");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarAlunos();
                break;
            case "2":
                cadastrarAlunos();
                break;
            case "3":
                atualizarAlunos();
                break;
            case "4":
                excluirAlunos();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida");

        }
    }

    private static void menuTurmas() {
        System.out.println("--- Turmas ---");
        System.out.println("1 - Listar Turmas");
        System.out.println("2 - Cadastrar Turmas");
        System.out.println("3 - Atualizar Turmas");
        System.out.println("4 - Excluir Turmas");
        System.out.println("5 - Voltar");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarTurmas();
                break;
            case "2":
                cadastrarTurmas();
                break;
            case "3":
                atualizarTurmas();
                break;
            case "4":
                excluirTurmas();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida");

        }
    }


    private static void listarAlunos() {
        for (Aluno a : listaAlunos){
            System.out.println(a);
        }

    }

    private static void cadastrarAlunos() {

    }

    private static void atualizarAlunos() {
    }

    private static void excluirAlunos() {

    }

    private static void listarTurmas() {
        if(listaTurmas.isEmpty()){
            System.out.println("Não há turmas cadastradas");
            return;
        }

        for (Turma t : listaTurmas){
            System.out.println(t);
        }
    }

    private static void cadastrarTurmas() {
        Periodo periodo = validarPeriodo();

        String curso = Leitura.dados("Digte o curso: ");
        while (!isCharacter(curso)) {
            System.out.println("nome de curso iválido");
            curso = Leitura.dados("Digite o curso");
        }
        String sigla = Leitura.dados("Digite a sigla");
        boolean repetido = true;
        while (sigla.isBlank()) || !repetido {
            System.out.println("Sigla inválida");
            sigla = Leitura.dados("Digite a sigla");
            sigla = sigla.toUpperCase();

        for (Turma t : listaTurmas){
            if (t.getSigla().equals(sigla)){
                System.out.println("Turma já cadastrada!");
                

            }
        }
        repetido = false;
        }
        Turma turma = new Turma(curso, sigla, periodo);
        listaTurmas.add(turma)}


    private static boolean isCharacter(String texto) {
            String textoSemNumeros = texto.replaceAll("\\d","");
            return !texto.isBlank() && texto.equals(textoSemNumeros);
    }

    private static Periodo validarPeriodo() {
        Periodo periodo;
        String opcaoPeriodo = Leitura.dados(
                        """Digite o número do peiodo escolhido:
                         1- Matutino
                         2- Vespertino
                         3- Noturno
                         4- Integral""");
        switch (opcaoPeriodo) {
            case "1":
                return Periodo.MATUTINO;
            case "2":
                return Periodo.VESPERTINO;
            case "3":
                return Periodo.NOTURNO;
            case "4":
                return Periodo.INTEGRAL;
            default:
                System.out.println("Opção inválida");
                return validarPeriodo();

        }

    }

    private static void atualizarTurmas() {

    }

    private static void excluirTurmas() {

    }


}