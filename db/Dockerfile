FROM mysql:8.0.25

ENV MYSQL_ROOT_PASSWORD="admin"
ENV MYSQL_DATABASE="nomandb"

ADD db-setup.sql docker-entrypoint-initdb.d/db-setup.sql