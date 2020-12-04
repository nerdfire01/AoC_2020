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
}
