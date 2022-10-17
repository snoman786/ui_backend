FROM mysql:5.7.25

ENV MYSQL_ROOT_PASSWORD="root"
ENV MYSQL_DATABASE="admin"

ADD db-setup.sql docker-entrypoint-initdb.d/db-setup.sql