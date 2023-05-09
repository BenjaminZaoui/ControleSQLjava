package Entities;

public class Pizza
{
    private String numeroPizza;
    private String nomPizza;
    private int nbPersonne;
    private int prixPizza;
    private int quantite;

    public Pizza(String numeroPizza, String nomPizza, int nbPersonne, int prixPizza, int quantite) {
        this.numeroPizza = numeroPizza;
        this.nomPizza = nomPizza;
        this.nbPersonne = nbPersonne;
        this.prixPizza = prixPizza;
        this.quantite = quantite;
    }

    public String getNumeroPizza() {
        return numeroPizza;
    }

    public String getNomPizza() {
        return nomPizza;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public int getPrixPizza() {
        return prixPizza;
    }

    public int getQuantite() {
        return quantite;
    }
}
