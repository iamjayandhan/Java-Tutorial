public class Strongpwd {

    public static void main(String args[]){
        System.out.println(minimumNumber(0, null));
    }

    public static int minimumNumber(int n, String password) {
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (numbers.indexOf(c) >= 0)
                hasDigit = true;
            else if (lower_case.indexOf(c) >= 0)
                hasLower = true;
            else if (upper_case.indexOf(c) >= 0)
                hasUpper = true;
            else if (special_characters.indexOf(c) >= 0)
                hasSpecial = true;
        }

        int missingTypes = 0;
        if (!hasDigit)
            missingTypes++;
        if (!hasLower)
            missingTypes++;
        if (!hasUpper)
            missingTypes++;
        if (!hasSpecial)
            missingTypes++;

        return Math.max(missingTypes, 6 - n);
    }
}
