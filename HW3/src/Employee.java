/**
 * This interface has functions only Employee types can use
 * @author Bao Tran
 * @version 1.00, 06 January 2017
 * @see Police
 * @see Teacher
 */
public interface Employee {
	void givePay();
	int getID();
	double getBalance();
	double getWage();
}
