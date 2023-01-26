package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * <b>Equivalent est le panneau dans lequel vont s'afficher les chambres equivalentes</b>
 * <p>
 * Ce panneau est constitué d'une liste qu'on peut scroller
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class Equivalent extends GraphPanneau{

  /**
   * Liste des chambres equivalentes
   */
  private JList liste;

  /**
   * Liste scrollable
   */
  private JScrollPane listeScrollable;

  /**
   * Equivalent.
   * <p>
   * Ce constructeur construit le panneau par defaut qui n'affiche aucun equivalent
   * Il initialise le titre du panneau et une liste vide
   * </p>
   */
  public Equivalent(){
    this.setLayout(new GridBagLayout());

    //String [] valeursTest = { "toto", "titi", "tata", "fred", "marc", "hugues", "soprano", "sch" };
    this.liste = new JList(/*valeursTest8*/);
    this.listeScrollable = new JScrollPane(liste);

    JLabel equivalent = new JLabel("EQUIVALENTS");
    equivalent.setFont(this.getPoliceMontserratRegular());
    equivalent.setFont(equivalent.getFont().deriveFont(equivalent.getFont().getSize() * 1.2F));

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
    equivalent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(equivalent, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 90, 50);
    this.add(this.listeScrollable, gbc);

    this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, super.getCouleurBordurePanneau()));
  }

  /**
   * Equivalent.
   * <p>
   * Ce constructeur recouvre le 1er pour creer le panneau equivalent avec les chambres equivalents
   * Il initialise le titre du panneau et une liste avec les chambres equivalentes
   * </p>
   */
  public Equivalent(JList listeEquivalents){
    this.setLayout(new GridBagLayout());

    //String [] valeursTest = { "toto", "titi", "tata", "fred", "marc", "hugues", "soprano", "sch" };
    this.liste = listeEquivalents;
    this.listeScrollable = new JScrollPane(liste);

    JLabel equivalent = new JLabel("EQUIVALENTS");
    equivalent.setFont(this.getPoliceMontserratRegular());
    equivalent.setFont(equivalent.getFont().deriveFont(equivalent.getFont().getSize() * 1.2F));

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
    equivalent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    this.add(equivalent, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.insets = new Insets(0, 50, 90, 50);
    this.add(this.listeScrollable, gbc);

    this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, super.getCouleurBordurePanneau()));
  }
}
