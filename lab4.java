import java.util.*;

public class lab4 {
    public static void main(String[] args) {
        Boolean flag = true;
        String elementsInString = "";
        Scanner console = new Scanner(System.in);
        while(flag){
            System.out.println("Введите элемент массива: ");
            String str = console.next();
            if(str.equals("quit")) {
                flag = false;
                break;
            }
            try {
                Float.parseFloat(str);
                elementsInString = (elementsInString == "") ? str : elementsInString + " " + str;
            } catch(NumberFormatException e) {}
            
        }
        console.close();
        if(elementsInString == "") {
            return;
        }
        String[] stringArray = elementsInString.split(" "); 
        float[] floatArray = new float[stringArray.length];
        int i = 0;
        for(String s : stringArray) {
            floatArray[i++] = Float.parseFloat(s);
        }
        System.out.println("Массив: " + Arrays.toString(floatArray));

        String newElementsInString = stringArray[0];
        for (i = 1; i < stringArray.length; i++) {
            float value = Float.parseFloat(stringArray[i]);
            float prevValue = (newElementsInString.lastIndexOf(" ") != -1) 
                ? Float.parseFloat(newElementsInString.substring(newElementsInString.lastIndexOf(" "),newElementsInString.length()))
                : Float.parseFloat(newElementsInString);
            
            if(prevValue < value) {
                newElementsInString = newElementsInString + " " + value;
            }
        }
        
        String[] newStringArray = newElementsInString.split(" ");
        float[] newFloatArray = new float[newStringArray.length];
        i = 0;
        for(String s : newStringArray) {
            newFloatArray[i++] = Float.parseFloat(s);
        }
        System.out.println("Новый Массив: " + Arrays.toString(newFloatArray));
    }
}
