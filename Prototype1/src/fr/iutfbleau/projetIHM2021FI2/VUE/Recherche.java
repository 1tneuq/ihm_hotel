package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * <b>Recherche est la classe qui définit le panneau de recherche</b>
 * <p>
 * Cette classe comprend un bouton pour initier la recherche, ainsi que 3 champs: nom, prenom et numero de reservation
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
   * Champs pour le nom
   */
  private JTextField nom;

  /**
   * Champs pour le prenom
   */
  private JTextField prenom;

  /**
   * Champs pour le numero de reservation
   */
  private JTextField numReserv;

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
    ///Nom
    this.nom = new JTextField("Nom");
    nom.setFont(super.getPoliceMontserratRegular());
    nom.setBackground(super.getCouleurFond());
    nom.setForeground(super.getCouleurTextePreremplie());
    nom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
    //Prenom
    this.prenom = new JTextField("Prenom");
    prenom.setFont(super.getPoliceMontserratRegular());
    prenom.setBackground(super.getCouleurFond());
    prenom.setForeground(super.getCouleurTextePreremplie());
    prenom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
    //Num de reservation
    this.numReserv = new JTextField("Numero de reservation");
    numReserv.setFont(super.getPoliceMontserratRegular());
    numReserv.setBackground(super.getCouleurFond());
    numReserv.setForeground(super.getCouleurTextePreremplie());
    numReserv.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220,220, 220)));

    //Bouton valider
    this.bt3 = new JButton("RECHERCHER");
    bt3.setFont(super.getPoliceMontserratRegular());
    bt3.setBorderPainted(false);
    bt3.setBackground(super.getCouleurBoutonValidation());
    bt3.setForeground(Color.WHITE);
    bt3.setFocusPainted(false);
    bt3.setPreferredSize(new Dimension(200, 40));

    //le ou
    JLabel label = new JLabel("OU");
    label.setFont(super.getPoliceMontserratRegular());

    //Recherche
    JLabel recherche = new JLabel("RECHERCHE");
    recherche.setFont(super.getPoliceMontserratRegular());
    recherche.setFont(recherche.getFont().deriveFont(recherche.getFont().getSize() * 1.2F));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    recherche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(recherche, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(label, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 0, 0);
    this.add(nom, gbc);

    gbc.gridx = 2;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 50);
    this.add(prenom, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 0, 50);
    this.add(numReserv, gbc);

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

    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, super.getCouleurBordurePanneau()));
  }

  /**
   * Retourne le champs nom
   *
   * @return nom
   *            Le champs dans lequel on rentre le nom du client
   *
   */
  public JTextField getNom(){
    return this.nom;
  }

  /**
   * Retourne le champs prenom
   *
   * @return prenom
   *            Le champs dans lequel on rentre le prenom du client
   *
   */
  public JTextField getPrenom(){
    return this.prenom;
  }

  /**
   * Retourne le champs de reference de prereservation
   *
   * @return numReserv
   *                  Le champs dans lequel on rentre la reference d'une prereservation
   *
   */
  public JTextField getReserv(){
    return this.numReserv;
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
