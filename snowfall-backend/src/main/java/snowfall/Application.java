package snowfall;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import snowfall.gui.MainView;

@EntityScan
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
@Configuration
@SpringBootApplication
public class Application  extends AbstractJavaFxApplicationSupport {

    private String windowTitle;

    @Autowired
    private MainView view;


    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(windowTitle);
        primaryStage.setScene(new Scene(view.getView()));
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
