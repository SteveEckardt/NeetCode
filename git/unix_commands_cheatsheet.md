
# 🐧 Common Unix Commands Cheat Sheet

## 📁 File and Directory Commands

### `ls` – List directory contents
- `ls -l` → long listing format  
- `ls -a` → include hidden files  
- `ls -lh` → long + human-readable sizes  
- `ls -lt` → sort by modification time

### `cd` – Change directory
- `cd ..` → go up one directory  
- `cd ~` → go to home directory

### `pwd` – Print working directory

### `mkdir` – Make directories
- `mkdir -p dir/subdir` → create parent dirs as needed

### `rm` – Remove files or directories
- `rm file.txt` → delete file  
- `rm -r folder/` → recursive delete  
- `rm -f file.txt` → force delete without prompt  
- `rm -rf folder/` → delete folder forcibly (⚠️ dangerous)

### `cp` – Copy files and directories
- `cp file1 file2` → copy file  
- `cp -r dir1 dir2` → recursive copy

### `mv` – Move or rename files
- `mv oldname newname`  
- `mv file /path/to/dir/`

### `touch` – Create an empty file or update timestamp

### `find` – Find files in a directory hierarchy
- `find . -name "*.txt"` → find all .txt files  
- `find /path -type f -size +10M` → files larger than 10MB

## 📄 Viewing and Editing Files

### `cat` – Concatenate and display file
- `cat file.txt`

### `less` – View file one page at a time
- `less filename` (use `q` to quit)

### `head` – View top lines of a file
- `head -n 20 file.txt`

### `tail` – View bottom lines
- `tail -n 20 file.txt`  
- `tail -f logfile.log` → follow live updates

### `nano`, `vim`, `vi` – Text editors
- `nano file.txt` → beginner-friendly  
- `vim file.txt` → powerful but advanced

## 🔍 Search and Filter

### `grep` – Search text using patterns
- `grep "word" file.txt`  
- `grep -i "word"` → case-insensitive  
- `grep -r "word" dir/` → recursive search

### `cut` – Remove sections from lines
- `cut -d":" -f1 /etc/passwd`  
- `cut -c1-5 file.txt` → first 5 characters

### `sort` – Sort lines of text
- `sort file.txt`  
- `sort -r` → reverse order  
- `sort -n` → numeric sort

### `uniq` – Filter out repeated lines
- `uniq file.txt`  
- `uniq -c` → prefix with count

## 📊 Permissions and Ownership

### `chmod` – Change permissions
- `chmod +x script.sh`  
- `chmod 755 file` → rwxr-xr-x

### `chown` – Change ownership
- `chown user file.txt`  
- `chown user:group file.txt`

## ⚙️ Process and System Monitoring

### `ps` – Show active processes
- `ps` → current shell  
- `ps aux` → all processes  
- `ps -ef` → full-format listing

### `top` – Real-time process viewer
- `top` (press `q` to quit)

### `kill` – Terminate processes
- `kill PID`  
- `kill -9 PID` → force kill

### `df` – Disk space usage
- `df -h` → human-readable

### `du` – File space usage
- `du -sh folder/` → summary of folder size

## 🌐 Networking

### `ping` – Test network connectivity
- `ping google.com`

### `curl` – Transfer data from URLs
- `curl https://example.com`

### `wget` – Download files
- `wget https://example.com/file.zip`

## 🧪 Miscellaneous

### `echo` – Print to screen
- `echo "Hello, world"`

### `date` – Show current date and time

### `whoami` – Show current user

### `man` – Manual for commands
- `man ls` → open manual for `ls`
