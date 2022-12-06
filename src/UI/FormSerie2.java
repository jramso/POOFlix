package UI;

//import java.io.Console;
import CDU.*;

public class FormSerie2 implements Form {
    private String id;
    private String titulo;
    private String idademin;
    private CDUcadastrarSerie cducs;

    public void setcdu(CDUcadastrarSerie cducs) {
        this.cducs = cducs;
    }

    public void exibe() {
        Console c = new Console();
        boolean termina = false;
        String continuar;

        System.out.println("CADASTRANDO SÉRIE\n");

        do {
            id = c.readLine("ID: ");
            titulo = c.readLine("Titulo: ");
            idademin = c.readLine("Idade mínima: ");

            continuar = c.readLine("Deseja continuar?(s/n): ");
            termina = continuar.toLowerCase().equals("n");

            if (termina == true) {
                cducs.salvarSerie();
                System.out.print(cducs);
                
            }
        } while (termina != true);
    }

    public String getid() {
        return id;
    }

    public String gettitulo() {
        return titulo;
    }

    public String getidademin() {
        return idademin;
    }
}