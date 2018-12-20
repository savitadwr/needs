#!/usr/bin/env bash
set -e

docker-compose --no-ansi up --build -d $*

MY_SQL_PORT=$(docker-compose port needs_db 3307 | awk -F : '{print $2}')
echo MySQL is ready on port ${MY_SQL_PORT}
