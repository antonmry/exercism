" see https://stackoverflow.com/questions/2229551/mixing-vertical-and-horizontal-splits-in-vim-from-command-line
" nvim -S ~/Downloads/s3.vim in the root folder of the exercise
botright edit src/lib.rs
botright split tests/*.rs
botright vsplit README.md
" Resize all windows so they share space equally
wincmd =
wincmd w
wincmd w
" Delete ignore in tests
g/ignore/d
wincmd w
"Reformat markdown
norm ggVGgqgg
