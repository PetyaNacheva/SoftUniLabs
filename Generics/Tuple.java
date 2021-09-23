package Advanced.Generics.Tuple;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                String[] inputTokens = scanner.nextLine().split("[\\s]+");
                String firstElement = inputTokens[0];
                String secondElement = inputTokens[1];
                String secondValue = inputTokens[2];

                switch (i) {
                    case 0:
                        firstElement = inputTokens[0] + " " + inputTokens[1];
                        secondElement = inputTokens[2];
                        secondValue = inputTokens[3];
                        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(firstElement, secondElement, secondValue);
                        System.out.println(firstThreeuple.getKey() + " -> " + firstThreeuple.getValue() + " -> " + firstThreeuple
                                .getSecondValue());
                        break;
                    case 1:
                        int value = Integer.valueOf(secondElement);
                        boolean isDrunk = secondValue.equalsIgnoreCase("drunk");
                        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(firstElement, value, isDrunk);
                        System.out.println(secondThreeuple.getKey() + " -> " + secondThreeuple.getValue() + " -> " + secondThreeuple
                                .getSecondValue());
                        break;
                    case 2:
                        double balance = Double.valueOf(secondElement);
                        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(firstElement, balance, secondValue);
                        System.out.println(thirdThreeuple.getKey() + " -> " + thirdThreeuple.getValue() + " -> " + thirdThreeuple
                                .getSecondValue());
                        break;
                }
            }
        }
    }

    class Threeuple<K, V, V2> {

        private K key;

        private V value;

        private V2 secondValue;

        public Threeuple(K key, V value, V2 secondValue) {
            this.setKey(key);
            this.setValue(value);
            this.setSecondValue(secondValue);
        }

        public K getKey() {
            return key;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        protected void setValue(V value) {
            this.value = value;
        }

        public V2 getSecondValue() {
            return secondValue;
        }

        protected void setSecondValue(V2 secondValue) {
            this.secondValue = secondValue;
        }
    }
