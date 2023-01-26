package fr.iutfbleau.projetIHM2021FI2.CONTROLEUR;
//import fr.iutfbleau.projetIHM2021FI2.MODELE.*;
import fr.iutfbleau.projetIHM2021FI2.VUE.*;
//import fr.iutfbleau.projetIHM2021FI2.API.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

/**
 * <b>ControleurPrereservation est la classe qui gere les action effectuees sur le panneau de reservation</b>
 * <p>
 * Ce controleur a une Vue, qu'il "ecoute" et un modele qu'il interroge
 *<p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class ControleurPrereservation implements ActionListener{

  //Private ModelePrereservation model;

  /**
   * La vue que le controleur ecoute
   */
  private Vue vue;

  /**
   * ControleurPrereservation.
   * <p>
   * A la construction d'un objet ControleurPrereservation, la vue est donnée assignée directement
   * vide.
   * </p>
   *
   * @param vue
   *            La vue dans que le contoleur ecoute.
   * @param modele
   *            Le modele qu'il interroge.
   *
   */
  public ControleurPrereservation(Vue vue/* ,ModelePrereservation model*/){
    this.vue = vue;
  }

  /**
   * Lorsque le bouton "Allouer" est pressé appelle le modele pour reserver la ModelePrereservation.
   * Lorsque le bouton "Equivalents" est pressé appelle le modele et affiche les equivalents, le panneau en haut a droite et degrise les deux du bas.
   * Lorsque le bouton "Retour" est pressé, grise les deux panneux du bas.
   *
   * @param un évenement
   *
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //Faudra faire tt ca avec le modele, auquel on donnera la vue en param
    //modele => reservation ou reservationFactory
    JButton booton = (JButton)e.getSource();
    if(booton.getText().equals("ALLOUER")){
      //Faire une popup quand c'est reussi
      JOptionPane.showMessageDialog(this.vue, "Allocation réussie");
      //OU
      //JOptionPane.showMessageDialog(this.vue, "Allocation échouée", "Résultat allocation");
      System.out.println("Clic Allouer");
    }else if(booton.getText().equals("EQUIVALENTS")){
      this.vue.activationPanneau(this.vue.getPanneauPrereservation(), false);
      this.vue.activationPanneau(this.vue.getPanneauEquivalent(), true);
      this.vue.activationPanneau(this.vue.getPanneauValidation(), true);
      System.out.println("Clic Equivalents");
    }else if(booton.getText().equals("RETOUR")){
      this.vue.actualisationPanneauPrereservVide();
      this.vue.activationPanneau(this.vue.getPanneauPrereservation(), false);
      this.vue.activationPanneau(this.vue.getPanneauRecherche(), true);
      System.out.println("Clic Retour");
    }
  }
}
