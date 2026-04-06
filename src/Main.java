import org.w3c.dom.CDATASection;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("\n==== Secretaria ====");
        System.out.println("1 - Alunos");
        System.out.println("2 - Turmas");
        System.out.println("3 - Sair");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                menuAlunos();
                break;
            case "2":
                menuTurmas();
                break;
            case "3":
                System.out.println("Até breve...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuPrincipal();
        }

    }

    private static void menuTurmas() {
        System.out.println("\n==== Turmas ====");
        System.out.println("1 - Listar Turmas");
        System.out.println("2 - Cadastrar Turma");
        System.out.println("3 - Atualizar Turma");
        System.out.println("4 - Excluir Turma");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarTurmas();
                menuTurmas();
                break;
            case "2":
                cadastrarTurma();
                menuTurmas();
                break;
            case "3":
                atualizarTurma();
                menuTurmas();
                break;
            case "4":
                excluirTurma();
                menuTurmas();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuTurmas();
        }
    }

    private static void menuAlunos() {
        System.out.println("\n==== Alunos ====");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Atualizar Aluno");
        System.out.println("4 - Excluir Aluno");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarAlunos();
                menuAlunos();
                break;
            case "2":
                cadastrarAluno();
                break;
            case "3":
                atualizarAluno();
                break;
            case "4":
                excluirAluno();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente");
                menuAlunos();
        }
    }

    private static void excluirTurma() {
        if(isVazioTurmas(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }

        listarTurmasIndiceSigla();

        int idExcluir = validaIdTurma();

        if (confirmaExclusao()){
//            listaTurmas.remove(idExcluir);
            listaTurmas.get(idExcluir).setAtivo(false);
            System.out.println("Turma excluída com sucesso!");
        }
    }

    private static boolean isVazioTurmas(ArrayList<Turma> listaTurmas) {
        if (listaTurmas.isEmpty()) return true;

        for (Turma turma : listaTurmas){
            if (turma.isAtivo()) return false;
        }

        return true;
    }

    private static boolean isVazioAlunos(ArrayList<Aluno> listaAlunos) {
        if (listaAlunos.isEmpty()) return true;

        for (Aluno aluno : listaAlunos){
            if (aluno.isAtivo()) return false;
        }

        return true;
    }

    private static boolean confirmaExclusao() {
        while (true) {
            String confirma = Leitura.dados("Você tem certeza? (S/N): ").toUpperCase();
            switch (confirma) {
                case "S":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Opção inválida, digite S para sim ou N para não!");
                    break;
            }
        }
    }

    private static int validarItemLista(String opcao) {
        if (opcao.isBlank()) return -1;

        int opcaoNumero = -1;

        try{
            opcaoNumero = Integer.parseInt(opcao);
        } catch (NumberFormatException e) {
            return -1;
        }

        int indiceLista = opcaoNumero-1;
        return indiceLista >= 0 && listaTurmas.size() > indiceLista ? indiceLista : -1;
    }

    private static void listarTurmasIndiceSigla() {
        System.out.println("\nLista das Turmas:");
        for (int i=0;i<listaTurmas.size();i++){
            if (listaTurmas.get(i).isAtivo())
                System.out.printf("\n%d - %s",i+1, listaTurmas.get(i).getSigla());
        }
    }

    private static void listaralunoIndice() {
        System.out.println("\nLista das Alunos:");
        for (int i=0;i<listaAlunos.size();i++){
            if (listaAlunos.get(i).isAtivo())
                System.out.printf("\n%d - %s",i+1, listaAlunos.get(i).getNome());
        }
    }

    private static void atualizarTurma() {
        if(isVazioTurmas(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }

        listarTurmasIndiceSigla();

        int idAtualizar = validaIdTurma();

        System.out.printf("O período atual é: %s", listaTurmas.get(idAtualizar).getPeriodo());
        atualizarParcial("período", idAtualizar);

        System.out.printf("O curso atual é: %s", listaTurmas.get(idAtualizar).getCurso());
        atualizarParcial("curso", idAtualizar);

        System.out.printf("A sigla atual é: %s", listaTurmas.get(idAtualizar).getSigla());
        atualizarParcial("sigla", idAtualizar);

    }

    private static void atualizarParcialAluno (String atributo, int atualizarAlunoIndice){
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcao= Leitura.dados("\nDeseja modificar a "+ atributo + "(S/N)?").toUpperCase();
            switch (opcao) {
                case "S":
                    switch (atributo){
                        case "nome":
                            String nome  = validarNome();
                            listaAlunos.get(atualizarAlunoIndice).setNome(nome);
                            break;
                        case "curso":
                            LocalDate dataNascimento = validarData();
                            listaAlunos.get(atualizarAlunoIndice).setDataNascimento(dataNascimento);
                            break;
                        case "turma":
                            Turma turma  = validaTurma();
                            listaAlunos.get(atualizarAlunoIndice).setTurma(turma);
                            break;
                    }
                    System.out.println(atributo + " atualizado com sucesso!");
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");

            }

        }
    }


    private static void atualizarParcial(String atributo, int idAtualizar){
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcao = Leitura.dados("\nDeseja modificar "+ atributo +" ? (S/N): ").toUpperCase();
            switch (opcao) {
                case "S":
                    switch (atributo){
                        case "período":
                            Periodo periodo = validarPeriodo();
                            listaTurmas.get(idAtualizar).setPeriodo(periodo);
                            break;
                        case "curso":
                            String curso = validarCurso();
                            listaTurmas.get(idAtualizar).setCurso(curso);
                            break;
                        case "sigla":
                            String sigla = validarSigla();
                            listaTurmas.get(idAtualizar).setSigla(sigla);
                            break;
                    }
                    System.out.println(atributo + " atualizado com sucesso!");
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");
            }
        }
    }

    private static String validarSigla() {
        String sigla = Leitura.dados("Digite a sigla: ");
        while(!validarSigla(sigla)){
            System.out.println("Sigla inválida! Precisa conter texto e não pode ser repetida");
            sigla = Leitura.dados("Digite a sigla: ");
        }
        return sigla;
    }

    private static String validarCurso() {
        String curso = Leitura.dados("Digite o curso: ");
        while(!isCharacter(curso)) {
            System.out.println("Nome de curso inválido! Não use números ou caracteres especiais, por favor");
            curso = Leitura.dados("Digite o curso: ");
        }
        return curso;
    }

    private static void atualizarPeriodo(int idAtualizar) {
        boolean rodarNovamente = true;
        while (rodarNovamente) {
            String opcaoPeriodo = Leitura.dados("\nDeseja modificar o período? (S/N): ").toUpperCase();
            switch (opcaoPeriodo) {
                case "S":
                    Periodo periodo = validarPeriodo();
                    listaTurmas.get(idAtualizar).setPeriodo(periodo);
                    System.out.println("Período atualizado com sucesso para " + periodo);
                    rodarNovamente = false;
                    break;
                case "N":
                    rodarNovamente = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha S para SIM ou N para NÃO");
            }
        }

////                Periodo periodo = validarPeriodo();
////                listaTurmas.get(idAtualizar).setPeriodo(periodo);
    }

    private static int validaIdTurma() {
        String opcao = Leitura.dados("\nDigite o número da turma desejada: ");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
        while (opcaoValida==-1){
            opcaoUsuario = validarItemLista(opcao);

            if (opcaoUsuario==-1) {
                System.out.println("Opção inválida! Digite novamente: ");
                opcao = Leitura.dados("Digite o número da turma desejada: ");
            } else {
                opcaoValida = opcaoUsuario;
            }
        }
        return opcaoValida;
    }

    private static int validaIdAluno(){
        String opcao = Leitura.dados("\nDigite o aluno que deseja: ");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
        while (opcaoValida == -1) {
            opcaoUsuario = validarItemLista(opcao);

            if (opcaoUsuario == -1) {
                System.out.println("Opção inválida! Digite novamente:");
                opcao = Leitura.dados("Digite o Id da turma que deseja:");
            } else {
                opcaoValida = opcaoUsuario;
            }

        }
        return opcaoValida;
    }

    private static void cadastrarTurma() {
        Periodo periodo = validarPeriodo();
        String curso = validarCurso();
        String sigla = validarSigla();

        Turma turma = new Turma(curso, sigla, periodo);
        listaTurmas.add(turma);
    }

    private static boolean validarSigla(String sigla) {
        if (sigla.isBlank()) return false;

        for (Turma turma : listaTurmas){
            if (turma.getSigla().equals(sigla)){
                return false;
            }
        }
        return true;
    }

    private static boolean isCharacter(String texto) {
        String textoSemNumeros = texto.replaceAll("\\d", "");
        return !texto.isBlank() && texto.equals(textoSemNumeros);
    }

    private static Periodo validarPeriodo() {
        String opcaoPeriodo = Leitura.dados("""
                Digite o número do período escolhido:
                1 - Matutino
                2 - Vespertino
                3 - Noturno
                4 - Integral""");
        switch (opcaoPeriodo){
            case "1":
                return Periodo.MATUTINO;
            case "2":
                return Periodo.VESPERTINO;
            case "3":
                return Periodo.NOTURNO;
            case "4":
                return Periodo.INTEGRAL;
            default:
                System.out.println("Opção inválida, digite novamente");
                return validarPeriodo();
        }
    }

    private static void listarTurmas() {
        if(isVazioTurmas(listaTurmas)) {
            System.out.println("Não há turmas cadastradas");
            return;
        }
        for(Turma t : listaTurmas){
            if (t.isAtivo())
                System.out.println(t);
        }
    }

    private static void excluirAluno() {
        if(isVazioAlunos(listaAlunos)) {
            System.out.println("Não há alunos cadastradas");
            return;
        }
//

        listarAlunoIndice();

        int idExcluir = validaIdAluno();
//
        if (confirmaExclusao()){
            listaAlunos.get(idExcluir).setAtivo(false);
            System.out.println("Aluno excluído com sucesso!");
        }


    }

    private static void listarAlunoIndice() {
        System.out.println("\nLista de alunos:");
        for (int i=0;i<listaAlunos.size();i++){
            if (listaAlunos.get(i).isVazioAlunos())
                System.out.printf("\n%d - %s", i + 1, listaAlunos.get(i).getNome());
        }
    }

    private static void atualizarAluno() {

    }

    private static void cadastrarAluno() {

        String nome = validarNome();
        LocalDate dataNascimento = validarData();
        Turma turma = validaTurma();
        Aluno aluno = new Aluno(nome, dataNascimento, turma);
        listaAlunos.add(aluno);

    }

    private static Turma validaTurma() {
        int turmaAluno = turmaAluno();
        System.out.printf("\nA turma escolhida é: %s\n",listaTurmas.get(turmaAluno).getCurso());
        return listaTurmas.get(turmaAluno);
    }

    private static int turmaAluno() {
        listarTurmasIndiceSigla();
        String turmaAluno = Leitura.dados("/n Em qual turma deseja colocar o alno?");
        int opcaoValida = -1;
        int opcaoUsuario = -1;
        while (opcaoValida == -1) {
            opcaoUsuario = validarItemLista(turmaAluno);

            if (opcaoUsuario == -1) {
                System.out.println("Opção inválida! Digite novamente:");
                turmaAluno = Leitura.dados("Digite o Id da turma que deseja:");
            } else {
                opcaoValida = opcaoUsuario;
            }

        }
        return opcaoValida;

    }

    private static LocalDate validarData() {
        while(true){
            String dataAluno = Leitura.dados("/nQual a data de nascimento do aluno");


        }
    }

    private static boolean isData(LocalDate data){
        LocalDate hoje = LocalDate.now();

        if(data.isAfter(hoje)){
            System.out.println("Data não pode ser no futuro.");
            return false;
        }

        if (data.isAfter(hoje.minusYears(14))){
            System.out.println("Aluno deve ter no mínimo 14 anos.");
            return false;
        }

        if(data.isBefore(hoje.minusYears(130))){
            System.out.println("Idade inválida");
            return false;
        }
        return true;
    }

    private static String validarNome() {
        String nome = Leitura.dados("\nQual o nome do aluno?");
        while (!isCharacter(nome)){
            System.out.println("Nome do aluno inválido! Não use caracteres especiais ou números");
            nome = Leitura.dados("Digite o nome novamente: ");
        }
        return nome;
    }

    private static void listarAlunos() {
        if (isVazioAlunos(listaAlunos)){
            System.out.println("Não há turmas cadastradas");
            menuAlunos();
        }

        for (Aluno a : listaAlunos) {
            if (a.isAtivo())
                System.out.println(a);
        }

    }
}

