package net.killarexe.jlwin.util.text;

import net.killarexe.jlwin.comp.TextPane;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaDocumentFilter extends DocumentFilter{

    private final StyledDocument styledDocument;
    private final StyleContext styleContext;
    private final AttributeSet redAttributeSet;
    private final AttributeSet blueAttributeSet;
    private final AttributeSet blackAttributeSet;
    private final TextPane pane;
    private final Pattern redPattern = buildRedPattern();

    public JavaDocumentFilter(TextPane pane){
        this.pane = pane;
        styledDocument = pane.getTextPane().getStyledDocument();
        styleContext = StyleContext.getDefaultStyleContext();
        redAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.RED);
        blueAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
        blackAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        super.insertString(fb, offset, string, attr);
        handleTextChanged(offset);
    }

    @Override
    public void remove (FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
        handleTextChanged(offset);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
        handleTextChanged(offset);
    }

    private void handleTextChanged(int offset)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                updateTextStyles(offset);
            }
        });
    }

    private Pattern buildRedPattern()
    {
        StringBuilder sb = new StringBuilder();
        String[] words = new String[]{"public", "class"};
        for (String token : words) {
            sb.append("\\b"); // Start of word boundary
            sb.append(token);
            sb.append("\\b|"); // End of word boundary and an or for the next word
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); // Remove the trailing "|"
        }

        Pattern p = Pattern.compile(sb.toString());

        return p;
    }


    private void updateTextStyles(int offset)
    {
        // Clear existing styles
        styledDocument.setCharacterAttributes(0, pane.getTextPane().getText().length(), blackAttributeSet, true);

        // Look for tokens and highlight them
        Matcher matcher = redPattern.matcher(pane.getTextPane().getText());
        while (matcher.find()) {
            // Change the color of recognized tokens
            styledDocument.setCharacterAttributes(matcher.start(), (matcher.end() - matcher.start()) * offset, redAttributeSet, false);
        }
    }
}
