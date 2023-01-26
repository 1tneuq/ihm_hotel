package fr.iutfbleau.projetIHM2021FI2.MODELE;

import fr.iutfbleau.projetIHM2021FI2.API.*;
import java.time.LocalDate;
import java.sql.*;
import java.lang.*;
import org.mariadb.jdbc.*;
import java.util.*;
/**
 * Cette classe est une usine permettant de créer des objets ModelePrereservation.
 *
 *  Elle permet de rechercher les préréservations à partir du numéro d'une préréservation, ou bien du nom et prenom d'un Client.
 *  Elle crée ensuite un ou des objet.s ModelePrereservation et les renvoie.s
 *
 */
public class ModelePrereservationFactory implements PrereservationFactory{

    /**
    *Le prenom du client correspondant à la preréservation
    *@see ModeleClient
    */
    private String prenomClient;

    /**
    *Le nom du client correspondant à la preréservation
    *@see ModeleClient
    */
    private String nomClient;

    /**
    *L'id du client correspondant à la preréservation
    *@see ModeleClient
    */
    private int idClient;

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
    *Objet permettant de retenir la connexion à la base de données
    *@see Connection
    */
    private Connection connexionBdd;

    public ModelePrereservationFactory(){}

    /**
     * Recherche une préréservation par reference
     * @param  reference la référence du système de préréservation
     * @return la préréservation.
     * @throws NullPointerException si un argument est null
     * @throws IllegalStateException si la Préréservation avec cette référence n'existe pas.
     *
     * Ne devrait pas retourner un objet null.
     */
    public Prereservation getPrereservation(String reference) {
        Objects.requireNonNull(reference,"nom obligatoire");//leve une NullPointerException si l'argument est null
        try{
          connexion(); //Connection à la BdD
          recupPrereservation(reference); //Recuperation des info de la table Prereservation, notamment l'id du client qui permettra de chercher son identité
          recupNomPrenom(this.idClient);//Recup de l'identité du Client
          ModeleClient client = new ModeleClient(this.prenomClient, this.nomClient, this.idClient); //Creation de l'objet Client;
          deconnexion(this.connexionBdd);//On ferme la connection avec la BdD
          return new ModelePrereservation(client, this.typeChambre, this.reference, this.dateDebut, this.jours); //On retourne l'objet crée (but de la factory)
        }catch(PasDePrereservationException ex){
          throw new IllegalStateException();// Si quelque chose une methode a retourné false, le client n'a pas été trouvé dans la BdD
        }
    }

    /**
     * Recherche une préréservation par nom et prenom
     * @param  nom le nom
     * @param  prenom le prenom
     * @return un ensemble de préréservations.
     * @throws NullPointerException si un argument est null
     * @throws IllegalStateException si aucune préréservation n'existe avec ce nom
     *
     * Ne devrait pas retourner un objet null ou un ensemble vide.
     */
    public Set<Prereservation> getPrereservations(String nom, String prenom){
      Objects.requireNonNull(nom,"nom obligatoire");//leve une NullPointerException si l'argument est null
      Objects.requireNonNull(prenom,"nom obligatoire");//leve une NullPointerException si l'argument est null

      try{
          connexion();//On se connecte à la BdD
          recupId(prenom, nom);//On recupere l'id du correspondant au nom et prenom
        }catch(PasDePrereservationException ex1){
          deconnexion(this.connexionBdd);
          throw new IllegalStateException();//Aucun client n'as été trouvé
        }
          Set<Prereservation> setPrereservation = new HashSet<>(); //Ce set recuperera toutes les differentes prereservation du client
      try{

           PreparedStatement pst = this.connexionBdd.prepareStatement("SELECT debut FROM PreservationIHM WHERE  client = ? ");//Requete pour connaitre les dates des prereservations attribué au client
            pst.setInt(1,this.idClient);
            ResultSet rs = pst.executeQuery();//ReSultSet concernant les dates des prereservations

           PreparedStatement pst2 = this.connexionBdd.prepareStatement("SELECT * FROM PreservationIHM WHERE client = ? AND debut = ? "); //Requete pour connaitre la prereservation correspondant à une date
            pst2.setInt(1,this.idClient);
            ResultSet rs2 = null; //Le ResultSet recevant les differentes prereservation au cours de la boucle
            ModeleClient client = null;//L'objet Client recevant les differents clients au cours de la boucle
            int i=0;
           while(rs.next()){//Tant qu'il y'a une prereservation correspondant au client
             pst2.setDate(2,rs.getDate(1)); // On recherche la prereservation correspondant à la date
             client = new ModeleClient(this.prenomClient, this.nomClient, this.idClient);
             rs2 = pst2.executeQuery();
             rs2.next();
            ModelePrereservation mdl = new ModelePrereservation(client, determineType(rs2.getInt(5)),rs2.getString(2), rs2.getDate(3).toLocalDate(),rs2.getInt(4));
            System.out.println(mdl.monPrint());
            setPrereservation.add(mdl);//On ajoute un nouvel objet ModelePrereservation au set
           }
           deconnexion(this.connexionBdd);
           return setPrereservation;
         }catch(SQLException ex){
              deconnexion(this.connexionBdd);
              throw new IllegalStateException();
          }
    }

