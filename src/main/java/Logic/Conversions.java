package Logic;

public class Conversions {
    public String decToQuat(int dec){
        StringBuilder converted = new StringBuilder();
        while(dec > 0){
            int remainder = dec % 4;
            dec = (dec - remainder)/4;
            converted.append(remainder);
        }
        converted.reverse();
        return converted.toString();
    }

    public int quatToDec(String quat){
        String[] quatArray = quat.split("");
        int converted = 0;
        for(int i = 0; i <= quatArray.length-1; i++){
            converted += Integer.parseInt(quatArray[quatArray.length-1 - i]) * (int)Math.pow(4,i);
        }
        return converted;
    }

}
