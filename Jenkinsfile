pipeline {
    agent any

    parameters {
         string(name: 'BASE_BRANCH', defaultValue: 'develop', description: 'Main Branch')
         string(name: 'BRANCH_TO_TEST', defaultValue: 'develop', description: 'Local Branch')
         string(name: 'MANIFEST_BRANCH', defaultValue: 'develop', description: 'Local Branch')
    }

    stages{
        stage('Checkout the Code'){
            steps {
                sh 'rm -rf .* * || echo "Cleaned Workspace"'
                sh '~/bin/repo init -u ssh://git@github.kdc.capitalone.com/android5x/manifest -m android5x.xml -b ${MANIFEST_BRANCH}'
                sh '~/bin/repo sync'
                sh '~/bin/repo forall -c "git checkout ${BASE_BRANCH} || echo ${BASE_BRANCH} not found for ${REPO_PROJECT}"'
                sh '~/bin/repo forall -c "git checkout ${BRANCH_TO_TEST} || echo ${BRANCH_TO_TEST} not found for ${REPO_PROJECT}"'
            }
        }
        stage ('Clean the Repo'){
              sh 'cd mobilebanking'
              sh './gradlew clean'
              sh './gradlew assembleDeveloperDebug mobilebanking:assembleDeveloperDebugAndroidTest --stacktrace'
        }

    }
}
