package me.sbkg.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import me.sbkg.api.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * author : ms.Lee
 * date   : 2024-01-04
 */

@RestController
@RequestMapping (value = "/api/v1/get-api")
public class GetController {

  private final Logger logger = LoggerFactory.getLogger( GetController.class );

  // http://localhost:8080/api/v1/get-api/hello
  @RequestMapping (value = "/hello", method = RequestMethod.GET)
  public String getHello() {

    logger.info( "getHello 메소드가 호출되었습니다." );
    return "Hello World";
  }

  // http://localhost:8080/api/v1/get-api/name
  @GetMapping (value = "/name")
  public String getName() {

    logger.info( "getName 메소드가 호출되었습니다." );
    return "Flature";
  }

  // http://localhost:8080/api/v1/get-api/variable1/{String 값}
  @GetMapping (value = "/variable1/{variable}")
  public String getVariable1(@PathVariable String variable) {

    return variable;
  }

  // http://localhost:8080/api/v1/get-api/variable2/{String 값}
  @GetMapping (value = "/variable2/{variable}")
  public String getVariable2(@PathVariable ("variable") String var) {

    return var;
  }

  // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
  @Operation(
      summary = "GET 메소드 예제",
      description = "@RequestParam을 활용한 GET Method"
  )
  @GetMapping (value = "/request1")
  public String getRequestParam1(
      @Parameter(description = "이름", required = true) @RequestParam String name,
      @Parameter(description = "이메일", required = true) @RequestParam String email,
      @Parameter(description = "회사", required = true) @RequestParam String organization
  ) {

    return name + " " + email + " " + organization;
  }

  // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
  @GetMapping (value = "/request2")
  public String getRequestParam2(@RequestParam Map<String, String> param) {

    StringBuilder sb = new StringBuilder();

    param.entrySet().forEach( map -> {
      sb.append( map.getKey() + " : " + map.getValue() + "\n" );
    } );

    return sb.toString();
  }

  // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
  @GetMapping (value = "/request3")
  public String getRequestParam3(MemberDTO memberDTO) {

    return memberDTO.toString();
  }
}
