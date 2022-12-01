package UI;

import java.io.Console;

import CDU.*;

public class FormMain implements Form{
    
    private CDUMain cdumain = null;

    public void setcdu(CDUMain cdumain) {
        this.cdumain = cdumain;
    }

    public void exibe() {
        String opcao;
        Console c = System.console();
        boolean termina = false;

        System.out.println("POOFlix\n");

        while (!termina) {
            System.out.println("1. Cadastrar Série\n");
            System.out.println("2. Cadastrar Episódio\n");
            System.out.println("3. Cadastrar Personagem\n");
            System.out.println("4. Cadastrar Ator\n");
            System.out.println("5. Sair\n");

            opcao = (String) c.readLine("Digite a opção desejada: ");
            System.out.println(opcao);

            termina = opcao.equals("5");

            if (!termina) {
                cdumain.processaOpcao(opcao);
            }
        }
    }
}
