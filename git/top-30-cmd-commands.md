# Top 30 Windows CMD Commands (with Common Switches)

A handy reference for the most commonly used Windows Command Prompt commands, including useful switch options.

---

## 1. cd [path]
Change directory.

---

## 2. dir [options] [path]
List directory contents.  
`/w` Wide list &nbsp;&nbsp; `/p` Pause per page &nbsp;&nbsp; `/s` Include subdirectories

---

## 3. copy [source] [dest] [options]
Copy files.  
`/y` Suppress overwrite prompt &nbsp;&nbsp; `/v` Verify copy

---

## 4. move [source] [dest]
Move files.  
`/y` Suppress overwrite prompt

---

## 5. del [options] [files]
Delete files.  
`/q` Quiet mode &nbsp;&nbsp; `/f` Force delete &nbsp;&nbsp; `/s` Delete from subdirs

---

## 6. mkdir [dir]
Make new directory.  
`/p` Create parent dirs if needed

---

## 7. rmdir [dir] [options]
Remove directory.  
`/s` Remove all contents &nbsp;&nbsp; `/q` Quiet mode

---

## 8. cls
Clear screen.

---

## 9. echo [on|off|message]
Display messages or control command echoing.

---

## 10. pause
Pause for keypress.

---

## 11. exit
Exit CMD or batch file.

---

## 12. ren [old] [new]
Rename files.

---

## 13. type [file]
Show file contents.

---

## 14. attrib [options] [file]
Change file attributes.  
`+r/-r` Read-only &nbsp;&nbsp; `+h/-h` Hidden &nbsp;&nbsp; `+a/-a` Archive &nbsp;&nbsp; `+s/-s` System

---

## 15. help [command]
Show command help.

---

## 16. chkdsk [drive:] [options]
Check disk for errors.  
`/f` Fix errors &nbsp;&nbsp; `/r` Locate bad sectors

---

## 17. format [drive:] [options]
Format disk.  
`/fs:ntfs` or `/fs:fat32` Set file system &nbsp;&nbsp; `/q` Quick format

---

## 18. tasklist [options]
List running processes.  
`/v` Verbose &nbsp;&nbsp; `/fi` Filter &nbsp;&nbsp; `/m` Modules

---

## 19. taskkill [options]
Kill process.  
`/pid` [id] &nbsp;&nbsp; `/im` [name] &nbsp;&nbsp; `/f` Force

---

## 20. shutdown [options]
Shutdown or restart system.  
`/s` Shutdown &nbsp;&nbsp; `/r` Restart &nbsp;&nbsp; `/t` [sec] Delay

---

## 21. ping [host] [options]
Test network.  
`/n` [count] &nbsp;&nbsp; `/t` Continuous &nbsp;&nbsp; `/l` [size]

---

## 22. ipconfig [options]
Show network info.  
`/all` Detailed &nbsp;&nbsp; `/release` &nbsp;&nbsp; `/renew`

---

## 23. netstat [options]
Network statistics.  
`-a` All connections &nbsp;&nbsp; `-n` Numeric &nbsp;&nbsp; `-o` Show PID

---

## 24. find [string] [file]
Search for text in file.  
`/c` Count matches &nbsp;&nbsp; `/i` Ignore case

---

## 25. findstr [options] [pattern] [file]
Search for strings in files.  
`/s` Subdirs &nbsp;&nbsp; `/i` Ignore case &nbsp;&nbsp; `/c:"str"` Exact match

---

## 26. fc [file1] [file2] [options]
Compare files.  
`/l` ASCII &nbsp;&nbsp; `/b` Binary &nbsp;&nbsp; `/c` Case-insensitive

---

## 27. sfc [options]
System File Checker.  
`/scannow` Scan and fix system files

---

## 28. xcopy [src] [dest] [options]
Copy files & directories.  
`/s` Subdirs &nbsp;&nbsp; `/e` Empty dirs &nbsp;&nbsp; `/h` Hidden &nbsp;&nbsp; `/y` Suppress prompt

---

## 29. robocopy [src] [dest] [options]
Robust copy of files & directories.  
`/e` Subdirs &nbsp;&nbsp; `/mir` Mirror &nbsp;&nbsp; `/mov` Move &nbsp;&nbsp; `/purge` Delete dest. files not in src.

---

## 30. set [var=[value]]
Set environment variables.

---

**Tip:**  
For more details and all options, run `command /?` in the CMD prompt.