package com.service.info;

import org.springframework.web.bind.annotation.RestController;

@RestController("/counter")
public class InfoController {

  /**
   * The Customer service.
   */
  private final InfoService infoService;

  /**
   * Instantiates a new Customer controller.
   *
   * @param service the service
   */
  public InfoController(final InfoService service) {
    this.infoService = service;
  }

}
