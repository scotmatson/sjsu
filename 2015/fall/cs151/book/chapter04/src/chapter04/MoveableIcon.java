package chapter04;

import javax.swing.*;

/**
 * A class extending this interface will not only have to implement the
 * translate method but also all methods from the Icon interface.
 * @author scot
 *
 */
public interface MoveableIcon extends Icon {
	
	void translate(int x, int y);
}
