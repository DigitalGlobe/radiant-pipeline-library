#!/usr/bin/env groovy

def call(String path, String pattern, String channel = '#jenkins') {
    channel = channel ?: '#jenkins'

    def imgFiles = new FileNameFinder().getFileNames(path, pattern)
    for (String file : imgFiles) {
        echo file
    }
}