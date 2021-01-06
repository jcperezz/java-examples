# weblogic 11g quartz clustering example

## Install
1. Execute the `quartz-sql/tables_oracle.sql` on your oracle scheme 
1. Configure a oracle db datasource with `jdbc/quartz-ds` jndi for your oracle scheme
1. Run `mvn clean install` 
1. Deploy war on all server instances

## References
- http://www.quartz-scheduler.org/documentation/quartz-2.1.7/configuration/ConfigJobStoreTX.html
- https://github.com/quartz-scheduler/quartz/tree/master/quartz-core/src/main/resources/org/quartz/impl/jdbcjobstore
- http://www.quartz-scheduler.org/documentation/quartz-2.1.7/configuration/ConfigJDBCJobStoreClustering.html
- http://www.quartz-scheduler.org/documentation/2.3.1-SNAPSHOT/configuration.html#configuration-of-datasources-for-use-by-the-jdbc-jobstores
- https://stackoverflow.com/questions/7159080/how-to-interrupt-or-stop-currently-running-quartz-job