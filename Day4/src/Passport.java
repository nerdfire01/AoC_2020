public class Passport {

    //all Fields for a passport
    String byr;
    String iyr;
    String eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;

    boolean check_passport(){
        if(this.byr==null){
            return false;
        }
        if(this.iyr==null){
            return false;
        }
        if(this.eyr==null){
            return false;
        }
        if(this.hgt==null){
            return false;
        }
        if(this.hcl==null){
            return false;
        }
        if(this.ecl==null){
            return false;
        }
        if(this.pid==null){
            return false;
        }

//        Ignore cid
//        if(this.cid==null){
//            return false;
//        }

        return true;
    }

    boolean check_passport_valid(){
        if(!check_passport()){
            return false;
        }

        //rule for Birthday year
        if(!(Integer.parseInt(this.byr)>=1920 && Integer.parseInt(this.byr)<=2002  )){
            return false;
        }

        //rule for Issue year
        if(!(Integer.parseInt(this.iyr)>=2010 && Integer.parseInt(this.iyr)<=2020)){
            return false;
        }

        //rule for Expiration year
        if(!(Integer.parseInt(this.eyr)>=2020 && Integer.parseInt(this.eyr)<=2030)){
            return false;
        }

        //rule for hgt
        if(!check_hgt(this.hgt)){
            return false;
        }

        //rule for hcl
        if(!check_hcl(this.hcl)){
            return false;
        }

        //rule for ecl
        if(!check_ecl(this.ecl)){
            return false;
        }

        //rule for pid
        if(!check_pid(this.pid)){
            return false;
        }

        return true;
    }

    boolean check_hgt(String hgt){
        int length=hgt.length();

        if(hgt.charAt(length-2)=='c' && hgt.charAt(length-1)=='m'){
            String sub=hgt.substring(0,length-2);
            int sub_i=Integer.parseInt(sub);
            if(sub_i>=150 && sub_i<=193){
                return true;
            }else{
                return false;
            }


        } else if(hgt.charAt(length-2)=='i' && hgt.charAt(length-1)=='n'){
            String sub=hgt.substring(0,length-2);
            int sub_i=Integer.parseInt(sub);
            if(sub_i>=59 && sub_i<=76){
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }
    }

    boolean check_hcl(String hcl){
        if(hcl.charAt(0)=='#'){
            if(hcl.length()==7){
                for(int i=1; i>=7;i++){
                    if(check_int(hcl.charAt(i))){
                    }else if(hcl.charAt(i)=='a'){
                    }else if(hcl.charAt(i)=='b'){
                    }else if(hcl.charAt(i)=='c'){
                    }else if(hcl.charAt(i)=='d'){
                    }else if(hcl.charAt(i)=='e'){
                    }else if(hcl.charAt(i)=='f'){
                    }else{
                        return false;
                    }
                }
            }else{
                return false;
            }

        }else{
            return false;
        }
        return true;
    }
    boolean check_ecl(String ecl){
        if(ecl.equals("amb")){
            return true;
        }else if(ecl.equals("blu")){
            return true;
        }else if(ecl.equals("brn")){
            return true;
        }else if(ecl.equals("gry")){
            return true;
        }else if(ecl.equals("grn")){
            return true;
        }else if(ecl.equals("hzl")){
            return true;
        }else if(ecl.equals("oth")){
            return true;
        }else{
            return false;
        }
    }
    boolean check_pid(String pid){
        if(pid.length()==9){
            for(int i=0; i<9;i++){
                if(!check_int(pid.charAt(i))) {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    private boolean check_int(Character c) {
        if (c.equals('0')) {
        } else if (c.equals('1')) {
        } else if (c.equals('2')) {
        } else if (c.equals('3')) {
        } else if (c.equals('4')) {
        } else if (c.equals('5')) {
        } else if (c.equals('6')) {
        } else if (c.equals('7')) {
        } else if (c.equals('8')) {
        } else if (c.equals('9')) {
        } else {
            return false;
        }
        return true;
    }
}
