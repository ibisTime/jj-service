部署步骤：
1，eclipse导出war包

2. 本地war包上传至服务器
  scp -P 57652 xn-mall.war root@120.26.222.73:/home  
  
    scp -P 57652 xn-mall.war root@121.43.101.148:/home  
  

3. 备份原先配置(如果第一次部署，跳过此步骤)
  cd /home/wwwroot/tomcat_JY_mall/webapps
  cp ./xn-mall/WEB-INF/classes/application.properties .
  cp ./xn-mall/WEB-INF/classes/config.properties .
  rm -rf xn-mall.war
  rm -rf xn-mall
  mv /home/xn-mall.war .
  
4. 已备份配置文件放回原处
  mv -f application.properties ./xn-mall/WEB-INF/classes/
  mv -f config.properties ./xn-mall/WEB-INF/classes/
  
5. 启停tomcat 
  cd /home/wwwroot/tomcat_JY_mall/bin
  ../bin/shutdown.sh
  ../bin/startup.sh
  
6. 验证程序
  http://121.43.101.148:6202/xn-mall/api

