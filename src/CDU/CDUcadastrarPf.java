package CDU;

import java.sql.Connection;

import UI.FormPerformance;
import domain.Performance;

public class CDUcadastrarPf extends CDU{
    // FIX create this...
    private Performance perf;
    private FormPerformance formPf;

    public CDUcadastrarPf(FormPerformance formPf, Connection conexaobd) {
        this.formPf = formPf;
        this.formPf.setcdu(this);
        this.conexaobd=conexaobd;
    }

    public void exec() {
        formPf.exibe();
    }

    public void salvarPerformance() {
        formPf.getIdAtor();
    }
}
