/*
 * Copyright (C) 2008-2015 by Holger Arndt
 *
 * This file is part of the Java Data Mining Package (JDMP).
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * JDMP is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * JDMP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with JDMP; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.jdmp.gui.variable;

import org.jdmp.core.sample.Sample;
import org.jdmp.core.variable.HasVariableMap;
import org.jdmp.core.variable.Variable;
import org.jdmp.gui.util.AbstractListPanel;
import org.ujmp.core.interfaces.CoreObject;
import org.ujmp.core.interfaces.GUIObject;

public class VariableListPanel extends AbstractListPanel {
	private static final long serialVersionUID = -1241880733454399837L;

	public VariableListPanel(HasVariableMap iVariables) {
		super();
		if (iVariables instanceof CoreObject) {
			this.object = ((CoreObject) iVariables).getGUIObject();
		} else {
			this.object = (GUIObject) iVariables;
		}

		dataModel = new VariableListTableModel(iVariables);
		dataModel.addTableModelListener(this);
		jTable.setDefaultRenderer(Variable.class, new VariableTableCellRenderer());

		jTable.setModel(dataModel);

		updateTitle();
	}

	public VariableListPanel(Sample sample) {
		super();
		this.object = sample.getGUIObject();
		dataModel = new VariableListTableModel(sample);
		dataModel.addTableModelListener(this);
		jTable.setDefaultRenderer(Variable.class, new VariableTableCellRenderer());

		jTable.setModel(dataModel);

		updateTitle();
	}

	public void updateTitle() {
		getBorder().setTitle("Variables (" + jTable.getRowCount() + ")");
		repaint(1000);
	}

}
