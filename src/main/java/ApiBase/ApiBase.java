package ApiBase;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;


public class ApiBase {

    public JsonNode RequestApi(String request){
        Unirest.setTimeouts(0, 0);

        try {
            if(request == "RequestAll"){
                return Unirest.get("https://www.breakingbadapi.com/api/characters").asJson().getBody();
            }
            else{
                return Unirest.get("https://www.breakingbadapi.com/api/characters?name=Walter+White").asJson().getBody();
            }

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CharacterDto> GetDtoList(JsonNode resposndeBody){

        ObjectMapper objectMapper =  new ObjectMapper();

        try {
           return objectMapper.readValue(String.valueOf(resposndeBody), new TypeReference<List<CharacterDto>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
