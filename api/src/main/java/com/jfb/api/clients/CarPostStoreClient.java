package com.jfb.api.clients;

import com.jfb.api.dto.CarPostDTO;
import com.jfb.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.jfb.api.utils.Constantes.POSTS_STORE_SERVICE_URI;
import static com.jfb.api.utils.Constantes.USER_STORE_SERVICE_URI;

@Component
public class CarPostStoreClient {

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDTO> carForSaleClient() {
        ResponseEntity<CarPostDTO[]> responseEntity =
                restTemplate.getForEntity(POSTS_STORE_SERVICE_URI + "/cars", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostsClient(OwnerPostDTO newuser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newuser, OwnerPostDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
        restTemplate.put(POSTS_STORE_SERVICE_URI + "/cars/" + id, carPostDTO, carPostDTO.getClass());
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(POSTS_STORE_SERVICE_URI + "/cars/" + id);
    }
}
