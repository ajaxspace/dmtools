package com.github.istin.dmtools.job;


import com.github.istin.dmtools.documentation.DocumentationGenerator;
import com.github.istin.dmtools.estimations.JEstimator;

import java.util.Base64;

public class JobRunner {

    public static void main(String[] args) throws Exception {
        Job job = new Job(new String(decodeBase64(args[0])));
        if (job.getName().equalsIgnoreCase(JEstimator.NAME)) {
            JEstimator.runJob(job.getJEstimatorParams());
        } else if (job.getName().equalsIgnoreCase(DocumentationGenerator.NAME)) {
            DocumentationGenerator.runJob(job.getDocumentationGeneratorParams());
        }

    }

    public static String decodeBase64(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        // Convert the decoded bytes to a string
        return new java.lang.String(decodedBytes);
    }

    public static String encodeBase64(String input) {
        byte[] decodedBytes = Base64.getEncoder().encode(input.getBytes());
        // Convert the decoded bytes to a string
        return new String(decodedBytes);
    }
}
