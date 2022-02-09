pipeline {

    agent any
    stages {

        stage('Checkout Codebase') {
            steps{
                cleanWs()
                checkout([
                        $class: 'GitSCM',
                        branches: [[ name: 'feature/add-logger' ]],
                        userRemoteConfigs:
                            [[ credentialsId: 'github-ssh-key', url: 'git@github.com:JoeyInTheChair/retail.git' ]]
                        ])
            }
        }

        stage('Build') {
            steps{
                sh 'mkdir lib'
                sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/murex-retail-experience.jar'
                sh 'cd src ; javac -cp "../lib/murex-retail-experience.jar" Main.java MainTest.java'
            }
        }

        stage('Test') {
            steps{
                sh 'cd src/ ; java -jar../lib/murex-retail-experience.jar -cp "." --select-class MainTest --reports-dir="reports"'
            }
        }

        stage('Success') {
            steps{
                echo 'Test Successful'
            }
        }
    }
}
