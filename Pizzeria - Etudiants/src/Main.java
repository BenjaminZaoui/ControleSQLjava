import Vues.FrmCommander;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FrmCommander frmCommander = new FrmCommander();
        frmCommander.setVisible(true);
    }
}
