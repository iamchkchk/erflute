package org.dbflute.erflute.db.impl.postgres;

import org.dbflute.erflute.core.DisplayMessages;
import org.dbflute.erflute.core.exception.InputException;
import org.dbflute.erflute.editor.view.dialog.table.tab.AdvancedComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class PostgresAdvancedComposite extends AdvancedComposite {

    private Button withoutOIDs;

    public PostgresAdvancedComposite(Composite parent) {
        super(parent);
    }

    @Override
    protected void initComposite() {
        super.initComposite();

        final GridData gridData = new GridData();
        gridData.horizontalSpan = 2;

        this.withoutOIDs = new Button(this, SWT.CHECK);
        withoutOIDs.setText(DisplayMessages.getMessage("label.without.oids"));
        withoutOIDs.setLayoutData(gridData);
    }

    @Override
    protected void setData() {
        super.setData();

        withoutOIDs.setSelection(((PostgresTableProperties) tableProperties).isWithoutOIDs());
    }

    @Override
    public void validate() throws InputException {
        super.validate();

        ((PostgresTableProperties) tableProperties).setWithoutOIDs(withoutOIDs.getSelection());
    }
}
