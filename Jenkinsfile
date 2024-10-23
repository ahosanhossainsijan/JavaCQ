pipeline {
    agent any

    tools {
        maven 'MavenLocal'
        allure 'ALLURE_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                 checkout scm
            }
        }

        stage('Build') {
            steps {
                    bat 'mvn clean install'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                    bat 'mvn test'
                }            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            publishHTML(target: [allowMissing: true,
                reportName: 'Test Results',
                reportDir: 'target/test-results',
                reportTitles: 'My Reports',
                reportFiles: 'index.html',
                keepAll: true,
                alwaysLinkToLastBuild: true
            ])
        }
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
