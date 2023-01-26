package fr.iutfbleau.projetIHM2021FI2.VUE;

import fr.iutfbleau.projetIHM2021FI2.API.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Date;

/**
 * <b>Reservation est le panneau dans lequel va s'afficher les details de la reservation du client</b>
 * <p>
 * Ce panneau est constitué des infos de la reservation
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class PrereservationPanneau extends GraphPanneau{

  /**
   * Bouton pour allouer la chambre
   */
  private JButton boutonAllouer;

  /**
   * Bouton pour acceder aux equivalents
   */
  private JButton boutonEquivalents;

  /**
   * Bouton pour revenir en arriere
   */
  private JButton boutonRetour;

  /**
   * Prereservation courante
   */
  private Prereservation prereservation;

  /**
   * Label relatif au client
   */
  private JLabel client;
  /**
   * Label relatif à la chambre
   */
  private JLabel chambre;
  /**
   * Label relatif à la categorie de chambre
   */
  private JLabel categorie;
  /**
   * Label relatif a la date de debut de la reservation
   */
  private JLabel debut;
  /**
   * Label relatif au nombre de nuit de la reservation
   */
  private JLabel nuit;
  /**
   * Reservation.
   * <p>
   * Ce constructeur construit le panneau par defaut qui n'affiche aucun detail de reservation
   * Il initialise le titre du panneau et une un panneau vite
   * </p>
   */
  public PrereservationPanneau(){
    this.setLayout(new GridBagLayout());

    this.boutonAllouer = new JButton("ALLOUER");
    boutonAllouer.setFont(super.getPoliceMontserratRegular());
    boutonAllouer.setBorderPainted(false);
    boutonAllouer.setBackground(super.getCouleurBoutonValidation());
    boutonAllouer.setForeground(Color.WHITE);
    boutonAllouer.setFocusPainted(false);
    boutonAllouer.setPreferredSize(new Dimension(150, 40));

    this.boutonEquivalents = new JButton("EQUIVALENTS");
    this.boutonEquivalents.setFont(super.getPoliceMontserratRegular());
    this.boutonEquivalents.setBorderPainted(false);
    this.boutonEquivalents.setBackground(new Color(117, 176, 224));
    this.boutonEquivalents.setForeground(Color.WHITE);
    this.boutonEquivalents.setFocusPainted(false);
    this.boutonEquivalents.setPreferredSize(new Dimension(150, 40));

    this.boutonRetour = new JButton("RETOUR");
    this.boutonRetour.setFont(super.getPoliceMontserratRegular());
    this.boutonRetour.setBorderPainted(false);
    this.boutonRetour.setBackground(new Color(255, 112, 99));
    this.boutonRetour.setForeground(Color.WHITE);
    this.boutonRetour.setFocusPainted(false);
    this.boutonRetour.setPreferredSize(new Dimension(150, 40));

    this.client= new JLabel("Identite du client: ");
    this.client.setFont(super.getPoliceMontserratRegular());

    this.chambre= new JLabel("Numero de la chambre: " );
    this.chambre.setFont(super.getPoliceMontserratRegular());

    this.categorie= new JLabel("Catégorie de la chambre: ");
    this.categorie.setFont(super.getPoliceMontserratRegular());

    this.debut= new JLabel("Date de début de la reservation: ");
    this.debut.setFont(super.getPoliceMontserratRegular());

    this.nuit= new JLabel("Nombre de nuits de la reservation: ");
    this.nuit.setFont(super.getPoliceMontserratRegular());

    JLabel reservation = new JLabel("RESERVATION");
    reservation.setFont(super.getPoliceMontserratRegular());
    reservation.setFont(reservation.getFont().deriveFont(reservation.getFont().getSize() * 1.2F));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    reservation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(reservation, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(20, -150, 0, 0);
    //this.client.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.client, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.chambre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.chambre, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.categorie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.categorie, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.debut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.debut, gbc);

    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.nuit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.nuit, gbc);

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonRetour, gbc);

    gbc.gridx = 1;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonAllouer, gbc);

    gbc.gridx = 2;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonEquivalents, gbc);

    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, super.getCouleurBordurePanneau()));
  }

  /**
   * Reservation.
   * <p>
   * Ce constructeur construit le panneau qui affiche le detail de la reservation client
   * Il initialise les attributs vides
   * </p>
   */
  public PrereservationPanneau(Prereservation prereservation){
    this.prereservation = prereservation;
    this.setLayout(new GridBagLayout());

    this.boutonAllouer = new JButton("ALLOUER");
    boutonAllouer.setFont(super.getPoliceMontserratRegular());
    boutonAllouer.setBorderPainted(false);
    boutonAllouer.setBackground(super.getCouleurBoutonValidation());
    boutonAllouer.setForeground(Color.WHITE);
    boutonAllouer.setFocusPainted(false);
    boutonAllouer.setPreferredSize(new Dimension(200, 40));

    this.boutonEquivalents = new JButton("EQUIVALENTS");
    this.boutonEquivalents.setFont(super.getPoliceMontserratRegular());
    this.boutonEquivalents.setBorderPainted(false);
    this.boutonEquivalents.setBackground(new Color(117, 176, 224));
    this.boutonEquivalents.setForeground(Color.WHITE);
    this.boutonEquivalents.setFocusPainted(false);
    this.boutonEquivalents.setPreferredSize(new Dimension(200, 40));

    this.boutonRetour = new JButton("RETOUR");
    this.boutonRetour.setFont(super.getPoliceMontserratRegular());
    this.boutonRetour.setBorderPainted(false);
    this.boutonRetour.setBackground(new Color(255, 112, 99));
    this.boutonRetour.setForeground(Color.WHITE);
    this.boutonRetour.setFocusPainted(false);
    this.boutonRetour.setPreferredSize(new Dimension(150, 40));

    this.client= new JLabel("Client:   " + this.prereservation.getClient().getPrenom() + " " +this.prereservation.getClient().getNom());
    this.client.setFont(super.getPoliceMontserratRegular());

    //this.chambre= new JLabel("Chambre:   " + "5");
    //this.chambre.setFont(super.getPoliceMontserratRegular());

    this.categorie= new JLabel("Catégorie:   " + this.prereservation.getTypeChambre());
    this.categorie.setFont(super.getPoliceMontserratRegular());

    this.debut= new JLabel("Date de début:   " + this.prereservation.getDateDebut());
    this.debut.setFont(super.getPoliceMontserratRegular());

    this.nuit= new JLabel("Nombre de nuits:   " + this.prereservation.getJours());
    this.nuit.setFont(super.getPoliceMontserratRegular());

    JLabel reservation = new JLabel("RESERVATION");
    reservation.setFont(super.getPoliceMontserratRegular());
    reservation.setFont(reservation.getFont().deriveFont(reservation.getFont().getSize() * 1.2F));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    reservation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(reservation, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(20, -150, 0, 0);
    //this.client.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.client, gbc);

    /*gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.chambre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.chambre, gbc);*/

    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.categorie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.debut, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.debut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.nuit, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, -150, 0, 0);
    //this.nuit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    this.add(this.categorie, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonRetour, gbc);

    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonAllouer, gbc);

    gbc.gridx = 2;
    gbc.gridy = 5;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonEquivalents, gbc);

    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, super.getCouleurBordurePanneau()));
  }

  /**
   * Retourne le bouton "Allouer"
   *
   * @return boutonAllouer
   *                      Le bouton vert pour allouer la chambre de la reservation
   *
   */
  public JButton getBoutonAllouer(){
    return this.boutonAllouer;
  }

  /**
   * Retourne le bouton "Equivalents"
   *
   * @return boutonEquivalents
   *                      Le bouton bleu pour afficher les chambres equivalentes
   *
   */
  public JButton getBoutonEquivalents(){
    return this.boutonEquivalents;
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
}
