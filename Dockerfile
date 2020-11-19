# Docker image for springboot application
# VERSION 0.0.1
# Author: bolingcavalry

### 基础镜像，使用alpine操作系统，openjkd使用8u201
FROM openjdk:8u201-jdk-alpine3.9

#作者
MAINTAINER JoyceZhu <Joyce.X.Zhu.-ND@disney.com>

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /docker/

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/joyce-r2dbc-mysql-1.0.jar joyce-r2dbc-mysql-1.0.jar

#启动容器时的进程
ENTRYPOINT ["java","-jar","/joyce-r2dbc-mysql-1.0.jar"]

#暴露8080端口
EXPOSE 18010