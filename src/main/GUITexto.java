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
        List<ElementoQuimico> lt = controle.listar();

        System.out.println("NUMERO DE PROTONS;NOME DO ELEMENTO;NUMERO DE MASSA;"
                + "SIMBOLO;CAMADA DE VALENCIA;RAIO ATOMICO;ELETRONEGATIVIDADE");
        for (ElementoQuimico elementoquimico : lt) {
            System.out.println(elementoquimico);
        }

        entrada.pausaEnter();
    }

    public void telaRetrieve() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("RETRIEVE\n");
        int numerodeProtons = entrada.lerNumeroInteiro
        ("Digite o NUMERO DE PROTONS do elementoquimico");
        ElementoQuimico elementoquimico = controle.buscar(numerodeProtons);
        if (elementoquimico != null) {
            saida.imprimirNumeroInteiro("NUMERO DE PROTONS", elementoquimico.
                    getNumerodeProtons());
            saida.rotuloString("Nome:", elementoquimico.getNomeElem());
            saida.rotuloString("Simbolo:", elementoquimico.getSimbolo());
            saida.rotuloString("Camada de Valencia:",
                    elementoquimico.getCamadadevalencia());
            saida.imprimirNumeroDouble("Numero de Massa", 
                    elementoquimico.getNumeroMassa());
            saida.imprimirNumeroDouble("Raio Atomico", 
                    elementoquimico.getRaioatomico());
            saida.imprimirNumeroDouble("Eletronegatividade", 
                    elementoquimico.getEletronegatividade());

        } else {
            saida.imprimirNumeroInteiro("Não encontrou esse numerodeProtons",
                    numerodeProtons);
        }
        entrada.pausaEnter();
    }

    public void telaCreate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("INSERT\n");
        entrada.teclado.reset();
        int numerodeProtons = entrada.lerNumeroInteiro(
                "Digite o NUMERO DE PROTONS do elementoquimico");
        ElementoQuimico trab = controle.buscar(numerodeProtons);
        if (trab == null) { //não achou, então pode adicionar
            ElementoQuimico elementoquimico = new ElementoQuimico();
            elementoquimico.setNumerodeProtons(numerodeProtons);
            elementoquimico.setNomeElem(entrada.lerString("Digite o nome"));
            elementoquimico.setNumeroMassa(entrada.lerNumeroDouble(
                    "Digite o salário"));
            
            controle.adicionar(elementoquimico);
        } else {
            System.out.println(trab);
            System.out.println("ElementoQuimico já cadastrado");
            entrada.pausaEnter();
        }
    }

    public void telaUpdate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("UPDATE\n");
        entrada.teclado.reset();
        String numerodeProtons = entrada.lerString("Digite o NUMERO DE PROTONS do elementoquimico");
        ElementoQuimico elementoquimico = controle.buscar(numerodeProtons);
        if (elementoquimico != null) { //achou, então pode alterar
            ElementoQuimico elementoquimicoAntigo = elementoquimico; //guarda dados para pesquisa no controle
            elementoquimico.setNumerodeProtons(numerodeProtons);
            saida.rotuloString("Nome atual: ", elementoquimico.getNomeElem());
            elementoquimico.setNomeElem(entrada.lerString("Digite o novo nome"));
            saida.imprimirNumeroDouble("Numero de Massa atual", elementoquimico.getNumeroMassa());
            elementoquimico.setNumeroMassa(entrada.lerNumeroDouble("Digite o novo salário"));
            saida.rotuloString("Aposentado", elementoquimico.isAposentado() ? "SIM" : "NÃO");
            elementoquimico.setAposentado(entrada.lerConfirmacao("Aposentado"));
            controle.alterar(elementoquimico, elementoquimicoAntigo);
        } else {
            System.out.println("ElementoQuimico não cadastrado, impossível alterar");
            entrada.pausaEnter();
        }
    }

    public void telaDelete() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("DELETE\n");
        entrada.teclado.reset();
        int numerodeProtons = entrada.lerNumeroInteiro(""
                + "Digite o NUMERO DE PROTONS do elementoquimico");
        ElementoQuimico elementoquimico = controle.buscar(numerodeProtons);
        if (elementoquimico != null) { //achou, então pode excluir
            elementoquimico.setNumerodeProtons(numerodeProtons);
            saida.imprimirNumeroDouble("NUMERO DE PROTONS", numerodeProtons);
            saida.rotuloString("Nome do Elemento: ", elementoquimico.
                    getNomeElem());
            saida.imprimirNumeroDouble("Numero de Massa", elementoquimico.
                    getNumeroMassa());
            if (entrada.lerConfirmacao("Excluir esse elementoquimico?")) {
                controle.excluir(elementoquimico);
            }
        } else {
            System.out.println("ElementoQuimico não cadastrado,"
                    + " exclusão impossível");
            entrada.pausaEnter();
        }
    }

    public GUITexto() {
        Entrada entrada = new Entrada();
        String caminho = "ElementoQuimico.csv";
        //carregar dados do HD para memória RAM
        controle.carregarDados(caminho);
        
        
        int opcao = 0;
        while (opcao != 9) {
            tools.clearScreen();
            System.out.println("CRUD - ElementoQuimico\n");
            System.out.println("\nMenu Principal\n");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Listar");
            System.out.println("9 - Sair");

            opcao = entrada.lerNumeroInteiro("Qual a opção");

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
