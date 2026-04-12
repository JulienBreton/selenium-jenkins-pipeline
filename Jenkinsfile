pipeline {
    agent any

    stages {
        stage('Pre-Check Platform') {
            steps {
                // Si ce test échoue (ex: statut KO), Jenkins s'arrête ici
                sh 'mvn clean test -P precheck'
            }
        }
        stage('Main Selenium Tests') {
            steps {
                sh 'mvn test -P maintest'
            }
        }
        stage('Post-Check Tests') {
            steps {
                sh 'mvn test -P postcheck'
            }
        }
    }

    post {
        always {
            // Cette commande va lister tous les XML et leur chemin dans la console
            sh 'find . -name "*.xml" | grep surefire-reports'

            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
        }
    }
}
