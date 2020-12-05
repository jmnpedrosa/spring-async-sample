package pt.jmnpedrosa.samples.springboot.async.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.jmnpedrosa.samples.springboot.async.model.AsyncStatus;
import pt.jmnpedrosa.samples.springboot.async.service.IAsyncService;

@RestController
@RequestMapping("/")
public class AsyncRestController {

  @Autowired
  private IAsyncService asyncService;

  @PostMapping("/start")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void start() {
    asyncService.startAsyncProcess();
  }

  @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public AsyncStatus getStatus() {
    return asyncService.getProcessStatus();
  }

}
