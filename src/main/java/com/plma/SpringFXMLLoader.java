package com.plma;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;

@Component
public class SpringFXMLLoader {
    private final ApplicationContext applicationContext;

    public SpringFXMLLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T load(URL url) throws IOException {
        try (InputStream fxmlStream = url.openStream()) {
            FXMLLoader loader = new FXMLLoader(url);
            loader.setControllerFactory(applicationContext::getBean);
            return loader.load(fxmlStream);
        }
    }
}
