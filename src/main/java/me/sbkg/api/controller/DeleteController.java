package me.sbkg.api.controller;

import org.springframework.web.bind.annotation.*;

/**
 * author : ms.Lee
 * date   : 2024-01-04
 */
@RestController
@RequestMapping (value = "/api/v1/delete-api")
public class DeleteController {

  // http://localhost:8080/api/v1/delete-api/{String 값}
  @DeleteMapping (value = "/{variable}")
  public String DeleteVariable(@PathVariable String variable) {

    return variable;
  }

  // http://localhost:8080/api/v1/delete-api/reqeust1?email=value
  @DeleteMapping (value = "/request")
  public String getReqeustParam(@RequestParam String email) {

    return "e-mail: " + email;
  }
}
