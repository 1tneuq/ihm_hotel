# Projet IHM Hotel

## Description générale du projet

Réalisation de deux prototypes permettant de faire de la gestion au sein d'un hôtel en partant d'une base de données de pré-réservations.


## Specifications
### Premier prototype: réservations

1. Rechercher une pré-réservation par nom et prénom du client ou par le numéro de réservation
2. Valider la pré-réservation (allouer la chambre de la recherche) 
3. Consulter les équivalents pour une chambre pré-réservée
4. Remplacer le numéro de chambre d'une réservation par un autre

### Second prototype: statistiques

1. Rechercher une date
2. Afficher les statistiques d'occupation de la date
3. Afficher un graphique sous forme de batons

## Dépendances

```bash
sudo apt-get install default-jre
```


## Prototypes

```
MakeFile

USAGE

    make

COMMANDES 

    run (commande par défaut) : crée une archive .jar du prototype si elle n'existe pas et l'éxecute.

    clean : supprime tous les fichiers de compilation .class ainsi que l'archive .jar.

    doc : génère la documentation du projet avec ses différentes classes et méthodes sous forme de pages HTML Javadoc.

```


## Illustrations

![Ecran principal du premier prototype](https://github.com/1tneuq/1tneuq.github.io/blob/main/img/Hotel_pt1.JPG)
![Ecran de recherche du second prototype](https://github.com/1tneuq/1tneuq.github.io/blob/main/img/Hotel_pt2.JPG)
![Graphique du second prototype](https://github.com/1tneuq/1tneuq.github.io/blob/main/img/Hotel_pt21.JPG)


### Contributeurs

- Quentin LACOMBE
- Adam MEDDAHI
