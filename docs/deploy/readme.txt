部署步骤：
A,环境准备/检验----略过
B,数据库升级/检验
    B1,结构
    B2,初始化数据
C，程序升级/检验

1，eclipse导出war包

2. 本地war包上传至服务器
  scp -P 57652 xn-mall.war root@121.43.101.148:/home  

3. 备份原先配置(如果第一次部署，跳过此步骤)
  ssh root@121.43.101.148 -p 57652

  cd /home/wwwroot/caigo/tomcat_jfmall_biz/webapps
  cp ./xn-mall/WEB-INF/classes/application.properties .
  rm -rf xn-mall.war
  rm -rf xn-mall
  mv /home/xn-mall.war .
  
4. 已备份配置文件放回原处,启停tomcat 
  mv -f application.properties ./xn-mall/WEB-INF/classes/
  ../bin/shutdown.sh
  ../bin/startup.sh
  
6. 验证程序
  http://121.43.101.148:5302/xn-mall/api
  
D,运营测试
  D1索取运营测试权限
  D2运营测试
  D3权限归还