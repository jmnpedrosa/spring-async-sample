package pt.jmnpedrosa.samples.springboot.async.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pt.jmnpedrosa.samples.springboot.async.model.AsyncStatus;

@Service
public class AsyncService implements IAsyncService {

  private static final Logger LOG = LoggerFactory.getLogger(AsyncService.class);
  private static final int MAX_SECS = 20;

  private boolean running;
  private String message = "";
  private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd '@' HH:mm:ss");

  @Override
  @Async
  public void startAsyncProcess() {
    if (running) {
      LOG.warn("Process already running.");
      return;
    }
    LOG.info("Process started.");
    running = true;
    for (int i = 0; i < MAX_SECS; i++) {
      message = (i + 1) + "/" + MAX_SECS + " : " + sdf.format(new Date());
      LOG.debug(message);
      try {
        Thread.sleep(1000L);
      } catch (Exception e) {
        message = "Exception!";
        running = false;
      }
    }
    running = false;
    LOG.info("Process finished.");
  }

  @Override
  public AsyncStatus getProcessStatus() {
    return new AsyncStatus(running, message);
  }

}
