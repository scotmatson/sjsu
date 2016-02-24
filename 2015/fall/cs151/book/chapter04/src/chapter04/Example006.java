package chapter04;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Example006 {

	public static void main(String[] args)
	{
		Graphics g = null;
		Graphics2D g2 = (Graphics2D) g;
		String text = "Message";
		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(text, context);
	}
}
