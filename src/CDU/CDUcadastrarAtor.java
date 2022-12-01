package CDU;

import UI.FormAtor;

public class CDUcadastrarAtor {

    private FormAtor formator;

    public CDUcadastrarAtor(FormAtor formator) {
        this.formator = formator;
        this.formator.setcdu(this);
    }

    public void exec() {
        formator.exibe();
    }

    // TOdo
    public void salvarAtor() {

    }

}
