package fr.iutfbleau.projetIHM2021FI2.API;
import java.time.LocalDate;
/**
 * Une Réservation
 *
 * e.g. utilisé par le système de réservation interne à l'hôtel.
 *
 */

public class ModeleReservation implements Reservation {

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
  *Objet de type enumeré permettant de définir les types de chambres
  *@see TypeChambre
  */
  private Chambre chambre;

  /**
  *Objet representant le client correspondant à la preréservation
  *@see ModeleClient
  */
  private ModeleClient client;

  /**
   * permet de récupérer
   * @return la référence.
   */
  public String getReference(){
    return this.reference;
  }


  /**
   * permet de récupérer
   * @return la date de début
   *
   * A priori seule la date est importante, le reste est sans importance.
   */
  public LocalDate getDateDebut(){
    return this.dateDebut;
  }

  /**
   * permet de récupérer
   * @return la durée en jours (mais comme un entier)
   */
  public int getJours(){
    return this.jours;
  }

  /**
   * permet de récupérer
   * @return la chambre
   */
  public Chambre getChambre(){
    return this.chambre;
  }

  /**
   * permet de récupérer
   * @return le client
   */
  public Client getClient(){
    return this.client;
  }
}
