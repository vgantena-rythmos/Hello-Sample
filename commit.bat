@echo off
echo type "commit" or "update"
cd "curl"

set GIT_PATH="C:\Program Files\Git\bin\git.exe"
set BRANCH = "origin"

set ACTION=commit
set /P ACTION=Action: %=%
if "%ACTION%"=="c" (
  %GIT_PATH% add -A
	%GIT_PATH% commit -am "Auto-committed on %date%"
	%GIT_PATH% pull %BRANCH%
	%GIT_PATH% push %BRANCH%
)
if "%ACTION%"=="u" (
	%GIT_PATH% pull %BRANCH%
)
if "%ACTION%"=="exit" exit /b
goto P