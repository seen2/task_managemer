package foo.bar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
  private static final Logger logger = LoggerFactory.getLogger(WelcomeMessage.class);

  public String getWelcomeMessage() {
    // Log with logger

    logger.info("Fetching welcome message");

    return "Hello Sintu";
  }
}
