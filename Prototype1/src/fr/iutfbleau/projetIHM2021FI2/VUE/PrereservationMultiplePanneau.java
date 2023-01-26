package fr.iutfbleau.projetIHM2021FI2.VUE;

import fr.iutfbleau.projetIHM2021FI2.API.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * <b>Reservation est le panneau dans lequel va s'afficher les details de la reservation du client</b>
 * <p>
 * Ce panneau est constitué des infos de la reservation
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class PrereservationMultiplePanneau extends PrereservationPanneau{

  /**
   * Bouton pour revenir en arriere
   */
  private JButton boutonRetour;

  /**
   * Bouton pour acceder aux equivalents
   */
  private JButton boutonEquivalents;

  /**
   * Liste des chambres equivalentes
   */
  private Set<Prereservation> liste;

  /**
   * Liste scrollable
   */
  private JScrollPane listeScrollable;


  /**
   * Reservation.
   * <p>
   * Ce constructeur construit le panneau par defaut qui n'affiche aucun detail de reservation
   * Il initialise le titre du panneau et une un panneau vite
   * </p>
   */

  /**
   * Reservation.
   * <p>
   * Ce constructeur construit le panneau qui affiche le detail de la reservation client
   * Il initialise les attributs vides
   * </p>
   */
  public PrereservationMultiplePanneau(ArrayList<Prereservation> listePrereservation){
    JPanel panneauPrereservations = new JPanel();
    panneauPrereservations.setLayout(new GridLayout(listePrereservation.size(),1));
    for(Prereservation prereservation : listePrereservation){
      panneauPrereservations.add(new JTextField(prereservation.monPrint()));
    }
    this.listeScrollable = new JScrollPane(panneauPrereservations);

    this.boutonRetour = new JButton("RETOUR");
    this.boutonRetour.setFont(super.getPoliceMontserratRegular());
    this.boutonRetour.setBorderPainted(false);
    this.boutonRetour.setBackground(new Color(255, 112, 99));
    this.boutonRetour.setForeground(Color.WHITE);
    this.boutonRetour.setFocusPainted(false);
    this.boutonRetour.setPreferredSize(new Dimension(150, 40));

    this.boutonEquivalents = new JButton("EQUIVALENTS");
    this.boutonEquivalents.setFont(super.getPoliceMontserratRegular());
    this.boutonEquivalents.setBorderPainted(false);
    this.boutonEquivalents.setBackground(new Color(117, 176, 224));
    this.boutonEquivalents.setForeground(Color.WHITE);
    this.boutonEquivalents.setFocusPainted(false);
    this.boutonEquivalents.setPreferredSize(new Dimension(150, 40));

    JLabel reservation = new JLabel("RESERVATIONS");
    reservation.setFont(super.getPoliceMontserratRegular());
    reservation.setFont(reservation.getFont().deriveFont(reservation.getFont().getSize() * 1.2F));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(40, 0, 0, 0);
    reservation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(reservation, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 90, 50);
    this.add(listeScrollable, gbc);


    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.NORTHEAST;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 0, 0, 0);
    this.add(boutonRetour, gbc);


    gbc.gridx = 2;
    gbc.gridy = 2;
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

  public JScrollPane getListeDeroulante(){
    return this.listeScrollable;
  }
}
