# grant 'executable' permission with > chmod +x push.sh
# run script with > ./push.sh "commit_msg"
git status
git add .
git commit -m "${1}"
git push