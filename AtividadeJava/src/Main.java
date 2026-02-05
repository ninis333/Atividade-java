import java.lang.reflect.Array;
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

    private static void menuTumas() {
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
        for (Turma t : listaTurmas){
            System.out.println(t);
        }
    }

    private static void cadastrarTurmas() {

    }

    private static void atualizarTurmas() {

    }

    private static void excluirTurmas() {

    }


}