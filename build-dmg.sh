#!/bin/bash
jpackage --input /Users/mbp/IdeaProjects/TicTacToe/out/artifacts/TicTacToe_jar/ \
         --name TicTacToe \
         --main-jar TicTacToe.jar \
         --main-class com.company.Main \
         --type dmg \
         --dest /Users/mbp/Desktop/ \
         --app-version 1.0