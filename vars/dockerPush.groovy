def call(String imageName, String taggedImage, String credsId) {
    echo "Pushing Docker image to registry..."
    withCredentials([usernamePassword(credentialsId: credsId, usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
        sh """
            echo "$DOCKERHUB_PASS" | docker login -u "$DOCKERHUB_USER" --password-stdin
            docker tag ${imageName} ${taggedImage}
            docker push ${taggedImage}
        """
    }
    echo "Docker image pushed successfully."
}
