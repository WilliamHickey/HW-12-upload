/* This is a program to create a GUI to create loans
 * Assignment: 10
 * Name: Will Hickey
 * 
 */
package Loaner;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LoanCreator extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Loan> toCollect = new ArrayList<Loan>();
		
		FlowPane pane = new FlowPane();
		Label directions = new Label("for loan types, enter 1 for a business loan, and 2 for a personal one.");
		Label directions2 = new Label("Amounts are capped at 500000 and terms other than 1,3, or 5. Violations will be set to 500000 and 1 respectively");
		Label loanType = new Label("Enter the loan type");
		TextField loanTypeInput = new TextField();
		Label loanNumber = new Label("Enter the loan number");
		TextField loanNumberInput = new TextField();
		Label name = new Label("Enter a name");
		TextField nameInput = new TextField();
		Label amount = new Label("Enter an amount");
		TextField amountInput = new TextField();
		Label term = new Label("Enter the term's amount of years");
		TextField termInput = new TextField();
		
		Button add = new Button("Add loan data.");
		add.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent click) 
			{
				if(loanTypeInput.getText().equals("")||loanNumberInput.getText().equals("")||nameInput.getText().equals("")||amountInput.getText().equals("")||termInput.getText().equals(""))
				{
					System.out.println("Please finish input");
				}
				else
				{
					int typeIn = Integer.parseInt(loanTypeInput.getText());
					if (typeIn > 2 || typeIn < 1)
					{
						System.out.println("Invalid loan type, rejecting input, press 1 or 2 first");
					}
					else
					{
						int numIn = Integer.parseInt(loanNumberInput.getText());
						String nameIn = nameInput.getText();
						int amountIn = Integer.parseInt(amountInput.getText());
						int termIn = Integer.parseInt(termInput.getText());
						if(typeIn == 1)
						{
							BusinessLoan newLoan = new BusinessLoan(numIn, nameIn, amountIn, termIn);
							toCollect.add(newLoan);
						}
						else
						{
							PersonalLoan newLoan = new PersonalLoan(numIn, nameIn, amountIn, termIn);
							toCollect.add(newLoan);
						}
					}
				}
			}
			
		});
		
		
		Button calc = new Button ("Calculate loans!");
		calc.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent click) 
			{	
				if(toCollect.size() < 5)
				{
					System.out.println("Not enough data");
				}
				else
				{
					FlowPane newPane= new FlowPane();
					Scene newScene = new Scene(newPane, 500, 800);
					Stage data = new Stage();
					data.setTitle("All events");
					data.setScene(newScene);
					for(int i = 0; i < toCollect.size(); i++)
					{
						Label text = new Label(toCollect.get(i).toString());
						newPane.getChildren().add(text);
					}
					data.show();
				}
			}
		});
		pane.getChildren().addAll(directions, directions2, loanType, loanTypeInput, loanNumber, loanNumberInput, name, nameInput, amount, amountInput, term, termInput, add, calc);
		Scene scene = new Scene(pane, 500, 750);
		primaryStage.setTitle("Calculation input");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		//launching GUI
		Application.launch(args);
	}
}
