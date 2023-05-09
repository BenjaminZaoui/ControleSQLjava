package Vues;

import Controlers.*;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FrmCommander extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;
    CtrlClient ctrlClient;
    CtrlLivreur ctrlLivreur;
    CtrlPizza ctrlPizza;
    CtrlCommande ctrlCommande;
    CtrlLigneCommande ctrlLigneCommande;
    ModelJTable mdl;

    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                // A vous de jouer
                ctrlClient = new CtrlClient();
                ctrlLivreur = new CtrlLivreur();
                ctrlCommande = new CtrlCommande();
                for (int i = 0; i<ctrlClient.getAllClients().size();i++){
                    cboClients.addItem(ctrlClient.getAllClients().toArray()[i]);
                }
                for (int j = 0;j<ctrlLivreur.getAllLivreurs().size();j++ ){
                    cboLivreurs.addItem(ctrlLivreur.getAllLivreurs().toArray()[j]);
                }
                mdl = new ModelJTable();
                ctrlPizza = new CtrlPizza();
                mdl.loadDatasPizzas(ctrlPizza.getAllPizzas());
                tblPizzas.setModel(mdl);
                txtNumCommande.setText(String.valueOf(ctrlCommande.getDernierNumeroDeCommande()));

            }
        });

        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantiter = 0;
                String numPizz = "";
                // A vous de jouer
                ctrlCommande = new CtrlCommande();
                ctrlClient = new CtrlClient();
                ctrlLivreur = new CtrlLivreur();
                ctrlLigneCommande = new CtrlLigneCommande();
                int numCde = Integer.parseInt(txtNumCommande.getText());
                String nomCli = cboClients.getSelectedItem().toString();
                String nomLiv =cboLivreurs.getSelectedItem().toString();
                int numLiv = ctrlClient.getIdClientByName(nomCli) ;
                int numCli = ctrlLivreur.getIdLivreurByName(nomLiv);


                //ctrlCommande.InsertConsultation(numCde,numLiv,numCli);
                for (int i=0; i<tblPizzas.getRowCount();i++){
                    numPizz = tblPizzas.getValueAt(i,1).toString();
                    quantiter = Integer.parseInt(tblPizzas.getValueAt(i,4).toString());
                    ctrlLigneCommande.InsertLigneCommande(numCde,numPizz,quantiter);
                }
                mdl = new ModelJTable();
                ctrlPizza = new CtrlPizza();
                mdl.loadDatasPizzas(ctrlPizza.getAllPizzas());
                tblPizzas.setModel(mdl);
                txtNumCommande.setText(String.valueOf(ctrlCommande.getDernierNumeroDeCommande()));



            }
        });
    }
}
