package CDU;

import UI.FormPerformance;

public class CDUcadastrarPf {
    // FIX create this...

    private FormPerformance formPf;

    public CDUcadastrarPf(FormPerformance formPf) {
        this.formPf.setcdu(this);
    }

    public void exec() {
        formPf.exibe();
    }

    public void salvarPerformance() {
        
    }
}
