package fr.iutfbleau.projetIHM2021FI2.VUE;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * <b>GrapheTaux est la classe qui définit le panneau de l'histogramme</b>
 * <p>
 * Cette classe comprend la methode paintcomponent qu'elle herite de JComponent
 * <p>
 *
 * @author Quentin LACOMBE, Adam MEDDAHI
 * @version 1.0
 */
public class GrapheTaux extends GraphPanneau{

  /**
   * Le premier tableau de taux, celui de la semaine qui correspond a la date rentree
   */
  private int[] taux;

  /**
   * Le second tableau qui correspond aux 2 dernieres annees
   */
  private int[] taux2;

  /**
   * GrapheTaux.
   * <p>
   * Ce constructeur construit le panneau avec les batons de couleur
   * Il initialise le panneau et tous ses elements
   * </p>
   */
  public GrapheTaux(int[] lesTaux, int[] lesTaux2){
    this.taux = lesTaux;
    this.taux2 = lesTaux2;
  }

  /**
   * Permet de dessiner et de dimensionner les elements du graphe par rapport
   * à la taille de la fenetre.
   * Methode heritee de JComponent
   */
  protected void paintComponent(Graphics pinceau) {
  // obligatoire : on crée un nouveau pinceau pour pouvoir le modifier plus tard
  Graphics secondPinceau = pinceau.create();
  // obligatoire : si le composant n'est pas censé être transparent
  if (this.isOpaque()) {
    // obligatoire : on repeint toute la surface avec la couleur de fond
    secondPinceau.setColor(this.getBackground());
    secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
  }
  // maintenant on dessine ce que l'on veut
  secondPinceau.setColor(Color.BLACK);

  //secondPinceau.setFont(super.getPoliceMontserratRegular());
  //barre horizontale
  secondPinceau.drawLine(40, this.getHeight()-40, this.getWidth()-40 , this.getHeight()-40);
  //barre verticale
  secondPinceau.drawLine(40, this.getHeight()-40, 40 , 40);

  String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
  String[] zeroACent = {"100", "90", "80", "70", "60", "50", "40", "30", "20", "10", "0"};

  secondPinceau.drawString(zeroACent[0], 8 , 40);
  for(int i = 1; i < 11; i++){
    secondPinceau.drawString(zeroACent[i], 8, 40+((this.getHeight()-80)/10)*i);
  }

  secondPinceau.drawString(jours[0], 80, this.getHeight()-12);
  for(int i = 1; i < 7; i++){
    secondPinceau.drawString(jours[i], 80+((this.getWidth()-100)/7)*i, this.getHeight()-12);
  }

  //secondPinceau.setColor(super.getCouleurBoutonValidation());
  int hauteur = this.getHeight()-80;

  for(int i = 0; i < 7; i++){
    secondPinceau.setColor(super.getCouleurBoutonValidation());
    int j = 65+((this.getWidth()-100)/7)*i;
    int hauteurTab = 100-this.taux[i];
    secondPinceau.fillRect(j, hauteur*hauteurTab/100+40, /*largeur*/30, /*hauteur*/hauteur*this.taux[i]/100+1);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.drawString(this.taux[i] + "%",j , hauteur*hauteurTab/100+30);
  }

  //secondPinceau.setColor(new Color(117, 176, 224));
  for(int i = 0; i < 7; i++){
    secondPinceau.setColor(new Color(117, 176, 224));
    int j = 95+((this.getWidth()-100)/7)*i;
    int hauteurTab = 100-this.taux2[i];
    secondPinceau.fillRect(j, hauteur*hauteurTab/100+40, /*largeur*/30, /*hauteur*/hauteur*this.taux2[i]/100+1);
    secondPinceau.setColor(Color.BLACK);
    secondPinceau.drawString(this.taux2[i] + "%",j , hauteur*hauteurTab/100+30);
  }

  //secondPinceau.fillRect(60, hauteur*90/100+40, /*largeur*/30, hauteur*10/100+1);
}

  /*public static void main(String args[]){
  JFrame frame =new JFrame();
  int [] myArray = { 10, 20, 30, 40, 50, 60, 70 };
  int [] myArray2 = { 70, 60, 50, 40, 30, 20, 10 };
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.add(new GrapheTaux(myArray, myArray2));
  frame.setSize(800,800);
  frame.setLocation(0,0);
  frame.setVisible(true);
}*/
}
