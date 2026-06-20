pipeline {
    agent none

    tools {
        // Le nom ici doit être STRICTEMENT identique au "Nom" donné dans l'interface Jenkins
        jdk 'Java-21-JDK'
    }

    stages {

        stage('POC : Préparation Platform') {
            agent { label 'test-agent-inbound' }
            steps {
                cleanWs()
                echo "--- ÉTAPE 1 : Simulation Préparation ---"
                sh 'mkdir -p ./poc-test'
                sh 'date > ./poc-test/build_info.txt'
                dir('/home/jules/autres') {
                    sh 'date > autres_info.txt'
                }
                sh 'hostname'
                echo "Plateforme simulée avec succès."
                // Pas de stash — rien à transférer
            }
        }

        stage('Checkout') {
            agent { label 'built-in' }
            steps {
                cleanWs()
                checkout scm
            }
        }        

        stage('Pre-Check Platform') {
            agent { label 'built-in' }
            steps {
                // Checkout automatique ici — le code est disponible directement
                sh 'mvn clean test -P precheck'
            }
        }

        stage('Main Selenium Tests') {
            agent { label 'built-in' }
            steps {
                sh 'mvn test -P maintest'
            }
        }

        stage('Post-Check Tests') {
            agent { label 'built-in' }
            steps {
                sh 'mvn test -P postcheck'
            }
        }
    }

    post {
        always {
            node('built-in') {
                junit testResults: '**/target/surefire-reports/junitreports/*.xml',
                      allowEmptyResults: true
            }
        }
    }
}