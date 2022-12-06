package UI;

import CDU.CDUMain;
import persistencia.*;

/**
 * Classe Principal que inicia o Programa
 * 
 * @author Josué Ramos Souza
 * @version 2.0
 * @jramso
 */
public class Main {

    public static void main(String[] args) {

        FormMain tela = new FormMain();
        CDUMain cdu = new CDUMain(tela);
        cdu.exec();

    }

}
