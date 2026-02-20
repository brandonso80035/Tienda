package com.techShop.tienda.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class StorageConfig {

    @Value("${firebase.json.file}")
    private String firebaseJsonFile;

    @Bean
    public Storage storage() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(firebaseJsonFile);

        GoogleCredentials credentials =
                GoogleCredentials.fromStream(serviceAccount);

        return StorageOptions.newBuilder()
                .setCredentials(credentials)
                .build()
                .getService();
    }
}