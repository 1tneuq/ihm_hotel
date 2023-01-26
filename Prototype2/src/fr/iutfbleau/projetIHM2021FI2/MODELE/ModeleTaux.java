package fr.iutfbleau.projetIHM2021FI2.MODELE;

import fr.iutfbleau.projetIHM2021FI2.VUE.*;
import fr.iutfbleau.projetIHM2021FI2.CONTROLEUR.*;

import java.util.*;
import java.util.function.*;
import java.lang.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import java.time.*;
import org.mariadb.jdbc.*;

/**
 * <b>ModeleTaux est la classe qui permet les echanges avec la base de données et l'actualisation de la vue</b>
 * <p>
 * Ce modèle établit une connexion avec la BdD puis permet de calculer un taux et de remplir le tableau de taux de la semaine
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class ModeleTaux{

  /**
   * Littéralement la connection à la BdD
   */
  private Connection connect;

  /**
   * Déclaration
   */
  private PreparedStatement st;

  /**
   * Set de résultat qui correspond à ce que la BdD a renvoyé suite à une requete
   */
  private ResultSet rs;

  /**
   * La vue principale
   */
  private Vue vue;

  /**
   * La date rentrée par l'utilisateur
   */
  private Date dateRentree;

  /**
   * Le taux d'occupation de l'hotel pour une journée
   */
  private int taux;

  /**
   * Le tableau de taux d'occupation de toute la semaine
   */
  private int[] tabloTaux = { 0, 0, 0, 0, 0, 0, 0 };

  /**
   * Le tableau de taux d'occupation qui represente la moyenne des trois années précédentes (il s'agit en réalité de taux aléatoires)
   */
  private int[] tabloTauxTroisAns = { 0, 0, 0, 0, 0, 0, 0 };


  /**
   * ModeleTaux.
   * <p>
   * Ce constructeur appelle ses différentes méthodes afin de se connecter a la BdD, effectuer les requetes,
   * remplir les variables et tableaux puis se déconnecter proprement.
   * </p>
   */
  public ModeleTaux(Vue affichage, Date date){
    this.vue = affichage;
    this.dateRentree = date;
    this.taux = 0;

    this.initialiserConnexion();
    this.calculerTaux();
    this.remplirTableauTaux();

    this.remplirTauxTroisAns();
    this.vue.remplacerPanneau(this.vue.getPanneauRecherche(), new TauxOccupation(this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), taux, this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()), new GrapheTaux(this.tabloTaux, this.tabloTauxTroisAns));
    //on affiche le taux d'occupation
    System.out.println("Taux d'occupation: " + taux + "%");

    try{
      this.st.close();
      this.connect.close();
      this.rs.close();
    }catch(SQLException exept){
      System.out.println("Erreur dans la fermeture de la connexion à la base de données");
    }

  }

  /**
  * Remplit le tableau des taux de la semaine
  * @throws SQLException
  */
  public void remplirTableauTaux(){
    try{
      Calendar cal = Calendar.getInstance();
      cal.setTime(this.dateRentree);
      LocalDate localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

      switch(cal.get(Calendar.DAY_OF_WEEK)){
        case Calendar.MONDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(0);
          break;

        case Calendar.TUESDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(1);
          break;

        case Calendar.WEDNESDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(2);
          break;

        case Calendar.THURSDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(3);
          break;

        case Calendar.FRIDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(4);
          break;

        case Calendar.SATURDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(5);
          break;

        case Calendar.SUNDAY:
          localDateLundi = this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(6);
          break;

      }

      for(int i=0; i<7; i++){
        java.sql.Date sqlDatePourLundi = new java.sql.Date(Date.from(localDateLundi.plusDays(i).atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());
        this.st = connect.prepareStatement("SELECT nuits FROM PreservationIHM WHERE debut=?");
        this.st.setDate(1, sqlDatePourLundi);
        this.rs = st.executeQuery();

        while (rs.next()){
          this.tabloTaux[i]++;
        }

        for(int j = 1; j<=5; j++){
          //Check pour chaque date-i si elle a i nuits, si oui taux++
          java.sql.Date sqlDateJoursPrecedents = new java.sql.Date(Date.from(localDateLundi.plusDays(i).minusDays(j).atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());

          this.st = connect.prepareStatement("SELECT nuits FROM PreservationIHM WHERE debut=?");
          this.st.setDate(1, sqlDateJoursPrecedents);
          this.rs = st.executeQuery();

          while (rs.next()){
            int nuits = rs.getInt("nuits");
            if(nuits == j){
              //test aussi ici
              //System.out.println("ID: " + id + ", REFERENCE: " + reference + ", DEBUT: " + debut + ", NUITS: " + nuits + ", CATEGORIE: " + categorie + ", CLIENT: " + client);
              this.tabloTaux[i]++;
            }
          }
        }
      }
    }catch(SQLException e){
      System.out.println("La connexion à la base de données a échoué");
    }
  }

  /**
  * Initialise la valeur du taux pour une date donnée
  * @throws SQLException
  */
  public void calculerTaux(){
    try{
      //on cree un etat "prepare"
      this.st = connect.prepareStatement("SELECT nuits FROM PreservationIHM WHERE debut=?");
      this.st.setDate(1, new java.sql.Date(this.dateRentree.getTime()));

      // on execute la requete et on recupere un set de resultats
      this.rs = st.executeQuery();


      // on parcourt le set de resultats
      while (rs.next()){
        this.taux++;
      }

      //Pour voir s'il ya des reservations precedentes qui sont encore occupees le jour meme
      for(int i = 1; i<=5; i++){
        //Check pour chaque date-i si elle a i nuits, si oui taux++
        java.sql.Date sqlDateJoursPrecedents = new java.sql.Date(Date.from(this.dateRentree.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(i).atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());

        this.st = connect.prepareStatement("SELECT nuits FROM PreservationIHM WHERE debut=?");
        this.st.setDate(1, sqlDateJoursPrecedents);
        this.rs = st.executeQuery();

        while (rs.next()){
          int nuits = rs.getInt("nuits");
          if(nuits == i){
            this.taux++;
          }
        }
      }
    }catch(SQLException e){
      System.out.println("Erreur de requête ou dans la base de données");
    }
  }

  /**
  * Initialise la connexion proprement avec la BdD
  * @throws ClassNotFoundException
  * @throws SQLException
  */
  public void initialiserConnexion(){
    try{
      //On verifie que mariaDB est dans le classpath
      Class.forName("org.mariadb.jdbc.Driver");
    }catch(ClassNotFoundException exeption){
      System.out.println("Problème avec le driver de mariaDB");
    }
    try{
      // on cree la connexion a la BD
      String host = "dwarves.iut-fbleau.fr";
      String dbname = "meddahi";
      String url = "jdbc:mariadb://" + host + "/" + dbname;
      String username = "meddahi";
      String password = "DeOvZcjvwHdhbi7l";
      this.connect = DriverManager.getConnection(url, username, password);
    }catch(SQLException e){
      System.out.println("La connexion à la base de données a échoué");
    }
  }

  /**
  * Remplit le tableau des taux des 3 dernieres annees de nombres aleatoires pour simuler la presence de ces donnees
  */
  public void remplirTauxTroisAns(){
    for(int i = 0; i < 7; i++){
      this.tabloTauxTroisAns[i] = (int)(Math.random() * ((65 - 12) + 1)) + 12;
    }
  }

}
