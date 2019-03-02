package com.cloud.servicethree.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class DemoService implements IDemoService {

    public String getInfo(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        String privateInsuranceAPIUri = "http://172.20.10.3:10001/getInfo/show";
        try {
            ResponseEntity<String> responseEntity =
                    restTemplate.exchange(privateInsuranceAPIUri ,
                            HttpMethod.GET, entity, new ParameterizedTypeReference<String>() {
                            });
            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
            return null;
//            logger.error("调用查询保单接口失败，未连接到太平洋保险保单查询服务。transactionUUID为[" + transactionUUID + "}");
//            CpicFreightOverseaPolicyResponse cpicFreightOverseaPolicyResponse = new CpicFreightOverseaPolicyResponse();
//            cpicFreightOverseaPolicyResponse.setError("查询保单失败，请稍后再试");
//            return cpicFreightOverseaPolicyResponse;
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return null;
//            ObjectMapper objectMapper = new ObjectMapper();
//            CpicFreightOverseaPolicyResponse response = objectMapper.readValue(e.getResponseBodyAsString(), CpicFreightOverseaPolicyResponse.class);
//            throw new IOException(response.getError());
        }
    }

    public String getdata(){
        RestTemplate restTemplate = new RestTemplate();
        String infos = restTemplate.getForObject("http://localhost:10000/getInfo/port", String.class);
        System.out.println(infos);
        return infos;
    }

    public String getdatas(){
        RestTemplate restTemplate = new RestTemplate();
        String infos = restTemplate.getForObject("http://localhost:12000/show", String.class);
        return infos;
    }
}
