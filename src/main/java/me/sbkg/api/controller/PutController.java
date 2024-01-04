package me.sbkg.api.controller;

import me.sbkg.api.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author : ms.Lee
 * date   : 2024-01-04
 */
@RestController
@RequestMapping (value = "/api/v1/put-api")
public class PutController {

  // http://localhost:8080/api/v1/put-api/member
  @PutMapping (value = "/member")
  public String putMember(@RequestBody Map<String, String> putData) {

    StringBuilder sb = new StringBuilder();

    putData.entrySet().forEach( map -> {
      sb.append( map.getKey() + " : " + map.getValue() + "\n" );
    } );

    return sb.toString();
  }

  // http://localhost:8080/api/v1/put-api/member1
  @PutMapping (value = "/member1")
  public String putMemberDTO1(@RequestBody MemberDTO memberDTO) {

    return memberDTO.toString();
  }

  // http://localhost:8080/api/v1/put-api/member2
  @PutMapping (value = "/member2")
  public MemberDTO putMemberDTO2(@RequestBody MemberDTO memberDTO) {

    return memberDTO;
  }

  // http://localhost:8080/api/v1/put-api/member3
  @PutMapping (value = "/member3")
  public ResponseEntity<MemberDTO> putMembmerDTO3(
      @RequestBody MemberDTO memberDTO
  ) {

    return ResponseEntity
        .status( HttpStatus.ACCEPTED )
        .body( memberDTO );
  }
}
