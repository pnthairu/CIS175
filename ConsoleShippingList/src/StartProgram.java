import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		// method to add new store and item into the database
		private static void addAnItem() {
			// user input for store name
			System.out.print("Enter a store: ");			
			String store = in.nextLine();
			
			// user input for item name
			System.out.print("Enter an item: ");
			String item = in.nextLine();

			// adding store and item to the list
			ListItem toAdd = new ListItem(store, item);
			lih.insertItem(toAdd);
		}
		
		//method to delete store or item in the database
		private static void deleteAnItem() {
			// user input for the store to be deleted
			System.out.print("Enter the store to delete: ");
			String store = in.nextLine();
			
			// user input for the item to be deleted
			System.out.print("Enter the item to delete: ");
			String item = in.nextLine();
			ListItem toDelete = new ListItem(store, item);
			lih.deleteItem(toDelete);
		}
		
		// Method to edit existing store and items
		private static void editAnItem() {
			
			System.out.println("How would you like to search? ");
			// User input to search for a store to be edited
			System.out.println("1 : Search by Store");
			// User input to search for an item to be edited
			System.out.println("2 : Search by Item");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the store name: ");
				String storeName = in.nextLine();
				foundItems = lih.searchForItemByStore(storeName);
			} else {
				System.out.print("Enter the item: ");
				String itemName = in.nextLine();
				foundItems = lih.searchForItemByItem(itemName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getStore());
				System.out.println("1 : Update Store");
				System.out.println("2 : Update Item");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Store: ");
					String newStore = in.nextLine();
					toEdit.setStore(newStore);
				} else if (update == 2) {
					System.out.print("New Item: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}
		
		// Main method
		public static void main(String[] args) {			
			runMenu();
		}

		// Method to implment user menus
		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
			}
		}
		
		// method to view list of items in the database
		private static void viewTheList() {
				List<ListItem> allItems = lih.showAllItems();
				for(ListItem singleItem : allItems){
					System.out.println(singleItem.returnItemDetails());
			}				
		}
	}

