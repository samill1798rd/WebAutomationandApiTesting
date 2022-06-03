package ApiFolder;

import ApiBase.ApiBase;

public class ApiInteration extends ApiBase {


    public String getWatherWhiteInformation(){

        String birthDay =  "";
        var dtoCharacter = GetDtoList(RequestApi(""));

        for (int i = 0; i < dtoCharacter.size() ; i++) {
            System.out.println(dtoCharacter.get(i).birthday);
            birthDay = dtoCharacter.get(i).birthday;
        }

        return birthDay;
    }

    public void getallcharactersinformation(){

        var dtoCharacter = GetDtoList(RequestApi("RequestAll"));

        for (int i = 0; i < dtoCharacter.size() ; i++) {
            System.out.println("Character name: ".concat(dtoCharacter.get(i).name));
            System.out.println("Portrayed: ".concat(dtoCharacter.get(i).portrayed));
            System.out.println("_______________________________");

        }

    }

}
