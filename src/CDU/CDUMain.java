package CDU;

import java.sql.Connection;

import UI.*;
import UI.FormEpisodio;
import UI.FormSerie;
import javax.swing.JOptionPane;
import persistencia.*;

public class CDUMain extends CDU {
    private FormMain formMain;
    private String banco = "mfdbjbho";
    private String usuario = "mfdbjbho";
    private String senha = "3GXwClW96Y7v_lCWI-FBbebx9si0Z3ZN";
    private Conecta bd = null;
    private Connection conexao = null;

    public CDUMain(FormMain form) {
        this.formMain = form;
        this.formMain.setcdu(this);
        // bd = new Conecta(usuario, senha, banco);
        // conexaobd = bd.connectDB();
    }

    public void exec() {
        bd = new Conecta(usuario, senha, banco);

        System.out.println("Conectando ao banco de dados POOFlix.." + this.toString());
        conexaobd = bd.connectDB();

        if (conexaobd != null) {
            System.out.println("Conexão estabelecida com sucesso!\n");
            formMain.exibe();

        } else {
            System.out.println("Problemas ao estabelecer a conexão com o banco de dados!");
            System.out.println("Encerrando do sistema!!\n");
        }
    }

    public void processaOpcao(String opcao) {
        switch (opcao) {
            case "1":
                execCadSerie();
                break; // Serie
            case "2":
                execCadEpisodio();
                break; // Episodio
            case "3":
                execCadPers();
                break; // personagem
            case "4":
                execCadAtor();
                break; // Ator
            case "5":
                // execCadPerf();
                break;
            case "6":
                // sair();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }

    public Conecta getbd() {
        return bd;
    }

    public Connection getconexaobd() {
        return conexaobd;
    }

    public void execCadSerie() {
        bd = new Conecta(usuario, senha, banco);
        bd.connectDB();
        FormSerie telaSerie = new FormSerie();
        CDUcadastrarSerie casoUsoSerie = new CDUcadastrarSerie(telaSerie, bd.getConn());
        casoUsoSerie.exec();
        bd.disconnectDB();
    }

    public void execCadEpisodio() {
        if (bd==null){
            bd = new Conecta(usuario, senha, banco);
            bd.connectDB();
        }
        FormEpisodio telaEpisodio = new FormEpisodio();
        CDUcadastrarEpis casoUsoEpis = new CDUcadastrarEpis(telaEpisodio, bd.getConn());
        casoUsoEpis.exec();
        // bd.disconnectDB();
    }

    public void execCadPers() {
        bd = new Conecta(usuario, senha, banco);
        bd.connectDB();
        FormPersonagem2 telaPers = new FormPersonagem2();
        CDUcadastrarPers casoUsoPers = new CDUcadastrarPers(telaPers);
        casoUsoPers.exec();
        bd.disconnectDB();
    }

    public void execCadAtor() {
        bd = new Conecta(usuario, senha, banco);
        bd.connectDB();
        FormAtor telaAtor = new FormAtor();
        CDUcadastrarAtor casoUsoAtor = new CDUcadastrarAtor(telaAtor);
        casoUsoAtor.exec();
        bd.disconnectDB();

    }

    public void sair() {
        System.out.println("\nAguarde, fechando conexão com o banco de dados ..");
        bd.disconnectDB();
        System.out.println("conexão encerrada com sucesso.\n");

    }

}
