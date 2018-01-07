package org.ancit.examples.emf.ui.views;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import addressbook.AddressBook;
import addressbook.AddressbookFactory;
import addressbook.Contact;
import addressbook.Group;
import addressbook.provider.AddressbookItemProviderAdapterFactory;

public class EMFView extends ViewPart {
	
	public static final String ID = "org.ancit.examples.emf.ui.views.EMFView";
	
	@Inject IWorkbench workbench;

	private ComposedAdapterFactory adapterFactory;

	private TreeViewer treeViewer;

	private AddressBook book;

	private AdapterFactoryEditingDomain editingDomain;

	public EMFView() {
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory.addAdapterFactory(new AddressbookItemProviderAdapterFactory());
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setInput(initiateModel());
		
		getSite().setSelectionProvider(treeViewer);
		
		hookContextMenu();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				Collection<?> newChildDescriptors = editingDomain.getNewChildDescriptors(book, null);
				for (Object object : newChildDescriptors) {
					CreateChildAction action = new CreateChildAction(editingDomain, new StructuredSelection(book), object);
					manager.add(action);
				}
			}
		});
		
		Menu contextMenu = menuMgr.createContextMenu(treeViewer.getTree());
		treeViewer.getTree().setMenu(contextMenu);
	}
	
	ExtendedPropertySheetPage propertySheetPage = null;
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if(adapter.equals(IPropertySheetPage.class)) {
			if(propertySheetPage == null) {
				propertySheetPage = new ExtendedPropertySheetPage(editingDomain);
				propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
			}
			return (T) propertySheetPage;
		}
		return super.getAdapter(adapter);
	}

	private AddressBook initiateModel() {
		book = AddressbookFactory.eINSTANCE.createAddressBook();
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
