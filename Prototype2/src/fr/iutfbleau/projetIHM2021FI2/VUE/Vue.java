package fr.iutfbleau.projetIHM2021FI2.VUE;
import fr.iutfbleau.projetIHM2021FI2.CONTROLEUR.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.Date;

/**
 * <b>Vue est la classe qui instancie la fenetre principale du logiciel</b>
 * <p>
 * Cette vue est constituée soit d'un panneau au debut, puis de 3 quand on valide la date
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class Vue extends JFrame{

  /**
   * Panneau principal qui prend l'entiereté de la fenetre
   */
  private JPanel panneauPrincipal;

  /**
   * Panneau sur lequel on est au lancement de l'application
   */
  private Recherche panoAccueil;

  /**
  * Panneau du bas avec le bouton retour
  */
  private Footer footer;

  /**
   * Controleur qui écoute le vouton valider
   */
  private Controleur controle;

  /**
   * Le layout qui gere la disposition des panneaux dans la fenetre
   */
  private GridBagConstraints gbc;

  /**
   * Vue.
   * <p>
   * Ce constructeur construit la fenetre avec un panneau principal, qui est celui pour rentrer la date
   * </p>
   */
  public Vue(){
    super("Gestion Hotel IHM - Lacombe & Meddahi");
    this.setSize(1600, 900);
    this.setLocation(100, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.panneauPrincipal = new JPanel(new GridBagLayout());
    this.gbc = new GridBagConstraints();
    this.panoAccueil = new Recherche();

    this.controle = new Controleur(this);
    this.panoAccueil.getBttrois().addActionListener(controle);

    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoAccueil, gbc);

    this.add(this.panneauPrincipal);
    this.setVisible(true);
  }

  /**
   * Réinitialise le panneau d'accueil
   */
  public void actualiserPanneauRecherche(){
    this.panneauPrincipal.removeAll();
    this.panneauPrincipal.repaint();
    this.panoAccueil = new Recherche();
    this.panoAccueil.getBttrois().addActionListener(controle);
    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoAccueil, gbc);
    this.panneauPrincipal.revalidate();
}

  /**
   * Permet d'activer ou de désactiver un panneau en le "grisant"
   *
   * @param pano
   *            Le panneau a activer ou desactiver
   * @param estActive
   *            Si le panneau doit etre active (true) ou desactive (false)
   *
   */
  public void activationPanneau(JPanel pano, Boolean estActive){
    pano.setEnabled(estActive);
    Component[] contenu = pano.getComponents();

    for(int i = 0; i < contenu.length; i++) {
      if(contenu[i].getClass().getName() == "javax.swing.JPanel") {
        activationPanneau((JPanel) contenu[i], estActive);
      }
      contenu[i].setEnabled(estActive);
    }
  }

  /**
   * Permet de remplacer un panneau par un autre
   *
   * @param panneauAvant
   *                    Le panneau à remplacer
   * @param panneauApres
   *                    Un des deux nouveaux autres panneaux
   * @param panneauApres2
   *                    Un des deux nouveaux autres panneaux
   *
   */
  public void remplacerPanneau(JPanel panneauAvant, JPanel panneauApres, JPanel panneauApres2){
    this.panneauPrincipal.remove(panneauAvant);
    this.panneauPrincipal.repaint();
    //this.panoAccueil.getBttrois().addActionListener(controle);
    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.HORIZONTAL;     // occupe tout l'espace de la plage
    gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 0;  // souhaite plus de hauteur si possible
    gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(panneauApres, gbc);

    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 1;      // la plage de cellules commence à la premiere ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    gbc.gridheight = 2; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(panneauApres2, gbc);

    this.footer = new Footer();
    this.footer.getBoutonRetour().addActionListener(new Controleur(this));
    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 3;      // la plage de cellules commence à la premiere ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 0;  // souhaite plus de hauteur si possible
    gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(footer, gbc);

    this.panneauPrincipal.revalidate();
  }

  /**
   *Retourne le panneau de recherche
   *
   * @return panoAccueil
   *                  Le panneau de recherche en haut a gauche
   */
  public Recherche getPanneauRecherche(){
    return this.panoAccueil;
  }

  /**
  * Méthode principale
  */
  /*public static void main(String[] args){
    Vue vue = new Vue();
  }*/
}
