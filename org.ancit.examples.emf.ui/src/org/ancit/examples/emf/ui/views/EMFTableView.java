package org.ancit.examples.emf.ui.views;

import org.ancit.examples.emf.edit.extensions.AddressbookItemProviderAdapterFactoryExtension;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import addressbook.Group;

public class EMFTableView extends ViewPart implements ISelectionListener {
	private Text txtGroupname;
	private Table table;
	private TableViewer tableViewer;
	
	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryEditingDomain editingDomain;

	public EMFTableView() {
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory.addAdapterFactory(new AddressbookItemProviderAdapterFactoryExtension());
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		Label lblGroupName = new Label(parent, SWT.NONE);
		lblGroupName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGroupName.setText("Group Name");

		txtGroupname = new Text(parent, SWT.BORDER);
		txtGroupname.setText("groupName");
		txtGroupname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");

		TableColumn tblclmnAddress = new TableColumn(table, SWT.NONE);
		tblclmnAddress.setWidth(100);
		tblclmnAddress.setText("Address");

		TableColumn tblclmnMobileNo = new TableColumn(table, SWT.NONE);
		tblclmnMobileNo.setWidth(100);
		tblclmnMobileNo.setText("Mobile No");

		TableColumn tblclmnEmailId = new TableColumn(table, SWT.NONE);
		tblclmnEmailId.setWidth(100);
		tblclmnEmailId.setText("Email ID");
		// TODO Auto-generated method stub

		getSite().getPage().addSelectionListener(this);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			Object object = sSelection.getFirstElement();

			if (object instanceof Group) {
				Group group = (Group) object;
				txtGroupname.setText(group.getName());
				tableViewer.setInput(group);
			}

		}
	}

}
