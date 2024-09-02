
package corpoagrima.corpoagrima.logic;

import javax.swing.text.*;

/**
 *
 * @author alfaryus
 */

public class DateFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null) {
            replace(fb, offset, 0, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null) {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
            
            if (isValid(newText)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    private boolean isValid(String text) {
        // Validar longitud del año (YYYY)
        if (text.length() <= 4) {
            return text.matches("\\d{0,4}");
        }
        
        // Validar longitud del mes (MM)
        if (text.length() <= 7) {
            return text.matches("\\d{4}/\\d{0,2}");
        }
        
        // Validar longitud del día (DD)
        if (text.length() <= 10) {
            return text.matches("\\d{4}/\\d{2}/\\d{0,2}");
        }
        
        // Si tiene longitud mayor a 10, no es válido
        return false;
    }
}

