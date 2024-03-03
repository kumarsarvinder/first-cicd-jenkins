pipeline{
    agent any

    tools{
        maven "maven"
    }

    stages{

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/kumarsarvinder/first-cicd-jenkins.git']])
            }
        }

        stage("Build Process"){
            steps{
               bat 'mvn clean install'
            }
        }

        stage("Deploy to Container"){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9001/')], contextPath: 'jenkinsCiCd', war: '**/*.war'
            }
        }

    }

    post{
        always
        {
          emailext attachLog: true, body: '''
            <html>
            <body>
                <p>Github Code</p>
                <p>Build Status: ${BUILD_STATUS}</p>
                <p>Build Number: ${BUILD_NUMBER}</p>
                <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
            </body>
            </html>''', mimeType: 'text/html', replyTo: 'skumary200@gmail.com', subject: 'Jenkins Pipeline Status : ${BUILD_NUMBER}', to: 'skumary200@gmail.com'

        }
    }

}