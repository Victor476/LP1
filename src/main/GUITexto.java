package main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.util.List;
import tools.Tools;

public class GUITexto {

    Tools tools = new Tools();

    Saida saida = new Saida();
    Controle controle = new Controle();
    
  

    public void telaList() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        List<Estrela> lt = controle.listar();

        System.out.println("ID;NOME;MASSA;COR;DATA DE DESCOBERTA");
        for (Estrela estrela : lt) {
            System.out.println(estrela);
        }

        entrada.pausaEnter();
    }

    public void telaRetrieve() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("RETRIEVE\n");
        long Id = entrada.lerNumeroInteiro("Digite o ID do estrela");
        Estrela estrela = controle.buscar(Id);
        if (estrela != null) {
            saida.imprimirNumeroInteiro("ID", estrela.getId());
            saida.rotuloString("Nome:", estrela.getNome());
            saida.imprimirNumeroDouble("Massa", estrela.getMassa());
            saida.rotuloString("Cor", estrela.getCor());
        } else {
            saida.imprimirNumeroInteiro("Não encontrou esse Id", Id);
        }
        entrada.pausaEnter();
    }

    public void telaCreate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("INSERT\n");
        entrada.teclado.reset();
        long Id = entrada.lerNumeroInteiro("Digite o ID do estrela");
        Estrela trab = controle.buscar(Id);
        if (trab == null) { //não achou, então pode adicionar
            Estrela estrela = new Estrela();
            estrela.setId(Id);
            estrela.setNome(entrada.lerString("Digite o nome"));
            estrela.setMassa(entrada.lerNumeroDouble("Digite o salário"));
            estrela.setCor(entrada.lerString("Cor"));
            controle.adicionar(estrela);
        } else {
            System.out.println(trab);
            System.out.println("Estrela já cadastrado");
            entrada.pausaEnter();
        }
    }

    public void telaUpdate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("UPDATE\n");
        entrada.teclado.reset();
        long Id = entrada.lerNumeroInteiro("Digite o ID do estrela");
        Estrela estrela = controle.buscar(Id);
        if (estrela != null) { //achou, então pode alterar
            Estrela estrelaAntigo = estrela; //guarda dados para pesquisa no controle
            estrela.setId(Id);
            saida.rotuloString("Nome atual: ", estrela.getNome());
            estrela.setNome(entrada.lerString("Digite o novo nome"));
            saida.imprimirNumeroDouble("Massa atual", estrela.getMassa());
            estrela.setMassa(entrada.lerNumeroDouble("Digite o novo salário"));
            saida.rotuloString("Cor", estrela.getCor());
            estrela.setCor(entrada.lerString("Cor"));
            controle.alterar(estrela, estrelaAntigo);
        } else {
            System.out.println("Estrela não cadastrado, impossível alterar");
            entrada.pausaEnter();
        }
    }

    public void telaDelete() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("DELETE\n");
        entrada.teclado.reset();
        long Id = entrada.lerNumeroInteiro("Digite o ID do estrela");
        Estrela estrela = controle.buscar(Id);
        if (estrela != null) { //achou, então pode excluir
            estrela.setId(Id);
            saida.imprimirNumeroInteiro("ID", Id);
            saida.rotuloString("Nome: ", estrela.getNome());
            saida.imprimirNumeroDouble("Massa", estrela.getMassa());
            saida.rotuloString("Cor", estrela.getCor());
            if (entrada.lerConfirmacao("Excluir esse estrela?")) {
                controle.excluir(estrela);
            }
        } else {
            System.out.println("Estrela não cadastrado, exclusão impossível");
            entrada.pausaEnter();
        }
    }

    public GUITexto() {
        Entrada entrada = new Entrada();
        String caminho = "Estrela.csv";
        //carregar dados do HD para memória RAM
        controle.carregarDados(caminho);
        
        
        int opcao = 0;
        while (opcao != 9) {
            tools.clearScreen();
            System.out.println("CRUD - Estrela\n");
            System.out.println("\nMenu Principal\n");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Listar");
            System.out.println("9 - Sair");

            opcao = entrada.lerNumeroInteiroInt("Qual a opção");

            switch (opcao) {
                case 1:
                    telaCreate();
                    break;
                case 2:
                    telaRetrieve();
                    break;
                case 3:
                    telaUpdate();
                    break;
                case 4:
                    telaDelete();
                    break;
                case 5:
                    telaList();
                    break;
                case 9:
                    //antes de sair, transferir para o HD
                    controle.gravarLista(caminho);
                    System.out.println("\n\nBye");

                    break;

                default:
                    System.out.println("Opção errada, tente novamente");
            }

        }

    }

}
