package fr.iutfbleau.projetIHM2021FI2.VUE;

import fr.iutfbleau.projetIHM2021FI2.CONTROLEUR.*;
import fr.iutfbleau.projetIHM2021FI2.MODELE.*;
import fr.iutfbleau.projetIHM2021FI2.API.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;

/**
 * <b>Vue est la classe qui instancie la fenetre principale du logiciel</b>
 * <p>
 * Cette vue est constituée de 4 panneaux, qui sont les 4 fonctionnalités du logiciel.
 * Elle est controlée par 4 controleurs, 1 par panneau.
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
   * Panneau en haut à gauche pour la recherche
   */
  private Recherche panoRech;

  /**
   * Panneau en bas a gauche pour la validation
   */
  private Validation panoValid;

  /**
   * Panneau en haut a droite pour la reservation
   */
  private PrereservationPanneau panoReserv;

  /**
   * Panneau en bas à droite pour les equivalents
   */
  private Equivalent panoEquiv;

  /**
   * Controleur pour la recherche
   */
  private ControleurRecherche controle;

  /**
   * Controleur pour la reservation
   */
  private ControleurPrereservation controleReserv;

  /**
   * Controleur pour le remplacement de chambre
   */
  private ControleurValidation controleValid;


  /**
   * Le layout qui gere la disposition des panneaux dans la fenetre
   */
  private GridBagConstraints gbc;



  /**
   * Vue.
   * <p>
   * Ce constructeur construit la fenetre avec un panneau principal, qui prend
   * toute la place de la fenetre, et dans lequel il y'a les 4 autres panneaux.
   * </p>
   */
  public Vue(){
    super("Gestion Hotel IHM - Lacombe & Meddahi");
    this.setSize(1600, 900);
    this.setLocation(100, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.panneauPrincipal = new JPanel(new GridBagLayout());
    this.gbc = new GridBagConstraints();
    this.panoRech = new Recherche();
    this.panoValid = new Validation();
    this.panoReserv = new PrereservationPanneau();
    this.panoEquiv = new Equivalent();

    this.controle = new ControleurRecherche(this, new Modele());
    this.panoRech.getBttrois().addActionListener(controle);

    this.controleReserv = new ControleurPrereservation(this);
    this.panoReserv.getBoutonAllouer().addActionListener(controleReserv);
    this.panoReserv.getBoutonEquivalents().addActionListener(controleReserv);
    this.panoReserv.getBoutonRetour().addActionListener(controleReserv);

    this.controleValid = new ControleurValidation(this);
    this.panoValid.getBoutonRetour().addActionListener(controleValid);
    this.panoValid.getBoutonValider().addActionListener(controleValid);

    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoRech, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.panneauPrincipal.add(this.panoEquiv, gbc);
    this.activationPanneau(this.panoEquiv, false);

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.panneauPrincipal.add(this.panoReserv, gbc);
    this.activationPanneau(this.panoReserv, false);


    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.panneauPrincipal.add(this.panoValid, gbc);
    this.activationPanneau(this.panoValid, false);

    this.add(this.panneauPrincipal);
    this.setVisible(true);
  }

  /**
   * Réinitialise le panneau de recherche
   */
  public void actualiserPanneauRecherche(){
    this.panneauPrincipal.remove(this.panoRech);
    this.panneauPrincipal.repaint();
    this.panoRech = new Recherche();
    this.panoRech.getBttrois().addActionListener(controle);
    this.gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    this.gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    this.gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    this.gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    this.gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    this.gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    this.gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    this.gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    this.gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoRech, gbc);
    this.panneauPrincipal.revalidate();
  }

  /**
   * Actualise le panneau de reservation avec les informations client
   *
   * @param nomClient
   *                 le nom du client
   * @param prenomClient
   *                le prenom du client
   * @param numChambre
   *                le numero de la chambre
   *
   * @param categorie
   *
   * @param dateDebut
   *
   * @param nbNuits
   *
   *
   */
  public void actualiserPanneauPrereservation(Prereservation prereservation){
    this.panneauPrincipal.remove(this.panoReserv);
    this.panneauPrincipal.repaint();
    this.panoReserv = new PrereservationPanneau(prereservation);
    this.panoReserv.getBoutonAllouer().addActionListener(controleReserv);
    this.panoReserv.getBoutonEquivalents().addActionListener(controleReserv);
    this.panoReserv.getBoutonRetour().addActionListener(controleReserv);

    this.gbc.gridx = 1;      // la plage de cellules commence à la première colonne
    this.gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    this.gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    this.gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    this.gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    this.gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    this.gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    this.gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    this.gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoReserv, gbc);
    this.panneauPrincipal.revalidate();
  }

  /**
   * Actualise le panneau de reservation multiple avec les informations client
   *
   * @param nomClient
   *                 le nom du client
   * @param prenomClient
   *                le prenom du client
   * @param numChambre
   *                le numero de la chambre
   *
   * @param categorie
   *
   * @param dateDebut
   *
   * @param nbNuits
   *
   *
   */
