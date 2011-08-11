package org.openspaces.ece.client;

import javax.swing.*;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ExecutionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1006808632768911289L;
	private JTextField txtTradeCount;
	private JTextField txtThreadCount;

	/**
	 * Create the panel.
	 */
	public ExecutionPanel() {
		setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec.decode("27px"),
				ColumnSpec.decode("117px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("92px"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblTaskExecution = new JLabel("Task Execution");
		lblTaskExecution.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTaskExecution, "2, 2");

		JCheckBox chckbxTaskExecution = new JCheckBox();
		chckbxTaskExecution.setText("(If off, will use master/worker)");
		add(chckbxTaskExecution, "4, 2, 3, 1, left, default");

		JLabel lblTradeCount = new JLabel("Trade Count");
		add(lblTradeCount, "2, 4, right, default");

		txtTradeCount = new JTextField();
		txtTradeCount.setText("Trade Count");
		add(txtTradeCount, "4, 4, fill, default");
		txtTradeCount.setColumns(10);

		JButton btnRun = new JButton("Run");
		add(btnRun, "8, 4");

		JLabel lblThreadCount = new JLabel("Thread Count");
		add(lblThreadCount, "2, 6, right, default");

		txtThreadCount = new JTextField();
		txtThreadCount.setText("Thread Count");
		add(txtThreadCount, "4, 6, fill, default");
		txtThreadCount.setColumns(10);

	}

}