    /**
     *Permet de se connecter à la BdD
     */
    public void connexion(){
      try{
        Class.forName("org.mariadb.jdbc.Driver");
      }catch(ClassNotFoundException exPilote){
        System.out.println("ex pilote");
      }

      try{
        this.connexionBdd = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/meddahi", "meddahi", "DeOvZcjvwHdhbi7l");
      }catch(SQLException exConnection){
        System.out.println("ex connexion");
       }
    }

    /**
     * Permet de se deconnecter de la BdD
     *@param connexion La connexion à la connexionBdd
     *@see Connection
     */
    public void deconnexion(Connection connexion){
      try{
        connexion.close();
      }catch(SQLException ex){
        System.out.println("deconnection fail");
      }
    }

    /**
    *Cette methode permet de savoir si un nom et un prenom correspondent à un client, si oui, on recupere son ID
    *Cette méthode est un peu "l'inverse" de recupNomPrenom
    *@see recupNomPrenom
    *@param prenom Le prenom du client
    *@throws PasDePrereservationException si on ne reussit pas à récupérer les informations
    */
    public void recupId(String prenom, String nom) throws PasDePrereservationException{
      try{
        PreparedStatement pst = this.connexionBdd.prepareStatement(
         "SELECT id FROM ClientIHM WHERE prenom = ? AND nom = ? ");
         pst.setString(1,prenom);
         pst.setString(2,nom);
         ResultSet rs = pst.executeQuery();
         rs.next();// TOUJOURS FAIRE .next() pck le curseur est sur une position par defaut au debut
         this.idClient = rs.getInt(1);
         this.prenomClient = prenom;
         this.nomClient = nom;
      }catch(SQLException exResultSet){
        throw new PasDePrereservationException("ex recupId");
      }
    }

    /**
    *Cette methode permet de savoir si un ID correspondent à un client, si oui, on recupere son nom et prénom
    *Cette méthode est un peu "l'inverse" de recupId
    *@see recupId
    *@param idClient L'id du client recherché
    *@throws PasDePrereservationException si on ne reussit pas à récupérer les informations
    */
    public void recupNomPrenom(int idClient) throws PasDePrereservationException{
      try{
        PreparedStatement pst = this.connexionBdd.prepareStatement(
         "SELECT prenom, nom FROM ClientIHM WHERE id = ? ");
         pst.setInt(1,idClient);
         ResultSet rs = pst.executeQuery();
         rs.next();// TOUJOURS FAIRE .next() avant de récupérer les données pck le curseur est sur une position par defaut au debut
         this.prenomClient = rs.getString(1);
         this.nomClient = rs.getString(2);
      }catch(SQLException exResultSet){
        throw new PasDePrereservationException("ex recupNomPrenom");
      }
    }

    /**
    *Cette methode permet de chercher une prereservation dans la BdD à l'aide de la reference de la prereservation du client
    *On recupere ensuite les infos propre à cette prereservation*
    *@param reference La reference de la prereservation
    *@throws PasDePrereservationException si on ne reussit pas à récupérer les informations
    */
    public void recupPrereservation(String reference) throws PasDePrereservationException{
      try{
        PreparedStatement pst = this.connexionBdd.prepareStatement(
        "SELECT * FROM PreservationIHM WHERE reference = ?");
        pst.setString(1, reference);
        ResultSet rs = pst.executeQuery();
        rs.next();
        this.dateDebut = rs.getDate(3).toLocalDate();
        this.jours = rs.getInt(4);
        this.typeChambre = determineType(rs.getInt(5));
        this.idClient = rs.getInt(6);
        this.reference = reference;
      }catch(SQLException exResultSet){
        throw new PasDePrereservationException("ex recupPrereservation reference");
      }
    }

    /**
    *Cette méthode permet de determiner le type de la chambre retournée par la BdD
    *@param intType
    *              Le type de chambre retourné par la la BdD sous la forme d'un intType
    *@return le type enumere represenant le type des chambres
    *@see TypeChambre
    */
    public TypeChambre determineType(int intType){
      TypeChambre typeChambre = null;
      switch(intType){

        case 1:
          typeChambre = TypeChambre.UNLS;
        break;
        case 2:
         typeChambre = TypeChambre.DEUXLS;
        break;
        case 3:
           typeChambre = TypeChambre.UNLD;
        break;
      }
      return typeChambre;
    }

    public static void main(String[] args) {
      ModelePrereservationFactory a = new ModelePrereservationFactory();
      Prereservation pre = a.getPrereservation("5660-8953-YKJO");
      System.out.println(pre.monPrint());
      Set<Prereservation> setPrereservation = a.getPrereservations("Bailly","Florentin");
    }

}
