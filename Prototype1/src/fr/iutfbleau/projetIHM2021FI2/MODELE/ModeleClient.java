package fr.iutfbleau.projetIHM2021FI2.MODELE;

import fr.iutfbleau.projetIHM2021FI2.API.*;
import java.util.*;

/**
 * Cette classe represente un client
 */

public class ModeleClient implements Client{

    private int id;
    private String prenom;
    private String nom;

    public ModeleClient(String prenom, String nom, int id){
      Objects.requireNonNull(nom,"nom obligatoire");
      Objects.requireNonNull(prenom,"prenom obligatoire");
      Objects.requireNonNull(id,"id obligatoire");
      this.prenom = prenom;
      this.nom = nom;
      this.id = id;
    }

    /**
     * permet de récupérer l'identifiant du client (qu'on suppose être le même pour les différents systèmes, internes et externes à l'hôtel).
     * @return l'identifiant.
     */
    public int getId(){
      return this.id;
    }

    public void setId(int id){
       this.id=id;
    }
    /**
     * permet de récupérer
     * @return le nom du client.
     */
    public String getNom(){
      return this.nom;
    }

    public void setNom(String nom){
       this.nom=nom;
    }
    /**
     * permet de récupérer
     * @return le prénom du client
     */
    public String getPrenom(){
      return this.prenom;
    }
    public void setPrenom(String prenom){
       this.prenom=prenom;
    }

    /**
     * @see MonPrint
     * NB. On n'utilise le mécanisme des méthodes par défaut pour donner du code dans une interface. C'est un petit peu laid et à contre-emploi mais pratique ici.
     */
    public String monPrint() {
        return String.format("Nom " + getNom() + " Prenom " + getPrenom() + " (id="+getId()+")");
    }
}
