/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author apascal002
 */
public class AllException extends Exception {

    /**
     * Creates a new instance of <code>AllException</code> without detail
     * message.
     */
    public AllException() {
    }

    /**
     * Constructs an instance of <code>AllException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public AllException(String msg) {
        super(msg);
    }
}
