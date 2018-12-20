#!/usr/bin/env bash
set -e

export COMPOSE_PROJECT_NAME="${BUILD_TAG:-}"

docker-compose --no-ansi down -t 0 --rmi local
