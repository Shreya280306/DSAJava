public class BitwiseOperators {
    public static boolean getBit(int number, int bitPosition){
        int maskNum = 1 << bitPosition;
        if((number & maskNum) > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static int setBit(int number, int bitPosition){
        int maskNum = 1 << bitPosition;
        if((number & maskNum) <= 0){
            // bit is not set
            int result = number|maskNum;
            return result;
        }
        else return -1;
    }

    public static int clearBit(int number, int bitPosition){
        int maskNum = 1 << bitPosition;
        if((number & maskNum) > 0){ // bit is set
            int result = number & (~maskNum);
            return result;
        }
        else{
            return -1;
        }
    }

    public static int updateBit(int number, int bitPosition){
       int maskNum = 1 << bitPosition;
       if((number & maskNum) > 0){ //bit is set
           return (number & (~maskNum));
       }
        else{
            return (number | maskNum);
       }
    }
}
