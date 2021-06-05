package net.killarexe.jlwin.comp;

import net.killarexe.jlwin.util.Logger;

import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;

public abstract class LComponent {

    protected Logger logger = new Logger(getClass());

    public void setText(String name){

    }

    public void setBackgroundColor(Color color){

    }

    public void setBackgroundColor(int r, int g, int b){

    }

    public void setForegroundColor(Color color){

    }

    public void setForegroundColor(int r, int g, int b){

    }

    public void setTextColor(Color color){

    }

    public void setTextColor(int r, int g, int b){

    }

    public void setFont(Font font){

    }

    public void setFont(String text, int type, int size){

    }

    public void setAlignment(float x, float y){

    }

    public void addListener(ActionListener listener){

    }

    public void addListener(AncestorListener listener){

    }

    public void addListener(TextListener listener){

    }
}
