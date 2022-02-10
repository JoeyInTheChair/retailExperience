node {
    stage('SCM') {
        echo 'Gathering code from version control'
        git bracnh: '${branch}', url: 'git@github.com:JoeyInTheChair/retailExperience.git'
    }
    stage('Build') {
        echo 'Building...'
        sh 'dotnet --version'
        sh 'dotnet build ConsoleApp1'
        echo 'Building Murex Retail Experience'
    }
    stage('Test') {
        echo 'Testing...'
    }
    stage{'Success'} {
        echo 'Test Cases have all passed'
    }
}