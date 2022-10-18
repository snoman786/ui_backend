FROM mysql:5.7.25

ENV MYSQL_ROOT_PASSWORD="admin"
ENV MYSQL_DATABASE="nomandb"

ADD db-setup.sql docker-entrypoint-initdb.d/db-setup.sql