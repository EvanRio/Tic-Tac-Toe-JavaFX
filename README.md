# Tic-Tac-Toe - JavaFX

[cite_start]Projet réalisé par **Evan HERIAULT** dans le cadre du module R2.02 à l'IUT de Laval (2025-2026). [cite_start]Ce jeu de Morpion a été développé en environ 6 heures de cours pour mettre en pratique les concepts de programmation d'interfaces graphiques en Java[cite: 20].

## 🚀 Fonctionnalités

### Jeu & Logique
* [cite_start]**Grille standard 3x3** avec gestion de l'alternance entre les joueurs (X et O)[cite: 34].
* [cite_start]**Détection automatique** des victoires (alignement horizontal, vertical ou diagonal) et des matchs nuls[cite: 67, 68].
* [cite_start]**Mise en surbrillance** des cases gagnantes en vert à la fin de la partie[cite: 39].

### Configuration & UI
* [cite_start]**Personnalisation des pseudos** : Possibilité de modifier le nom des joueurs via une interface dédiée[cite: 37].
* [cite_start]**Gestion du premier joueur** : Menu de configuration permettant de choisir qui commence (Joueur 1, Joueur 2 ou Aléatoire)[cite: 38].
* [cite_start]**Tableau des scores** : Suivi des victoires cumulées durant la session de jeu[cite: 40].
* [cite_start]**Dialogues interactifs** : Fenêtres modales pour les résultats et boîte de dialogue non modale pour les règles du jeu[cite: 35, 39].

## 🛠️ Structure du Projet

[cite_start]L'application suit une architecture découplée pour faciliter la maintenance[cite: 20]:

* [cite_start]**Vue (`R202.fxml`)** : Définition de l'interface graphique (GridPane pour le plateau, VBox/HBox pour les contrôles) réalisée avec Scene Builder[cite: 21, 26].
* [cite_start]**Contrôleur (`R20Controller.java`)** : Gestion de la logique métier, des événements de clic et mise à jour dynamique de l'UI[cite: 23].
* [cite_start]**Principal (`R202.java`)** : Point d'entrée de l'application qui charge la scène et initialise les paramètres[cite: 24].

## 📸 Aperçu

| Menu Principal | Fenêtre de Victoire |
|---|---|
| ![Capture 1](https://via.placeholder.com/300x200?text=Interface+Jeu) | ![Capture 2](https://via.placeholder.com/300x200?text=Score+Table) |
[cite_start]*(Note : Pense à remplacer ces liens par tes propres captures d'écran situées dans ton dossier `/images`)*[cite: 47].

## 🧪 Difficultés résolues
[cite_start]Lors du développement, j'ai utilisé l'IA (Gemini) pour corriger une erreur d'affectation (`=` au lieu de `+=`) lors de la mise à jour des pseudos, ce qui m'a permis de mieux comprendre la gestion des chaînes de caractères en Java[cite: 44].

## ⚙️ Installation
1. Clonez le dépôt.
2. Importez le projet dans votre IDE (IntelliJ ou Eclipse).
3. Assurez-vous d'avoir configuré la bibliothèque **JavaFX**.
4. Lancez la classe `R202.java`.
