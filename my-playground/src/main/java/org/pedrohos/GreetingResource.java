package org.pedrohos;

import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.naming.OperationNotSupportedException;

public class GreetingResource {

    public static void main(String[] args) throws AuthenticationException{

        new GreetingResource().test();

//        try {
//            throwError(53);
//        } catch (OperationNotSupportedException e) {
//            System.out.println(e.getCause());
//            System.out.println(e);
//        } catch (AuthenticationException e) {
//            System.out.println(e);
//        } catch (NamingException e) {
//            System.out.println("xiiii: " + e);
//        }

    }

    public void test() {
        try {
            String x = null;
            System.out.println(x.compareTo(""));
        } catch (Exception e) {
            System.out.println("something happend: " + e.getMessage());
        }
    }


    public static void throwError(int error) throws NamingException {

        switch (error) {
            case 53:
                throw new OperationNotSupportedException(
                        "[LDAP: error code 53 - Password Policy Error :9001: GSL_ACCOUNTLOCKED_EXCP : Your account is locked. Contact your OID administrator.]");
            case 49:
                throw new AuthenticationException("[LDAP: error code 49 - Invalid Credentials]");
            default:
                throw new IllegalArgumentException("Unexpected value: " + error);
        }
    }
}
