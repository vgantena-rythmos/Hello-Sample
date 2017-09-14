#!/bin/sh
set GIT_PATH="C:\Program Files\Git\bin\git.exe"
set path=C:\Program Files\Git\bin
SET CurrentDir=%~dp0
git add .
git commit -am "made changes"
git push
echo Press Enter...
pause