package com.istec.componentes;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.istec.objectos.Engine;
import com.istec.objectos.Product;
import com.istec.objectos.Sale;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Enumeration;

import javax.swing.JLabel;
import java.awt.BorderLayout;

/**
 * 
 * <h1>ListOfSales</h1>
 * <p>Classe para mostrar as vendas numa tabela.</p>
 * 
 */
public class ListOfSales extends JPanel {
	private static final long serialVersionUID = 5280176045725860237L;
	private JTable productsTable;
	private JTable totalTable;
	public DefaultTableModel dtm;
	public DefaultTableModel dtmTotal;
	public JTableHeader th;

	/**
	 * <h1>ListOfSales</h1>
     * <p>Método para colocar as vendas numa lista</p>
	 * @param x
	 * @param y
	 */
	public ListOfSales(int x, int y) {
		
		setLayout(new BorderLayout(0, 0));
		this.setBounds(x, y, 250, 550);
		productsTable = new JTable();
		productsTable.setShowVerticalLines(false);
		//productsTable.setAlignmentY(Component.TOP_ALIGNMENT);
		productsTable.setBounds(x+0, y+0, 250, 499);
		dtm = new DefaultTableModel(new Object[][] {},new String[] {"Designacao", "Qt.", "Preco"}) {
				private static final long serialVersionUID = 222709334156674838L;
				boolean[] columnEditables = new boolean[] {false, false, false};
				public boolean isCellEditable(int row, int column) {return columnEditables[column];}
			};
		productsTable.setModel(dtm);
		productsTable.getColumnModel().getColumn(0).setPreferredWidth(147);
		productsTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		productsTable.getColumnModel().getColumn(2).setPreferredWidth(61);
		
		totalTable = new JTable();
		totalTable.setShowVerticalLines(false);
		//totalTable.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		totalTable.setBounds(x+0, y+500, 250, 50);
		totalTable.setEnabled(false);
		totalTable.setRowSelectionAllowed(false);
		dtmTotal = new DefaultTableModel(
			new Object[][] {
				{"", ""},
			},
			new String[] {
				"Total", ""
			}
		);
		totalTable.setModel(dtmTotal);
		
		add(productsTable);
		add(totalTable, BorderLayout.SOUTH);
		loadSales();
	}
	
	/**
	 * 
	 * <h1>loadSales</h1>
     * <p>Método para carregar as vendas com os respetivos valores de venda com e sem imposto</p>
     * 
	 */
	public void loadSales() {		
		dtm.setRowCount(0);
		if(Engine.currentSale == null) {
			Engine.currentSale = new Sale();
		}		
		
		for(Product p : Engine.currentSale.products) {
			Boolean newRow = true;
			
			for(int i = 0; i < dtm.getRowCount(); i++) {
				if(p.Designation.equals(dtm.getValueAt(i, 0))) {
					dtm.setValueAt((int)dtm.getValueAt(i, 1)+1, i, 1);
					newRow = false;
				}
			}
			if(newRow) {
				dtm.addRow(new Object[] {p.Designation, 1, p.Price});
			}
		}
		dtmTotal.setRowCount(0);
		dtmTotal.addRow(new Object[] {"Total s/ IVA", String.valueOf(new DecimalFormat("####0.00").format(getTotal()))});
		dtmTotal.addRow(new Object[] {"Total c/ IVA", String.valueOf(new DecimalFormat("####0.00").format(getTotal() * 1.23))});
	}

	/**
	 * 
	 * <h1>getTotal</h1>
     * <p>Método para calcular soma das vendas</p>
	 * @return valor total da venda
	 */
	public Double getTotal() {
		Double result = 0.0;
		
		for(Product p : Engine.currentSale.products) {
			result += p.Price;
		}
				
		return result;
	}
}
