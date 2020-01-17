#设置jenkins参数,构建完成后不杀shell启动的进程
BUILD_ID=dontKillMe

#初始化目录
service=/usr/local/src/app/service
flume_root=/usr/local/src/app/apache-flume-1.6.0-bin

service_name=service-calculate
copy_jar=/usr/local/src/app/jenkins/com-app-service-module-calculate-1.0-SNAPSHOT.jar
jar_name=com-app-service-module-calculate-1.0-SNAPSHOT.jar

#杀死应用服务进程
ps -ef | grep $jar_name | grep -v grep | awk '{print $2}' | xargs kill -9
sleep 5s

#启动应用服务
mkdir -p $service/$service_name/flume
rm -rf $service/$service_name/$service_name.*
java -jar -Xmx512m -Xms128m -Xmn128m -Xss64m $copy_jar --spring.profiles.active=test --server.port=8210 >> $service/$service_name/$service_name.log & echo $! > $service/$service_name/$service_name.pid
