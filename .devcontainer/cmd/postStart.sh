#!/usr/bin/env bash

# This script is executed after the container is started.

# create the .env file if it does not exist
if [[ ! -f .env ]]; then
  echo "Creating .env file from .env.example"
  cp .env.example .env
fi


# Ensure the .gradle directory exists and has the correct permissions
if [[ ! -d /home/vscode/.gradle ]]; then
  echo "Creating .gradle directory"
  sudo mkdir -p /home/vscode/.gradle
fi
sudo chown $USER:$USER /home/vscode/.gradle

# install dependencies
gradle clean --refresh-dependencies