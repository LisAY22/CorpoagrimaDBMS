
package corpoagrima.corpoagrima.logic;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author alfaryus
 */
public class SignedDecimalFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null) {
            replace(fb, offset, 0, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null) {
            String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
            if (isValid(newText)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    private boolean isValid(String text) {
        if (text.isEmpty()) {
            return true;
        }
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

