package lab02;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class alice {
    static File inputFile;
    static File outputFile;
    static StringBuilder result=new StringBuilder();
    static String content;

    static String[] ans=new String[6];
    static int[] occur=new int[6];

    public static void main(String[] args) {
        inputFile=new File("src/lab02/alice.txt");
        outputFile=new File("src/test.out");
        content=getContent();
        String regEx="[\\?/%$[0-9]#\\]\\[:(),-.;'\"_!]";
        content=content.replaceAll(regEx," ");
        String[] temp=content.split(" ");

        Map<String, Integer> map=new HashMap<>();
        int maxm=0;
        Integer count;
        for(int i=0; i<temp.length; i++){
            if(temp[i]=="") continue;
            temp[i]=temp[i].toLowerCase();
            if ((count = map.get(temp[i])) == null) {
                map.put(temp[i], 1);
            } else {
                map.put(temp[i], 1 + count);
                if(count>maxm) maxm=count;
            }
        }

        for(Map.Entry<String,Integer> entry: map.entrySet())
        {
            add(entry.getKey(),entry.getValue());
//            System.out.println("Key="+entry.getKey()+"  Value="+entry.getValue());
        }
        for(int i=1; i<=5; i++)
        {
            System.out.println(ans[i]+"  "+occur[i]);
        }
    }
    public static void add(String key,int value)
    {
        for(int i=1; i<=5; i++)
        {
            if(value>occur[i])
            {
                for(int j=5; j>i; j--)
                {
                    ans[j]=ans[j-1];
                    occur[j]=occur[j-1];
                }
                ans[i]=key;
                occur[i]=value;
                return;
            }
        }
    }
    public static String getContent(){
        StringBuilder ret=new StringBuilder();
        try(Scanner reader = new Scanner(inputFile))
        {
            while(reader.hasNextLine())
            {
                String line=reader.nextLine();
                ret.append(line);
                ret.append(" ");
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return ret.toString();
    }

    public static void outResult()
    {
        if(!outputFile.exists())
        {
            try{
                outputFile.createNewFile();
            }
            catch(IOException e1)
            {
                e1.printStackTrace();
            }
        }
        try(Writer writer=new FileWriter(outputFile))
        {
            writer.write(result.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}