package fr.iutfbleau.projetIHM2021FI2.CONTROLEUR;

import fr.iutfbleau.projetIHM2021FI2.VUE.*;
import fr.iutfbleau.projetIHM2021FI2.MODELE.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.sql.Time;

/**
 * <b>Controleur est la classe qui gere les action effectuees sur le panneau de ou on tape la date</b>
 * <p>
 * Ce controleur a une Vue, qu'il "ecoute"
 *<p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class Controleur implements ActionListener{

  /**
   * La vue que le controleur ecoute
   */
  private Vue vue;

  /**
   * Controleur.
   * <p>
   * A la construction d'un objet Controleur, la vue est donnée
   * </p>
   *
   * @param vue
   *            La vue dans que le contoleur ecoute
   *
   */
  public Controleur(Vue vue){
    this.vue = vue;
  }

  /**
   * Lorsque le bouton "Valider" est pressé, envoie les informations du champs de la date au modele.
   *
   * @param e
   *          un evenement
   *
   */
  @Override
  public void actionPerformed(ActionEvent e){
    JButton booton = (JButton)e.getSource();

    if(booton.getText().equals("RETOUR")){
      this.vue.actualiserPanneauRecherche();
    }else if(estValide(this.vue.getPanneauRecherche().getDate().getText()) == true){
      try{
        DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        Date date = dateFormat.parse(this.vue.getPanneauRecherche().getDate().getText());

        Date apres = dateFormat.parse("30/12/2017");
        Date avant = dateFormat.parse("12/01/2018");

        //Conversion au format qu'il y a dans la BD
        LocalDate dateModif = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(dateModif);

        if(date.after(apres) && date.before(avant)) {
          ModeleTaux modele = new ModeleTaux(this.vue, date);
        }else{
          JOptionPane.showMessageDialog(this.vue, "Aie! Cette date n'apparaît pas dans notre base de données !");
          this.vue.actualiserPanneauRecherche();
        }
      }catch(ParseException expt){
        System.out.println("Erreur Date");
      }

    }else{
      JOptionPane.showMessageDialog(this.vue, "La date n'est pas au bon format !");
      this.vue.actualiserPanneauRecherche();
    }

  }

  /**
   * Verifie si une date est valide et au bon format
   *
   * @param dateStr
   *              une date sous forme de String
   * @return
   *              un booleen, true si la date est ok, sinon false
   *
   */
  public boolean estValide(String dateStr) {
      DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      sdf.setLenient(false);
      try{
          sdf.parse(dateStr);
      }catch(ParseException e){
          return false;
      }
      return true;
  }
}
