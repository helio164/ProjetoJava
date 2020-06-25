package com.istec.componentes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;

/**
 * <h1>Placeholdertextfield</h1>
 * <p>Classe para permitir preencher o campo com texto</p> 
 */
@SuppressWarnings("serial")
public class Placeholdertextfield extends JTextField {

	private String placeholder;
	
	public Placeholdertextfield() {
		
	}

	/**
	 * 
	 * <h1>getPlaceholder</h1>
     * <p>Método para ir buscar o preenchimento</p>
     * 
	 * @return devolve conteúdo de preenchimento
	*/
	public String getPlaceholder() {
		return placeholder;
	}

	/**
	 * <h1>setPlaceholder</h1>
     * <p>Método para preencher o campo</p> 
	 * @param placeholder recebe string
	*/	
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	
	/**
	 * <h1>paintComponent</h1>
     * <p>Método para desenhar o placeholder no local</p>
	*/
	@Override
	protected void paintComponent(final Graphics pG) {
		super.paintComponent(pG);

		if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
			return;
		}

		final Graphics2D g = (Graphics2D) pG;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getDisabledTextColor());
		g.drawString(placeholder, getInsets().left, pG.getFontMetrics().getMaxAscent() + getInsets().top);
	}
	
}
