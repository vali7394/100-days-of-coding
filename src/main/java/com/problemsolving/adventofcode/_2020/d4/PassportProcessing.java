package com.problemsolving.adventofcode._2020.d4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//https://adventofcode.com/2020/day/4#part2
public class PassportProcessing {

    public static void main(String[] args) {
    /*   List<String> validPwdList = List.of(
               "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f",
               "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
               "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022",
               "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719",
               "eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
               "iyr:2019 hcl:#602927 eyr:1967 hgt:170cm ecl:grn pid:012533040 byr:1946",
               "hcl:dab227 iyr:2012 ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
               "hgt:59cm ecl:zzz eyr:2038 hcl:74454a iyr:2023 pid:3556412378 byr:2007"
       ); */
        List<String> validPwdList = getPassportDetails();
        System.out.println(validPassportCountPartII(validPwdList));
    }

    private static int validPassportCount(List<String> input){
        if(input==null || input.isEmpty()){
            return 0;
        }
        int validPwdCount = 0;
        Set<String> requiredFields = Set.of("byr","iyr","eyr","hgt","hcl","ecl","pid");
        Map<String,String> fields = new HashMap<>();
        for(String passport: input){
            String[] tokens = passport.split(" ");
            Set<String> availableFields = new HashSet<>();
            for(String token : tokens){
                String field = token.trim().split(":")[0];
                if(!"cid".equalsIgnoreCase(field)) {
                    availableFields.add(field);
                }
            }
            if(requiredFields.equals(availableFields)){
                validPwdCount++;
            }
        }
        return validPwdCount;
    }
    static Pattern yearValidation = Pattern.compile("[0-9]{4}");
    static Function<String,Boolean> byrValidator = (input)->{
        if(yearValidation.matcher(input).matches()){
            int year = Integer.parseInt(input);
            return 1920<=year && year<=2002;
        }
        return false;
    };
    static Function<String,Boolean> iyrValidator = (input)->{
        if(yearValidation.matcher(input).matches()){
            int year = Integer.parseInt(input);
            return 2010<=year && year<=2020;
        }
        return false;
    };
    static Function<String,Boolean> eyrValidator = (input)->{
        if(yearValidation.matcher(input).matches()){
            int year = Integer.parseInt(input);
            return 2020<=year && year<=2030;
        }
        return false;
    };
    static Function<String,Boolean> heightValidator = (input)->{
        if(input.length()!=5){
            return false;
        }
        int height = Integer.parseInt(input.substring(0,input.length()-2));
        if(input.contains("cm")){
            return height>=150 && height<=193;
        }else {
            return height>=59 && height<=76;
        }
    };
    static Function<String,Boolean> hairColorValidator = (input)-> Pattern.matches("#?[0-9a-f]{6}",input);
    static Function<String,Boolean> eclValidation = (input)-> Set.of("amb","blu", "brn", "gry", "grn" ,"hzl","oth").contains(input);
    static Function<String,Boolean> pidValidator = (input)->Pattern.matches("[0-9]{9}",input);
    private static Map<String,Function<String,Boolean>> validator = Map.of("byr",byrValidator,"iyr",iyrValidator,"eyr",eyrValidator
    ,"hgt",heightValidator,"hcl",hairColorValidator,"ecl",eclValidation,"pid",pidValidator);
    private static int validPassportCountPartII(List<String> input){
        Set<String> requiredFields = Set.of("byr","iyr","eyr","hgt","hcl","ecl","pid");
        Map<String,String> fields = new HashMap<>();
        int validCount = 0;
        for(String passport  : input){
            String[] tokens = passport.split(" ");
            for(String token : tokens){
                String[] fieldDetails = token.trim().split(":");
                if(requiredFields.contains(fieldDetails[0])){
                    fields.put(fieldDetails[0],fieldDetails[1]);
                }
            }
            if(fields.keySet().equals(requiredFields)){
                boolean valid = true;
                for(Map.Entry<String,String> attribute : fields.entrySet()){
                    if(!validator.get(attribute.getKey()).apply(attribute.getValue())){
                        valid = false;
                    }
                }
                if(valid){
                    System.out.println("valid " + passport);
                    validCount++;
                }
            }
        }
        return validCount;
    }


    private static List<String> getPassportDetails(){
        String fileName = "/Users/vali94/Documents/github-repos/Everyday-Problem-Solving/src/main/java/com/problemsolving/adventofcode/_2020/d4/passport-data.txt";
        List<String> passports = new ArrayList<>();
        try(Stream<String> content = Files.lines(Paths.get(fileName))){
            StringBuilder buffer = new StringBuilder();
            for(String line : content.collect(Collectors.toList())){
                if(line.isBlank()){
                    passports.add(buffer.toString());
                    buffer = new StringBuilder();
                } else {
                    buffer.append(line)
                            .append(" ");
                }
            }
        }catch (IOException exception){

        }
        return passports;
    }
}
