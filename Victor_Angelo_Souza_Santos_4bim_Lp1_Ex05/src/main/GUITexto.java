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
        List<PersonagemWOW> lt = controle.listar();

        System.out.println("Nome,Sexo,Facção,Raça,Classe,Data de Criação"
                + "Nivel");
        for (PersonagemWOW personagemwow : lt) {
            System.out.println(personagemwow);
        }

        entrada.pausaEnter();
    }

    public void telaRetrieve() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("RETRIEVE\n");
        String nome = entrada.lerString
        ("Digite o nome do personagem de wow");
        PersonagemWOW personagemwow = controle.buscar(nome);
        if (personagemwow != null) {
            saida.rotuloString("Nome do Personagem de WOW", nome);
            saida.rotuloString("Sexo do Personagem de WOW", 
            personagemwow.getSexo());
            saida.rotuloString("Facção do Personagem de WOW", 
                    personagemwow.getFacção());
            saida.rotuloString("Raça do Personagem de WOW", 
                    personagemwow.getRaça());
            saida.rotuloString("Raça do Personagem"
                    + " de WOW",
                    personagemwow.getRaça());
            saida.rotuloString("Classe do Personagem "
                    + "de WOW",
                    personagemwow.getClasse());
            saida.imprimirData("Data de criação do Personagem de WOW",
                    personagemwow.getDatadecriação());
            saida.imprimirNumeroInteiro("Nivel do Personagem de WOW",
                    personagemwow.getNevel());
        } else {
            saida.rotuloString("Não encontrou esse nome",
                    nome);
        }
        entrada.pausaEnter();
    }

    public void telaCreate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("INSERT\n");
        entrada.teclado.reset();
        String nome = entrada.lerString
        ("Digite o nome do personagemwow");
        PersonagemWOW trab = controle.buscar(nome);
        if (trab == null) { //não achou, então pode adicionar
            PersonagemWOW personagemwow = new PersonagemWOW();
            personagemwow.setNome(nome);
            personagemwow.setSexo(entrada.lerString("Digite o sexo do "
                    + "Personagem de WOW"));
            personagemwow.setFacção(entrada.lerString("Digite a facção do "
                    + "Personagem de WOW"));
            personagemwow.setRaça(entrada.lerString("Digite a raça "
                    + "PersonagemWOW"));
            personagemwow.setClasse(entrada.lerString("Digite a "
                    + "classe"));
            personagemwow.setDatadecriação(entrada.lerData("Digite a data de "
                    + "criação do personagem de WOW no formato dd/MM/yyyy"));
            personagemwow.setNevel(entrada.lerNumeroInteiro("Digite o nivel"
                    + " do personagem de WOW"));
            controle.adicionar(personagemwow);
        } else {
            System.out.println(trab);
            System.out.println("Personagem de WOW já cadastrado");
            entrada.pausaEnter();
        }
    }

    public void telaUpdate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("UPDATE\n");
        entrada.teclado.reset();
        String nome = entrada.lerString
        ("Digite o nome do personagem de wow");
        PersonagemWOW personagemwow = controle.buscar(nome);
        if (personagemwow != null) { //achou, então pode alterar
            PersonagemWOW personagemwowAntigo = personagemwow; 
            //guarda dados para pesquisa no controle
            saida.rotuloString("Nome atual do Personagem de WOW", 
                    personagemwow.getNome());
            personagemwow.setNome(entrada.lerString("Digite o novo nome do "
                    + "Personagem de WOW"));
            saida.rotuloString("Sexo atual do Personagem de WOW", personagemwow
                    .getSexo());
            personagemwow.setSexo(entrada.lerString("Digite o novo sexo do"
                    + " Personagem de WOW"));
            saida.rotuloString("Facção atual do Personagem de WOW", personagemwow.getFacção());
            personagemwow.setFacção(entrada.lerString("Digite a nova facção "
                    + "do Personagem de WOW"));
            saida.rotuloString("Raça atual do Personagem de WOW", personagemwow.getRaça());
             personagemwow.setRaça(entrada.lerString("Digite anova Raça "
                     + "do Personagem de WOW"));
            saida.rotuloString("Classe atual do Personagem de WOW",
                    personagemwow.getClasse());
            personagemwow.setClasse(entrada.lerString("Digite a nova classe"
                    + "do Personagem de WOW"));  
            saida.imprimirData("Data de criação atual do Personagem de WOW",
                    personagemwow.getDatadecriação());
            personagemwow.setDatadecriação(entrada.lerData("Digite a nova data "
                    + " de criação do personagem de WOW no formato "
                    + "dd/MM/yyyy"));            
            saida.imprimirNumeroInteiro("Nivel atual do Personagem de WOW",
                    personagemwow.getNevel());
            personagemwow.setNevel(entrada.lerNumeroInteiro("Digite o novo "
                    + "nivel do personagem de WOW"));            
            controle.alterar(personagemwow, personagemwowAntigo);
        } else {
            System.out.println("Personagem de WOW não cadastrado,"
                    + " impossível alterar");
            entrada.pausaEnter();
        }
    }

    public void telaDelete() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("DELETE\n");
        entrada.teclado.reset();
        String nome = entrada.lerString
        ("Digite o nome do personagemwow");
        PersonagemWOW personagemwow = controle.buscar(nome);
        if (personagemwow != null) { //achou, então pode excluir
            saida.rotuloString("Nome do Personagem de WOW", nome);
            saida.rotuloString("Sexo do Personagem de WOW", 
            personagemwow.getSexo());
            saida.rotuloString("Facção do Personagem de WOW", 
                    personagemwow.getFacção());
            saida.rotuloString("Raça do Personagem de WOW", 
                    personagemwow.getRaça());
            saida.rotuloString("Raça do Personagem"
                    + " de WOW",
                    personagemwow.getRaça());
            saida.rotuloString("Classe do Personagem "
                    + "de WOW",
                    personagemwow.getClasse());
            saida.imprimirData("Data de criação do Personagem de WOW",
                    personagemwow.getDatadecriação());
            saida.imprimirNumeroInteiro("Nivel do Personagem de WOW",
                    personagemwow.getNevel());      
       if (entrada.lerConfirmacao("Excluir esse personagem de WOW?")) {
            controle.excluir(personagemwow);
            }
        } else {
            System.out.println("PersonagemWOW não cadastrado,"
                    + " exclusão impossível");
            entrada.pausaEnter();
        }
    }

    public GUITexto() {
        Entrada entrada = new Entrada();
        String caminho = "PersonagemWOW.csv";
        //carregar dados do HD para memória RAM
        //controle.carregarDados(caminho);
        
        
        int opcao = 0;
        while (opcao != 6) {
            tools.clearScreen();
            System.out.println("CRUD - PersonagemWOW\n");
            System.out.println("\nMenu Principal\n");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");

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
                case 6:
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
