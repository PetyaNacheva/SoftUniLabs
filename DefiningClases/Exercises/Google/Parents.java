package Advanced.DefiningClasses.Exe.Google;

public class Parents {

        private String name;
        private String birthDate;

        public Parents(String name, String birthDate){
            this.name = name;
            this.birthDate = birthDate;
        }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            if(!getName().isEmpty()){
                sb.append(getName());
                sb.append(" ");
                sb.append(getBirthDate());
            }
        return sb.toString();
    }
}
