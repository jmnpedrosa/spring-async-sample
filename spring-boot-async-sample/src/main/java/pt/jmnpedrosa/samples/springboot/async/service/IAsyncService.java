package pt.jmnpedrosa.samples.springboot.async.service;

import pt.jmnpedrosa.samples.springboot.async.model.AsyncStatus;

public interface IAsyncService {

  void startAsyncProcess();

  AsyncStatus getProcessStatus();

}
