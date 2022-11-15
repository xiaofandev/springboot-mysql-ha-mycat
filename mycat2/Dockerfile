FROM xiaofandev/jdk:1.8

# 安装相关工具
RUN yum update -y && yum install -y wget unzip

# 切换工作目录
WORKDIR /usr/local

# 安装mycat
# 1.下载安装包
RUN wget http://dl.mycat.org.cn/2.0/install-template/mycat2-install-template-1.21.zip
# 2.下载 Mycat 2 所需依赖 jar
RUN wget http://dl.mycat.org.cn/2.0/1.21-release/mycat2-1.21-release-jar-with-dependencies.jar
RUN unzip mycat2-install-template-1.21.zip
RUN cp mycat2-1.21-release-jar-with-dependencies.jar  mycat/lib/
# 3.授予 bin 目录下所有命令可执行权限
RUN chmod +x mycat/bin/*

# 配置部署一主多从
# 1.拷贝配置文件
COPY conf /usr/local/mycat/conf

# 暴露端口
EXPOSE 8066

CMD ["/usr/local/mycat/bin/mycat", "console"]
