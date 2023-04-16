def call (String repoUrl) {
  
  pipeline{
	agent any
		stages{
				stage ('1-clone'){
					steps{
						//checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'groupgit', url: 'https://github.com/AppGroup2/jenkinsproject2.git']])
						git branch: 'main',
							url: "${repoUrl}"
						}	
					}
				stage('2-Group Parallel job'){
					parallel{
						stage('Teeto-sub-job-1'){
							steps{
								sh 'lscpu'
								sh 'sudo systemctl status jenkins'
							}
						}
						stage('Chris'){
							steps{
								sh '/home/ubuntu/christianbashscript.sh'
							}
						}
						stage('Yomi'){
							steps{
							sh '/home/ubuntu/yomiscript.sh'
							}
						}
					}
				}
				stage('3-Group Parallel job'){
					parallel{
						stage('Aubin'){
							steps{
								sh 'ls'
							}
						}
						stage('Afeez'){
							steps{
								sh 'pwd'
							}
						}
					}
				}
				stage('4-Group Parallel job'){
					parallel{
						stage('Olu'){
							steps{
								sh 'lscpu'
							}
						}
						stage('Tunde'){
							steps{
								sh 'pwd'
							}
						}
						
					}
				}
	

			}	

	}
  
}
