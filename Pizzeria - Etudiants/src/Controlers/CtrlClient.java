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

public class CtrlClient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlClient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllClients()
    {
        ArrayList<String> lesClients = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT numCli,nomCli\n" +
                    "FROM clients");
            rs = ps.executeQuery();
            while (rs.next()){
                String unClient = rs.getString(2);
                lesClients.add(unClient);
            }
            ps.close();
            rs.close();

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }


        return lesClients;
    }
    public int getIdClientByName(String nomCli)
    {
        int numCli = 0;
        try {
            ps = cnx.prepareStatement("SELECT clients.numCli\n" +
                    "FROM clients\n" +
                    "WHERE clients = ?");
            ps.setString(1,nomCli);
            rs = ps.executeQuery();
            numCli = rs.getInt(1);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"erreur SQL");
        }
        // A vous de jouer

        return numCli;
    }
}
