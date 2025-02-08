public class BitwiseOperators {
    //'1 << bitPosition' refers to bitwise left shift operator and bitPosition refers to the number of times it needs to be shifted towards the left
    //Logical operatora can also be applied on two numbers which means that it takes the numbers in their binary form and performs the operation on each digit of the number to return the result


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
            int result = number | maskNum;
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
            return number;
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
