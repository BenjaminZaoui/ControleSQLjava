package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getDernierNumeroDeCommande()
    {
        int maxNumero = 0;
        try {
            ps = cnx.prepareStatement("SELECT commandes.numCde\n" +
                    "FROM commandes");
            rs = ps.executeQuery();
            while (rs.next()){
                maxNumero = maxNumero + rs.getInt(1);
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }

        // A vous de jouer

        return maxNumero;
    }
    public void InsertConsultation(int numCde, int numClient,int numLivreur)
    {
        try {
            ps = cnx.prepareStatement("INSERT INTO commandes\n" +
                    "VALUES (?,?,?)");
            ps.setInt(1,numCde);
            ps.setInt(2,numClient);
            ps.setInt(3,numLivreur);
            ps.executeUpdate();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }
        // A vous de jouer

    }
}
