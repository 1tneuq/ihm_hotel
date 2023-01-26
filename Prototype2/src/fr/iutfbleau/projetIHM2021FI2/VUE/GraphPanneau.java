package fr.iutfbleau.projetIHM2021FI2.VUE;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

/**
 * <b>GraphPanneau est la classe dont tous les 4 panneaux de la vue vont heriter
 * et qui définit leur aspect graphique</b>
 * <p>
 * Cette classe est "constituee" de 4 couleurs et d'une police, qui va avec son fichier.
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class GraphPanneau extends JPanel{

  /**
   * Couleur des boutons verts
   */
  private Color couleurBoutonValidation;

  /**
   * Couleur des textes preremplis dans les champs, soit du gris clair
   */
  private Color couleurTextePreremplie;

  /**
   * Couleur des bordures des panneux, soit du gris fonce
   */
  private Color couleurBordurePanneau;

  /**
   * Couleur du fond, soit un blanc un peu grise
   */
  private Color couleurFond;

  /**
   * Police Montserrat Regular
   */
  private Font policeMontserratRegular;

  /**
   * Fichier qui contient la police Montserrat Regular
   */
  //private File fichierPoliceMontserratRegular;

  /**
   * Url qui contient la police Montserrat Regular
   */
  private URL fontUrl;


  /**
   * GraphPanneau.
   * <p>
   * Ce constructeur construit le patern de base des 4 panneuax de la vue.
   * Tout ce qui touche a leur esthetique est configure ici.
   * </p>
   */
  public GraphPanneau(){
    //Les couleurs
    this.couleurBoutonValidation = new Color(109, 227, 104);
    this.couleurTextePreremplie = new Color(128, 128, 128);
    this.couleurBordurePanneau = new Color(105, 105, 105);
    this.couleurFond = new Color(238,238,238);

    //La police Montserrat
    try{
      //this.fichierPoliceMontserratRegular = new File("../../../../../res/polices/Montserrat-Regular.ttf");
      this.fontUrl = new URL("https://dwarves.iut-fbleau.fr/~lacombe/Police/Montserrat-Regular.ttf");
      this.policeMontserratRegular = Font.createFont(Font.TRUETYPE_FONT, this.fontUrl.openStream());
      this.policeMontserratRegular = this.policeMontserratRegular.deriveFont(15.f);
    } catch(Exception exceptionPolice){
      System.err.println(exceptionPolice.getMessage());
    }
  }

  /**
   *Retourne la couleur des boutons verts
   *
   * @return couleurBoutonValidation
   *                                La couleur verte des boutons
   */
  public Color getCouleurBoutonValidation(){
    return this.couleurBoutonValidation;
  }

  /**
   *Retourne la couleur des textes preremplis
   *
   * @return couleurTextePreremplie
   *                                Le gris clair des textes preremplis
   */
  public Color getCouleurTextePreremplie(){
    return this.couleurTextePreremplie;
  }

  /**
   *Retourne la couleur des bordures des panneaux
   *
   * @return couleurBordurePanneau
   *                              La couleur gris fonce des bords
   */
  public Color getCouleurBordurePanneau(){
    return this.couleurBordurePanneau;
  }

  /**
   *Retourne la couleur de fond
   *
   * @return couleurFond
   *                    Le blanc gris clair du fond
   */
  public Color getCouleurFond(){
    return this.couleurFond;
  }

  /**
   *Retourne la police Montserrat Regular
   *
   * @return policeMontserratRegular
   *                                la police Montserrat Regular
   */
  public Font getPoliceMontserratRegular(){
    return this.policeMontserratRegular;
  }

  /**
   *Retourne le fichier qui contient la police
   *
   * @return fichierPoliceMontserratRegular
   *                                       Le fameux fichier
   */
  /*public File getFichierPoliceMontserratRegular(){
    return this.fichierPoliceMontserratRegular;
  }*/
}
