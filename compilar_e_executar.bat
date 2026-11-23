@echo off
chcp 65001 > nul
echo ========================================================
echo   Compilando e Executando - Trabalho Pratico 5 (LP2)
echo ========================================================

set "SRC_DIR=%~dp0src"
set "BIN_DIR=%~dp0build\classes"

if not exist "%BIN_DIR%" mkdir "%BIN_DIR%"

echo Compilando fontes Java...
javac -encoding UTF-8 -d "%BIN_DIR%" "%SRC_DIR%\trabalhopratico5\PainelContador.java" "%SRC_DIR%\trabalhopratico5\JFramePrincipal.java"

if %ERRORLEVEL% NEQ 0 (
    echo [ERRO] Falha na compilacao!
    pause
    exit /b %ERRORLEVEL%
)

echo [SUCESSO] Compilacao concluida com exito!
echo Iniciando aplicacao Swing...
start javaw -cp "%BIN_DIR%" trabalhopratico5.JFramePrincipal
exit /b 0
