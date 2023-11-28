/**
 * Functional interface that allows TrickOrTreaters to be robbed if implemented.
 * @author Hyeokjin Jin
 * @version 10/25/23 CS1331
 */
public interface Robbable {
    /**
     * Method representing a robbery conducted on a certain TrickOrTreater object.
     * @return Integer representing the number of candy lost during the robbery
     */
    int beRobbed();
}
