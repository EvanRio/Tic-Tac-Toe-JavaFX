# Tic-Tac-Toe - JavaFX

Projet réalisé par Evan HERIAULT dans le cadre du module R2.02 à l'IUT de Laval (2025-2026). Ce jeu de Morpion a été développé en environ 6 heures de cours pour mettre en pratique les concepts de programmation d'interfaces graphiques en Java.

## Fonctionnalités

### Jeu et Logique
* Grille standard 3x3 avec gestion de l'alternance entre les symboles X et O.
* Détection automatique des victoires (alignement horizontal, vertical ou diagonal) et des matchs nuls.
* Mise en surbrillance des cases gagnantes en vert à la fin de la partie pour une meilleure lisibilité.

### Configuration et UI
* Personnalisation des pseudos : Les joueurs peuvent modifier leurs noms via une interface dédiée.
* Gestion du premier joueur : Menu permettant de choisir qui commence la partie (Joueur 1, Joueur 2 ou Aléatoire) via une boîte de dialogue modale.
* Tableau des scores : Suivi des victoires mis à jour en temps réel durant la session.
* Dialogues interactifs : Utilisation de fenêtres modales pour les résultats et d'une boîte de dialogue non modale pour les règles du jeu.

## Structure du Projet

L'application suit une architecture MVC (Modèle-Vue-Contrôleur) pour séparer la logique de l'interface :

* Vue (R202.fxml) : Définit l'interface graphique (plateau, menu, boutons) réalisée avec Scene Builder. Utilisation de GridPane pour la grille et de VBox/HBox pour l'agencement.
* Contrôleur (R20Controller.java) : Contient toute la logique métier, gère les clics, les saisies et met à jour l'interface.
* Principal (R202.java) : Classe principale qui charge la scène et lance l'application.

## Aperçu

| Page d'ouverture | Fenêtre de victoire |
|---|---|
| ![Ouverture](https://i.ibb.co/xxfZttJ/capture1.png) | ![Victoire](https://i.ibb.co/Dmgx1YQ/capture2.png) |

## Difficultés résolues
Le développement a permis de surmonter des défis techniques, notamment sur l'exportation en fichier JAR et la correction d'erreurs logiques lors de la mise à jour des pseudos via l'opérateur d'affectation simple.

## Installation
1. Clonez le dépôt : git clone https://github.com/EvanRio/Tic-Tac-Toe-JavaFX.git
2. Importez le projet dans votre IDE (Eclipse ou IntelliJ).
3. Assurez-vous d'avoir configuré les bibliothèques JavaFX.
4. Lancez la classe R202.java pour démarrer le jeu.
