package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * <b>Recherche est la classe qui définit le panneau de recherche</b>
 * <p>
 * Cette classe comprend un bouton pour initier la recherche et un champs pour y entrer une date
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class Recherche extends GraphPanneau{

  /**
   * Bouton de recherche
   */
  private JButton bt3;

  /**
   * Champs pour la date
   */
  private JTextField dateDonnee;

  /**
   * Recherche.
   * <p>
   * Ce constructeur construit le panneau de recherche dans lequel on va rentrer
   * les informations d'une prereservation
   * Il initialise le panneau et tous ses elements
   * </p>
   */
  public Recherche(){
    this.setLayout(new GridBagLayout());

    this.dateDonnee = new JTextField("Date au format JJ/MM/AAAA");
    dateDonnee.setFont(super.getPoliceMontserratRegular());
    dateDonnee.setBackground(super.getCouleurFond());
    dateDonnee.setForeground(super.getCouleurTextePreremplie());
    dateDonnee.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220,220, 220)));

    //Bouton valider
    this.bt3 = new JButton("VALIDER");
    bt3.setFont(super.getPoliceMontserratRegular());
    bt3.setBorderPainted(false);
    bt3.setBackground(super.getCouleurBoutonValidation());
    bt3.setForeground(Color.WHITE);
    bt3.setFocusPainted(false);
    bt3.setPreferredSize(new Dimension(280, 60));

    //Recherche
    JLabel recherche = new JLabel("CONSULTER DES STATISTIQUES");
    recherche.setFont(super.getPoliceMontserratRegular());
    recherche.setFont(recherche.getFont().deriveFont(recherche.getFont().getSize() * 1.4F));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(50, 0, 0, 0);
    recherche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(recherche, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 0, 50);
    this.add(dateDonnee, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(bt3, gbc);

    //this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, super.getCouleurBordurePanneau()));
  }


  /**
   * Retourne le champs de la date
   *
   * @return dateDonnee
   *                  Le champs dans lequel on rentre la date pour voir les stats
   *
   */
  public JTextField getDate(){
    return this.dateDonnee;
  }

  /**
   * Retourne le bouton "Rechercher"
   *
   * @return bt3
   *            Le bouton vert pour lancer la recherche
   *
   */
  public JButton getBttrois(){
    return this.bt3;
  }
}
