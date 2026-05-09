pipeline {
    //agent { label 'master' } // Utilise bien le label que tu as mis à l'agent
    agent any

    stages {
        stage('POC : Préparation Platform') {
            agent { label 'test-agent-ubound' }
            steps {
                echo "--- ÉTAPE 1 : Simulation Préparation ---"
                sh 'mkdir -p ./poc-test'
                sh 'date > ./poc-test/build_info.txt'
                dir('/home/jules/autres') {
                    sh 'date > autres_info.txt'
                    // Toutes les commandes ici seront dans /home/jules/autres
                }
                echo "Plateforme simulée avec succès."
            }
        }

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
            // On cible le dossier junitreports qui contient les fichiers au format standard
            junit testResults: '**/target/surefire-reports/junitreports/*.xml', allowEmptyResults: true
        }
    }
}
