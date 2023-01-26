package fr.iutfbleau.projetIHM2021FI2.MODELE;

import fr.iutfbleau.projetIHM2021FI2.API.*;

/**
 * Une chambre
 */
public class ModeleChambre implements Chambre {

    private int numero;

    private TypeChambre type;

    public ModeleChambre(int numero, TypeChambre type){
      this.numero = numero;
      this.type = type;
    }

    /**
     * permet de récupérer le numéro de la chambre.
     * @return le numéro.
     */
    public int getNumero(){
      return this.numero;
    }

    public TypeChambre getType(){
      return this.type;
    }
}
