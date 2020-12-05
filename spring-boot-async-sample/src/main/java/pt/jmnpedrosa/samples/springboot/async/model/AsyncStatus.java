package pt.jmnpedrosa.samples.springboot.async.model;

public class AsyncStatus {

  private boolean running;
  private String message;

  public AsyncStatus(boolean running, String message) {
    this.running = running;
    this.message = message;
  }

  public boolean isRunning() {
    return running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "AsyncStatus{" +
        "running=" + running +
        ", message='" + message + '\'' +
        '}';
  }
}
