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
 */

public class ModelePrereservation implements Prereservation{

  /**
  *Objet representant le client correspondant à la preréservation
  *@see ModeleClient
  */
  private ModeleClient client;

  /**
  *Objet de type enumeré permettant de définir les types de chambres
  *@see TypeChambre
  */
  private TypeChambre typeChambre;

  /**
  *String representant la reference de la
  *@see TypeChambre
  */
  private String reference;

  /**
  *Objet de type LocalDate representant la date de debut de la prereservation
  *@see LocalDate
  */
  private LocalDate dateDebut;

  /**
  *Int representant la durée du sejour en jour
  *@see TypeChambre
  */
  private int jours;


    /**
     * Constructeur, on initialise chaque attribut
     * @see greenFlag.
     */
    public ModelePrereservation(ModeleClient client, TypeChambre typeChambre, String reference, LocalDate dateDebut, int jours ){
      this.client = client;
      this.typeChambre = typeChambre;
      this.reference = reference ;
      this. dateDebut = dateDebut;
      this. jours =  jours;
    }

    /**
     * permet de récupérer la référence de la résérvation ( le numéro de résérvation)
     * @return la référence.
     */
    public String getReference(){
      return this.reference;
    }

    /**
     * permet de récupérer la date de début de la résérvation
     * @return la date de début.
     */
    public LocalDate getDateDebut(){
      return this.dateDebut;
    }

    /**
     * permet de récupérer le nombre de jours de la résérvation
     * @return la durée en jours (mais comme un entier)
     */
    public int getJours(){
      return this.jours;
    }

    /**
     * permet de récupérer le type de chambre de la résérvation
     * @return le type de chambre
     */
    public TypeChambre getTypeChambre(){
      return this.typeChambre;
  }
    /**
     * permet de récupérer l'objet client correspondant à la reservation
     * @return le client
     */
    public Client getClient(){
      return this.client;
  }

    /**
     * @see MonPrint
     * NB. On n'utilise le mécanisme des méthodes par défaut pour donner du code dans une interface. C'est un petit peu laid et à contre-emploi mais pratique ici.
     */
    public String monPrint() {
        return String.format("Préréservation " + getReference() + ": " + getClient().monPrint() + " le " +  getDateDebut().toString() + " pour " + getJours() + " nuit(s) ");
    }

    //Ptit main pr test vite fait
  /*  public static void main(String[] args) {

      ModelePrereservation mdlPrereserv = new ModelePrereservation();
      mdlPrereserv.connexionBdD();

      System.out.println(ANSI_BLUE+"On cherche Aaron Dumas"+ANSI_RESET);
      mdlPrereserv.recupId("Aaron", "Dumas");
      mdlPrereserv.recupPrereservation(mdlPrereserv.getClient().getId());
      System.out.println(ANSI_GREEN+mdlPrereserv.monPrint()+ANSI_RESET);
      System.out.println(ANSI_BLUE+"Tape un id, il sera cherché dans la bdd"+ANSI_RESET);

      int id = -1;
      boolean a = true;
      Scanner sc = new Scanner(System.in);
      while(id!=0){
        id=sc.nextInt();
        System.out.println(ANSI_BLUE+"L'id est : " + id +ANSI_RESET);
        a = mdlPrereserv.connexionBdD();//On se co , l'objet Connexion est attribuer à l'attribut dans cette methode
        if(a) a=mdlPrereserv.recupNomPrenom(id);//On recup le prenom, l'objet Client est crée ici et attribué à l'attribut dans cette méthode
        if(a) a=mdlPrereserv.recupPrereservation(mdlPrereserv.getClient().getId());//On recup les infos de la reservation propre au au client, la methode (recupPrereservation) ferme aussi la connexion
        if(a){
          System.out.println(ANSI_BLUE+"l'ID existe : "+ANSI_GREEN+mdlPrereserv.monPrint()+ANSI_RESET);
        }else System.out.println(ANSI_RED+"L'id n'existe pas dans la bdd "+ANSI_RESET);
      }
    }*/
}
