#!/usr/bin/env groovy

def call(String path, String pattern, String token, String channel = '#jenkins') {
    channel = channel ?: '#jenkins'
    
    def imgFiles = new FileNameFinder().getFileNames(path, pattern)
    for (String file : imgFiles) {
        echo file
        sh "curl -F file=@$file -F channels=$channel -F token=$token https://slack.com/api/files.upload"
    }
}