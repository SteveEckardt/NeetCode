# VI (Vim) Common Commands

## Modes
- `i` — Insert mode (before cursor)
- `I` — Insert at the beginning of the line
- `a` — Append after cursor
- `A` — Append at the end of the line
- `Esc` — Return to Normal mode

## Moving the Cursor
- `h` — Move left
- `j` — Move down
- `k` — Move up
- `l` — Move right
- `w` — Move to next word
- `b` — Move to previous word
- `0` — Start of line
- `$` — End of line
- `gg` — First line
- `G` — Last line

## Editing
- `x` — Delete character under cursor
- `dd` — Delete current line
- `yy` — Yank (copy) current line
- `p` — Paste after cursor
- `P` — Paste before cursor
- `u` — Undo
- `Ctrl+r` — Redo

## Searching
- `/pattern` — Search forward for 'pattern'
- `?pattern` — Search backward for 'pattern'
- `n` — Repeat last search
- `N` — Repeat last search in opposite direction

## Saving and Exiting
- `:w` — Write (save) file
- `:wq` or `:x` — Write and quit
- `:q` — Quit (fails if changes)
- `:q!` — Quit without saving
- `:e!` — Reload file, discard changes

## Visual Mode
- `v` — Start visual mode (characterwise)
- `V` — Visual line mode
- `Ctrl+v` — Visual block mode

## Miscellaneous
- `:help` — Open help
- `:set nu` — Show line numbers
- `:set nonu` — Hide line numbers
- `:r filename` — Read in a file
- `:!command` — Run shell command

## Buffers and Windows
- `:ls` — List open buffers
- `:bn` — Next buffer
- `:bp` — Previous buffer
- `:bd` — Delete buffer
- `:split` — Split window horizontally
- `:vsplit` — Split window vertically
- `:tabnew` — Open new tab

## Registers
- `"ayy` — Yank line into register a
- `"ap` — Paste from register a