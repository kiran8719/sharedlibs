def call(credId,tomcatIp,tomcatuser){
  sshagent(['credId']) {
    // some block
    sh"""
    scp -o StrictHostKeyChecking=no target/myweb*.war ${tomcatuser}@${tomcatIp}:/opt/tomcat8/webapps/myweb.war
    ssh ${tomcatuser}@${tomcatIp} /opt/tomcat8/bin/shutdown.sh
    ssh ${tomcatuser}@${tomcatIp} /opt/tomcat8/bin/startup.sh
}
