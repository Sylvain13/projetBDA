import java.util.HashMap;

/**
 * Created by o15007109 on 31/03/17.
 */
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;
import java.util.Map;

public class DictionnaireMotif {
    private HashMap<Integer,String> dico = new HashMap<Integer,String>();
    private static int intDico =0;
    private static DictionnaireMotif instance = new DictionnaireMotif();

    private DictionnaireMotif(){}

    public static DictionnaireMotif getInstance(){
        return instance;
    }

    public HashMap<Integer,String> getMap() {
        return dico;
    }

    public void updateDico(String value){
        if (!dico.containsValue(value)) {
            dico.put(intDico++, value);
        }
    }

    public Integer returnValue(String word){
        for(Map.Entry<Integer, String> entry : dico.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (value.equals(word)) {
                return key;
            }
        }
       return null;
    }

    public void chargeFic()throws IOException{
        FileWriter fos = new FileWriter(new File("dico.txt"), true);
        for(Map.Entry<Integer, String> entry : dico.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            fos.write("key : "+ key + "; value : " + value + "\n");
        }
    }

//    public void chargerClass()throws IOException{
//        String line = null;
//        FileReader fileReader = new FileReader("data.csv");
//
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        while((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        bufferedReader.close();
//    }
}


//
//    static int intDico = 0;
//
//    public static void main(String[] args) {
//        //csvToTrans("test.csv", "test.trans");
//        //transToCsv("test.trans", "testRetourTrans.csv");
//        //outToCsv("test.out", "testRetourOut.csv");
//    }


