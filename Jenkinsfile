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
            // TestNG génère ces XML dans surefire-reports quand il est lancé par Maven
            junit '**/target/surefire-reports/testng-results.xml'
        }
    }
}
