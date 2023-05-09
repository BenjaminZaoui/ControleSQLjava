package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLigneCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLigneCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public void InsertLigneCommande(int numCommande, String numPizza,int quantite)
    {
        try {
            ps = cnx.prepareStatement("INSERT INTO commandes\n" +
                    "VALUES (?,?,?)");
            ps.setInt(1,numCommande);
            ps.setString(2,numPizza);
            ps.setInt(3,quantite);
            ps.executeUpdate();


        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }
        // A vous de jouer

    }
}
