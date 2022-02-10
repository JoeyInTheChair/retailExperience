pipeline {

    agent any
    stages {
        stage('Build') {
            steps{
                git 'https://github.com/JoeyInTheChair/retailExperience.git'
                //sh './mvnw clean compile'
                bat '.\\mvnw clean compile'
            }
        }

        stage('Test') {
            steps{
                //sh './mvnw test'
                bat '.\\mvnw test'
            }
        }

        stage('Success') {
            steps{
                echo 'Test Successful'
            }
        }
    }
}
