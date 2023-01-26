package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * <b>Footer est la classe qui definit le panneau en bas de l'histogramme</b>
 * <p>
 * Cette classe comprend un bouton de retour pour revenir a l'accueil aisi que la legende de l'histogramme
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */

 public class Footer extends GraphPanneau{

   /**
   * Bouton pour revenir en arriere
   */
   private JButton boutonRetour;

   /**
   * Footer.
   * <p>
   * Ce constructeur construit le panneau qui affiche la legende de l'histogramme et le bouton retour
   * </p>
   */
   public Footer(){
     this.setLayout(new GridBagLayout());

     this.boutonRetour = new JButton("RETOUR");
     this.boutonRetour.setFont(super.getPoliceMontserratRegular());
     this.boutonRetour.setBorderPainted(false);
     this.boutonRetour.setBackground(new Color(255, 112, 99));
     this.boutonRetour.setForeground(Color.WHITE);
     this.boutonRetour.setFocusPainted(false);
     this.boutonRetour.setPreferredSize(new Dimension(175, 50));


     JLabel semaine = new JLabel("▢ taux d'occupation de la semaine");
     semaine.setFont(super.getPoliceMontserratRegular());
     semaine.setFont(semaine.getFont().deriveFont(semaine.getFont().getSize() * 1.1F));
     semaine.setForeground(super.getCouleurBoutonValidation());

     JLabel annees = new JLabel("▢ moyenne des 3 années précédentes");
     annees.setFont(super.getPoliceMontserratRegular());
     annees.setFont(annees.getFont().deriveFont(annees.getFont().getSize() * 1.1F));
     annees.setForeground(new Color(117, 176, 224));

     GridBagConstraints gbc = new GridBagConstraints();

     gbc.gridx = 0;
     gbc.gridy = 0;
     gbc.gridwidth = 1;
     gbc.gridheight = 1;
     gbc.fill = GridBagConstraints.HORIZONTAL;
     gbc.anchor = GridBagConstraints.NORTH;
     gbc.weightx = 1.0;
     gbc.weighty = 1.0;
     gbc.insets = new Insets(10, 0, 0, 0);
     semaine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     this.add(semaine, gbc);

     gbc.gridx = 2;
     gbc.gridy = 0;
     gbc.gridwidth = 1;
     gbc.gridheight = 1;
     gbc.fill = GridBagConstraints.HORIZONTAL;
     gbc.anchor = GridBagConstraints.NORTH;
     gbc.weightx = 1.0;
     gbc.weighty = 1.0;
     gbc.insets = new Insets(10, 0, 0, 0);
     annees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
     this.add(annees, gbc);

     gbc.gridx = 1;
     gbc.gridy = 1;
     gbc.gridwidth = 1;
     gbc.gridheight = 1;
     gbc.fill = GridBagConstraints.NONE;
     gbc.anchor = GridBagConstraints.NORTH;
     gbc.weightx = 0;
     gbc.weighty = 1.0;
     gbc.insets = new Insets(30, 0, 18, 0);
     this.add(boutonRetour, gbc);

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
