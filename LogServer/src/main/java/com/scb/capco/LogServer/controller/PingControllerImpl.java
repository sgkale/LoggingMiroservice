
package com.scb.capco.LogServer.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
public class PingControllerImpl {

  private static final Logger logger = Logger.getLogger(PingControllerImpl.class);

  /**
   * Test service providing an indication that the service is available.
   * 
   * @throws ServcieException (HTTP 503) for unknown or unanticipated issues
   * @return - pong as a string
 * @throws Exception 
   */
  @RequestMapping(method = RequestMethod.GET)
  public String ping() throws Exception {
    try {
      return "pong";
    } catch (Exception e) {
      logger.error("Error on ping:  " + e.getMessage());
      throw new Exception(e);
    }
  }
}
