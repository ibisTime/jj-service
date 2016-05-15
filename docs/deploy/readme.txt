../bin/shutdown.sh
  ../bin/startup.sh制作钥匙：

在装有java环境里
1，切换到DatGen.java目录,比如E目录
2，E:\>javac -d ./ DatGen.java
3，E:\>java DatGen '{"ipList":["127.0.0.1"],"codeList":["706000","706001","706002","706003","706004"]}'

4，拷贝当前目录下的“config.dat”到项目“{项目路径}\src\main\resources”
5，验证：项目跑起来。在浏览器输入“http://IP:端口/项目名/api”，出现版本信息即成功。





部署步骤：
1，切换到本地tomcat部署包所在目录,例如
  cd /Users/myb858/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps

2，打包
  rm -rf moom.tar.gz
  tar zcvf moom.tar.gz xn-moom/
  scp -P57652 ./moom.tar.gz root@120.55.113.192:/home/
  scp -P56011 ./xn-moom.war root@115.28.58.167:/home/
  
  
  scp -P57652 ./xn-moom.war root@121.43.101.148:/mnt/wwwroot/
  
  scp -P57652 ./xn-moom.war root@120.26.222.73:/home
    
3，部署
  ssh root@120.55.113.192 -p 57652
  ssh root@121.43.101.148 -p 57652
  
  cd /home/tomcat_SYJ_moom/webapps
  cp -f ./xn-moom/WEB-INF/classes/application.properties .
  cp -f ./xn-moom/WEB-INF/classes/config.properties .

  rm -rf xn-moom.war
  rm -rf xn-moom/
  mv  /home/xn-moom.war .
  
4,起停tomcat_develop_pop
  mv -f application.properties ./xn-moom/WEB-INF/classes/
  mv -f config.properties ./xn-moom/WEB-INF/classes/
  ../bin/shutdown.sh
  ../bin/startup.sh

http://120.26.222.73:7202/xn-moom/api

http://121.43.101.148:7202/xn-moom/api





  


