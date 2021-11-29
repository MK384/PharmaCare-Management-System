package records.area.head;

/**
 * This interface type to deal with dynamic data in the records.
 */

public interface Token {

    /**
     *
     * @return String label of the token.
     */
    String getLabel();

    /**
     * set the label of the token
     * @param label
     */
    void setLabel(String label);

    /**
     *
     * @return String the plain form of the token.
     */
    @Override
    String toString();

}
