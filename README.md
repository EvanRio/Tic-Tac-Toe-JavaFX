# Tic-Tac-Toe - JavaFX 🕹️

[cite_start]Projet réalisé par **Evan HERIAULT** [cite: 3] [cite_start]dans le cadre du module R2.02 à l'IUT de Laval (2025-2026)[cite: 2]. [cite_start]Ce jeu de Morpion a été développé en environ 6 heures de cours pour mettre en pratique les concepts de programmation d'interfaces graphiques en Java[cite: 20].

## 🚀 Fonctionnalités

### Jeu & Logique
* [cite_start]**Grille standard 3x3** avec gestion de l'alternance entre les symboles X et O[cite: 34].
* [cite_start]**Détection automatique** des victoires (alignement horizontal, vertical ou diagonal) et des matchs nuls[cite: 67, 68].
* [cite_start]**Mise en surbrillance** des cases gagnantes en vert à la fin de la partie pour une meilleure lisibilité[cite: 39, 191].

### Configuration & UI
* [cite_start]**Personnalisation des pseudos** : Les joueurs peuvent modifier leurs noms via une interface dédiée[cite: 37, 171].
* [cite_start]**Gestion du premier joueur** : Menu permettant de choisir qui commence la partie (Joueur 1, Joueur 2 ou Aléatoire) via une boîte de dialogue modale[cite: 38, 160].
* [cite_start]**Tableau des scores** : Suivi des victoires mis à jour en temps réel durant la session[cite: 40, 225].
* [cite_start]**Dialogues interactifs** : Utilisation de fenêtres modales pour les résultats et d'une boîte de dialogue non modale pour les règles du jeu[cite: 35, 39].

## 🛠️ Structure du Projet

[cite_start]L'application suit une architecture **MVC** (Modèle-Vue-Contrôleur) pour séparer la logique de l'interface[cite: 20]:

* [cite_start]**Vue (`R202.fxml`)** : Définit l'interface graphique (plateau, menu, boutons) de manière descriptive[cite: 21]. [cite_start]Utilisation de `GridPane` pour la grille et de `VBox`/`HBox` pour l'agencement[cite: 26].
* [cite_start]**Contrôleur (`R20Controller.java`)** : Contient toute la logique métier, gère les clics, les saisies et met à jour l'UI[cite: 23].
* [cite_start]**Principal (`R202.java`)** : Classe principale qui charge la scène et lance l'application[cite: 24].

## 📸 Aperçu

| Page d'ouverture | Fenêtre de victoire |
|---|---|
| ![Ouverture](https://via.placeholder.com/300x200?text=Tic-Tac-Toe+Interface) | ![Victoire](https://via.placeholder.com/300x200?text=Winner+Highlight) |
[cite_start]*(Note : Pense à remplacer ces liens par tes propres captures d'écran issues de ton rapport [cite: 47])*

## 🧪 Difficultés résolues
[cite_start]Le développement a permis de surmonter des défis techniques, notamment sur l'exportation en fichier JAR [cite: 42] [cite_start]et la correction d'erreurs logiques lors de la mise à jour des pseudos via l'opérateur d'affectation `=`[cite: 44].

## ⚙️ Installation
1. Clonez le dépôt : `git clone https://github.com/EvanRio/Tic-Tac-Toe-JavaFX.git`
2. Importez le projet dans votre IDE (Eclipse ou IntelliJ).
3. Assurez-vous d'avoir configuré les bibliothèques **JavaFX**.
4. Lancez la classe `R202.java` pour démarrer le jeu.
