package com.topica.vn.integration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;

@Component
public class Transformer {

    public String transform(String filePath) throws IOException {

        String content = new String(Files.readAllBytes(
                Paths.get(filePath)));

        String str = Normalizer.normalize(content, Normalizer.Form.NFKD);
        return str.replaceAll("\\p{M}", "").toUpperCase();

    }
}