/*  public void actualiserPanneauPrereservation(ArrayList<Prereservation> listePrereservation){
    this.panneauPrincipal.remove(this.panoReserv);
    this.panneauPrincipal.repaint();
    this.panoReserv = new PrereservationMultiplePanneau(listePrereservation);
    ControleurPrereservationMultiple controle = new ControleurPrereservationMultiple(this);
    this.panoReserv.getBoutonEquivalents().addActionListener(controle);
    this.panoReserv.getBoutonRetour().addActionListener(controle);
    this.panoReserv.getListeDeroulante().addMouseListener(controle);

    this.gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    this.gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    this.gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    this.gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    this.gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    this.gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    this.gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    this.gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    this.gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoReserv, gbc);
    this.panneauPrincipal.revalidate();
  }


  /**
   * Actualise le panneau des equivalents avec la liste
   * @param listeEquivalents
   *                        La liste des chambres equivalentes
   */
  public void actualiserPanneauEquivalents(JList listeEquivalents){
    this.panneauPrincipal.remove(this.panoEquiv);
    this.panneauPrincipal.repaint();
    this.panoEquiv = new Equivalent(listeEquivalents);

    this.gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    this.gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    this.gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    this.gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    this.gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    this.gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    this.gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    this.gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    this.gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoEquiv, gbc);
    this.panneauPrincipal.revalidate();
  }

  /**
   * Permet d'actualiser n'importe quel panneau sans controleur
   *
   * @param ancienPanneau
   *                      le panneau a remplacer
   * @param nouveauPanneau
   *                      le panneau qu'on met apres
   * @param x
   *          la position x du nouveau panneau dans la fenetre
   * @param y
   *          la position y du nouveau panneau dans la fenetre
   *
   */
  public void actualisationPanneauPrereservVide(){
    this.panneauPrincipal.remove(this.panoReserv);
    this.panneauPrincipal.repaint();
    this.panoReserv = new PrereservationPanneau();
    this.panoReserv.getBoutonAllouer().addActionListener(controleReserv);
    this.panoReserv.getBoutonEquivalents().addActionListener(controleReserv);
    this.panoReserv.getBoutonRetour().addActionListener(controleReserv);

    this.gbc.gridx = 1;      // la plage de cellules commence à la première colonne
    this.gbc.gridy = 0;      // la plage de cellules commence à la premiere ligne
    this.gbc.gridwidth = 1;  // la plage de cellules englobe une colonnes
    this.gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    this.gbc.fill = GridBagConstraints.BOTH;     // occupe tout l'espace de la plage
    this.gbc.anchor = GridBagConstraints.NORTH; // se place en haut au centre de la plage
    this.gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    this.gbc.weighty = 1.0;  // souhaite plus de hauteur si possible
    this.gbc.insets = new Insets(0, 0, 0, 0); // Aucune marge sur aucun des cotés
    this.panneauPrincipal.add(this.panoReserv, gbc);
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
   *Retourne le panneau de recherche
   *
   * @return panoRech
   *                  Le panneau de recherche en haut a gauche
   */
  public Recherche getPanneauRecherche(){
    return this.panoRech;
  }

  /**
   *Retourne le panneau de validation (celui pour remplacer une chambre)
   *
   * @return panoValid
   *                  Le panneau de validation en bas a gauche
   */
  public Validation getPanneauValidation(){
    return this.panoValid;
  }

  /**
   *Retourne le panneau de reservation
   *
   * @return panoReserv
   *                  Le panneau de reservation en haut a droite
   */
  public PrereservationPanneau getPanneauPrereservation(){
    return this.panoReserv;
  }

  /**
   *Retourne le panneau d'equivalents
   *
   * @return panoEquiv
   *                  Le panneau d'equivalents en bas a droite
   */
  public Equivalent getPanneauEquivalent(){
    return this.panoEquiv;
  }
}
