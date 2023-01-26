package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.*;
import java.sql.*;
import java.util.*;


/**
 * <b>TauxOccupation est la classe qui définit le panneau de recherche</b>
 * <p>
 * Cette classe comprend un bouton pour initier la recherche, ainsi que 3 champs: nom, prenom et numero de reservation
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class TauxOccupation extends GraphPanneau{

  /**
   * TauxOccupation.
   * <p>
   * Ce constructeur construit le panneau en haut du graphe
   * Il initialise le panneau et tous ses elements
   * </p>
   */
  public TauxOccupation(LocalDate date, int taux,LocalDate dateLundi){
    this.setLayout(new GridBagLayout());

    //TauxOccupation
    JLabel recherche = new JLabel("TAUX D'OCCUPATION");
    recherche.setFont(super.getPoliceMontserratRegular());
    recherche.setFont(recherche.getFont().deriveFont(recherche.getFont().getSize() * 1.4F));

    JLabel tauxOccup = new JLabel("Le taux d'occupation à la date du " + date + " était de " + taux + "%");
    tauxOccup.setFont(super.getPoliceMontserratRegular());
    tauxOccup.setFont(tauxOccup.getFont().deriveFont(tauxOccup.getFont().getSize() * 1.2F));

    JLabel presentation = new JLabel("Par rapport à la moyenne des trois années précédentes, voici les taux d'occupation pour la semaine du " + dateLundi + " :");
    presentation.setFont(super.getPoliceMontserratRegular());
    presentation.setFont(presentation.getFont().deriveFont(presentation.getFont().getSize() * 1.2F));

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(15, 100, 0, 100);
    recherche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(recherche, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(15, 100, 0, 100);
    tauxOccup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(tauxOccup, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(15, 50, 0, 50);
    tauxOccup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(presentation, gbc);


    //this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, super.getCouleurBordurePanneau()));
  }

}
