@echo off
E:
cd E:\c2t\svn\0.Resource\trunk\c2t\c2t-service-api\mybatis_generator
java -jar mybatis-generator-core-1.3.1.jar -configfile generatorConfig-oracle.xml -overwrite

pause