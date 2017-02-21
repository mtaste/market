@echo off

F:
cd F:\code\appMarket\app\market\market-services-admin\mybatis_generator
java -jar mybatis-generator-core-1.3.1.jar -configfile generatorConfig-mysql.xml -overwrite

pause