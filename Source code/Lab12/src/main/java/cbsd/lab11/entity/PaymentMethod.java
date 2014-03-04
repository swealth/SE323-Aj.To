package cbsd.lab11.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: chillyprig
 * Date: 2/24/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public enum PaymentMethod implements Serializable {
    MONEY_TRANSFER,CREDIT_CARD,PAYPAL;
    /**
     * Returns the enum constant of this type with the specified name.
     * The string must match exactly with the toString() method for each enum constant.
     * (Extraneous whitespace characters are not permitted.)
     * @param name input the name of specific enum constant.
     * @return constant of enum with matched name.
     *          return null otherwise.
     */
    public static PaymentMethod fromString(String name){
        if(name != null){
            for(PaymentMethod payment:PaymentMethod.values()){
                if(name.equals(payment.toString())){
                    return payment;
                }
            }
        }
        return null;
    }
}
