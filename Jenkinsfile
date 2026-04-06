pipeline {
    agent any
    
    tools {
        // On ne garde que Maven, car Java est déjà là
        maven 'maven3' 
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & HealthCheck') {
            steps {
                // On lance d'abord le test de statut de la plateforme
                sh 'mvn verify -DskipTests' 
            }
        }
        stage('UI Tests') {
            steps {
                // On lance ton test Google sur le Docker
                sh 'mvn test -Dtest=GoogleTest -DrunMode=remote'
            }
        }
    }
}