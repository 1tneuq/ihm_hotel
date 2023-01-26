package fr.iutfbleau.projetIHM2021FI2.MODELE;

import fr.iutfbleau.projetIHM2021FI2.API.*;
import java.time.LocalDate;
import java.sql.*;
import java.lang.*;
import org.mariadb.jdbc.*;
import java.util.*;
/**
 * Une préréservation
 *
 * e.g. utilisé par le système de réservation externe à l'hôtel.
 * A SUPPRIMER - En gros l'idée c'est que cet objet sois crée une seule fois, il modifie tout seul ses attribut (notamment client) au fur et à mesure des recherches de preréservation
 */

public class Modele {

    /**
    *Permet de retenir la prereservation courante
    *@see ModelePrereservation
    */
    private Prereservation prereservation;

    /**
    *Permet de retenir le set de prereservations courant
    *@see ModelePrereservation
    */
    private Set<Prereservation> prereservations;

    /**
    *Permet de retenir le set de prereservations courant dans une liste afin d'ordonner les prereservations
    *@see ModelePrereservation
    */
    private ArrayList<Prereservation> listePrereservations;

    /**
    *Permet de créer les differentes prereservations
    *@see ModelePrereservationFactory
    */
    private PrereservationFactory factory;


    /**
    *Constructeur
    *@see ModelePrereservationFactory
    */
    public Modele() {
      this.factory = new ModelePrereservationFactory();
    }

    /**
    *Permet de créer la prereservation courante
    *throws IllegalStateException si la prereservation n'as pas pus etre trouvée
    *@see ModelePrereservation
    */
    public void setPrereservation(String reference){
      try{
        this.prereservation = this.factory.getPrereservation(reference);
      }catch(IllegalStateException ex){
        throw ex;
      }
    }

    /**
    *Permet de recuperer la prereservation courante
    *@see ModelePrereservation
    */
    public Prereservation getPrereservation(){
      return this.prereservation;
    }

    /**
    *Permet de créer le set de prereservations courant
    *throws IllegalStateException si le set de prereservations n'as pas pus etre trouvé²
    *@see ModelePrereservation
    */
    public void setPrereservations(String nom, String prenom){
      try{
        this.prereservations = this.factory.getPrereservations(nom, prenom);
        this.listePrereservations = new ArrayList<Prereservation>();
        for(Prereservation prereservation: this.prereservations){//On entre chaque prereservation du Set dans le ArrayList
          this.listePrereservations.add(prereservation);
        }
      }catch(IllegalStateException ex){
        throw ex;
      }
    }

    /**
    *Permet de recuperer le set de prereservation courant sous forme d'un arraylist
    *@see ModelePrereservation
    */
    public ArrayList<Prereservation> getListePrereservations(){

      return this.listePrereservations;
    }

    /**
    *Permet de recuperer le set de prereservation courant
    *@see ModelePrereservation
    */
    public Set<Prereservation> getPrereservations(){

      return this.prereservations;
    }



}
