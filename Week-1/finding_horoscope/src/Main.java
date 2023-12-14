import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int month, day;
        boolean isError = false;
        String horscp;

        Scanner input = new Scanner(System.in);

        System.out.print("In which month were you born?");
        month = input.nextInt();

        System.out.print("In which day were you born?");
        day = input.nextInt();

        if (month >= 1 && month <= 12) {
            if (month == 1) {
                if (day <= 31 && day >= 1) {
                    if (day < 21) {
                        horscp = "Capricorn";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Aquarius";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                } else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }
            } else if (month == 2) {
                if (day <= 29 && day >= 1) {
                    if (day <= 19) {
                        horscp = "Aquarius";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Pisces";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 3) {
                if (day <= 31 && day >= 1) {
                    if (day <= 20) {
                        horscp = "Pisces";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Aries";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 4) {
                if (day <= 30 && day >= 1) {
                    if (day <= 20) {
                        horscp = "Aries";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Taurus";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 5) {
                if (day <= 31 && day >= 1) {
                    if (day <= 21) {
                        horscp = "Taurus";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Gemini";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 6) {
                if (day <= 30 && day >= 1) {
                    if (day <= 21) {
                        horscp = "Gemini";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Cancer";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 7) {
                if (day <= 31 && day >= 1) {
                    if (day <= 22) {
                        horscp = "Cancer";
                        System.out.print("Your zodiac sign isunuz: " + horscp);
                    } else {
                        horscp = "Leo";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 8) {
                if (day <= 31 && day >= 1) {
                    if (day <= 22) {
                        horscp = "Leo";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Virgo";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 9) {
                if (day <= 30 && day >= 1) {
                    if (day <= 22) {
                        horscp = "Virgo";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Libra";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 10) {
                if (day <= 31 && day >= 1) {
                    if (day <= 22) {
                        horscp = "Libra";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Scorpio";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 11) {
                if (day <= 30 && day >= 1) {
                    if (day <= 21) {
                        horscp = "Scorpio";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Sagittarius";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                }else {
                    isError = true;
                    System.out.print("You logged in incorrectly. Try again.");
                }

            } else if (month == 12) {
                if (day <= 31 && day >= 1) {
                    if (day <= 21) {
                        horscp = "Sagittarius";
                        System.out.print("Your zodiac sign is: " + horscp);
                    } else {
                        horscp = "Capricorn";
                        System.out.print("Your zodiac sign is: " + horscp);
                    }
                } else {
                    isError = true;
                    if (isError) {
                        System.out.print("You logged in incorrectly. Try again.");
                    }
                }


            }
        }
    }
}