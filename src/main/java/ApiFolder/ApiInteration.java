package ApiFolder;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ApiInteration {


    public void getWatherWhiteInformation(String resposndeBody){

        var dtoCharacter = GetDtoList(resposndeBody);
        String birthDay =  "";

        for (int i = 0; i < dtoCharacter.size() ; i++) {
            birthDay = dtoCharacter.get(i).birthday;
        }

        System.out.println(birthDay); ;
    }

    public void getallcharactersinformation(String resposndeBody){

        var dtoCharacter = GetDtoList(resposndeBody);

        for (int i = 0; i < dtoCharacter.size() ; i++) {
            System.out.println("Character name: ".concat(dtoCharacter.get(i).name));
            System.out.println("Portrayed: ".concat(dtoCharacter.get(i).portrayed));
            System.out.println("_______________________________");

        }

    }
    public List<CharacterDto> GetDtoList(String resposndeBody){

        ObjectMapper objectMapper =  new ObjectMapper();

        try {
            return objectMapper.readValue(String.valueOf(resposndeBody), new TypeReference<List<CharacterDto>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
