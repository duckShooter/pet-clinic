# grant 'executable' permission with > chmod +x push.sh
# run script with > ./push.sh "commit_msg"
echo "#~>>>>>>>>>>>>>>> Checking Status <<<<<<<<<<<<<<<<<~#"
git status
echo "#~>>>>>>>>>>>>>>> Adding files <<<<<<<<<<<<<<<<<~#"
git add .
echo "#~>>>>>>>>>>>>>>> Committing <<<<<<<<<<<<<<<<<~#"
git commit -m "${1}"
echo "#~>>>>>>>>>>>>>>> Pushing <<<<<<<<<<<<<<<<<~#"
git push