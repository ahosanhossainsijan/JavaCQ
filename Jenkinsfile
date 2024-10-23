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
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'allure-results']]
            }
        }
    }
}
