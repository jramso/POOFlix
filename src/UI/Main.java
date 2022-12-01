package UI;

import CDU.CDUMain;
import persistencia.*;

public class Main {

    public static void main(String[] args) {

	FormMain inicio = new FormMain();
	CDUMain cdu = new CDUMain(inicio);
	inicio.setcdu(cdu);
	inicio.exibe();

         Conecta conn = new Conecta("mfdbjbho", "3GXwClW96Y7v_lCWI-FBbebx9si0Z3ZN", "mfdbjbho");
         conn.connectDB();
         
    }

}
