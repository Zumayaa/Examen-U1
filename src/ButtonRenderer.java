import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class ButtonRenderer extends JButton implements TableCellRenderer {
    
	public ButtonRenderer() {
        setText("X");
        setEnabled(true);
        setBackground(Color.decode("#E32636"));
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}