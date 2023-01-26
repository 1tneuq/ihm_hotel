package fr.iutfbleau.projetIHM2021FI2.CONTROLEUR;
import fr.iutfbleau.projetIHM2021FI2.VUE.*;
import fr.iutfbleau.projetIHM2021FI2.MODELE.*;
import fr.iutfbleau.projetIHM2021FI2.API.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

/**
 * <b>ControleurRecherche est la classe qui gere les action effectuees sur le panneau de recherche</b>
 * <p>
 * Ce controleur a une Vue, qu'il "ecoute" et un modele qu'il interroge
 *<p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class ControleurRecherche implements ActionListener{

  /*
    Le modele
  */
  private Modele modele;

  /**
   * La vue que le controleur ecoute
   */
  private Vue vue;

  /**
   * ControleurRecherche.
   * <p>
   * A la construction d'un objet ControleurRecherche, la vue est donnée assignée directement
   * vide.
   * </p>
   *
   * @param vue
   *            La vue dans que le controleur ecoute.
   * @param modele
   *            Le modele qu'il interroge.
   *
   */
  public ControleurRecherche(Vue vue , Modele modele){
    this.vue = vue;
    this.modele = modele;
  }

  /**
   * Lorsque le bouton "Rechercher" est pressé, envoie les informations des champs au modele.
   *
   * @param un évenement
   *
   */
  @Override
  public void actionPerformed(ActionEvent e){

    String test = "Numero de reservation";
    String testN = "Nom";
    String testP = "Prenom";

    if(test.compareTo(this.vue.getPanneauRecherche().getReserv().getText()) != 0){ //Si la référence a été saisie
      try{
        this.modele.setPrereservation(this.vue.getPanneauRecherche().getReserv().getText());
        this.vue.actualiserPanneauRecherche();
        this.vue.activationPanneau(this.vue.getPanneauRecherche(), false);//Desactive le panel de recherche
        this.vue.activationPanneau(this.vue.getPanneauPrereservation(), true);
        this.vue.actualiserPanneauPrereservation(this.modele.getPrereservation());

      }catch(IllegalStateException ex){ //La ref n'est pas trouvée
        JOptionPane.showMessageDialog(this.vue, "Il n'y a pas de résultat pour cette référence");
        this.vue.getPanneauRecherche().getNom().setText("Nom");
        this.vue.getPanneauRecherche().getPrenom().setText("Prenom");
        this.vue.getPanneauRecherche().getReserv().setText("Numero de reservation");
        this.vue.getPanneauRecherche().repaint();
      }

    }else{ //Si la reference n'a pas ete saisie

        if(testP.compareTo(this.vue.getPanneauRecherche().getPrenom().getText()) != 0 && testN.compareTo(this.vue.getPanneauRecherche().getNom().getText()) != 0 ){ //Si nom et prenom client sont entrés
          try{
            this.modele.setPrereservations(this.vue.getPanneauRecherche().getNom().getText(), this.vue.getPanneauRecherche().getPrenom().getText());
            JOptionPane.showMessageDialog(this.vue, "Ce client est present dans la base de données");
            this.vue.actualiserPanneauRecherche();
            this.vue.activationPanneau(this.vue.getPanneauRecherche(), false);
            this.vue.activationPanneau(this.vue.getPanneauPrereservation(), true);
            //this.vue.actualiserPanneauPrereservation(this.modele.getListePrereservations());

          }catch(IllegalStateException ex){//Le client n'as pas été trouvé
            JOptionPane.showMessageDialog(this.vue, "Il n'y a pas de résultat pour ce client");
            this.vue.getPanneauRecherche().getNom().setText("Nom");
            this.vue.getPanneauRecherche().getPrenom().setText("Prenom");
            this.vue.getPanneauRecherche().getReserv().setText("Numero de reservation");
            this.vue.getPanneauRecherche().repaint();
          }
        }else{ //Si nom et prenom ne sont pas entrés
          JOptionPane.showMessageDialog(this.vue, "Veuillez rechercher à l'aide de la référence ou de l'identité client");
          this.vue.getPanneauRecherche().getNom().setText("Nom");
          this.vue.getPanneauRecherche().getPrenom().setText("Prenom");
          this.vue.getPanneauRecherche().getReserv().setText("Numero de reservation");
          this.vue.getPanneauRecherche().repaint();
        }
    }

    //faire un if pour executer ca seulement si les infos ont ete trouvees dans la bd

  }

}
