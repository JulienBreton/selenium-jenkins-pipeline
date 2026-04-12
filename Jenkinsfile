pipeline {
    agent any
    
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
        stage('Main-Test') {
            steps {
                // On lance les tests Selenium (souvent on ignore les erreurs ici pour passer au post-test)
                sh 'mvn test -DsuiteXmlFile=testng_main.xml -Dmaven.test.failure.ignore=true'
            }
        }
    }

    post {
        always {
            // C'est ici qu'on publie les rapports TestNG dans Jenkins
            recordTestResults '**/target/surefire-reports/testng-results.xml'
            archiveArtifacts artifacts: '**/target/surefire-reports/**', allowEmptyArchive: true
        }
    }
}