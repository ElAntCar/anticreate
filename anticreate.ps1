# ============================================================
# AntiCreate - funciones básicas de PowerShell
# Path del proyecto: E:\Downloads\brassrocket
# Mini-Proyecto para hacerme la vida más facil
# ============================================================
# Uso: dot-source este archivo al abrir PowerShell para tener
# las funciones disponibles en la sesión
# ============================================================

$ModPath = "E:\Downloads\brassrocket"

function Build-Mod {
    <# Compila el mod (build normal, usa caché) #>
    Push-Location $ModPath
    .\gradlew.bat build
    Pop-Location
}

function Clean-Build-Mod {
    <# Borra todo lo compilado antes y recompila desde cero.
       Usar cuando algo no se actualiza como debería
       (cambios de modid, mods.toml viejo cacheado, etc). #>
    Push-Location $ModPath
    .\gradlew.bat clean build
    Pop-Location
}

function Open-JarFolder {
    <# Abre la carpeta donde queda el jar compilado #>
    Invoke-Item "$ModPath\build\libs"
}

function Push-ModChanges {
    <# Add + commit + push en un solo paso.
       Uso: Push-ModChanges "mensaje del commit" #>
    param(
        [Parameter(Mandatory = $true)]
        [string]$Message
    )
    Push-Location $ModPath
    git add .
    git commit -m $Message
    git push
    Pop-Location
}

function New-ModBranch {
    <# Crea y cambia a una rama nueva para trabajar antes de un PR.
       Uso: New-ModBranch "nombre-de-la-rama" #>
    param(
        [Parameter(Mandatory = $true)]
        [string]$BranchName
    )
    Push-Location $ModPath
    git checkout -b $BranchName
    Pop-Location
}

function Status-Mod {
    <# Quick-Check sin commit #>
    Push-Location $ModPath
    git status
    Pop-Location
}

function Diff-Mod {
    <# Ver los cambios línea por línea (unstaged) #>
    Push-Location $ModPath
    git diff
    Pop-Location
}

Write-Host "Funciones cargadas: Build-Mod, Clean-Build-Mod, Open-JarFolder, Push-ModChanges, New-ModBranch, Status-Mod, Diff-Mod" -ForegroundColor Green
