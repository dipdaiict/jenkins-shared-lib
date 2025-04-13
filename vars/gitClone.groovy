def call(String repoUrl, String branch = 'main') {
    echo "Cloning from ${repoUrl} (branch: ${branch})..."
    git url: repoUrl, branch: branch
}
