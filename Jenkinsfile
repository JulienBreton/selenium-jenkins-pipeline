pipeline {
   agent any

    stages {
        stage('Pre-Check Platform') {
            //agent { label 'built-in' }
            steps {
                // Si ce test échoue (ex: statut KO), Jenkins s'arrête ici
                sh 'mvn clean test -P precheck'
            }
        }
        stage('Main Selenium Tests') {
            //agent { label 'built-in' }
            steps {
                sh 'mvn test -P maintest'
            }
        }
        stage('Post-Check Tests') {
            //agent { label 'built-in' }
            steps {
                sh 'mvn test -P postcheck'
            }
        }
    }

    post {
        always {
            // On cible le dossier junitreports qui contient les fichiers au format standard
            junit testResults: '**/target/surefire-reports/junitreports/*.xml', allowEmptyResults: true
        }
    }
}
