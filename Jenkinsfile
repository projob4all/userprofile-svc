pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        
        stage('Build && Push Docker image') {
            steps {
                container('kaniko'){
                	script{
                		sh '/kaniko/executor \
                				--context=git://https://github.com/projob4all/userprofile-svc.git \
                				--destination=svelytskyy/job4all/userprofile-svc:1.0.0 \
                				--insecure \
                				--skip-tls-verify \
                				-v=debug'
                			
                	}
                }
            }
        }
        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
            }
        }
    }
}