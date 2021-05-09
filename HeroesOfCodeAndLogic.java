package FinalExam;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> heroesMana = new TreeMap<>();
        Map<String,Integer> heroesHit = new TreeMap<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <number ; i++) {
            String input = scanner.nextLine();
            String []token = input.split("\\s+");
            String name = token[0];
            int points = Integer.parseInt(token[1]);
            int mana = Integer.parseInt(token[2]);
            heroesHit.put(name,points);
            heroesMana.put(name,mana);
            //a hero can have a maximum of 100 HP and 200 MP
        }
        String input = scanner.nextLine();
        while (!input.equals("End")){
                String []token = input.split(" - ");
                String command = token[0];
                String name = token[1];
                switch (command){
                    case "CastSpell":
                        int manaNeeded = Integer.parseInt(token[2]);
                        String spellName = token[3];
                        if(heroesMana.get(name)>=manaNeeded){
                            int newMana = heroesMana.get(name)-manaNeeded;
                            heroesMana.put(name,newMana);
                            System.out.printf("%s has successfully cast %s and now has %d MP!%n",name,spellName,newMana);
                        }else{
                            System.out.printf("%s does not have enough MP to cast %s!%n",name,spellName);
                        }
                        break;
                    case "TakeDamage":
                        int damage = Integer.parseInt(token[2]);
                        String attacker = token[3];
                        if(heroesHit.get(name)-damage>0){
                            int newPoints = heroesHit.get(name)-damage;
                            heroesHit.put(name,newPoints);
                            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",name,damage,attacker,newPoints);
                        }else {
                            System.out.printf("%s has been killed by %s!%n",name,attacker);
                            heroesHit.remove(name);
                            heroesMana.remove(name);
                        }

                        break;
                    case "Recharge":
                        int amount = Integer.parseInt(token[2]);
                        int newMana = heroesMana.get(name)+amount;
                        if(newMana>200){
                            newMana=200;
                            amount = newMana-heroesMana.get(name);
                        }
                        heroesMana.put(name,newMana);
                        System.out.printf("%s recharged for %d MP!%n",name,amount);
                        break;
                    case "Heal":
                        int amountHit = Integer.parseInt(token[2]);
                        int newPoints = heroesHit.get(name)+amountHit;
                        if(newPoints>100){
                            newPoints=100;
                            amountHit = newPoints-heroesHit.get(name);
                        }
                        heroesHit.put(name,newPoints);
                        System.out.printf("%s healed for %d HP!%n",name,amountHit);

                        break;
                }

            input=scanner.nextLine();
        }
        heroesHit.entrySet().stream()
                .sorted((f,s)->s.getValue().compareTo(f.getValue()))

                .forEach(e->{
            System.out.printf("%s %n  HP: %d %n  MP: %d%n",e.getKey(),e.getValue(),heroesMana.get(e.getKey()));
        });
    }
}
