# Git & GitHub Command Cheat Sheet

Below are the Git commands used in this session, with brief descriptions for each:

---

| Command                                   | Description                                                                              |
|--------------------------------------------|------------------------------------------------------------------------------------------|
| `git status`                              | Shows the current state of your working directory and staging area.                      |
| `git add <filename>`                      | Stages a specific file for commit.                                                       |
| `git add .`                               | Stages all changed files in the current directory and subdirectories.                    |
| `git commit -m "your message"`            | Commits the staged changes with a message.                                               |
| `git pull origin main`                    | Fetches and merges changes from the remote `main` branch to your local branch.           |
| `git push origin main`                    | Pushes your local commits to the remote `main` branch on GitHub.                         |
| `git rm -r <foldername>`                  | Removes a folder and its contents from your working directory and stages the removal.    |
| `rmdir /S /Q <foldername>`                | (Windows) Removes a folder and its contents from your file system (not a Git command).   |
| `move <source>\* .`                       | (Windows) Moves all files from a folder to the current directory.                        |
| `git log origin/main..HEAD`               | Shows commits that are in your local branch but not in the remote `main` branch.         |
| `git config --global core.autocrlf true`  | Configures Git to handle line endings automatically (recommended for Windows users).      |
| `git commit`                              | Starts a commit in your default editor (e.g., vim/vi) if you didn't use -m.              |
| `:wq` (in vi/vim)                         | Writes (saves) changes and quits the vi/vim editor.                                      |
| `:q!` (in vi/vim)                         | Quits the vi/vim editor without saving changes.                                          |
| `git remote add upstream <url>`           | Adds a new remote repository (commonly used to sync with an upstream repo).              |
| `git fetch upstream`                      | Downloads branches and their commits from the upstream repository.                       |
| `git merge upstream/main`                 | Merges changes from the upstream `main` branch into your current branch.                 |
| `git rebase upstream/main`                | Re-applies your changes on top of the upstream `main` branch.                            |

---

**Tips:**
- Replace `<filename>`, `<foldername>`, `<source>`, and `<url>` with your actual file, folder, or URL.
- For Mac/Linux, use `mv` instead of `move`, and `rm -rf` instead of `rmdir`.

---