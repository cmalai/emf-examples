package org.ancit.examples.emf.ui.views;

import javax.inject.Inject;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

import addressbook.AddressBook;
import addressbook.AddressbookFactory;
import addressbook.Contact;
import addressbook.Group;
import addressbook.provider.AddressbookItemProviderAdapterFactory;

public class EMFView extends ViewPart {
	
	public static final String ID = "org.ancit.examples.emf.ui.views.EMFView";
	
	@Inject IWorkbench workbench;

	private ComposedAdapterFactory adapterFactory;

	public EMFView() {
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory.addAdapterFactory(new AddressbookItemProviderAdapterFactory());
	}

	@Override
	public void createPartControl(Composite parent) {
		TreeViewer treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setInput(initiateModel());
	}

	private AddressBook initiateModel() {
		AddressBook book = AddressbookFactory.eINSTANCE.createAddressBook();
		book.setName("Malai's World");
		
		Group group = AddressbookFactory.eINSTANCE.createGroup();
		group.setName("Friends");
		
		Contact contact = AddressbookFactory.eINSTANCE.createContact();
		contact.setName("Michael");
		
		book.getGroups().add(group);
		book.getContacts().add(contact);
		
		group.getContacts().add(contact);
		
		return book;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
