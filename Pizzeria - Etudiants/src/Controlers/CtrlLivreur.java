package Controlers;

import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlLivreur
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlLivreur() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllLivreurs()
    {
        ArrayList<String> lesLivreurs = new ArrayList<>();
        try {
           ps = cnx.prepareStatement("SELECT livreurs.numLiv, livreurs.nomLiv\n" +
                   "FROM livreurs");
           rs = ps.executeQuery();
           while (rs.next()){
               String unlivreur = rs.getString(2);
               lesLivreurs.add(unlivreur);
           }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }

        // A vous de jouer

        return lesLivreurs;
    }
    public int getIdLivreurByName(String nomLiv)
    {
        int numLiv = 0;
        try {
            ps = cnx.prepareStatement("SELECT livreurs.numLiv\n" +
                    "FROM livreurs\n" +
                    "WHERE livreurs.nomLiv = ?");
            ps.setString(1,nomLiv);
            rs = ps.executeQuery();
            numLiv = rs.getInt(1);
            ps.close();
            rs.close();

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }

        // A vous de jouer

        return numLiv;
    }
}
