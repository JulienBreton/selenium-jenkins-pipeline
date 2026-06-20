pipeline {
    agent none

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
            tools {
                jdk 'Java-25-JDK'
            }
            steps {
                // Checkout automatique ici — le code est disponible directement
                sh 'mvn clean test -P precheck'
            }
        }

        stage('Main Selenium Tests') {
            agent { label 'built-in' }
            tools {
                jdk 'Java-25-JDK'
            }
            steps {
                sh 'mvn test -P maintest'
            }
        }

        stage('Post-Check Tests') {
            agent { label 'built-in' }
            tools {
                jdk 'Java-25-JDK'
            }
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