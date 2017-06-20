部署步骤：
A,环境准备/检验----略过
B,数据库升级/检验
    B1,结构
    B2,初始化数据
C，程序升级/检验

1，eclipse导出war包

2. 本地war包上传至服务器
  scp -P22 jj-service.war root@121.43.101.148:/home  
  T6dh%$%$ss1

3. 备份原先配置(如果第一次部署，跳过此步骤)
  ssh root@121.43.101.148
  T6dh%$%$ss1

  cd /home/wwwroot/jj-service/tomcat_jjservice_biz/webapps
  cp ./jj-service/WEB-INF/classes/application.properties .
  cp ./jj-service/WEB-INF/classes/config.properties .
  rm -rf jj-service.war
  rm -rf jj-service
  mv /home/jj-service.war .
  
4. 已备份配置文件放回原处,启停tomcat 
  mv -f application.properties ./jj-service/WEB-INF/classes/
  mv -f config.properties ./jj-service/WEB-INF/classes/
  ../bin/shutdown.sh
  ../bin/startup.sh
  
6. 验证程序
  http://118.178.124.16:5502/jj-service/api
  
D,运营测试
  D1索取运营测试权限
  D2运营测试
  D3权限归还