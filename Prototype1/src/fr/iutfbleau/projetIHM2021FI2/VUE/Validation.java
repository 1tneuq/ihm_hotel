package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Validation extends GraphPanneau{

  /**
   * Bouton pour valider
   */
  private JButton bt3;

  /**
   * Bouton pour revenir en arriere
   */
  private JButton boutonRetour;

  /**
   * Champs pour le numero de reservation (ou reference)
   */
  private JTextField numReserv;

  /**
   * Champs pour le numero de chambre
   */
  private JTextField numChambre;

  /**
   * Validation.
   * <p>
   * Ce constructeur construit le panneau pour remplacer une reservation
   * Il initialise le titre du panneau et ses composants
   * </p>
   */
  public Validation(){
    this.setLayout(new GridBagLayout());
    ///Nom
    //Num de reservation
    this.numReserv = new JTextField("Numero de reservation");
    numReserv.setFont(this.getPoliceMontserratRegular());
    numReserv.setForeground(this.getCouleurTextePreremplie());
    numReserv.setBackground(new Color(238, 238, 238));
    numReserv.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
    //Num de chambre
    this.numChambre = new JTextField("Nouveau numero de chambre");
    numChambre.setFont(this.getPoliceMontserratRegular());
    numChambre.setForeground(this.getCouleurTextePreremplie());
    numChambre.setBackground(new Color(238, 238, 238));
    numChambre.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 220, 220)));
    //Bouton valider
    this.bt3 = new JButton("VALIDER");
    bt3.setFont(this.getPoliceMontserratRegular());
    bt3.setBorderPainted(false);
    bt3.setBackground(this.getCouleurBoutonValidation());
    bt3.setForeground(Color.WHITE);
    bt3.setFocusPainted(false);
    bt3.setPreferredSize(new Dimension(175, 40));
    //Bouton RETOUR
    this.boutonRetour = new JButton("RETOUR");
    this.boutonRetour.setFont(super.getPoliceMontserratRegular());
    this.boutonRetour.setBorderPainted(false);
    this.boutonRetour.setBackground(new Color(255, 112, 99));
    this.boutonRetour.setForeground(Color.WHITE);
    this.boutonRetour.setFocusPainted(false);
    this.boutonRetour.setPreferredSize(new Dimension(175, 40));
    //Recherche
    JLabel recherche = new JLabel("REMPLACER CHAMBRE");
    recherche.setFont(this.getPoliceMontserratRegular());
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


    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(40, 50, 0, 50);
    this.add(numReserv, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 0, 50);
    this.add(numChambre, gbc);

    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(bt3, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonRetour, gbc);

    //this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, super.getCouleurBordurePanneau()));
  }

  /**
   * Retourne le bouton "Retour"
   *
   * @return boutonRetour
   *                      Le bouton rouge pour revenir en arriere
   *
   */
  public JButton getBoutonRetour(){
    return this.boutonRetour;
  }

  /**
   * Retourne le bouton "Valider"
   *
   * @return bt3
   *            Le bouton vert pour la validation
   *
   */
  public JButton getBoutonValider(){
    return this.bt3;
  }

}
