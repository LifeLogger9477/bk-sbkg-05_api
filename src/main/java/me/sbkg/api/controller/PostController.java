package me.sbkg.api.controller;

import me.sbkg.api.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * author : ms.Lee
 * date   : 2024-01-04
 */
@RestController
@RequestMapping (value = "/api/v1/post-api")
public class PostController {

  // http://localhost:8080/api/v1/post-api/domain
  @RequestMapping (value = "/domain", method = RequestMethod.POST)
  public String postExample() {

    return "Hello Post API";
  }

  // http://localhost:8080/api/v1/post-api/member
  @PostMapping (value = "/member")
  public String postMember(@RequestBody Map<String, String> postData) {

    StringBuilder sb = new StringBuilder();

    postData.entrySet().forEach( map -> {
      sb.append( map.getKey() + " : " + map.getValue() + "\n" );
    } );

    return sb.toString();
  }

  // http://localhost:8080/api/v1/post-api/member2
  @PostMapping (value = "/member2")
  public String postMember(@RequestBody MemberDTO memberDTO) {

    return memberDTO.toString();
  }
}
