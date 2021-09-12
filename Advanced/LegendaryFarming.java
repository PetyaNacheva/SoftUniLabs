package Advanced.SetsAndMaps.Lab.Exercises.Last;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                TreeMap<String,Integer> junk = new TreeMap<>();
                HashMap<String, Integer> keyMaterials = new HashMap<>();
                keyMaterials.put("motes",0);
                keyMaterials.put("fragments",0);
                keyMaterials.put("shards",0);
                int [] collectedValues = new int[3];
                boolean itemObtained = false;
                while (!itemObtained){
                    String [] tokens =scanner.nextLine().split("\\s+");

                    for (int i = 0; i < tokens.length; i+=2) {
                        int quantity = Integer.parseInt(tokens[i]);
                        String material = tokens[i+1].toLowerCase();

                        if(keyMaterials.containsKey(material)){
                            int value = keyMaterials.get(material)+quantity;
                            keyMaterials.put(material, value);
                            switch (material){
                                case "motes": collectedValues[0]+=quantity;
                                    itemObtained = collectedValues[0]>=250;
                                    break;
                                case "fragments":collectedValues[1]+=quantity;
                                    itemObtained = collectedValues[1]>=250;
                                    break;
                                case "shards":collectedValues[2]+=quantity;
                                    itemObtained = collectedValues[2]>=250;
                                    break;
                            }
                            if(itemObtained){
                                break;
                            }
                        }else {
                            if(!junk.containsKey(material)){
                                junk.put(material,quantity);
                            }
                            else {
                                junk.put(material, junk.get(material)+quantity);
                            }
                        }
                    }
                }
                String itemName = "";
                if(collectedValues[0]>=250){
                    int value = keyMaterials.get("motes")-250;
                    keyMaterials.put("motes",value);
                    itemName = "Dragonwrath";
                }else if(collectedValues[1]>=250){
                    int value = keyMaterials.get("fragments")-250;
                    keyMaterials.put("fragments",value);
                    itemName = "Valanyr";
                }else {
                    int value = keyMaterials.get("shards")-250;
                    keyMaterials.put("shards",value);
                    itemName = "Shadowmourne";
                }
                System.out.println(itemName+" obtained!");
                keyMaterials.entrySet().stream().sorted((f,s)->{
                    int result = s.getValue().compareTo(f.getValue());
                    if(result==0){
                        result =f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(entry->{
                    System.out.println(entry.getKey()+": "+entry.getValue());
                });

                for (Map.Entry<String, Integer> entry : junk.entrySet()) {
                    System.out.println(entry.getKey()+": "+entry.getValue());
                }
            }
        }

