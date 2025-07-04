# Common PowerShell File Commands

This document lists frequently used PowerShell commands for managing files, along with examples.

---

## 1. Create a New File

```powershell
New-Item -Path C:\Temp\file.txt -ItemType File
```
Creates a new file at the specified path.

---

## 2. Copy a File

```powershell
Copy-Item -Path C:\Temp\file.txt -Destination D:\Backup\
```
Copies a file to the specified destination.

---

## 3. Move a File

```powershell
Move-Item -Path C:\Temp\file.txt -Destination D:\Archive\
```
Moves a file to the specified destination.

---

## 4. Remove (Delete) a File

```powershell
Remove-Item -Path C:\Temp\file.txt
```
Deletes the specified file.

---

## 5. Rename a File

```powershell
Rename-Item -Path C:\Temp\file.txt -NewName newfile.txt
```
Renames the specified file.

---

## 6. Read File Content

```powershell
Get-Content -Path C:\Temp\file.txt
```
Displays the contents of a file.

---

## 7. Overwrite File Content

```powershell
Set-Content -Path C:\Temp\file.txt -Value "Hello World"
```
Overwrites the file content with new text.

---

## 8. Append to File Content

```powershell
Add-Content -Path C:\Temp\file.txt -Value "More text"
```
Appends text to the end of a file.

---

## 9. List Files in a Directory

```powershell
Get-ChildItem -Path C:\Temp\
```
Lists files and directories in the specified path.

---

## 10. Check If a File Exists

```powershell
Test-Path -Path C:\Temp\file.txt
```
Returns `True` if the file exists, otherwise `False`.

---

> **Tip:** For more help about any command, use:
>
> ```powershell
> Get-Help <CommandName>
> ```
