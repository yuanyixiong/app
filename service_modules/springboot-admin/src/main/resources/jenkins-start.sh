#设置jenkins参数,构建完成后不杀shell启动的进程
BUILD_ID=dontKillMe

#初始化目录
service=/usr/local/src/app/service

service_name=springboot-admin
copy_jar=/usr/local/src/app/jenkins/springboot-admin-1.0-SNAPSHOT.jar
jar_name=springboot-admin-1.0-SNAPSHOT.jar

#杀死应用服务进程
ps -ef | grep $jar_name | grep -v grep | awk '{print $2}' | xargs kill -9
sleep 5s

#启动应用服务
mkdir -p $service/$service_name
rm -rf $service/$service_name/$service_name.*
java -jar -Xmx128m -Xms32m -Xmn32m -Xss16m $copy_jar --spring.profiles.active=test --server.port=9999 >> $service/$service_name/$service_name.log & echo $! > $service/$service_name/$service_name.pid
