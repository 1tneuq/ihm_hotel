package fr.iutfbleau.projetIHM2021FI2.CONTROLEUR;
//import fr.iutfbleau.projetIHM2021FI2.MODELE.*;
import fr.iutfbleau.projetIHM2021FI2.VUE.*;
//import fr.iutfbleau.projetIHM2021FI2.API.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

/**
 * <b>ControleurValidation est la classe qui gere les action effectuees sur le panneau de validation</b>
 * <p>
 * Ce controleur a une Vue, qu'il "ecoute" et un modele qu'il interroge
 *<p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class ControleurValidation implements ActionListener{

  //Private ModelePrereservation model;

  /**
   * La vue que le controleur ecoute
   */
  private Vue vue;

  /**
   * ControleurValidation.
   * <p>
   * A la construction d'un objet ControleurValidation, la vue est donnée assignée directement
   * vide.
   * </p>
   *
   * @param vue
   *            La vue dans que le contoleur ecoute.
   * @param modele
   *            Le modele qu'il interroge.
   *
   */
  public ControleurValidation(Vue vue/* ,ModelePrereservation model*/){
    this.vue = vue;
  }

  /**
   * Lorsque le bouton "Valider" est pressé, envoie les informations des champs au modele pour creer une reservation.
   * Lorsque le bouton "Retour" est pressé, grise les deux panneuax du bas et degrise celui en haut a droite.
   *
   * @param un évenement
   *
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //Faudra faire tt ca avec le modele, auquel on donnera la vue en param
    //modele => reservation ou reservationFactory
    JButton booton = (JButton)e.getSource();
    if(booton.getText().equals("VALIDER")){
      //Faire une popup quand c'est reussi
      System.out.println("Clic Valider");
    }else if(booton.getText().equals("RETOUR")){
      this.vue.activationPanneau(this.vue.getPanneauValidation(), false);
      this.vue.activationPanneau(this.vue.getPanneauEquivalent(), false);
      this.vue.activationPanneau(this.vue.getPanneauPrereservation(), true);
      System.out.println("Clic Retour");
    }

  }
}
