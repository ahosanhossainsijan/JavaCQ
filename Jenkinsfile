pipeline {
    agent any

    tools {
        maven 'maven'
        allure 'allure'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: 'java', results: [[path: 'allure-results']]
            }
        }
    }
}
