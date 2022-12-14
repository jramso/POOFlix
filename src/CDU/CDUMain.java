package CDU;

import java.sql.Connection;

import UI.*;
import UI.FormEpisodio;
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
                execCadPerf();
                break;
            case "6":
                sair();
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
        if (bd==null){
            bd = new Conecta(usuario, senha, banco);
            bd.connectDB();
        }
        FormSerie telaSerie = new FormSerie();
        CDUcadastrarSerie casoUsoSerie = new CDUcadastrarSerie(telaSerie, bd.getConn());
        casoUsoSerie.exec();
    }

    public void execCadEpisodio() {
        if (bd==null){
            bd = new Conecta(usuario, senha, banco);
            bd.connectDB();
        }
        FormEpisodio telaEpisodio = new FormEpisodio();
        CDUcadastrarEpis casoUsoEpis = new CDUcadastrarEpis(telaEpisodio, bd.getConn());
        casoUsoEpis.exec();
    }

    public void execCadPers() {
        if (bd==null){
            bd = new Conecta(usuario, senha, banco);
            bd.connectDB();
        }
        FormPersonagem telaPers = new FormPersonagem();
        CDUcadastrarPers casoUsoPers = new CDUcadastrarPers(telaPers, bd.getConn());
        casoUsoPers.exec();
    }

    public void execCadAtor() {
        if (bd==null){
            bd = new Conecta(usuario, senha, banco);
            bd.connectDB();
        }
        FormAtor telaAtor = new FormAtor();
        CDUcadastrarAtor casoUsoAtor = new CDUcadastrarAtor(telaAtor, bd.getConn());
        casoUsoAtor.exec();

    }
    
    public void execCadPerf(){
        if (bd==null){
            bd = new Conecta(usuario, senha, banco);
            bd.connectDB();
        }
        FormPerformance formPf = new FormPerformance();
        CDUcadastrarPf casoUsoPf = new CDUcadastrarPf(formPf, bd.getConn());
        casoUsoPf.exec();
    }

    public void sair() {
        if(bd!=null){
            System.out.println("\nAguarde, fechando conexão com o banco de dados ..");
            bd.disconnectDB();
            System.out.println("conexão encerrada com sucesso.\n");
        }
        formMain.getCadastra().setVisible(false);
        formMain.getBtn_red_icon().setVisible(true);
        formMain.getBtn_green_icon().setVisible(true);
        formMain.getBtn_yellow_icon().setVisible(true);
    }

}
