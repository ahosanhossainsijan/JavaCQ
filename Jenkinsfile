pipeline {
    agent any

    tools {
        maven 'maven'
        allure 'allure'
    }

    stages {
        stage('Clean') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Compile') {
            steps {
                script {
                    sh 'mvn compile'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    sh 'mvn package'
                }
            }
        }

         stage('Generate Allure Report') {
              steps {
                 allure includeProperties: false, jdk: 'java', results: [[path: 'allure-results']]
              }
         }

    }
}