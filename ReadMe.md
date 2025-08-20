```markdown
# Projet d'Interdépendance de Microservices Spring Boot

Ce projet illustre une architecture de microservices interdépendants développés avec Spring Boot. Il met en évidence la communication et la gestion des données entre un microservice dépendant et un microservice indépendant, en utilisant une base de données relationnelle.

## Architecture

L'architecture du projet comprend les composants suivants :

*   **Frontend**: Simule l'interface utilisateur qui initie les requêtes.
*   **Dependent Microservice (Spring Boot)**: Microservice dépendant qui reçoit les requêtes initiales, effectue une partie du traitement et interagit avec le microservice indépendant.
*   **Independent Microservice (Spring Boot)**: Microservice indépendant qui effectue des opérations de lecture/écriture sur la base de données.
*   **Database**: Base de données relationnelle utilisée pour la persistance des données.

## Fichiers du Projet

### `UML/SequenceDiagramWithInterDependentMicroservices.plantuml`

Ce fichier contient un diagramme de séquence UML qui illustre le flux d'interaction entre les différents composants du système. Il détaille les étapes suivantes :

1.  Le Frontend envoie une requête au microservice dépendant.
2.  Le microservice dépendant prépare les données et effectue une logique métier.
3.  Le microservice dépendant envoie une requête au microservice indépendant.
4.  Le microservice indépendant valide et traite la requête, puis interagit avec la base de données.
5.  Les résultats sont renvoyés au microservice dépendant, qui effectue un traitement supplémentaire et interagit à nouveau avec la base de données.
6.  Enfin, le résultat est renvoyé au Frontend.

### `pom.xml` (Exemple pour chaque microservice)

Ce fichier Maven contient les dépendances et la configuration nécessaires pour construire et exécuter chaque microservice Spring Boot. Les dépendances incluent Spring Web, Spring Data JPA, une base de données (par exemple, H2, MySQL, PostgreSQL), et potentiellement des bibliothèques pour la gestion du JSON et les tests.

### `src/main/java/.../DTO` (Exemple pour chaque microservice)

Ce répertoire contient les Data Transfer Objects (DTOs) utilisés pour transférer les données entre les microservices et les couches de l'application.

### `src/main/java/.../Controller` (Exemple pour chaque microservice)

Ce répertoire contient les contrôleurs Spring Boot qui exposent les API REST pour interagir avec les microservices.

### `src/main/java/.../Service` (Exemple pour chaque microservice)

Ce répertoire contient les classes de service qui implémentent la logique métier des microservices.

### `src/main/java/.../Repository` (Exemple pour chaque microservice)

Ce répertoire contient les interfaces de repository Spring Data JPA utilisées pour interagir avec la base de données.

### `src/main/java/.../Entity` (Exemple pour chaque microservice)

Ce répertoire contient les classes d'entité JPA qui représentent les tables de la base de données.

## Comment Lancer le Projet

1.  **Cloner le projet :**

    ```bash
    git clone <URL_du_projet>
    ```
2.  **Installer les dépendances :**

    Assurez-vous d'avoir installé les outils suivants :

    *   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 17 ou supérieure)
    *   [Maven](https://maven.apache.org/download.cgi)
    *   [Git](https://git-scm.com/downloads)
    *   Une base de données (par exemple, MySQL, PostgreSQL, H2)

3.  **Configurer la base de données :**

    *   Créez une base de données et mettez à jour les paramètres de connexion dans les fichiers `application.properties` ou `application.yml` de chaque microservice.
4.  **Construire les microservices :**

    ```bash
    cd <microservice_directory>
    mvn clean install
    ```

    Répétez cette étape pour chaque microservice.
5.  **Exécuter les microservices :**

    ```bash
    cd <microservice_directory>
    mvn spring-boot:run
    ```

    Répétez cette étape pour chaque microservice. Assurez-vous que chaque microservice s'exécute sur un port différent.

## Outils Nécessaires

*   **Java Development Kit (JDK)**: Nécessaire pour compiler et exécuter les applications Java.
*   **Maven**: Outil de gestion de dépendances et de construction de projet.
*   **Git**: Système de contrôle de version pour gérer le code source.
*   **IntelliJ IDEA/Eclipse**: IDE pour le développement Java (optionnel).
*   **Base de données (MySQL, PostgreSQL, H2)**: Pour la persistance des données.
*   **Postman/Insomnia**: Pour tester les API REST (optionnel).
```